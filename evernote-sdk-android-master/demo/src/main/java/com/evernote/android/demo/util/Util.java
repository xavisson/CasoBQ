package com.evernote.android.demo.util;

import android.app.Activity;
import android.content.Intent;

import com.evernote.android.demo.activity.BQ_LoginActivity;
import com.evernote.android.demo.activity.MainActivity;
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
       //When user sign out, launches loggin view
        EvernoteSession.getInstance().authenticate(activity);

        activity.finish();
        //This avoids that the Activity disappear when login by adding a MainActivity to the stack
        activity.startActivity(new Intent(activity, MainActivity.class));
    }
}
