package org.codeforbirmingham.spotholes.ui.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * @author @justinharrison
 */
public abstract class RealmAdapter<E extends RealmObject, VH extends RealmAdapter.ViewHolder>
        extends BaseAdapter {

    public static class ViewHolder {
        public final View itemView;

        public ViewHolder(View itemView) {
            this.itemView = itemView;
            this.itemView.setTag(this);
        }
    }

    protected RealmResults<E> results;

    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

    public abstract void onBindViewHolder(VH holder, int position);

    public void onViewRecycled(VH holder) {
    }

    public void setResults(RealmResults<E> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return results == null ? 0 : results.size();
    }

    @Override
    public E getItem(int position) {
        return results == null ? null : results.get(position);
    }

    @Override
    public long getItemId(int position) {
        return -1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = onCreateViewHolder(parent, getItemViewType(position)).itemView;
        } else {
            onViewRecycled(getViewHolder(convertView));
        }

        onBindViewHolder(getViewHolder(convertView), position);

        return convertView;
    }

    private VH getViewHolder(View view) {
        return (VH) view.getTag();
    }

}