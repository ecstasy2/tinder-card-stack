package com.lal.focusprototype.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lal.focusprototype.app.views.FeedItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diallo on 21/03/14.
 */
public class FeedListAdapter extends BaseAdapter {

    List<FeedItem> mItems;

    Context context;

    public FeedListAdapter(Context context) {
        this.context = context;
        initAdapter();
    }

    void initAdapter() {
        mItems = new ArrayList<FeedItem>();
        for(int i=1; i<= 15; i++){
            int index = i % 5 != 0 ? i % 5 : 1;
            mItems.add(new FeedItem(i%5, i));
        }
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public FeedItem getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        FeedItemView personItemView;
        if (convertView == null) {
            personItemView = new FeedItemView(context);
        } else {
            personItemView = (FeedItemView) convertView;
        }

        personItemView.bind(getItem(position));

        return personItemView;
    }
}
