package kr.or.ddit.emp.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmpVo {
	private String empno;
	private String ename;
	private String job;
	private Date hiredate;

	public EmpVo() {
	}

	public String getHiredate_fmt() {
		// Hiredate 필드가 null 이면 "" 문자열 반환
		// Hiredate 필드가 null이 아니면 simpleDateFormat을
		// 생성하여 yyyy.mm,dd 포맷의 문자열로 변환하여 리턴

		if (this.hiredate != null) {
			return "";
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			return sdf.format(this.hiredate);
		}

	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
