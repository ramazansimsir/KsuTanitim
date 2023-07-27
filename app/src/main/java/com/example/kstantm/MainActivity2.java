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

import java.util.Map;

public class MainActivity2 extends RobotActivity implements RobotLifecycleCallbacks {

    ActivityMain2Binding design;
    private QiChatbot qiChatbot;
    private Chat chat;
    private BookmarkStatus bookmarkStatus;
    private BookmarkStatus bookmarkStatus2;
    private BookmarkStatus bookmarkStatus3;
    private BookmarkStatus bookmarkStatus4;
    private BookmarkStatus bookmarkStatus5;
    private Bookmark tarihBookmark;
    private Bookmark vizyon;
    private Bookmark neden;
    private  Bookmark misyon;
    private Bookmark kareler;
    private Bookmark yurt;
    private Bookmark ulus;
    private Bookmark tvideo;
    private Bookmark bolum1;
    private Bookmark ilet;
    private Bookmark iletisim;
    private BookmarkStatus bookmarkStatus6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Register the RobotLifecycleCallbacks to this Activity.
        design=ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(design.getRoot());
        QiSDK.register(this, this);

        design.d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            qiChatbot.async().goToBookmark(tarihBookmark, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);
            }
        });
        design.d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(vizyon, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);
            }
        });
        design.d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(misyon, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);
            }
        });
        design.d4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(neden, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);
            }
        });
        design.d5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(kareler, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);
            }
        });
        design.d6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(yurt, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);
            }
        });
        design.d7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(ulus, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);
            }
        });
        design.d8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(tvideo, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);
            }
        });
        design.d9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(bolum1, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);
            }
        });

        design.d10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiChatbot.async().goToBookmark(ilet, AutonomousReactionImportance.HIGH, AutonomousReactionValidity.IMMEDIATE);
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
                .withResource(R.raw.intro) // Set the topic resource.
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
        Bookmark bookmark=bookmarks.get("resim");
        Bookmark bookmark2=bookmarks.get("video");
        Bookmark bookmark3=bookmarks.get("erasmus");
        Bookmark bookmark4=bookmarks.get("tanitim");
        Bookmark bookmark5=bookmarks.get("bolum");
        tarihBookmark=bookmarks.get("tarih");
        vizyon=bookmarks.get("vizyon");
        misyon=bookmarks.get("misyon");
        neden=bookmarks.get("neden");
        kareler=bookmarks.get("kareler");
        yurt=bookmarks.get("yurt");
        ulus=bookmarks.get("uluslar");
        tvideo=bookmarks.get("tvideo");
        bolum1=bookmarks.get("bolum1");
        ilet=bookmarks.get("ilet");
        iletisim=bookmarks.get("iletisim");

        bookmarkStatus=qiChatbot.bookmarkStatus(bookmark);
        bookmarkStatus2=qiChatbot.bookmarkStatus(bookmark2);
        bookmarkStatus3=qiChatbot.bookmarkStatus(bookmark3);
        bookmarkStatus4=qiChatbot.bookmarkStatus(bookmark4);
        bookmarkStatus5=qiChatbot.bookmarkStatus(bookmark5);
        bookmarkStatus6=qiChatbot.bookmarkStatus(iletisim);



        bookmarkStatus.addOnReachedListener(()->{
            Intent intent=new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(intent);
        });
        bookmarkStatus2.addOnReachedListener(()->{
            Intent intent=new Intent(MainActivity2.this, MainActivity4.class);
            intent.putExtra("deger",1);
            startActivity(intent);
        });
        bookmarkStatus3.addOnReachedListener(()->{
            Intent intent=new Intent(MainActivity2.this, MainActivity4.class);
            intent.putExtra("deger",2);
            startActivity(intent);
        });
        bookmarkStatus4.addOnReachedListener(()->{
            Intent intent=new Intent(MainActivity2.this, MainActivity4.class);
            intent.putExtra("deger",3);
            startActivity(intent);
        });
        bookmarkStatus5.addOnReachedListener(()->{
            Intent intent2=new Intent(MainActivity2.this,MainActivity7.class);
            startActivity(intent2);
        });
        bookmarkStatus6.addOnReachedListener(()->{
            Intent intent= new Intent(MainActivity2.this,MainActivity6.class);
            startActivity(intent);
        });


        chat.async().run();



    }

    @Override
    public void onRobotFocusLost() {
        // The robot focus is lost.
        if (chat!=null){
            chat.removeAllOnStartedListeners();
        }
        if(bookmarkStatus!=null){
            bookmarkStatus.removeAllOnReachedListeners();
        }
        if(bookmarkStatus2!=null){
            bookmarkStatus2.removeAllOnReachedListeners();
        }
        if (bookmarkStatus3!=null){
            bookmarkStatus3.removeAllOnReachedListeners();
        }
        if (bookmarkStatus4!=null){
            bookmarkStatus3.removeAllOnReachedListeners();
        }
        if(bookmarkStatus5!=null){
            bookmarkStatus5.removeAllOnReachedListeners();
        }
        if(bookmarkStatus6!=null){
            bookmarkStatus6.removeAllOnReachedListeners();
        }

    }

    @Override
    public void onRobotFocusRefused(String reason) {
        // The robot focus is refused.
    }
}