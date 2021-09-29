package com.wv.blog.domain.board.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardReplyServiceImpl {

	@Autowired
	BoardReplyRepository boardReplyRepository;
	
	public BoardReply save(BoardReply boardReply) {
		// TODO Auto-generated method stub
		BoardReply reply = boardReplyRepository.save(boardReply);
		return reply;
	}

}
