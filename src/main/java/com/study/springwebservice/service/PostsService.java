package com.study.springwebservice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.springwebservice.domain.posts.PostsRepository;
import com.study.springwebservice.dto.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
	private PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}
	
}
