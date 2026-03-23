
package com.iptv.pro;

import android.content.Context;
import java.io.*;
import java.util.*;

public class AssetLoader {

    public static List<Channel> loadAll(Context c){
        List<Channel> list=new ArrayList<>();
        try{
            String[] files=c.getAssets().list("channels");
            for(String f:files){
                InputStream is=c.getAssets().open("channels/"+f);
                BufferedReader r=new BufferedReader(new InputStreamReader(is));
                String line,name="";
                while((line=r.readLine())!=null){
                    if(line.startsWith("#EXTINF")){
                        name=line.substring(line.indexOf(",")+1);
                    }else if(line.startsWith("http")){
                        list.add(new Channel(name,line));
                    }
                }
            }
        }catch(Exception e){e.printStackTrace();}
        return list;
    }
}
