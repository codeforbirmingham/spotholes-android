package org.codeforbirmingham.potholes.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * @author @justinharrison
 */
public class Util {

    public static String getScreenDensityString(Context context) {
        int displayDensity = context.getResources().getDisplayMetrics().densityDpi;

        switch (displayDensity) {
            case DisplayMetrics.DENSITY_MEDIUM:
                return "mdpi";
            case DisplayMetrics.DENSITY_HIGH:
                return "hdpi";
            case DisplayMetrics.DENSITY_XHIGH:
                return "xhdpi";
            case DisplayMetrics.DENSITY_XXHIGH:
                return "xxhdpi";
            case DisplayMetrics.DENSITY_XXXHIGH:
                return "xxxhdpi";
            default:
                return "xxxhdpi";
        }
    }
}
