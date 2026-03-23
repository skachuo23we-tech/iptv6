
package com.iptv.pro;

import android.net.Uri;
import android.os.*;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.exoplayer2.*;
import com.google.android.exoplayer2.ui.PlayerView;

public class PlayerActivity extends AppCompatActivity {

    PlayerView playerView;
    ExoPlayer player;
    Handler handler = new Handler();
    String url;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_player);

        playerView = findViewById(R.id.playerView);
        url = getIntent().getStringExtra("url");

        player = new ExoPlayer.Builder(this).build();
        playerView.setPlayer(player);

        play();

        player.addListener(new Player.Listener() {
            @Override
            public void onPlayerError(PlaybackException error) {
                handler.postDelayed(() -> play(), 5000);
                Toast.makeText(PlayerActivity.this, "Reconnecting...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void play() {
        MediaItem item = MediaItem.fromUri(Uri.parse(url));
        player.setMediaItem(item);
        player.prepare();
        player.play();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.release();
    }
}
