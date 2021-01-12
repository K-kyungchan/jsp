package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import kr.or.ddit.common.dao.PageDao;
import kr.or.ddit.common.dao.PageDaoI;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.respository.UserDao;
import kr.or.ddit.user.respository.UserDaoI;

public class ServiceDaoTest {

	// 전체 사용자 조회 테스트
	@Test
	public void selectAllUserTest() {
		/*** Given ***/
		UserServiceI userDao = new UserService();
		/*** When ***/
		List<UserVo> userList = userDao.selectAllUser();
		/*** Then ***/
		assertEquals(16, userList.size());

	}

	// 사용자 아이디를 이용하여 특정 사용자 정보 조회
	@Test
	public void selectUserTest() {
		/*** Given ***/
		UserServiceI userDao = new UserService();
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
		UserServiceI userDao = new UserService();
		PageVo vo = new PageVo(2, 5);
		/*** When ***/
		List<UserVo> page = (List<UserVo>) userDao.selectPagingUser(vo);
		/*** Then ***/
		assertEquals(5, page.size());
	}

}
