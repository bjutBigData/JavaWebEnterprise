package com.panda.daoFactory;

import com.panda.dao.VoteDAO;
import com.panda.daoImpl.VoteDAOImpl;

/**
 * Created by Panda on 2016/5/17.
 */
public class VoteDAOFactory {
    public static VoteDAO getVoteDAOInstance(){                //工厂方法，用来返回DAO实现类实例
        return new VoteDAOImpl();                               //返回DAO实现类实例
    }
}
