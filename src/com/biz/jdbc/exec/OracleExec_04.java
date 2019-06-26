package com.biz.jdbc.exec;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.jdbc.model.ScoreVO;
import com.biz.jdbc.model.StudentVO;

// DB tbl_Score 연결
public class OracleExec_04 {

	public static void main(String[] args) {
		
		List<ScoreVO> stdList = new ArrayList<ScoreVO>();
	
		String jdbcDriver 
			= "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "user4";
		String password = "1234";
		
		try {

			Class.forName(jdbcDriver); // Class.forName 사용
			Connection con 
					= DriverManager.getConnection(url, userName, password); // DriverManager로 연결통로를 만듦
			System.out.println("오라클 연결 성공");
			
			PreparedStatement pStr = null;
			
			String sql = " SELECT * FROM tbl_score ";
			
			pStr = con.prepareStatement(sql);
			
			ResultSet rs = pStr.executeQuery();
			
			while(rs.next()) {
//				SC_SEQ
//				SC_DATE
//				SC_ST_NO
//				SC_SCORE
//				SC_SB_NO
				ScoreVO vo = new ScoreVO();
				vo.setSc_seq(rs.getLong(1));
				vo.setSc_date(rs.getString(2));
				vo.setSc_st_no(rs.getString(3));
				vo.setSc_score(rs.getInt(4));
				vo.setSc_sb_no(rs.getString(5));
				
				stdList.add(vo);
			}
			
			for(ScoreVO vo : stdList) {
				
				System.out.println(vo);
			}
			
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("JDBC Driver 실행 오류");
			
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("오라클에 연결할 수 없음");
			e.printStackTrace();
		}
		
	}

}
