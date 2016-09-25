package app.num.residemenu;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {
  ResideMenu resideMenu;
  private Context mContext;
  private ResideMenuItem itemHome;
  private ResideMenuItem itemProfile;
  private ResideMenuItem itemCalendar;
  private ResideMenuItem itemSettings;
  @Nullable
  @Bind(R.id.toolbar)
  Toolbar toolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ButterKnife.bind(this);
    mContext = this;
  }

  public void setUpMenu() {

    // attach to current activity;
    resideMenu = new ResideMenu(this);

    resideMenu.setBackground(R.drawable.menu_background);
    resideMenu.attachToActivity(this);
    resideMenu.setMenuListener(menuListener);
    //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip.
    resideMenu.setScaleValue(0.6f);

    // create menu items;
    itemHome = new ResideMenuItem(this, R.drawable.icon_home, "Home");
    itemProfile = new ResideMenuItem(this, R.drawable.icon_profile, "Profile");
    itemCalendar = new ResideMenuItem(this, R.drawable.icon_calendar, "Calendar");
    itemSettings = new ResideMenuItem(this, R.drawable.icon_settings, "Settings");

    itemHome.setOnClickListener(this);
    itemProfile.setOnClickListener(this);
    itemCalendar.setOnClickListener(this);
    itemSettings.setOnClickListener(this);

    resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_LEFT);
    resideMenu.addMenuItem(itemProfile, ResideMenu.DIRECTION_LEFT);
    resideMenu.addMenuItem(itemCalendar, ResideMenu.DIRECTION_RIGHT);
    resideMenu.addMenuItem(itemSettings, ResideMenu.DIRECTION_RIGHT);

    // You can disable a direction by setting ->
    resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);
    resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_LEFT);

    findViewById(R.id.title_bar_left_menu).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
      }
    });
    findViewById(R.id.title_bar_right_menu).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
      }
    });
  }

  private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
    @Override
    public void openMenu() {
      Toast.makeText(mContext, "Menu is opened!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void closeMenu() {
      Toast.makeText(mContext, "Menu is closed!", Toast.LENGTH_SHORT).show();
    }
  };

  @Override
  public boolean dispatchTouchEvent(MotionEvent ev) {
    return resideMenu.dispatchTouchEvent(ev);
  }

  public void setActionBarProperties(String title, int drawerIcon) {
    if (drawerIcon != 0)
      toolbar.setNavigationIcon(getResources().getDrawable(drawerIcon));
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowTitleEnabled(false);
    TextView toolbarTV = (TextView) toolbar.findViewById(R.id.toolbar_text_view);
    toolbarTV.setText(title);
  }

  @Override
  public void onClick(View view) {
    Intent intent = new Intent();
    resideMenu.clearIgnoredViewList();
    if (view == itemHome) {
      intent = new Intent(this, MainActivity.class);
      intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
      startActivity(intent);
    } else if (view == itemProfile) {
      intent = new Intent(this, ProfileActivity.class);
      intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
      startActivity(intent);
    } else if (view == itemCalendar) {
    } else if (view == itemSettings) {
    }
    resideMenu.closeMenu();
  }

  // What good method is to access resideMenu？
  public ResideMenu getResideMenu() {
    return resideMenu;
  }

}
