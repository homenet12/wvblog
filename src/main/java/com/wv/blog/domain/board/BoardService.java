package com.wv.blog.domain.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {

	void save(BoardDto boardDto);
	Page<BoardDto> findAllPage(Pageable pageable);
	BoardDto findById(Long id);
}
