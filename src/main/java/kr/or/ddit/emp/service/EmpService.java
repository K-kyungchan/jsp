package kr.or.ddit.emp.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtill;
import kr.or.ddit.emp.dao.EmpDao;
import kr.or.ddit.emp.dao.EmpDaoI;
import kr.or.ddit.emp.vo.EmpVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.respository.UserDao;
import kr.or.ddit.user.respository.UserDaoI;

public class EmpService implements EmpServiceI {
	private EmpDaoI empDao = new EmpDao();

	@Override
	public List<EmpVo> selectAllUser() {
		return empDao.selectAllUser();
	}

}
