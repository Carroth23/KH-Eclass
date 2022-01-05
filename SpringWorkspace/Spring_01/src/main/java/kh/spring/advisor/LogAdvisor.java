package kh.spring.advisor;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.ContactDTO;

@Component // 레이어로 취급하지않기때문에 컴포넌트를 붙임
@Aspect // 관점지향 빈이라는걸 알리기 위해(이제 이 안은 AOP로? 사용)
public class LogAdvisor {

	// 여기에 세션꺼내서 방문자 로그 남길수도있음
	@Autowired
	private HttpSession session;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");

	@Before("within(kh.spring.controller.HomeController)") // within : HomeController안에 모든 메서드가 pointcut 대상이다라는// 뜻(class까지만 적용)
	public void beforeLog(JoinPoint jp) { // 옆에 화살표 표시가 있으면 적용된거
		Signature sign = jp.getSignature(); // org.aspectj.lang.Signature;
		String logTime = sdf.format(System.currentTimeMillis());

		System.out.print(logTime + " ");
		System.out.println(sign.getDeclaringTypeName() + " 클래스에서 " + sign.getName() + " 메서드 실행");
	}

	// .. 0 개 이상
	// * return값 에서는 자료형 상관없음 / parameter 에서는 아무 자료형이나 1개
	// *,* parameter 에서는 아무자료형이나 2개
	@After("execution(String kh.spring.controller.HomeController.inputProc(*))") // String대신 *찍으면 리턴값은 상관없다는 뜻,
																					// Homecontroller.*은 컨트롤러 밑 모든메서드
	public void afterLog(JoinPoint jp) { // *Controller은 모든 컨트롤러 *.(*)은 매개변수가 하나민 모든 메서드

		Signature sign = jp.getSignature();
		String logTime = sdf.format(System.currentTimeMillis());

		Object[] args = jp.getArgs(); // 인자값도 받을수? 뽑아낼 수 있다.
		ContactDTO dto = (ContactDTO) args[0];
		System.out.println("전달된 Contact 객체의 name값 : " + dto.getName());

		System.out.print(logTime + " ");
		System.out.println(sign.getDeclaringTypeName() + " 클래스에서 " + sign.getName() + " 메서드 종료");
	}

	// 어라운드는 before랑 after합친거같은느낌 굉장히 강력하다
	@Around("execution(String kh.spring.controller.HomeController.outputProc(..))")
	public Object aroundLog(ProceedingJoinPoint pjp) {
		System.out.println("Around Before 입니다.");

		// 여기서 세션꺼내서 아이디검사하고 아이디 없으면 proceed 안해주면 그게 막아버리는것처럼 됨 (인터셉터 느김 근데 잘 안씀 ㅎㅎ)
		// 실행시간 테스트도 가능할듯. 시작 - 끝 시간
		
		Object returnValue = null;
		try {				// proceed()가 PointCut메서드 자체인 느낌
			returnValue = pjp.proceed(); // 여기에 결국 PointCut메서드가 리턴하는 "Home" 이런게 리턴되니까 그걸 받아서 리턴해줘야 정상적으로 감.
			// Around Advice가 PointCut 메서드를 호출하는 구문(컨트롤러 메서드를 통제해버릴수있?) 얘를 안부르면 PointCut
			// 메서드를 실행 안해버릴수도있을듯
			// proceed를 기준으로 앞에 쓰인게 before, 뒤에쓰이는 코드가 after
		} catch (Throwable e) {
			e.printStackTrace();
			e.getMessage();
		}
		
		System.out.println("Around After 입니다.");
		return returnValue;
	}

}
