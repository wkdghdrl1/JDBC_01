package com.biz.jdbc.exec;

import java.util.List;

import com.biz.jdbc.model.StudentVO;
import com.biz.jdbc.service.StdService;

// selectALL 메소드 호출
public class OracleExec_06 {

	public static void main(String[] args) {

		StdService ss = new StdService();

		List<StudentVO> stdList = ss.selectAll();

		if (stdList != null) {
			for (StudentVO vo : stdList) {
				System.out.println(vo);
			}
		} else {
			System.out.println("오류 발생");
		}
	}

}
