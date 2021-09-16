package com.wv.blog.domain.board;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.wv.blog.domain.user.UserDto;

import lombok.extern.slf4j.Slf4j;

/**
 * @author homen
 *
 */
/**
 * @author homen
 *
 */
/**
 * @author homen
 *
 */
/**
 * @author homen
 *
 */
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
	
	/**
	 * 상세 페이지
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/board/{id}")
	public String post(@PathVariable Long id, Model model) {
		BoardDto board = boardService.findById(id);
		model.addAttribute("board", board);
		return "board/post";
	}
	
	/**
	 * 등록 페이지
	 * @return
	 */
	@GetMapping("/board/form")
	public String form() {
		return "board/form";
	}
	
	/**
	 * 수정 페이지
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/board/form/{id}")
	public String updateForm(@AuthenticationPrincipal UserDto user, @PathVariable Long id, Model model) {
		BoardDto board = boardService.findById(id);
		if(board.getUserDto().getId() != user.getId()) { throw new IllegalArgumentException("글 등록자만 수정할 수 있습니다.");}
		model.addAttribute("board", board);
		return "board/form";
	}
	
	@PostMapping("/board/board")
	public String save(@AuthenticationPrincipal UserDto user, @Valid BoardDto boardDto) {
		
		boardDto.setUserDto(user);
		log.info(boardDto.getTitle());
		log.info(boardDto.getContents());
		boardService.save(boardDto);
		return "redirect://localhost:8080/board";
	}
	
	
}
