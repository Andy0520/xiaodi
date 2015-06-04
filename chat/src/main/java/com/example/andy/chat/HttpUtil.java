package com.example.andy.chat;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by 王杰 on 2015/6/4.
 */
public class HttpUtil{
    public static final String API="http://www.tuling123.com/openapi/api";
    public static final String KEY="ba33716e18650b6b787ec19244982674";
    public static StringBuilder doGet(final Handler handler, final String msg){
        final StringBuilder sb=new StringBuilder();
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection conn=null;
                String line="";
                try {
                    URL url=new URL(API+"?key="+KEY+"&info="+ URLEncoder.encode(msg,"UTF-8"));
                    Log.d("url",url+"");
                    conn= (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(5 * 1000);
                    InputStream is=conn.getInputStream();
                    InputStreamReader isr=new InputStreamReader(is);
                    BufferedReader buff=new BufferedReader(isr);
                    while((line=buff.readLine())!=null){
                        sb.append(line);
                    }
                    Log.d("SB",sb+"");
                    Message msg=handler.obtainMessage();
                    msg.obj=sb;
                    handler.sendMessage(msg);
                    buff.close();
                    isr.close();
                    is.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return sb;
    }
}
