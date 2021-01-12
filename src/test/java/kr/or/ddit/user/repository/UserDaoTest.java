package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.common.dao.PageDao;
import kr.or.ddit.common.dao.PageDaoI;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.respository.UserDao;
import kr.or.ddit.user.respository.UserDaoI;

public class UserDaoTest {

	// 전체 사용자 조회 테스트
	@Test
	public void selectAllUserTest() {
		/*** Given ***/
		UserDaoI userDao = new UserDao();
		/*** When ***/
		List<UserVo> userList = userDao.selectAllUser();
		/*** Then ***/
		assertEquals(16, userList.size());

	}

	// 사용자 아이디를 이용하여 특정 사용자 정보 조회
	@Test
	public void selectUserTest() {
		/*** Given ***/
		UserDaoI userDao = new UserDao();
		String userid = "brown";
		/*** When ***/
		UserVo user = userDao.selectUser(userid);
		/*** Then ***/
		assertNotNull(user);// user가 null이면 실패
		assertEquals("브라운", user.getUsernm());
	}

	@Test
	public void selectPagingUserTest() {
		/*** Given ***/
		UserDaoI userDao = new UserDao();
		PageVo vo = new PageVo(2, 5);
		/*** When ***/
		List<UserVo> page = userDao.selectPagingUser(vo);
		/*** Then ***/
		assertEquals(5, page.size());
	}

	// 사용자 아이디가 존재하지 않을 때 특정 사용자 조회
	@Test
	public void selectUserNotExsistTest() {
		/*** Given ***/
		UserDaoI userDao = new UserDao();
		String userid = "asgew2e";
		/*** When ***/
		UserVo user = userDao.selectUser(userid);
		/*** Then ***/
		assertNull(user);// user가 null이면 실패

	}
	@Test
	public void selectAllUserCntTest() {
		/***Given***/
		UserDaoI userDao = new UserDao();

		/***When***/
		int userCnt = userDao.selectAlluserCnt();
			
		/***Then***/
		assertEquals(16, userCnt);
		
	}

}
