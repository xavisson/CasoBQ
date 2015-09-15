package com.evernote.android.demo;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import com.evernote.android.demo.activity.LoginActivity;
import com.evernote.android.demo.activity.MainActivity;
import com.evernote.client.android.EvernoteOAuthActivity;
import com.evernote.client.android.EvernoteSession;
import com.evernote.client.android.login.EvernoteLoginActivity;
import com.evernote.android.demo.activity.BQ_LoginActivity;

import java.util.Arrays;
import java.util.List;

/**
 * @author rwondratschek
 */
public class LoginChecker implements Application.ActivityLifecycleCallbacks {

    private static List<Class<? extends Activity>> IGNORED_ACTIVITIES = Arrays.asList(
            BQ_LoginActivity.class,
            EvernoteLoginActivity.class,
            EvernoteOAuthActivity.class
    );

    private Intent mCachedIntent;

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (!EvernoteSession.getInstance().isLoggedIn() && !isIgnored(activity)) {
            mCachedIntent = activity.getIntent();
            //Login automatically
            EvernoteSession.getInstance().authenticate(activity);


        }
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {
   /*     if (activity instanceof BQ_LoginActivity && EvernoteSession.getInstance().isLoggedIn()) {
            if (mCachedIntent != null) {
                activity.startActivity(mCachedIntent);
                mCachedIntent = null;
            } else {
                activity.startActivity(new Intent(activity, MainActivity.class));
            }
        }*/
    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    private boolean isIgnored(Activity activity) {
        return IGNORED_ACTIVITIES.contains(activity.getClass());
    }
}
