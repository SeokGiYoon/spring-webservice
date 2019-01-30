package com.study.springwebservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.springwebservice.domain.posts.PostsRepository;
import com.study.springwebservice.dto.PostsSaveRequestDto;
import com.study.springwebservice.service.PostsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {
	
	private PostsRepository postsRepository;
	private PostsService postsService;
	
	@GetMapping("/hello")
	public String hello() {
		return "Helloworld";
	}
	
	@PostMapping("/posts")
	public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
		return postsService.save(dto); 
	}
	
}
