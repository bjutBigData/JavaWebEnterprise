package com.panda.bean;

/**
 * Created by Panda on 2016/5/14.
 */
public class Channel {
    private int ChannelID;               //ÆµµÀID
    private String ChannelName;          //ÆµµÀÃû³Æ

    public int getChannelID() {
        return ChannelID;
    }
    public void setChannelID(int chaneelID){
        this.ChannelID = chaneelID;
    }
    public String getChannelName(){
        return ChannelName;
    }
    public void setChannelName(String ChannelName){
        this.ChannelName = ChannelName;
    }
}
