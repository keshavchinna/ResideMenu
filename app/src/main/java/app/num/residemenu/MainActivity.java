package app.num.residemenu;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

  private Context mContext;
  ViewPager viewPager;

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mContext = this;
    ButterKnife.bind(this);
    viewPager = (ViewPager) findViewById(R.id.viewPager);
    setUpMenu();
    FragmentManager fm = getSupportFragmentManager();
    /** Instantiating FragmentPagerAdapter */
    MyPagerAdapter myPagerAdapter = new MyPagerAdapter(fm);
    viewPager.setAdapter(myPagerAdapter);
    viewPager.setCurrentItem(1);
  }

  /*private void changeFragment(Fragment targetFragment) {
//    resideMenu.clearIgnoredViewList();
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.main_fragment, targetFragment, "fragment")
        .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        .commit();
  }*/
  public static class MyPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;

    public MyPagerAdapter(FragmentManager fragmentManager) {
      super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
      return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
      switch (position) {
        case 0:
          return new HomeFragment();
        case 1:
          return new ProfileFragment();
        case 2:
          return new CalendarFragment();
        default:
          return null;
      }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
      return "Page " + position;
    }

  }
}

