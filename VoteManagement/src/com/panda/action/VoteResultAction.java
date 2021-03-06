package com.panda.action;

import com.opensymphony.xwork2.ActionSupport;
import com.panda.bean.Vote;
import com.panda.bean.VoteOption;
import com.panda.dao.VoteDAO;
import com.panda.dao.VoteOptionDAO;
import com.panda.daoFactory.VoteDAOFactory;
import com.panda.daoFactory.VoteOptionDAOFactory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.List;


/**
 * Created by Panda on 2016/5/23.
 */
public class VoteResultAction extends ActionSupport {
    private JFreeChart chart;
    private int voteID; //投票ID

    public int getVoteID() {
        return voteID;
    }

    public void setVoteID(int voteID) {
        this.voteID = voteID;
    }

    public JFreeChart getChart() {
        VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
        VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();

        //根据投票ID得到的投票
        Vote vote = voteDAO.findVoteById(voteID);
        String voteName = vote.getVoteName();

        //根据投票ID得到所有的投票选项
        List<VoteOption> voteOptions = voteOptionDAO.findVoteOptionByVoteID(voteID);

        DefaultCategoryDataset dcd = new DefaultCategoryDataset(); //数据源

        //设置数据
        for(VoteOption voteOption : voteOptions) {
            dcd.setValue(voteOption.getTicketNum(), "", voteOption.getVoteOptionName());
        }
        //使用工厂类创建柱状图
        JFreeChart chart = ChartFactory.createBarChart3D(
                voteName,
                "投票选项",
                "投票数",
                dcd,
                PlotOrientation.VERTICAL,
                false,
                true,
                false);
        return chart;
    }

    public void setChart(JFreeChart chart) {
        this.chart = chart;
    }
    public String execute() throws Exception{
        return SUCCESS;
    }
}
