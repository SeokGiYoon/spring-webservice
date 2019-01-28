package com.study.springwebservice.dto;

import com.study.springwebservice.domain.posts.Posts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostsSaveRequestDto {

	private String title;
	private String content;
	private String author;
	
	public Posts toEntity() {
		return Posts.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
	}
	
}
