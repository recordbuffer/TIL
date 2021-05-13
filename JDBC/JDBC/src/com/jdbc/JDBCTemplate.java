package com.jdbc;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class JDBCTemplate {
    
    
    public static Connection getConnection() {
    
        try {
            //����̹� ����
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            //����̹� �������
            e.printStackTrace();
        }
        
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String id="scott";
        String pw="tiger";
        
        Connection con = null;
        
        try {
            //���� ����
            con = DriverManager.getConnection(url, id, pw);
            
            con.setAutoCommit(false);
        } catch (SQLException e) {
            //���� ���� ����
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
    
    //����� �������� �ƴ��� Ȯ�� ->���� ���� Ȯ�εǸ� close
    public static void close(Connection con) {
        if(isConnection(con)) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    //stmt�� null�ƴҶ� close
    public static void close(Statement stmt) {
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
 
    
    //rs�� null �ƴҶ� close
    public static void close(ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
 
    //���� ���¶�� commit
    public static void commit(Connection con) {
        if(isConnection(con)) {
            try {
                con.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    //���� ���¶�� rollback
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
