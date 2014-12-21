package  org.codeforbirmingham.potholes.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.codeforbirmingham.potholes.R;

public class PotholeListAdapter extends RecyclerView.Adapter<PotholeListAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public ViewHolder(View v) {
            super(v);
            mView = v;
        }
    }

    private String[] mDataset;

    public PotholeListAdapter(String[] dataset) {
        mDataset = dataset;
    }

    @Override
    public PotholeListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pothole_list_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

}
