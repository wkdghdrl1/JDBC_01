package com.biz.jdbc.exec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.jdbc.model.StudentVO;

// tbl_student 
public class OracleExec_02 {

	public static void main(String[] args) {
		
		List<StudentVO> stdList = new ArrayList<StudentVO>();
	
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
			
			String sql = " SELECT * FROM tbl_student ";
			
			pStr = con.prepareStatement(sql);
			
			ResultSet rs = pStr.executeQuery();
			
			while(rs.next()) {
				
				StudentVO vo = new StudentVO();
				vo.setSt_no(rs.getString(1));
				vo.setSt_name(rs.getString(2));
				vo.setSt_addr(rs.getString(3));
				vo.setSt_grade(rs.getInt(4));
				vo.setSt_height(rs.getInt(5));
				vo.setSt_weight(rs.getInt(6));
				vo.setSt_nick(rs.getString(7));
				vo.setSt_nick_rem(rs.getString(8));
				vo.setSt_dept_no(rs.getString(9));
				
				stdList.add(vo);
			}
			
			for(StudentVO vo : stdList) {
				
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
