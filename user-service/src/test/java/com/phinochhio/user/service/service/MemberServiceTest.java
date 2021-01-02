package com.phinochhio.user.service.service;

import com.phinochhio.user.service.domain.Member;
import com.phinochhio.user.service.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    //MemoryMemberRepository memberRepository = new MemoryMemberRepository(); // MemoryMemberRepository와 굳이 다른 객체를 만들어야할까? => 좀 위험
    MemoryMemberRepository memberRepository; // 해결방법=> MemberService 클래스에서 아예 객체 선언을 외부에서 넣어줌.

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore(); //테스트가 한번씩 실행될 때 마다 저장소나 공용데이터 지워주는 코드
    }

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
        /*
        try{
            memberService.join(member2); // 둘이 이름이 같은 객체가 들어가니까 예외가 발생함
            fail();
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
       */

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}