package org.codeforbirmingham.spotholes.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.codeforbirmingham.spotholes.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author @justinharrison
 */
public class PotholesListFragment extends Fragment {

    @InjectView(R.id.potholes_list_error_text)
    TextView potholesListErrorText;
    @InjectView(R.id.progressBar)
    ProgressBar progressBar;
    @InjectView(R.id.potholes_list)
    RecyclerView potholesList;
    @InjectView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private LinearLayoutManager linearLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.potholes_list_fragment, container, false);
        ButterKnife.inject(this, view);

        potholesList.setHasFixedSize(true);
        potholesList.setItemAnimator(new DefaultItemAnimator());

        linearLayoutManager = new LinearLayoutManager(getActivity());
        potholesList.setLayoutManager(linearLayoutManager);
        potholesList.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

        return view;
    }


}
