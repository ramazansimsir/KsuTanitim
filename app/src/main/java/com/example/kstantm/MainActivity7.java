package com.example.kstantm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.aldebaran.qi.sdk.QiContext;
import com.aldebaran.qi.sdk.QiSDK;
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks;
import com.aldebaran.qi.sdk.builder.ChatBuilder;
import com.aldebaran.qi.sdk.builder.QiChatbotBuilder;
import com.aldebaran.qi.sdk.builder.TopicBuilder;
import com.aldebaran.qi.sdk.design.activity.RobotActivity;
import com.aldebaran.qi.sdk.object.conversation.AutonomousReactionImportance;
import com.aldebaran.qi.sdk.object.conversation.AutonomousReactionValidity;
import com.aldebaran.qi.sdk.object.conversation.Bookmark;
import com.aldebaran.qi.sdk.object.conversation.BookmarkStatus;
import com.aldebaran.qi.sdk.object.conversation.Chat;
import com.aldebaran.qi.sdk.object.conversation.QiChatbot;
import com.aldebaran.qi.sdk.object.conversation.Topic;
import com.aldebaran.qi.sdk.object.locale.Language;
import com.aldebaran.qi.sdk.object.locale.Locale;
import com.aldebaran.qi.sdk.object.locale.Region;
import com.example.kstantm.databinding.ActivityMain2Binding;
import com.example.kstantm.databinding.ActivityMain7Binding;

import java.util.Map;

public class MainActivity7 extends RobotActivity implements RobotLifecycleCallbacks {

    ActivityMain7Binding binding;
    private QiChatbot qiChatbot;
    private Chat chat;

    Bookmark bookmark;
    Bookmark bookmark1;
    Bookmark bookmark2;
    Bookmark bookmark3;
    Bookmark bookmark4;
    Bookmark bookmark5;
    Bookmark bookmark6;
    Bookmark bookmark7;
    Bookmark bookmark8;
    Bookmark bookmark9;
    Bookmark bookmark10;
    Bookmark bookmark11;
    BookmarkStatus bookmarkStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMain7Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Register the RobotLifecycleCallbacks to this Activity.
        QiSDK.register(this, this);
        binding.button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(bookmark1, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);

            }
        });
        binding.button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(bookmark, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);

            }
        });
        binding.button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(bookmark2, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);

            }
        });
        binding.button26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(bookmark3, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);

            }
        });
        binding.button27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(bookmark4, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);

            }
        });
        binding.button28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(bookmark5, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);

            }
        });
        binding.button29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(bookmark6, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);

            }
        });
        binding.button30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(bookmark7, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);

            }
        });
        binding.button32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(bookmark8, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);

            }
        });
        binding.button33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(bookmark9, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);

            }
        });
        binding.button34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(bookmark11,AutonomousReactionImportance.HIGH,AutonomousReactionValidity.IMMEDIATE);
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
        // The robot focus is gained.
        // The robot focus is gained.
        // Create a topic.
        Locale locale = new Locale(Language.TURKISH, Region.TURKEY);

        Topic topic = TopicBuilder.with(qiContext) // Create the builder using the QiContext.
                .withResource(R.raw.bolum) // Set the topic resource.
                .build(); // Build the topic.

        // Create a new QiChatbot.
        qiChatbot = QiChatbotBuilder.with(qiContext)
                .withTopic(topic)
                .withLocale(locale)
                .build();
        // Create a new Chat action.
        chat = ChatBuilder.with(qiContext)
                .withChatbot(qiChatbot)
                .withLocale(locale)
                .build();
        Map<String, Bookmark> bookmarks = topic.getBookmarks();
           bookmark=bookmarks.get("muh");
           bookmark1=bookmarks.get("tip");
           bookmark2=bookmarks.get("sag");
           bookmark3=bookmarks.get("ikt");
           bookmark4=bookmarks.get("fen");
           bookmark5=bookmarks.get("egi");
           bookmark6=bookmarks.get("guzel");
           bookmark7=bookmarks.get("ila");
           bookmark8=bookmarks.get("dis");
           bookmark9=bookmarks.get("orman");
           bookmark10=bookmarks.get("geri");
           bookmark11=bookmarks.get("geribas");
           bookmarkStatus=qiChatbot.bookmarkStatus(bookmark10);

           bookmarkStatus.addOnReachedListener(()->{
               Intent intent=new Intent(MainActivity7.this,MainActivity2.class);
               startActivity(intent);
           });

            chat.async().run();



    }

    @Override
    public void onRobotFocusLost() {
        // The robot focus is lost.
        if(chat!=null){
            chat.removeAllOnStartedListeners();
        }
        if(bookmarkStatus!=null){
            bookmarkStatus.removeAllOnReachedListeners();
        }
    }

    @Override
    public void onRobotFocusRefused(String reason) {
        // The robot focus is refused.
    }
}