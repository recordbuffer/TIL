package com.jdbc;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class JDBCTemplate {
    
    
    public static Connection getConnection() {
    
        try {
            //드라이버 연결
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            //드라이버 연결실패
            e.printStackTrace();
        }
        
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String id="scott";
        String pw="tiger";
        
        Connection con = null;
        
        try {
            //계정 연결
            con = DriverManager.getConnection(url, id, pw);
            
            con.setAutoCommit(false);
        } catch (SQLException e) {
            //계정 연결 실패
            e.printStackTrace();
        }
        
        return con;
    }
    
    public static boolean isConnection(Connection con) {
        boolean valid = true;
        
        try {
            if(con == null || con.isClosed()) {
                valid = false;
            }
        } catch (SQLException e) {
            valid = true;
            e.printStackTrace();
        }
        
        return valid;
    }
    
    //연결된 상태인지 아닌지 확인 ->연결 상태 확인되면 close
    public static void close(Connection con) {
        if(isConnection(con)) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    //stmt가 null아닐때 close
    public static void close(Statement stmt) {
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
 
    
    //rs가 null 아닐때 close
    public static void close(ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
 
    //연결 상태라면 commit
    public static void commit(Connection con) {
        if(isConnection(con)) {
            try {
                con.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    //연결 상태라면 rollback
    public static void rollback(Connection con) {
        if(isConnection(con)) {
            try {
                con.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
}
