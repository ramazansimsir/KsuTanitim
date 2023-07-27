package com.example.kstantm;


import android.content.Intent;
import android.net.Uri;
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

import com.example.kstantm.databinding.ActivityMain6Binding;

import java.util.Map;


public class MainActivity6 extends RobotActivity implements RobotLifecycleCallbacks {

    ActivityMain6Binding binding;
    Uri uri;
    private QiChatbot qiChatbot;
    private Chat chat;
    private  Bookmark bookmark;
    BookmarkStatus bookmarkStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Register the RobotLifecycleCallbacks to this Activity.
        binding = ActivityMain6Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        QiSDK.register(this, this);
        binding.buton25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(bookmark, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);
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
        // Create a topic.
        Locale locale = new Locale(Language.TURKISH, Region.TURKEY);

        Topic topic = TopicBuilder.with(qiContext) // Create the builder using the QiContext.
                .withResource(R.raw.ilet) // Set the topic resource.
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

        bookmark=bookmarks.get("tanıtım");
        bookmarkStatus=qiChatbot.bookmarkStatus(bookmark);
        bookmarkStatus.addOnReachedListener(()->{

            Intent intent=new Intent(MainActivity6.this,MainActivity2.class);
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