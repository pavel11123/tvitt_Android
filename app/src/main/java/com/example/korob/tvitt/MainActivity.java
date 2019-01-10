package com.example.korob.tvitt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.korob.tvitt.adapter.TweetAdapter;
import com.example.korob.tvitt.pojo.Tweet;
import com.example.korob.tvitt.pojo.User;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    private ImageView userImageView;
    private TextView nameTextView;
    private TextView nickTextView;
    private TextView descriptionTextView;
    private TextView locationTextView;
    private TextView followingCountTextView;
    private TextView followersCountTextView;

    private RecyclerView tweetsRecyclerView;
    private TweetAdapter tweetAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userImageView = findViewById(R.id.user_image_view);

        nameTextView = findViewById(R.id.user_name_text_view);
        nickTextView = findViewById(R.id.user_nick_text_view);
        descriptionTextView = findViewById(R.id.user_description_text_view);
        locationTextView = findViewById(R.id.user_location_text_view);
        followingCountTextView = findViewById(R.id.following_count_text_view);
        followersCountTextView = findViewById(R.id.followers_count_text_view);

        initRecyclerView();

        loadUserInfo();
        loadTweets();
    }

    private  void loadTweets(){
        Collection<Tweet> tweets = getTweets();
        tweetAdapter.setItems(tweets);
    }

    private Collection<Tweet> getTweets(){
        return Arrays.asList(
                new Tweet(getUser(), 1L, "Thu Dec 13 07:31:08 +0000 2017", "Река в Европейской части России. Небольшая часть дельты Волги, вне основного русла реки, находится на территории Казахстана. Волга является одной из крупнейших рек на Земле и самой большой по водности и длине в Европе. Кроме того, Волга является крупнейшей в мире рекой",
                        1983L, 436L, "https://www.w3schools.com/w3css/img_fjords.jpg"),
                new Tweet(getUser(), 2L, "Thu Dec 12 07:31:08 +0000 2017", "Свечение (люминесценция) верхних слоёв атмосфер планет, обладающих магнитосферой, вследствие их взаимодействия с заряжёнными частицами солнечного ветра.",
                        2039L, 501L, "https://www.w3schools.com/w3images/lights.jpg"),
                new Tweet(getUser(), 1L, "Thu Dec 13 07:31:08 +0000 2017", "Река в Европейской части России. Небольшая часть дельты Волги, вне основного русла реки, находится на территории Казахстана. Волга является одной из крупнейших рек на Земле и самой большой по водности и длине в Европе. Кроме того, Волга является крупнейшей в мире рекой",
                        1983L, 436L, "https://www.w3schools.com/w3css/img_fjords.jpg"),
                new Tweet(getUser(), 2L, "Thu Dec 12 07:31:08 +0000 2017", "Свечение (люминесценция) верхних слоёв атмосфер планет, обладающих магнитосферой, вследствие их взаимодействия с заряжёнными частицами солнечного ветра.",
                        2039L, 501L, "https://www.w3schools.com/w3images/lights.jpg"),
                new Tweet(getUser(), 1L, "Thu Dec 13 07:31:08 +0000 2017", "Река в Европейской части России. Небольшая часть дельты Волги, вне основного русла реки, находится на территории Казахстана. Волга является одной из крупнейших рек на Земле и самой большой по водности и длине в Европе. Кроме того, Волга является крупнейшей в мире рекой",
                        1983L, 436L, "https://www.w3schools.com/w3css/img_fjords.jpg"),
                new Tweet(getUser(), 2L, "Thu Dec 12 07:31:08 +0000 2017", "Свечение (люминесценция) верхних слоёв атмосфер планет, обладающих магнитосферой, вследствие их взаимодействия с заряжёнными частицами солнечного ветра.",
                        2039L, 501L, "https://www.w3schools.com/w3images/lights.jpg"),
                new Tweet(getUser(), 3L, "Thu Dec 11 07:31:08 +0000 2017", "В античных источниках, Урал отчасти связывают с Рифейскими горами и чаще с Гиперборейскими горами. По данным Птолемея Уральские горы состоят из гор Римнус, Норосы, «Норосские» — Южный Урал, с которых течёт река Яик и северной частью — Гиперборейские. Рипейские горы — однозначно водораздел между бассейнами Каспия, Чёрного моря и Балтики",
                        1002L, 204L, "https://www.w3schools.com/css/img_mountains.jpg")
        );
    }

    private void initRecyclerView(){
        tweetsRecyclerView = findViewById(R.id.tweets_recycler_view);
        tweetsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        tweetAdapter = new TweetAdapter();
        tweetsRecyclerView.setAdapter(tweetAdapter);
    }

    private void loadUserInfo() {
        User user = getUser();
        displayUserInfo(user);
    }


    private void displayUserInfo(User user){
        Picasso.with(this).load(user.getImageUrl()).into(userImageView);
        nameTextView.setText(user.getName());
        nickTextView.setText(user.getNick());
        descriptionTextView.setText(user.getDescription());
        locationTextView.setText(user.getLocation());

        String followingCount = String.valueOf(user.getFollowingCount());
        followingCountTextView.setText(followingCount);

        String followersCount = String.valueOf(user.getFollowersCount());
        followersCountTextView.setText(followersCount);
    }



    private User getUser() {
        return new User (
                1L,
                "http://i.imgur.com/DvpvklR.png",
                "Korobko Pavel",
                "Pavel",
                "20 лет. " +
                        "Университет ОмГТУ " +
                        "г.Омск",
                "Russia",
                1024,
                54359
        );
    }
}
