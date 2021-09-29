package com.wv.blog.domain.board.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardReplyController {

	private final BoardReplyServiceImpl boardReplyServiceImpl;
	
	@Autowired
	public BoardReplyController(BoardReplyServiceImpl boardReplyServiceImpl) {
		this.boardReplyServiceImpl = boardReplyServiceImpl;
	}
	
	@PostMapping("/boardReply")
	public BoardReply save(BoardReply boardReply) {
		return boardReplyServiceImpl.save(boardReply); 
	}
}
