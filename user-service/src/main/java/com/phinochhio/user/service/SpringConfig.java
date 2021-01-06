package com.phinochhio.user.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.phinochhio.user.service.repository.MemberRepository;
import com.phinochhio.user.service.repository.MemoryMemberRepository;
import com.phinochhio.user.service.service.MemberService;

@Configuration
public class SpringConfig {

	@Bean
	public MemberService memberService(){
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository(){
		return new MemoryMemberRepository();
	}


}
