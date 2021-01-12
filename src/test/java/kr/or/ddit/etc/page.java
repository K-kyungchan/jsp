package kr.or.ddit.etc;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.user.respository.UserDao;
import kr.or.ddit.user.respository.UserDaoI;

public class page {

	@Test
	public void test() {
		/*** Given ***/
		int userCnt = 16;
		int pageSize = 5;
		/*** When ***/
		int pagination = (int) Math.ceil((double) userCnt / pageSize);

		/*** Then ***/
		assertEquals(4, pagination);
	}
	

}
