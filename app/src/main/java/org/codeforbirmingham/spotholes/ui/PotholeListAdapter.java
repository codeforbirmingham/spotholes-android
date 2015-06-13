package org.codeforbirmingham.spotholes.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.codeforbirmingham.spotholes.R;
import org.codeforbirmingham.spotholes.models.Pothole;
import org.codeforbirmingham.spotholes.ui.widget.RealmAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author @justinharrison
 */
public class PotholeListAdapter extends RealmAdapter<Pothole, PotholeListAdapter.ViewHolder> {

    public static class ViewHolder extends RealmAdapter.ViewHolder {
        @InjectView(R.id.pothole_thumbnail)
        CircleImageView potholeThumbnail;
        @InjectView(R.id.pothole_title)
        TextView potholeTitle;
        @InjectView(R.id.pothole_submitter)
        TextView potholeSubmitter;
        @InjectView(R.id.pothole_upvote)
        ImageView potholeUpvote;
        @InjectView(R.id.pothole_score)
        TextView potholeScore;
        @InjectView(R.id.pothole_downvote)
        ImageView potholeDownvote;
        @InjectView(R.id.pothole_list_item_layout)
        RelativeLayout potholeListItemLayout;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }

    private final LayoutInflater inflater;

    public PotholeListAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.pothole_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        Pothole pothole = getItem(position);

        viewHolder.potholeTitle.setText(pothole.getName());

        SpannableString name = new SpannableString(pothole.getUser().getName());
        StyleSpan boldItalic = new StyleSpan(Typeface.BOLD_ITALIC);
        name.setSpan(boldItalic, 0, pothole.getUser().getName().length() - 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        viewHolder.potholeSubmitter.setText("Submitted by " + name + " at " + pothole.getLogs().last().getCreatedAt().toString());

    }

    @Override
    public long getItemId(int position) {
        return results.get(position).getId();
    }

}
