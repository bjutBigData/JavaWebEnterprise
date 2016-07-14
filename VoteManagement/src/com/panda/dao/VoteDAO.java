package com.panda.dao;

/**
 * Created by Panda on 2016/5/16.
 */
import java.util.List;

import com.panda.bean.Vote;
import com.panda.util.Page;


public interface VoteDAO {
    public void addVote(Vote vote);                         //添加投票
    public void updateVote(Vote vote);                      //更新投票
    public void deleteVote(int voteID);                     //删除投票
    public List<Vote> findAllVote(Page page);               //分页查询所有投票
    public List<Vote> findVoteByChannel(Page page, int channelID);       //分页查询每个频道的投票
    public Vote findVoteById(int voteID);                   //通过ID查询投票
    public Vote findVoteByName(String voteName);            //同名名字查询投票
    public int findAllCount();                              //查询所有记录数
    public int findCountByChannel(int channelID);           //查询每个频道下的记录数
}
