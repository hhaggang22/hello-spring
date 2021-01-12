package com.phinochhio.user.service.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.phinochhio.user.service.domain.Member;
import com.phinochhio.user.service.repository.MemberRepository;
import com.phinochhio.user.service.repository.MemoryMemberRepository;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;

	@Test
	void 회원가입() {
		//given
		Member member = new Member();
		member.setName("Spring");

		//when
		Long saveId = memberService.join(member);

		//then
		Member findMember = memberService.findOne(saveId).get(); //우리가 저장한게 repository에 있는지 확인하고 싶음
		assertThat(member.getName()).isEqualTo(findMember.getName());
	}

	@Test
	void 중복_회원_예외(){
		//given
		Member member1 = new Member();
		member1.setName("Spring");

		Member member2 = new Member();
		member2.setName("Spring");

		//when
		memberService.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

	}
}
