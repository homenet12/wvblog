package com.wv.blog.domain.board.reply;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import com.wv.blog.config.entity.BaseEntity;
import com.wv.blog.domain.board.Board;

import lombok.Getter;


@Entity
@Getter
public class BoardReply extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String name;
	@Column(columnDefinition = "LONGTEXT")
	private String contents;
	
	@ManyToOne 
	private Board board;
}
