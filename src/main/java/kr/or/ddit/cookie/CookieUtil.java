package kr.or.ddit.cookie;

public class CookieUtil {
	/**
	 * Method : getCookieValue 작성자 : PC-22 변경이력 :
	 * 
	 * @param cookieStr
	 * @param cookieName
	 * @return Method 설명 : cookieStri에서 cookieName에 해당하는 쿠키 값을 조회
	 */
	// cookieStr : userid=brownl rememberme=Y; test=testcookie
	// cookieName : uesrid, rememberme
	// return : brown, Y
	public static String getCookieValue(String cookieStr, String cookieName) {

		String[] cookies = cookieStr.split("; ");
		// cookies[0] = userid=brown
		// cookies[1] = rememberme=Y
		// cookies[2] = test=testcookie
		String test2 = "";
		for (int i = 0; i < cookies.length; i++) {
			String[] test = cookies[i].split("=");
			if (test[0].equals(cookieName)) {
				test2 = test[1];
			}
		}

		return test2;
	}

}
