package kr.or.ddit.user.respository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtill;
import kr.or.ddit.user.model.UserVo;

public class UserDao implements UserDaoI {

	@Override
	public List<UserVo> selectAllUser() {
		SqlSession sqlSession = MybatisUtill.getSqlSession();

		// select : 리턴되는 값의 복수 유무를 확인
		// 1. 단건 : 일반객체를 반환(UserVo) selectOne()
		// 2. 여러건 : List<UserVo> selectList()
		// insert. update. delete : insert. update. delete

		// 메소드 이름과 실행할 sql id를 동일하게 맞추자. 그럼 나중에 유지보수- 다른 개발자의 가독성 up

		List<UserVo> userlist = sqlSession.selectList("users.selectAllUser");

		// 사용한 자원 반납
		sqlSession.close();

		return userlist;
	}

	@Override
	public UserVo selectUser(String userid) {
		SqlSession sqlSession = MybatisUtill.getSqlSession();

		/*
		 * select * from users where userid = id
		 */

		UserVo user = sqlSession.selectOne("users.selectUser", userid);

		sqlSession.close();

		return user;
	}

	@Override
	public List<UserVo> selectPagingUser(PageVo page) {
		SqlSession sqlSession = MybatisUtill.getSqlSession();

		List<UserVo> page1 = sqlSession.selectList("users.selectPagingUser", page);

		sqlSession.close();

		return page1;
	}

	@Override
	public int selectAlluserCnt() {
		SqlSession sqlSession = MybatisUtill.getSqlSession();

		int userCnt = sqlSession.selectOne("users.selectAllUserCnt");

		sqlSession.close();

		return userCnt;
	}

	@Override
	public int modifyUser(UserVo userVo) {
		SqlSession sqlSession = MybatisUtill.getSqlSession();

		int updateCnt = sqlSession.update("users.modifyUser", userVo);

		if (updateCnt == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return updateCnt;
	}

	@Override
	public int registUser(UserVo userVo) {
		SqlSession sqlSession = MybatisUtill.getSqlSession();

		int registCnt = sqlSession.insert("users.registUser", userVo);

		if (registCnt == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return registCnt;
	}

	@Override
	public int deleteUser(String userid) {
		SqlSession sqlSession = MybatisUtill.getSqlSession();

		int deleteUser = sqlSession.delete("users.deleteUser", userid);

		if (deleteUser == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return deleteUser;
	}
	
	
}
