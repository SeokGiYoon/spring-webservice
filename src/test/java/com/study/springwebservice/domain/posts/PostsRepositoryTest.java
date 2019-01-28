package com.study.springwebservice.domain.posts;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
	
	@Autowired
	PostsRepository postsRepository;
	
	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}
	
	@Test
	public void 게시글저장_불러오기() {
		//given
		postsRepository.save(Posts.builder()
							.title("title")
							.author("author")
							.content("content").build());
		//when
		List<Posts> postList= postsRepository.findAll();
		
		Posts posts = postList.get(0);
		assertThat(posts.getTitle(),  is("title"));
		assertThat(posts.getAuthor(), is("author"));
		assertThat(posts.getContent(), is("content"));
		
	}
	@Test
	public void BaseTimeEntity_등록() {
		//given
		LocalDateTime now = LocalDateTime.now();
		postsRepository.save(Posts.builder()
							.title("테스트 게시글")
							.author("jojoldu@gmail.com")
							.content("테스트 본문")
							.build());
		//when
		List<Posts> postList= postsRepository.findAll();
		
		//then
		Posts posts = postList.get(0);
		assertTrue(posts.getCreateDate().isAfter(now));
		assertTrue(posts.getModifiedDate().isAfter(now));
	}
}
