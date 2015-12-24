package com.chheang.chuunibyou;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.chheang.chuunibyou.Miscellaneous.GIFView;
import com.chheang.chuunibyou.Miscellaneous.PressStartView;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

import java.io.InputStream;

public class SplashActivity extends Activity{
    MediaPlayer bgm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Parse.initialize(this, getString(R.string.parse_app_id), getString(R.string.parse_client_key));
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        ParseACL.setDefaultACL(defaultACL, true);

        bgm = MediaPlayer.create(this, R.raw.splashbgm);
        bgm.setLooping(true);
        bgm.start();

        final PressStartView mPressStart = (PressStartView) findViewById(R.id.press_start);
        mPressStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                bgm.release();
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
//        bgm.release();
        finish();
    }
}
