package kh.spring.endpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session; // Http세션이 아닌 웹소켓 세션이다
import javax.websocket.server.ServerEndpoint;

import com.google.gson.JsonObject;

import kh.spring.configurator.WSConfig;
						// 내가 만든 WSConfig로 핸드쉐이크함
@ServerEndpoint(value="/chat", configurator = WSConfig.class)
public class ChatEndpoint {
											// 동기화 처리
	private static List<Session> clients = Collections.synchronizedList(new ArrayList<>()); // 스태틱을 안주면 endpoint가 만들어지고 리스트가 만들어지고, 다른사람이 접속하면
																// endpoint가 만들어지고 또 리스트만들어지고 = 의미없음

//	@Autowired 얘 작동안한다.
	private HttpSession session;
	
	@OnOpen // 클라이언트 웹소켓 뭐시기 들어왔을때 제일 먼저 실행되는 코드
	public void onConnect(Session session, EndpointConfig config) { // A가 접속했을때 세션하나 만들고 B접속하면 세션 또만들고...
		clients.add(session);				// config는 내가 만든 sercerendpointconfig였던거임
		this.session =  (HttpSession) config.getUserProperties().get("hSession");
	}

	@OnMessage
	public void onMessage(String message) {
		// 메세지를 같은 웹소켓 엔드포인트에 접속한 클라이언트 들에게 배포해야 한다.
		
		
		// 이제 세션을 사용 가능하니까 이렇게 뽑을 수 있음.
		String userID = (String)this.session.getAttribute("loginID");
		JsonObject obj = new JsonObject();
		obj.addProperty("ID", userID);
		obj.addProperty("message", message);
		
		synchronized (clients) { // 쓰레드 관련 코드 
			for (Session client : clients) {
				try {
					client.getBasicRemote().sendText(obj.toString()); // 받는곳에서 json.parse해서 꺼내면될듯
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@OnClose // 접속을 종료한다면 해당 사용자의 세션을 지워버림. 안그러면 첫번째 사용자가 세션을 끊고 나갔을때 닫힌세션이 유지되어 다음사람이 들어왔을때
				// 닫힌세션이 선택되면 에러남
	public void onClose(Session session) {
		clients.remove(session);
	}

}
