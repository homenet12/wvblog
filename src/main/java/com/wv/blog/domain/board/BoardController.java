package com.wv.blog.domain.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/board")
public class BoardController {

	@GetMapping("/")
	public String boardList() {
		return "board/list";
	}
	
}
