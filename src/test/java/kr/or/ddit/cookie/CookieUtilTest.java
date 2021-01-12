package kr.or.ddit.cookie;

import static org.junit.Assert.*;

import org.junit.Test;

public class CookieUtilTest {

	// 테스트 메소드 명명 규칙 : 테스트할 메소드+"Test"
	@Test
	public void getCookieValueTest() {

		String cookieStr = "userid=brown; rememberme=Y; test=testcookie";
		String cookieName = "rememberme";

		String cookieValue = CookieUtil.getCookieValue(cookieStr, cookieName);

		assertEquals("Y", cookieValue);
	}
	
	@Test
	public void getCookieValue2Test() {

		String cookieStr = "userid=brown; rememberme=Y; test=testcookie";
		String cookieName = "userid";

		String cookieValue = CookieUtil.getCookieValue(cookieStr, cookieName);

		assertEquals("brown", cookieValue);
	}
	
	@Test
	public void getCookieValue3Test() {

		String cookieStr = "userid=brown; rememberme=Y; test=testcookie";
		String cookieName = "nonono";

		String cookieValue = CookieUtil.getCookieValue(cookieStr, cookieName);

		assertEquals("", cookieValue);
	}
}
