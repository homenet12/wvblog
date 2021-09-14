package com.wv.blog.domain.board;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
//@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	
	/**
	 * 메인 페이지 (BOARD LIST) 
	 * @return
	 */
	@GetMapping("/board")
	public String index(@PageableDefault(page = 0, size = 10) Pageable pageable, Model model) {
		Page<BoardDto> boardList = boardService.findAllPage(pageable);
		model.addAttribute("boardList", boardList);
		return "board/index";
	}
	
	@GetMapping("/board/about")
	public String about() {
		return "board/about";
	}
	
	@GetMapping("/board/contact")
	public String contact() {
		return "board/contact";
	}
	@GetMapping("/board/post")
	public String post() {
		return "board/post";
	}
	
	@GetMapping("/board/form")
	public String form() {
		return "board/form";
	}
	
	@PostMapping("/board")
	public String save(@Valid BoardDto boardDto) {
		
		log.info(boardDto.getTitle());
		log.info(boardDto.getContents());
		
		boardService.save(boardDto);
		return "redirect://localhost:8080/board";
	}
	
	
}
