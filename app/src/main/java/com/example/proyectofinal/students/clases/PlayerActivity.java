package com.example.proyectofinal.students.clases;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;

import com.example.proyectofinal.R;
import com.google.api.services.youtube.YouTube;

public class PlayerActivity extends YoutubeBaseActivity implements YoutubePlayer.OnInitializedListener{
    YoutubePlayer player;
    Button fullScreen;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_stu_test);
        YoutubePlayerView playerView = (YouTubePlayerview)findViewById(R.id.youTubePlayerView);
        playerView.initialize(DeveloperKey.DEVELOPER_KEY,this);
        fullScreen = (Button)findViewById(R.id.getStream);
        fullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.setFullscreen(true);
            }
        });
    }
    @Override
    public void onInitializationSucess(YouTubePlayer.Provider, YouTubePlayer player,boolean b){
        this.player = player;
        if (!b){
            player.setPlayerStyle(YouTubePlayer.PlayerStyle.MINIMAL);
            player.loadVideo("PXj5QghExJA");
        }
    }
    @Override
    public void onInitializationFailure(YoutubePlayer.Provider provider,YoutubeInitializationResult youtubeInitializationResult){

    }
}
