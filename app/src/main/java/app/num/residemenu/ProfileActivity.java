package app.num.residemenu;

import android.os.Bundle;


public class ProfileActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sample_activitu);
    setUpMenu();
    resideMenu.clearAnimation();
  }
}
