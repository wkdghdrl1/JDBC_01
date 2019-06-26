package com.biz.jdbc.exec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.jdbc.model.IolistVO;

// DB Iolist 연결
public class OracleExec_05 {
	
	/*
	 * user4 schema에 있는 tbl_iolsit 테이블을 읽어서 리스트를 콘솔에 보이시오.
	 */
	public static void main(String[] args) {
		

		 List<IolistVO> ioList = new ArrayList<IolistVO>();
		 
		 
		String jdbcDriver 
			= "oracle.jdbc.driver.OracleDriver";
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "user4";
		String password = "1234";
		
		try {
			Class.forName(jdbcDriver);
			
			Connection con = DriverManager.getConnection(url, userName, password);
			System.out.println("연결 성공");
			
			PreparedStatement pStr = null;
			
			String sql = "SELECT * FROM tbl_iolist";
			
			pStr = con.prepareStatement(sql);
			
			ResultSet rs = pStr.executeQuery();
			
			while(rs.next()) {
//				IO_SEQ
//				IO_DATE
//				IO_INOUT
//				IO_AMT
//				IO_PRICE
//				IO_TOTAL
//				IO_PCODE
//				IO_CCODE
				IolistVO vo = new IolistVO();
				vo.setIo_seq(rs.getInt(1));
				vo.setIo_date(rs.getString(2));
				vo.setIo_inout(rs.getString(3));
				vo.setIo_amt(rs.getInt(4));
				vo.setIo_price(rs.getInt(5));
				vo.setIo_total(rs.getInt(6));
				vo.setIo_pcode(rs.getString(7));
				vo.setIo_ccode(rs.getString(8));
			
				ioList.add(vo);
				
			}
		
			for(IolistVO vo : ioList) {
				System.out.println(vo);
				
			}
			
		} catch (ClassNotFoundException e) {
				System.out.println("JDBC Driver 연결 오류");
			e.printStackTrace();
		} catch (SQLException e) {
			  	System.out.println("오라클에 연결할 수 없음");
			e.printStackTrace();
		}
	}

}
