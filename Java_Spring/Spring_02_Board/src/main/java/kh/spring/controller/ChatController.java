package kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat/")
public class ChatController {
	
	@RequestMapping("toChat")
	public String toChat() {
		return "chat/room";
	}
	
}
