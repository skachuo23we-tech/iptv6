
package com.iptv.pro;

import android.content.*;
import android.view.*;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.*;

public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.H> {

    Context c; List<Channel> list;

    public ChannelAdapter(Context c,List<Channel> l){this.c=c;this.list=l;}

    public H onCreateViewHolder(ViewGroup p,int v){
        return new H(LayoutInflater.from(c).inflate(R.layout.item,p,false));
    }

    public void onBindViewHolder(H h,int i){
        Channel ch=list.get(i);
        h.t.setText(ch.name);
        h.itemView.setOnClickListener(v->{
            Intent in=new Intent(c,PlayerActivity.class);
            in.putExtra("url",ch.url);
            c.startActivity(in);
        });
    }

    public int getItemCount(){return list.size();}

    static class H extends RecyclerView.ViewHolder{
        TextView t;
        H(View v){super(v); t=v.findViewById(R.id.t);}
    }
}
