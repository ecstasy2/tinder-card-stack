package com.lal.focusprototype.app;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diallo on 21/03/14.
 */
@EBean
public class FeedItemFinderImpl implements FeedItemFinder{
    @Override
    public List<FeedItem> findAll() {
        ArrayList<FeedItem> items = new ArrayList<FeedItem>();
        for(int i=1; i<= 15; i++){
            int index = i % 5 != 0 ? i % 5 : 1;
            items.add(new FeedItem(i%5, i));
        }
        return items;
    }
}
