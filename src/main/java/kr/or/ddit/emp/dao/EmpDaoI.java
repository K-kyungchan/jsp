package kr.or.ddit.emp.dao;

import java.util.List;

import kr.or.ddit.emp.vo.EmpVo;

public interface EmpDaoI {
	List<EmpVo> selectAllUser();
}
