package com.panda.daoFactory;

import com.panda.dao.VoteOptionDAO;
import com.panda.daoImpl.VoteOptionDAOImpl;

/**
 * Created by Panda on 2016/5/17.
 */
public class VoteOptionDAOFactory {
    public static VoteOptionDAO getVoteOptionDAOInstance(){
        return new VoteOptionDAOImpl();
    }
}
