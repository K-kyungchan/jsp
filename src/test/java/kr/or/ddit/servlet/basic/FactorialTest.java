package kr.or.ddit.servlet.basic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactorialTest {
//	TDD : Test Driven Development 
//	BDD : Behavior Driven Development
	//@Test : 테스트 메서드에 붙이는 어노테이션
	// 		  해당 어노테이션을 붙이지 않으면 테스트 메서드드로 인식하지 않음(테스트 대상에서 제외)
	 		  
	//        제한사항 
	// 		  1. 메서드 시그니처를 정해진대로 구성해야함
	// 			 접근제어자 : public
	//			 변환타입 : void
	//		 	 인자 : 없음
	
	//		테스트 메서드 통과조건
	// 		1. 테스트 메서드를 실행하는 과정에서 예외가 없이 끝까지 실행된 경우
	//		2. assert 구문이 있을 경우 assert 구문이 전부 통과 했을때(참으로 인정 되었을떄)
	
	//@before : 초기화 메서드에 붙이는 어노테이션
	//			@Test 어노테이션에 붙은 테스트 메서드를 호출하기전에 먼저 실행됨
	// 			@Before ==> @Test(test)
	// 			@Before ==> @Test(test2)
	// 			@Before ==> @Test(test3)
	
	//@after : @Test 메서드 실행 이후에 실행된 메서드에 붙이는 어노테이션
	// 			자원 해제를 주로 담당
	
	// @BeforeClass, @AfterClass
	// 클래스 단위로 최초 1회씩 호출되는 메서드
	// @beofreClass
	//			@Before ==> @Test(test) ==> @After
	// 			@Before ==> @Test(test2) ==> @After
	// 			@Before ==> @Test(test3) ==> @After
	//  @AfterClass ==> 제한사항은 static 메소드로  선언을 해야함 해당 메서드에서 사용하는 필드는 static 필드여야함 ==> 사용 빈도가 떨어지는 원인
	
	private static final Logger logger = LoggerFactory.getLogger(FactorialTest.class);
	
	private Factorial factorial;
	
	@Before
	public void setup() {
		logger.debug("setup");
		factorial = new Factorial();
	}
	
	@Test
	public void test() {
		/***Given***/ // 현재 테스트 환경에서 주어진 조건을 기술
		logger.debug("test1");
		/***When***/ // 테스트를 검증하고자 하는 행위 (method call)
		int result = factorial.calculate2(5);
		/***Then***/ // 코드를 실행한 결과와 내가 예상한값이 일치하는지 검증 
		assertEquals(120, result);
	}
	
	@Test
	public void test2() {
		/***Given***/ // 현재 테스트 환경에서 주어진 조건을 기술
		logger.debug("test2");
		/***When***/ // 테스트를 검증하고자 하는 행위 (method call)
		int result = factorial.calculate2(4);
		/***Then***/ // 코드를 실행한 결과와 내가 예상한값이 일치하는지 검증 
		assertEquals(3, result);
	}
	
	@Test
	public void test3() {
		/***Given***/ // 현재 테스트 환경에서 주어진 조건을 기술
		logger.debug("test3");
		/***When***/ // 테스트를 검증하고자 하는 행위 (method call)
		int result = factorial.calculate2(3);
		/***Then***/ // 코드를 실행한 결과와 내가 예상한값이 일치하는지 검증 
		assertEquals(6, result);
	}

}
