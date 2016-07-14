package com.panda.action;

import com.opensymphony.xwork2.ActionSupport;
import com.panda.bean.VoteOption;
import com.panda.dao.VoteOptionDAO;
import com.panda.daoFactory.VoteOptionDAOFactory;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;

/**
 * Created by Panda on 2016/5/23.
 */
public class DoVoteAction extends ActionSupport {
    private int voteOptionID;       //ѡ��ID
    private String otherOption;     //��ȡ�û����������ѡ��
    private int voteID;             //ͶƱID
    private int channelID;          //Ƶ��ID

    public int getChannelID() {
        return channelID;
    }

    public void setChannelID(int channelID) {
        this.channelID = channelID;
    }

    public int getVoteID() {
        return voteID;
    }

    public void setVoteID(int voteID) {
        this.voteID = voteID;
    }

    public int getVoteOptionID() {
        return voteOptionID;
    }

    public String getOtherOption() {
        return otherOption;
    }

    public void setOtherOption(String otherOption) {
        this.otherOption = otherOption;
    }

    public String execute() throws Exception{
        VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
        //�����ж��û��Ƿ��ܽ���ͶƱ
        Cookie[] cookies = ServletActionContext.getRequest().getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getValue().equals(Integer.toString(voteID))){
                this.addActionError("�������Ѿ�ͶƱ�ˣ�����������");
                return this.INPUT;
            }
        }
        //�ж��Ƿ�ѡ������ѡ��
        if(voteOptionID == 0){
            //��Ӹ�ѡ��
            VoteOption voteOption = new VoteOption();
            voteOption.setVoteID(voteID);
            voteOption.setVoteOptionName(otherOption);
            voteOption.setTicketNum(1);
            voteOptionDAO.addVoteOption(voteOption);
        }else {
            //ȡ����ǰ��ͶƱѡ��
            VoteOption voteOption = voteOptionDAO.findVoteOptionById(voteOptionID);
            int ticketNum = voteOption.getTicketNum();
            //����ѡ���ͶƱ��
            voteOption.setTicketNum(ticketNum + 1);
            voteOptionDAO.updateVoteOption(voteOption);
            //������ɺ����cookie����ֹ�ظ�ͶƱ
            Cookie cookie = new Cookie("hasVote" + voteID, Integer.toString(voteID));
            ServletActionContext.getResponse().addCookie(cookie);
        }
        return this.SUCCESS;
    }
}
