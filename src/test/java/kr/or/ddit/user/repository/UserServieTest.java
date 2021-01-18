package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.dao.PageDao;
import kr.or.ddit.common.dao.PageDaoI;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.respository.UserDao;
import kr.or.ddit.user.respository.UserDaoI;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

public class UserServieTest {

	private UserServiceI userDaoI; 
	@Before
	public void setup() {
		userDaoI = new UserService();
		// 테스트에서 사용할 신규 사용자 추가 
		UserVo userVo = new UserVo("testUser", "테스트사용자", "testUserPass", new Date(),"대덕", "대전 중구 중앙로 76", "4층", "3232");
		
		userDaoI.registUser(userVo);
		// 신규 입력 테스트를 위해 테스트 과정에서 입력된 데이터를 삭제
		userDaoI.deleteUser("ddit_n");
		
	}
	
//		@비포
//			1. 테스트유저 삭제
//			1. 테스트유저 등록
//		@테스트
//			테스트 실행
	
	@After
	public void tearDown() {
		userDaoI = new UserService();
		userDaoI.deleteUser("testUser");
	}
	
	// 삭제 테스트
	@Test
	public void deleteUserTest() {
		userDaoI = new UserService();
		/***Given***/
		// 해당 테스트가 실행될 때는 testUser라는 사용자가 before메소드에 의해 등록이 된상태
		String userid = "testUser";
		/***When***/
		int deleteCnt = userDaoI.deleteUser(userid);
		/***Then***/
		assertEquals(1, deleteCnt);
		
	}
	
	// 전체 사용자 조회 테스트
	@Test
	public void selectAllUserTest() {
		userDaoI = new UserService();
		/*** Given ***/
//		UserDaoI userDao = new UserDao();
		/*** When ***/
		List<UserVo> userList = userDaoI.selectAllUser();
		/*** Then ***/
		assertEquals(23, userList.size());

	}
 	// 사용자 아이디를 이용하여 특정 사용자 정보 조회
	@Test
	public void selectUserTest() {
		userDaoI = new UserService();
		/*** Given ***/
//		UserDaoI userDao = new UserDao();
		String userid = "brown";
		/*** When ***/
		UserVo user = userDaoI.selectUser(userid);
		/*** Then ***/
		assertNotNull(user);// user가 null이면 실패
		assertEquals("브라운", user.getUsernm());
	}
 
	@Test
	public void selectPagingUserTest() {
		userDaoI = new UserService();
		/*** Given ***/
//		UserDaoI userDao = new UserDao();
		PageVo vo = new PageVo(2, 5);
		/*** When ***/
		Map<String, Object> page = userDaoI.selectPagingUser(vo);
		/*** Then ***/
		assertEquals(2, page.size());
	}

 	// 사용자 아이디가 존재하지 않을 때 특정 사용자 조회
 	@Test
	public void selectUserNotExsistTest() {
 		userDaoI = new UserService();
		/*** Given ***/
//		UserDaoI userDao = new UserDao();
		String userid = "asgew2e";
		/*** When ***/
		UserVo user = userDaoI.selectUser(userid);
		/*** Then ***/
		assertNull(user);// user가 null이면 실패

	}
 
// 	@Test
//	public void selectAllUserCntTest() {
//// 		userDaoI = new UserService();
//		/*** Given ***/
//		UserDaoI userDao = new UserDao();
//
//		/*** When ***/
//		int userCnt = userDaoI.selectAllUser();
//		
//		/*** Then ***/
//		assertEquals(23, userCnt);
//	}
 
 	@Test
	public void modifyUserTest() {
 		userDaoI = new UserService();
		/*** Given ***/
//		UserServiceI userDao = new UserService();
		// userid, usernm, pass, reg_dt, alias, addr1 , addr2, zipcode
		UserVo userVo = new UserVo("ddit", "대덕인재", "dditpass", new Date(), "개발원_m", "대전시 중구 중앙로 76", "4층 대덕인재개발원",
				"34940");

		/*** When ***/
		int updateCnt = userDaoI.modifyUser(userVo);
		/*** Then ***/
		assertEquals(1, updateCnt);
	}
 	
//	@Test
//	public void registUserTest() {
//		
//	}
//	
 

}
