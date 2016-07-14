package com.panda.daoImpl;

/**
 * Created by Panda on 2016/5/16.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.panda.bean.Vote;
import com.panda.dao.VoteDAO;
import com.panda.util.DBConnection;
import com.panda.util.Page;

public class VoteDAOImpl implements VoteDAO {

    @Override
    public void addVote(Vote vote){
        Connection conn = DBConnection.getConnection();                         //获取连接对象
        String addSQL = "insert into " +
                        "tb_vote(voteName,channelID) values(?,?)";
        PreparedStatement pstmt = null;
        try{
            pstmt = conn.prepareStatement(addSQL);                      //获取预处理对象并赋值
            pstmt.setString(1, vote.getVoteName());                     //设置投票名称
            pstmt.setInt(2, vote.getChannelID());                       //设置频道ID
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
    }

    @Override
    public void deleteVote(int voteID) {
        Connection conn = DBConnection.getConnection();
        String deleteSQL = "delete from tb_vote where voteID = ?";
        PreparedStatement pstmt = null;
        try{
            pstmt = conn.prepareStatement(deleteSQL);
            pstmt.setInt(1, voteID);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
    }

    @Override
    public List<Vote> findAllVote(Page page) {
        Connection conn = DBConnection.getConnection();
        String findByIDSQL = "select * from tv_vote limit ?, ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Vote> votes = new ArrayList<Vote>();
        try{
            pstmt = conn.prepareStatement(findByIDSQL);
            pstmt.setInt(1, page.getBeginIndex());
            pstmt.setInt(2,page.getEveryPage());
            rs = pstmt.executeQuery();
            while (rs.next()){
                Vote vote = new Vote();
                vote.setVoteID(rs.getInt(1));
                vote.setVoteName(rs.getString(2));
                vote.setChannelID(rs.getInt(3));
                votes.add(vote);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
        return votes;
    }

    @Override
    public Vote findVoteById(int voteID) {
        Connection conn = DBConnection.getConnection();
        String querySQL = "select * from tb_vote where voteID = ? ";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Vote vote = null;
        try {
            pstmt = conn.prepareStatement(querySQL);
            pstmt.setInt(1, voteID);
            rs = pstmt.executeQuery();
            if(rs.next()){
                vote = new Vote();
                vote.setVoteID(rs.getInt(1));
                vote.setVoteName(rs.getString(2));
                vote.setChannelID(rs.getInt(3));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
        return vote;
    }

    @Override
    public void updateVote(Vote vote) {

    }

    @Override
    public Vote findVoteByName(String voteName) {
        Connection conn = DBConnection.getConnection();
        String querySQL = "select * from tb_vote where voteName = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Vote vote = null;
        try{
            pstmt = conn.prepareStatement(querySQL);
            pstmt.setString(1, voteName);
            rs = pstmt.executeQuery();
            if(rs.next()){
                vote = new Vote();
                vote.setVoteID(rs.getInt(1));
                vote.setVoteName(rs.getString(2));
                vote.setChannelID(rs.getInt(3));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
        return vote;
    }

    @Override
    public int findAllCount() {
        Connection conn = DBConnection.getConnection();
        String findSQL = "select count(*) from tb_vote";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        try{
            pstmt = conn.prepareStatement(findSQL);
            rs = pstmt.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
        return count;
    }

    @Override
    public List<Vote> findVoteByChannel(Page page, int channelID) {
        Connection conn = DBConnection.getConnection();
        String findByIDSQL = "select * from tb_vote where channelID = ? limite ?, ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Vote> votes = new ArrayList<Vote>();
        try {
            pstmt = conn.prepareStatement(findByIDSQL);
            pstmt.setInt(1,channelID);
            pstmt.setInt(2,page.getBeginIndex());
            pstmt.setInt(3,page.getBeginIndex());
            rs = pstmt.executeQuery();
            if(rs.next()){
                Vote vote = new Vote();
                vote.setVoteID(rs.getInt(1));
                vote.setVoteName(rs.getString(2));
                vote.setChannelID(rs.getInt(3));
                votes.add(vote);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
        return votes;
    }

    @Override
    public int findCountByChannel(int channelID) {
        Connection conn = DBConnection.getConnection();
        String findSQL = "select count(*) from tb_vote where channelID = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            pstmt = conn.prepareStatement(findSQL);
            pstmt.setInt(1,channelID);
            rs = pstmt.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
        return count;
    }
}






























