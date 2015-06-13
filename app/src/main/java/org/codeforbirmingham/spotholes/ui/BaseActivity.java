package org.codeforbirmingham.spotholes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;

import org.codeforbirmingham.spotholes.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author @justinharrison
 */
public class BaseActivity extends AppCompatActivity {

    @InjectView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @InjectView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handler = new Handler();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        ButterKnife.inject(this);

        setupDrawerContent(navigationView);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            super.onBackPressed();
        }
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(final MenuItem menuItem) {

                        if (menuItem.getItemId() == getSelfNavDrawerItem()) {
                            menuItem.setChecked(true);
                            drawerLayout.closeDrawers();
                            return true;
                        }

                        if (menuItem.getItemId() == R.id.nav_settings) {
                            goToNavDrawerItem(menuItem);
                        } else {
                            // launch the target Activity after a short delay, to allow the close animation to play
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    goToNavDrawerItem(menuItem);
                                }
                            }, NAVDRAWER_LAUNCH_DELAY);

                            // change the active item on the list so the user can see the item changed
                            menuItem.setChecked(true);
                        }

                        drawerLayout.closeDrawers();
                        return true;
                    }
                }
        );


    }

    private void goToNavDrawerItem(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.nav_potholes:
                intent = new Intent(this, PotholesActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_my_reports:
                // TODO Add intent here once activity is built
                break;
            case R.id.nav_leaderboard:
                // TODO Add intent here once activity is built
                break;
            case R.id.nav_settings:
                // TODO Add intent here once activity is built
                break;
            case R.id.nav_about:
                // TODO Add intent here once activity is built
                break;
        }
    }

    protected int getSelfNavDrawerItem() {
        return 0;
    }

    private Handler handler;
    // delay to launch nav drawer item, to allow close animation to play
    private static final int NAVDRAWER_LAUNCH_DELAY = 250;

}
