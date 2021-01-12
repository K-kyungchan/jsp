package kr.or.ddit.common.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtill;
import kr.or.ddit.user.model.UserVo;

public class PageDao implements PageDaoI {
	@Override
	public List<PageVo> selectPagingUser(PageVo page) {
		SqlSession sqlSession = MybatisUtill.getSqlSession();

		List<PageVo> page1 = sqlSession.selectList("users.selectPagingUser");

		return page1;
	}


}
