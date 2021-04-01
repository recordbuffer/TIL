package com.lib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.jdbc.JDBCTemplate;
import com.lib.dto.LibDto;

public class LibDao extends JDBCTemplate {
	public int delete() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " DELETE FROM SEOUL_LIB ";
		
		try {
			pstm = con.prepareStatement(sql);
			
			res = pstm.executeUpdate();
			
			if(res>0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		return res;
	}
	
	public int insert(List<LibDto> dtos) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " INSERT INTO SEOUL_LIB VALUES(?,?,?,?,?,?) ";
		
		try {
			pstm = con.prepareStatement(sql);
			
			for(int i=0; i<dtos.size(); i++) {
				LibDto dto = dtos.get(i); 	//반복을 하면서 LibDto 인덱스 i에 해당하는 dto 하나씩 가져옴
				
				pstm.setString(1, dto.getGu_code());
				pstm.setString(2, dto.getLib_seq());
				pstm.setString(3, dto.getLib_name());
				pstm.setString(4, dto.getAddr());
				pstm.setString(5, dto.getTel());
				pstm.setString(6, dto.getHpg());
				
				pstm.addBatch(); 	//모든 dto들의 배열이 메모리에 대기 
			}
			int[] result = pstm.executeBatch();		//쿼리 실행 후 결과 값 배열 result에 저장
			
			for(int i=0; i<result.length; i++) {	//결과 값 비교해줌
				if(result[i]==-2) {					//성공이면 -2 res값 증가 
					res++;
				}
			}
			if(res==dtos.size()) {		//dtos랑 res값 같으면(insert 모두 성공이면) 커밋
				commit(con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}
}
