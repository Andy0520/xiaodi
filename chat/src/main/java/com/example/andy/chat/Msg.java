package com.example.andy.chat;

/**
 * Created by Andy on 2015/6/4.
 */
public class Msg {

    public static final int TYPE_RECEIVED=0;
    public static final int TYPE_SENT=1;
    private String content;
    private int type;

    public Msg(String content,int type){
        this.content=content;
        this.type=type;
    }

    public String getContent(){
        return content;
    }

    public int getType(){
        return type;
    }
}
