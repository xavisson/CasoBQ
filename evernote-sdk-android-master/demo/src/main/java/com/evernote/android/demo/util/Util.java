package com.evernote.android.demo.util;

import android.app.Activity;

import com.evernote.android.demo.activity.BQ_LoginActivity;
import com.evernote.client.android.EvernoteSession;

/**
 * @author rwondratschek
 */
public final class Util {

    private Util() {
        // no op
    }

    public static void logout(Activity activity) {
        EvernoteSession.getInstance().logOut();
        BQ_LoginActivity.launch(activity);
        activity.finish();
    }
}
