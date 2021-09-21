package com.wv.blog.domain.board;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.wv.blog.domain.user.UserDto;

import lombok.Data;

@Data
public class BoardDto {

	private Long id;
	@NotBlank
	private String title;
	@NotBlank
	private String contents;
	private LocalDateTime createDate;
	
	private int pageView = 0;
	
	private UserDto userDto;
	
	public Board toEntity() {
		return new Board().builder()
				.id(id)
				.title(this.title)
				.contents(this.contents)
				.user(this.userDto.toEntity())
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
		this.createDate = board.getCreatedDate();
		this.userDto = new UserDto(board.getUser());
	}
}
