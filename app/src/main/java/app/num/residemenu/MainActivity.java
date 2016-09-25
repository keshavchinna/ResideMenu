package app.num.residemenu;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends BaseActivity {

  private Context mContext;

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mContext = this;
    setUpMenu();
  }

  /*private void changeFragment(Fragment targetFragment) {
//    resideMenu.clearIgnoredViewList();
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.main_fragment, targetFragment, "fragment")
        .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        .commit();
  }*/
}

