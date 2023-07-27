package com.example.kstantm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;


import com.aldebaran.qi.sdk.QiContext;
import com.aldebaran.qi.sdk.QiSDK;
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks;
import com.aldebaran.qi.sdk.design.activity.RobotActivity;
import com.example.kstantm.databinding.ActivityMain4Binding;

public class MainActivity4 extends RobotActivity implements RobotLifecycleCallbacks {

    ActivityMain4Binding binding;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Register the RobotLifecycleCallbacks to this Activity.
        binding =ActivityMain4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        QiSDK.register(this, this);
        Intent intent=getIntent();
        int number=intent.getIntExtra("deger",0);

        switch (number){
            case 1:
                uri=Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
                break;
            case 2:
                uri=Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.erasmus);
                break;
            case 3:
                uri=Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.tanitim);
                break;
            default:
                break;
        }

        binding.videoView.setVideoURI(uri);
        binding.videoView.requestFocus();
        binding.videoView.start();


        // Start playing the video
        binding.videoView.start();
        // Set a completion listener to navigate back to the main activity when the video ends
        binding.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
              Intent intent=new Intent(MainActivity4.this, MainActivity2.class);
              startActivity(intent);
                finish();
            }


        });

    }

    @Override
    protected void onDestroy() {
        // Unregister the RobotLifecycleCallbacks for this Activity.
        QiSDK.unregister(this, this);
        super.onDestroy();
    }

    @Override
    public void onRobotFocusGained(QiContext qiContext) {


    }

    @Override
    public void onRobotFocusLost() {
        // The robot focus is lost.
    }

    @Override
    public void onRobotFocusRefused(String reason) {
        // The robot focus is refused.
    }
}