package com.phinochhio.user.service.repository;

import com.phinochhio.user.service.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    public static Map<Long, Member> store = new HashMap<>(); //현재 DB가 없으니까 데이터 대신 저장할 HashMap생성
    private static long sequence = 0L; //key값 생성해주는 애

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null이어도 감쌀 수 있게 Optional.ofNullable사용
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //Lambda사용
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //store의 멤버들을 반환
    }
}
