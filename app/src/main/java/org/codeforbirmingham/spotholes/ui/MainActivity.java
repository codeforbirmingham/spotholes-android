package org.codeforbirmingham.spotholes.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;

import org.codeforbirmingham.spotholes.R;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if (savedInstanceState == null) {
            Fragment potholeListFragment = new PotholeListFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, potholeListFragment).commit();
        }
    }
}
