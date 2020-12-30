package kr.or.ddit.servlet.basic;

public class Factorial {
	public static void main(String[] args) {
		Factorial factorial = new Factorial();
		int result = factorial.calculate(5);

		if (result == 120) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}

	/**
	 * Method : 
	 * calculate 작성자 :
	 *  PC-22 변경이력 :
	 * @param n 
	 * Method 설명 : 인자로 들어온 n 값을 이용하여 팩토리얼을 계싼
	 */
	public int calculate(int n) {
		int num = 1;
		return n * calculate(--n);
	}

	public int calculate2(int n) {
		if (n <=1)
			return 1;
		else
			return n * calculate2(--n);
	}
}
