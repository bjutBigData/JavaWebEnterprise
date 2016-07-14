package com.panda.action;

/**
 * Created by Panda on 2016/5/16.
 */

import java.util.UUID;

import com.opensymphony.xwork2.ActionSupport;
import com.panda.bean.Vote;
import com.panda.bean.VoteOption;
import com.panda.dao.VoteDAO;
import com.panda.dao.VoteOptionDAO;
import com.panda.daoFactory.VoteDAOFactory;
import com.panda.daoFactory.VoteOptionDAOFactory;

public class AddVoteAction extends ActionSupport {
    private int channel;                        //封装channnel参数
    private String voteName;
    private String[] voteOption;

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public String getVoteName() {
        return voteName;
    }

    public void setVoteName(String voteName) {
        this.voteName = voteName;
    }

    public String[] getVoteOption() {
        return voteOption;
    }

    public void setVoteOption(String[] voteOption) {
        this.voteOption = voteOption;
    }

    public String execute() throws Exception {
        VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();          //获取voteDAO实例
        VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
        //首先保存投票。然后再进行保存投票选项
        Vote vote = new Vote();
        vote.setChannelID(channel);
        vote.setVoteName(voteName);
        voteDAO.addVote(vote);

        //查询投票ID
        int voteID = voteDAO.findVoteByName(voteName).getVoteID();
        //保存投票选项
        for(String voteOptionName : voteOption){
            VoteOption vp = new VoteOption();
            vp.setVoteID(voteID);
            vp.setVoteOptionName(voteOptionName);
            voteOptionDAO.addVoteOption(vp);
        }
        return this.SUCCESS;
    }
}













