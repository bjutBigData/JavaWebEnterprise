package com.panda.daoFactory;

import com.panda.dao.VoteDAO;
import com.panda.daoImpl.VoteDAOImpl;

/**
 * Created by Panda on 2016/5/17.
 */
public class VoteDAOFactory {
    public static VoteDAO getVoteDAOInstance(){                //������������������DAOʵ����ʵ��
        return new VoteDAOImpl();                               //����DAOʵ����ʵ��
    }
}
