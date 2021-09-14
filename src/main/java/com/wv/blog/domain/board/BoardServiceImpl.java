package com.wv.blog.domain.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardRepository boardRepository;
	
	@Override
	public void save(BoardDto boardDto) {
		Board board = boardDto.toEntity();
		boardRepository.save(board);
	}

	@Override
	public Page<BoardDto> findAllPage(Pageable pageable) {
		Page<Board> entityList = boardRepository.findAll(pageable);
		return entityList.map(b -> new BoardDto(b));
	}

}
