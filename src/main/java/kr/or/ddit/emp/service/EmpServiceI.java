package kr.or.ddit.emp.service;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.emp.vo.EmpVo;
import kr.or.ddit.user.model.UserVo;

public interface EmpServiceI {
	List<EmpVo> selectAllUser();
}
