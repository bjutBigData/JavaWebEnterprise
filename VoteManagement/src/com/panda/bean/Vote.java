package com.panda.bean;

/**
 * Created by Panda on 2016/5/14.
 */
public class Vote {
    private int voteID;                          //ͶƱID
    private String voteName;                     //ͶƱ����
    private int channelID;                       //Ƶ��ID

    public int getVoteID(){
        return voteID;
    }
    public void setVoteID(int voteID){
        this.voteID = voteID;
    }
    public String getVoteName(){                 //��ȡͶƱ����
        return voteName;
    }
    public void setVoteName(String voteName){
        this.voteName = voteName;
    }
    public int getChannelID(){
        return channelID;
    }
    public void setChannelID(int channelID){
        this.channelID = channelID;
    }
}
