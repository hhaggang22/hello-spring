package com.phinochhio.user.service.repository;

import com.phinochhio.user.service.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore(); //테스트가 한번씩 실행될 때 마다 저장소나 공용데이터 지워주는 코드
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); //Optional에서 꺼낼때는 get()으로 꺼냄

        //Assertions.assertEquals(member, result); //member와 result가 같은지 판단함
        assertThat(member).isEqualTo(result); // 위와 같은 기능
    }
    
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1"); //spring1과
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2"); //spring2라는 회원이 가입함.
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1"); //spring1과
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2"); //spring1과
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2); // 이렇게 하고 test run 하면 오류남(회원가입이 같은 내용이 2번 들어갔기 때문에) => 메소드 하나의 test끝날 때마다 repository 지워줘야함
    }

}
