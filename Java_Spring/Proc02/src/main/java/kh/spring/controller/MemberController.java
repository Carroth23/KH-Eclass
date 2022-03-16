package kh.spring.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	private final String CLIENT_ID = "b7b0a7f6722957ddef971b2ff4061bd7"; // REST ID
	private final String REDIRECT_URL = "http://localhost/member/login"; // 리퀘스트시킬 URL
	
	@ResponseBody
	@RequestMapping("getKakaoAuthUrl")
	public String getKakaoAuthUrl () { // 로그인 ajax동작시 오는곳
		String KaUrl = "https://kauth.kakao.com/oauth/authorize?client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URL + "&response_type=code";
		return KaUrl;
	}
	
	@RequestMapping("login")
	public String login(String code, String error) {
		if(error != null) { // 에러코드가 있다면 사용자가 취소를 했을 수 있으니.
			if(error.equals("")) {
				// 에러코드 넣고 그에대한 대비책을 넣을곳
			}
		}
		System.out.println("반환된 코드 : " + code);
		System.out.println("에러 코드 : " + error);
		
		Gson g = new Gson();
		// POST방식으로 key=value 데이터를 요청(카카오쪽으로)
		RestTemplate rt = new RestTemplate(); // RestTemplate
		
		// HttpHeader 오브젝트 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8"); // 내가 보낼 데이터 타입이 key=value값이다
		
		// HttpBody 오브젝트 생성
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "b7b0a7f6722957ddef971b2ff4061bd7");
		params.add("redirect_uri", "http://localhost/member/login");
		params.add("code", code);
		
		// HttpHeader와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest = new HttpEntity<>(params, headers);
		
		// Http 요청하기 - Post방식으로 - 그리고 response 변수응답받음
		ResponseEntity<String> response = rt.exchange("https://kauth.kakao.com/oauth/token", HttpMethod.POST, kakaoTokenRequest, String.class);
		
		System.out.println(response.getBody());
//		response.getBody(); // 토큰 바디
//		ObjectMapper obMapper = new ObjectMapper();
		
		return "/member/loginsu";
	}
	
}
