package com.phinochhio.user.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.phinochhio.user.service.repository.JdbcMemberRepository;
import com.phinochhio.user.service.repository.MemberRepository;
import com.phinochhio.user.service.service.MemberService;

@Configuration
public class SpringConfig {

	private DataSource dataSource;

	@Autowired
	public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		//return new MemoryMemberRepository();
		return new JdbcMemberRepository(dataSource);
	}

}
