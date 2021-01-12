package kr.or.ddit.emp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtill;
import kr.or.ddit.emp.vo.EmpVo;

public class EmpDao implements EmpDaoI {

	@Override
	public List<EmpVo> selectAllUser() {
		SqlSession sqlSession = MybatisUtill.getSqlSession();

		List<EmpVo> userlist = sqlSession.selectList("emps.selectAllUser");

		sqlSession.close();

		return userlist;
	}

}
