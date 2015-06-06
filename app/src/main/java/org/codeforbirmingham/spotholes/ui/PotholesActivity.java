package org.codeforbirmingham.spotholes.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import org.codeforbirmingham.spotholes.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class PotholesActivity extends BaseActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.content_frame)
    FrameLayout contentFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.potholes_activity);
        ButterKnife.inject(this);

        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }

        if (savedInstanceState == null) {
//            Fragment potholeListFragment = new PotholeListFragment();
//            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, potholeListFragment).commit();
        }
    }

    @Override
    protected int getSelfNavDrawerItem() {
        return R.id.nav_potholes;
    }
}
