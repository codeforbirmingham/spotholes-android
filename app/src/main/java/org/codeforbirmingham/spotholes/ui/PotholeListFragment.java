package  org.codeforbirmingham.spotholes.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.codeforbirmingham.spotholes.R;

public class PotholeListFragment extends Fragment {

    private RecyclerView mListView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pothole_list_fragment, container, false);

        mListView = (RecyclerView) view.findViewById(R.id.pothole_list);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mListView.setLayoutManager(mLayoutManager);

        mAdapter = new PotholeListAdapter(new String[20]);
        mListView.setAdapter(mAdapter);

        return view;
    }
}
