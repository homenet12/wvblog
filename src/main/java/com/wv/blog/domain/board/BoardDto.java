package com.wv.blog.domain.board;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class BoardDto {

	private Long id;
	@NotBlank
	private String title;
	@NotBlank
	private String contents;
	
	private int pageView = 0;
	
	public Board toEntity() {
		return new Board().builder()
				.title(this.title)
				.contents(this.contents)
				.build();
	}
	
	public BoardDto() {}
	
	public BoardDto(Board board) {
		if(board.getId() != null) {
			this.id = board.getId();
		}
		this.title = board.getTitle(); 
		this.contents = board.getContents();
		this.pageView = board.getPageView();
	}
}
