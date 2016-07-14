package com.panda.util;

import java.sql.*;

/**
 * Created by Panda on 2016/5/16.
 */
public class DBConnection {
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";                             //����������
    private static final String DBURL = "jdbc:mysql://localhost:3306/db_votemanage";            //����URL
    private static final String DBUSER = "root";                 //���ݿ��û���
    private static final String DBPASSWORD = "softwind";         // ���ݿ�����

    public static Connection getConnection(){
        Connection conn = null;                                  //����һ�����Ӷ���
        try{
            Class.forName(DBDRIVER);                             //ע������
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);      //��ȡ���Ӷ���
        }catch (ClassNotFoundException e){                      //�����������޷��ҵ��쳣
            e.printStackTrace();
        }catch (SQLException e){                                //����SQL�쳣
            e.printStackTrace();
        }
        return conn;
    }
    public static void close(Connection conn) {                 //�ر����Ӷ���
        if(conn != null) {
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void close(PreparedStatement pstmt){          //�ر�Ԥ�������
        if(pstmt != null){
            try{
                pstmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void close(ResultSet rs){                     //�رս��������
        if(rs != null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}













