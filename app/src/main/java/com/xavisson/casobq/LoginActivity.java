package com.xavisson.casobq;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ContentResolver;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.evernote.client.android.EvernoteSession;
import com.evernote.client.android.login.EvernoteLoginFragment;

import java.util.ArrayList;
import java.util.List;



    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    public class LoginActivity extends AppCompatActivity implements EvernoteLoginFragment.ResultCallback {

        public static void launch(Activity activity) {
            activity.startActivity(new Intent(activity, LoginActivity.class));
        }

        private Button mButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitleTextColor(getResources().getColor(R.color.tb_text));

            setSupportActionBar(toolbar);

            mButton = (Button) findViewById(R.id.button_login);
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EvernoteSession.getInstance().authenticate(LoginActivity.this);
                    mButton.setEnabled(false);
                }
            });

        }

        @Override
        public void onLoginFinished(boolean successful) {
            if (successful) {
                finish();
            } else {
                mButton.setEnabled(true);
            }
        }
    }

