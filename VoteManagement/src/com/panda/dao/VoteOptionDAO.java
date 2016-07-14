package com.panda.dao;

/**
 * Created by Panda on 2016/5/16.
 */
import java.util.List;

import com.panda.bean.VoteOption;


public interface VoteOptionDAO {
    public void addVoteOption(VoteOption voteOption);               //添加投票选项
    public void updateVoteOption(VoteOption voteOption);            //增加投票选项
    public void deleteVoteOption(int voteOptionID);                   //删除投票选项
    public List<VoteOption> findVoteOptionByVoteID(int voteID);     //查询所有投票选项
    public VoteOption findVoteOptionById(int voteOptionID);         //通过ID查询投票选项
}
