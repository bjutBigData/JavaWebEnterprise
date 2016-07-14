package com.panda.action;

import com.opensymphony.xwork2.ActionSupport;
import com.panda.bean.VoteOption;
import com.panda.dao.VoteDAO;
import com.panda.dao.VoteOptionDAO;
import com.panda.daoFactory.VoteDAOFactory;
import com.panda.daoFactory.VoteOptionDAOFactory;

import java.util.List;

/**
 * Created by Panda on 2016/5/23.
 */
public class DeleteVoteAction extends ActionSupport {
    private int voteID;

    public int getVoteID() {
        return voteID;
    }

    public void setVoteID(int voteID) {
        this.voteID = voteID;
    }

    public String execute() throws Exception{
        VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
        VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();

        List<VoteOption> voteOptions = voteOptionDAO.findVoteOptionByVoteID(voteID);
        //Ñ­»·É¾³ý
        for(VoteOption voteOption : voteOptions) {
            voteOptionDAO.deleteVoteOption(voteOption.getVoteOptionID());
        }
        voteDAO.deleteVote(voteID);
        return this.SUCCESS;
    }
}
