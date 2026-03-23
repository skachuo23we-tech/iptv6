
package com.iptv.pro;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new GridLayoutManager(this, 3));

        List<Channel> list = AssetLoader.loadAll(this);

        ChannelAdapter adapter = new ChannelAdapter(this, list);
        recycler.setAdapter(adapter);
    }
}
