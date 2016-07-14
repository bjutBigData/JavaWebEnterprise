package com.panda.daoImpl;

import java.sql.*;

import com.panda.bean.VoteOption;
import com.panda.dao.VoteOptionDAO;
import com.panda.util.DBConnection;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by Panda on 2016/5/16.
 */
public class VoteOptionDAOImpl implements VoteOptionDAO {

    @Override
    public void addVoteOption(VoteOption voteOption) {
        Connection conn = DBConnection.getConnection();
        String addSQL = "insert into " +
                        "tb_voteoption(voteOptionName, voteID, ticketNum) values(?, ?, ?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(addSQL);
            pstmt.setString(1, voteOption.getVoteOptionName());
            pstmt.setInt(2, voteOption.getVoteID());
            pstmt.setInt(3, voteOption.getTicketNum());
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
    }

    @Override
    public void deleteVoteOption(int voteOptionID) {
        Connection conn = DBConnection.getConnection();
        String deleteSQL = "delete from tb_voteoption where voteOption = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(deleteSQL);
            pstmt.setInt(1, voteOptionID);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
    }

    @Override
    public List<VoteOption> findVoteOptionByVoteID(int voteID) {
        Connection conn = DBConnection.getConnection();
        String findByIDSQL = "select * from tb_voteoption where voteID = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<VoteOption> voteOptions = new ArrayList<VoteOption>();
        try{
            pstmt = conn.prepareStatement(findByIDSQL);
            pstmt.setInt(1, voteID);
            rs = pstmt.executeQuery();
            while (rs.next()){
                VoteOption voteOption = new VoteOption();
                voteOption.setVoteOptionID(rs.getInt(1));
                voteOption.setVoteID(rs.getInt(2));
                voteOption.setVoteOptionName(rs.getString(3));
                voteOption.setVoteID(rs.getInt(4));
                voteOptions.add(voteOption);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
        return voteOptions;
    }

    @Override
    public VoteOption findVoteOptionById(int voteOptionID) {
        Connection conn = DBConnection.getConnection();
        String findByIDSQL = "select * from tb_voteoption where voteOptionID = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        VoteOption voteOption = null;
        try {
            pstmt = conn.prepareStatement(findByIDSQL);
            pstmt.setInt(1,voteOptionID);
            rs = pstmt.executeQuery();
            while (rs.next()){
                voteOption = new VoteOption();
                voteOption.setVoteOptionID(rs.getInt(1));
                voteOption.setVoteID(rs.getInt(2));
                voteOption.setVoteOptionName(rs.getString(3));
                voteOption.setTicketNum(rs.getInt(4));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
        return voteOption;
    }

    @Override
    public void updateVoteOption(VoteOption voteOption) {
        Connection conn = DBConnection.getConnection();
        String updateSQL = "update tb_voteoption set ticketNum = ? where voteOptionID = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(updateSQL);
            pstmt.setInt(1, voteOption.getTicketNum());
            pstmt.setInt(2,voteOption.getVoteOptionID());
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
    }
}































