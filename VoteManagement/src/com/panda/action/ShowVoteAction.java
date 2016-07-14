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
 * Created by Panda on 2016/5/17.
 */
public class ShowVoteAction extends ActionSupport {
    private int currentPage;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public  String execute() throws Exception{
        VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
        VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
        int totalCount = voteDAO.findAllCount();
        Page page = PageUtil.createPage(10, totalCount, currentPage);
        List<Vote> votes = voteDAO.findAllVote(page);
        List<VoteResult> voteResultList = new ArrayList<VoteResult>();
        for (Vote vote : votes){
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
