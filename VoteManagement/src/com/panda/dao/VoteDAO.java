package com.panda.dao;

/**
 * Created by Panda on 2016/5/16.
 */
import java.util.List;

import com.panda.bean.Vote;
import com.panda.util.Page;


public interface VoteDAO {
    public void addVote(Vote vote);                         //���ͶƱ
    public void updateVote(Vote vote);                      //����ͶƱ
    public void deleteVote(int voteID);                     //ɾ��ͶƱ
    public List<Vote> findAllVote(Page page);               //��ҳ��ѯ����ͶƱ
    public List<Vote> findVoteByChannel(Page page, int channelID);       //��ҳ��ѯÿ��Ƶ����ͶƱ
    public Vote findVoteById(int voteID);                   //ͨ��ID��ѯͶƱ
    public Vote findVoteByName(String voteName);            //ͬ�����ֲ�ѯͶƱ
    public int findAllCount();                              //��ѯ���м�¼��
    public int findCountByChannel(int channelID);           //��ѯÿ��Ƶ���µļ�¼��
}
