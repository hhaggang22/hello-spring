package com.phinochhio.user.service.repository;
import com.phinochhio.user.service.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository { //Repository에 4가지 기능 만듦.
    Member save(Member member);
    Optional<Member> findById(Long id); //Optional=> Java 8 부터 생긴 것, id나 name이 null 값으로 들어올 수 있기 때문에 처리해주는 것
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
