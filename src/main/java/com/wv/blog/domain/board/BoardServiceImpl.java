package com.wv.blog.domain.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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

	@Override
	public BoardDto findById(Long id) {
		Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("글이 존재하지 않습니다."));
		BoardDto boardDto = new BoardDto(board);
		return boardDto;
	}

	@Override
	public void delete(BoardDto boardDto) {
		boardRepository.delete(boardDto.toEntity());
	}

}
