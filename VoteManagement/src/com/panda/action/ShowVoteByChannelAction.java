package com.panda.action;

import com.opensymphony.xwork2.ActionSupport;
import com.panda.bean.Vote;
import com.panda.bean.VoteOption;
import com.panda.bean.VoteResult;
import com.panda.dao.VoteDAO;
import com.panda.dao.VoteOptionDAO;
import com.panda.daoFactory.VoteDAOFactory;
import com.panda.daoFactory.VoteOptionDAOFactory;
import com.panda.util.Page;
import com.panda.util.PageUtil;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Panda on 2016/5/23.
 */
public class ShowVoteByChannelAction extends ActionSupport{
    private int channelID;
    private int currentPage;

    public int getChannelID() {
        return channelID;
    }

    public void setChannelID(int channelID) {
        this.channelID = channelID;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String execute() throws Exception {
        VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
        VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
        //获得该频道下的记录数
        int totalCount = voteDAO.findCountByChannel(channelID);
        //设置分页信息
        Page page = PageUtil.createPage(3, totalCount, currentPage);
        //获取该频道下的记录
        List<Vote> votes = voteDAO.findVoteByChannel(page, channelID);
        //存放所有投票和选项
        List<VoteResult> voteResultList = new ArrayList<VoteResult>();
        for(Vote vote : votes){
            //查询该投票下的所有投票选项
            List<VoteOption> voteOptions = voteOptionDAO.findVoteOptionByVoteID(vote.getVoteID());
            VoteResult voteResult = new VoteResult();
            voteResult.setVote(vote);
            voteResult.setVoteOptions(voteOptions);
            voteResultList.add(voteResult);
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("voteResultList", voteResultList);
        request.setAttribute("page", page);
        return this.SUCCESS;
    }
}










