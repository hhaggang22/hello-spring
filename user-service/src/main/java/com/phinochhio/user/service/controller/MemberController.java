package com.phinochhio.user.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.phinochhio.user.service.service.MemberService;

@Controller //Controller 선언을 하면 spring이 실행될 때 container라는 spring 통이 생기는데 거기에 MemberController객체를 생성하여 넣어둠. (Spring Container에서 Spring bin이 관리됨)
public class MemberController {
	//private final MemberService memberService = new MemberService(); => 객체 하나만 생성해놓고 공유해서 쓰는게 나음

	private final MemberService memberService;

	@Autowired	//
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
}
