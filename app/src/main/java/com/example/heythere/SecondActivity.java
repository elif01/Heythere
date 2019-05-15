package com.example.heythere;

import android.net.Uri;
import android.content.*;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.FacebookException;
import com.facebook.FacebookCallback;
import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.*;
import com.facebook.share.widget.ShareButton;
import com.facebook.share.model.ShareLinkContent;




import java.util.Date;
import java.util.Random;


public class SecondActivity extends AppCompatActivity {

    private static final String TOTAL_COUNT = "total_count";
    public static CallbackManager callbackManager;
    public static LoginButton loginButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        showRandomNumber();


        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton) findViewById(R.id.login_button);
        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // app code

            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
    }

    public void showRandomNumber() {
        // get the random num textview
        TextView randomView = (TextView) findViewById(R.id.textview_random);
        // get the Random num Heading textview
        TextView headingView = (TextView) findViewById(R.id.textview_label);
        // get the upper bound for the random number from the intent that started this activity
        Intent origin = getIntent();
        int count = origin.getIntExtra(TOTAL_COUNT, 66);
        headingView.setText(getString(R.string.random_heading, count));
        // random number generator instantiate
        Random rand = new Random();
        int random_int = 0;
        if (count > 0) {
            random_int = rand.nextInt(count);
        }
        // Convert random number to string to display in the TextView.
        String rnd = Integer.toString(random_int);
        randomView.setText(rnd);
    }
}
