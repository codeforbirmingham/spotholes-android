package org.codeforbirmingham.spotholes;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;

/**
 * @author @justinharrison
 */
public class SpotholesApplication extends Application {

    private static Context context;

    public static Context getContext() {
        return context;
    }

    public static Realm getRealm() {
        return Realm.getInstance(context);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
