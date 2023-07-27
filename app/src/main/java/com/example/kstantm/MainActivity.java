package com.example.kstantm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.aldebaran.qi.Future;
import com.aldebaran.qi.sdk.QiContext;
import com.aldebaran.qi.sdk.QiSDK;
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks;
import com.aldebaran.qi.sdk.builder.AnimateBuilder;
import com.aldebaran.qi.sdk.builder.AnimationBuilder;
import com.aldebaran.qi.sdk.builder.ChatBuilder;
import com.aldebaran.qi.sdk.builder.QiChatbotBuilder;
import com.aldebaran.qi.sdk.builder.TopicBuilder;
import com.aldebaran.qi.sdk.design.activity.RobotActivity;
import com.aldebaran.qi.sdk.object.actuation.Animate;
import com.aldebaran.qi.sdk.object.actuation.Animation;
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
import com.example.kstantm.databinding.ActivityMainBinding;

import java.util.Map;

public class MainActivity extends RobotActivity implements RobotLifecycleCallbacks {

    ActivityMainBinding design;
    private QiChatbot qiChatbot;
    // Store the Chat action.
    private Chat chat;
    private BookmarkStatus bookmarkStatus;
    private BookmarkStatus bookmarkStatus1;
    private BookmarkStatus bookmarkStatus2;
    private BookmarkStatus bookmarkStatus3;
    private BookmarkStatus bookmarkStatus4;
    private Bookmark bookmark4;
    private Bookmark tanit;
    private Bookmark iyi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Register the RobotLifecycleCallbacks to this Activity.
        design=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(design.getRoot());
        QiSDK.register(this, this);
        design.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(bookmark4, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);
            }
        });
        design.buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(iyi, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);
            }
        });
        design.buton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(tanit, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);
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
                .withResource(R.raw.first) // Set the topic resource.
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


        // Add an on started listener to the Chat action
        Map<String, Bookmark> bookmarks = topic.getBookmarks();
        Bookmark bookmark=bookmarks.get("first");
        Bookmark bookmark1=bookmarks.get("firstEnd");
        Bookmark bookmark2=bookmarks.get("second");
        Bookmark bookmark3=bookmarks.get("third");
        bookmark4=bookmarks.get("fourth");
        tanit=bookmarks.get("tanit");
        iyi=bookmarks.get("iyi");
        bookmarkStatus=qiChatbot.bookmarkStatus(bookmark);
        bookmarkStatus1=qiChatbot.bookmarkStatus(bookmark1);
        bookmarkStatus2=qiChatbot.bookmarkStatus(bookmark2);
        bookmarkStatus3=qiChatbot.bookmarkStatus(bookmark3);
        bookmarkStatus4=qiChatbot.bookmarkStatus(bookmark4);


        chat.addOnStartedListener(()->{
       qiChatbot.async().goToBookmark(bookmark, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);
        });

        bookmarkStatus.addOnReachedListener(()->{
//// Create an animation object.
//            Animation myAnimation = AnimationBuilder.with(qiContext)
//                    .withResources(R.raw.hello_a010)
//                    .build();
//
//// Build the action.
//            Animate animate = AnimateBuilder.with(qiContext)
//                    .withAnimation(myAnimation)
//                    .build();
//
//// Run the action asynchronously.
//            animate.async().run();

        });
        bookmarkStatus1.addOnReachedListener(()->{
            // Create an animation object.
            Animation myAnimation = AnimationBuilder.with(qiContext)
                    .withResources(R.raw.drink_left_b001)
                    .build();

// Build the action.
            Animate animate = AnimateBuilder.with(qiContext)
                    .withAnimation(myAnimation)
                    .build();

// Run the action asynchronously.
            animate.async().run();

        });
        bookmarkStatus2.addOnReachedListener(()->{
            Intent intent=new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });
        bookmarkStatus3.addOnReachedListener(()->{
            // Create an animation object.
            Animation myAnimation = AnimationBuilder.with(qiContext)
                    .withResources(R.raw.affirmation_a003)
                    .build();

// Build the action.
            Animate animate = AnimateBuilder.with(qiContext)
                    .withAnimation(myAnimation)
                    .build();

// Run the action asynchronously.
            animate.async().run();

        });
        bookmarkStatus4.addOnReachedListener(()->{
            // Create an animation object.
            Animation myAnimation = AnimationBuilder.with(qiContext)
                    .withResources(R.raw.hello_a010)
                    .build();

// Build the action.
            Animate animate = AnimateBuilder.with(qiContext)
                    .withAnimation(myAnimation)
                    .build();

// Run the action asynchronously.
            animate.async().run();

        });






        // Run the Chat action asynchronously.
        Future<Void> chatFuture = chat.async().run();

    }

    @Override
    public void onRobotFocusLost() {
        // The robot focus is lost.
        // Remove on started listeners from the Chat action.
        if (chat != null) {
            chat.removeAllOnStartedListeners();
        }
        if(bookmarkStatus1!=null){
            bookmarkStatus1.removeAllOnReachedListeners();
        }
        if(bookmarkStatus!=null){
            bookmarkStatus.removeAllOnReachedListeners();
        }
        if(bookmarkStatus2!=null){
            bookmarkStatus2.removeAllOnReachedListeners();
        }
        if(bookmarkStatus3!=null){
            bookmarkStatus3.removeAllOnReachedListeners();
        }
        if(bookmarkStatus4!=null){
            bookmarkStatus4.removeAllOnReachedListeners();
        }

    }

    @Override
    public void onRobotFocusRefused(String reason) {
        // The robot focus is refused.
    }
}


