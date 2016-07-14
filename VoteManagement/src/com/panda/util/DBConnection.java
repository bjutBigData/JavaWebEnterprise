package com.panda.util;

import java.sql.*;

/**
 * Created by Panda on 2016/5/16.
 */
public class DBConnection {
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";                             //驱动类类名
    private static final String DBURL = "jdbc:mysql://localhost:3306/db_votemanage";            //连接URL
    private static final String DBUSER = "root";                 //数据库用户名
    private static final String DBPASSWORD = "softwind";         // 数据库密码

    public static Connection getConnection(){
        Connection conn = null;                                  //声明一个连接对象
        try{
            Class.forName(DBDRIVER);                             //注册驱动
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);      //获取连接对象
        }catch (ClassNotFoundException e){                      //捕获驱动类无法找到异常
            e.printStackTrace();
        }catch (SQLException e){                                //捕获SQL异常
            e.printStackTrace();
        }
        return conn;
    }
    public static void close(Connection conn) {                 //关闭连接对象
        if(conn != null) {
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void close(PreparedStatement pstmt){          //关闭预处理对象
        if(pstmt != null){
            try{
                pstmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void close(ResultSet rs){                     //关闭结果集对象
        if(rs != null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}













