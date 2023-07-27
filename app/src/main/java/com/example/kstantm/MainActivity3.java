package com.example.kstantm;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

import com.aldebaran.qi.sdk.QiContext;
import com.aldebaran.qi.sdk.QiSDK;
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks;
import com.aldebaran.qi.sdk.design.activity.RobotActivity;
import com.aldebaran.qi.sdk.object.conversation.Chat;
import com.aldebaran.qi.sdk.object.conversation.QiChatbot;
import com.example.kstantm.databinding.ActivityMain3Binding;

public class MainActivity3 extends RobotActivity implements RobotLifecycleCallbacks {

    ActivityMain3Binding binding;
    private QiChatbot qiChatbot;
    private Chat chat;

    int []images={R.drawable.res_1,R.drawable.res2,R.drawable.res3,R.drawable.res4,R.drawable.res5,
            R.drawable.res6,R.drawable.res7,R.drawable.res8,R.drawable.res9,R.drawable.res10,R.drawable.res11, R.drawable.res13,R.drawable.res14,R.drawable.res15,R.drawable.res16,R.drawable.res17,
            R.drawable.res18,R.drawable.res18,R.drawable.res19,R.drawable.res20,R.drawable.res21,R.drawable.res23};
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Register the RobotLifecycleCallbacks to this Activity.
        binding =ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        QiSDK.register(this, this);
        MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.risk);


        binding.imageView.setImageResource(R.drawable.logo);

        runOnUiThread(()->{
            handler.postDelayed(new Runnable() {
                int i=0;
                @Override
                public void run() {
                    binding.imageView.setImageResource(images[i]);
                    i++;
                    if(i<images.length){
                        mediaPlayer.start();
                        handler.postDelayed(this,3000);
                    }
                    else{
                        handler.removeCallbacks(this);
                        mediaPlayer.stop();
                        Intent intent=new Intent(MainActivity3.this, MainActivity2.class);
                        startActivity(intent);
                    }

                }
            },3000);


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