package com.panda.dao;

/**
 * Created by Panda on 2016/5/16.
 */
import java.util.List;

import com.panda.bean.VoteOption;


public interface VoteOptionDAO {
    public void addVoteOption(VoteOption voteOption);               //���ͶƱѡ��
    public void updateVoteOption(VoteOption voteOption);            //����ͶƱѡ��
    public void deleteVoteOption(int voteOptionID);                   //ɾ��ͶƱѡ��
    public List<VoteOption> findVoteOptionByVoteID(int voteID);     //��ѯ����ͶƱѡ��
    public VoteOption findVoteOptionById(int voteOptionID);         //ͨ��ID��ѯͶƱѡ��
}
