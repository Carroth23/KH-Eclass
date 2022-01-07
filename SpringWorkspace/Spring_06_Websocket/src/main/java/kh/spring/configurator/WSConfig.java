package kh.spring.configurator;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

public class WSConfig extends Configurator { // javax.websocket.server
	
	// 웹소켓이 세션을 만들어가는 핸드쉐이킹 과정에 우리가 Http세션을 담아서 보냄
	
	@Override					// 엔드포인트에 넘겨주는게 sec인데 여기에 세션을 넣어서 넘기면 Http세션 사용가능할듯
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		
		HttpSession session = (HttpSession)request.getHttpSession();
		sec.getUserProperties().put("hSession", session); // map
		
		super.modifyHandshake(sec, request, response);
	}
}
