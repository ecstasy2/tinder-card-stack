package com.lal.focusprototype.app;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by diallo on 24/03/14.
 */
public class Utils {
    public static int dpToPixel(Activity activity, float dp) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);

        return (int) (metrics.density*dp);
    }
}
