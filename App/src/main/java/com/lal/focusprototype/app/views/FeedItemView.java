package com.lal.focusprototype.app.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lal.focusprototype.app.FeedItem;
import com.lal.focusprototype.app.R;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

/**
 * Created by diallo on 21/03/14.
 */
@EViewGroup(R.layout.feed_item)
public class FeedItemView extends RelativeLayout implements CardStackView.CardStackListener {

    @ViewById(R.id.picture)
    ImageView picture;

    @ViewById(R.id.id_textView)
    TextView id;

    @ViewById(R.id.ok)
    TextView ok;

    @ViewById(R.id.no)
    TextView no;

    private FeedItem mFeedItem;

    public FeedItemView(Context context) {
        super(context);
    }

    public void bind(FeedItem item) {
        mFeedItem = item;

        return;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        if (mFeedItem != null) {
            int resource = getResources().getIdentifier(
                    "content_card_x_0" + mFeedItem.getId(),
                    "drawable", getContext().getPackageName());

            //loadPicture(resource);

            id.setText(mFeedItem.toString());
        }
    }

    public FeedItem getFeedItem() {
        return mFeedItem;
    }

    @Background
    void loadPicture(int id) {
        Drawable drawable = getResources().getDrawable(id);

        setPicture(drawable);
    }

    @UiThread
    void setPicture(Drawable drawable) {
        picture.setImageDrawable(drawable);
    }

    @Override
    public void onUpdateProgress(boolean positif, float percent, View view) {
        if (positif) {
            ok.setAlpha(percent);
        } else {
            no.setAlpha(percent);
        }
    }

    @Override
    public void onCancelled(View beingDragged) {
        ok.setAlpha(0);
        no.setAlpha(0);
    }

    @Override
    public void onChoiceMade(boolean choice, View beingDragged) {
        ok.setAlpha(0);
        no.setAlpha(0);
    }
}
