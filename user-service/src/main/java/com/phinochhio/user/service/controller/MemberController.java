package com.phinochhio.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.phinochhio.user.service.domain.Member;
import com.phinochhio.user.service.service.MemberService;

@Controller //Controller 선언을 하면 spring이 실행될 때 container라는 spring 통이 생기는데 거기에 MemberController객체를 생성하여 넣어둠. (Spring Container에서 Spring bin이 관리됨)
public class MemberController {
	//private final MemberService memberService = new MemberService(); => 객체 하나만 생성해놓고 공유해서 쓰는게 나음

	private final MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/members/new")
	public String createForm(){
		return "/members/createMemberForm";
	}

	@PostMapping("/members/new")
	public String create(MemberForm form){
		Member member = new Member();
		member.setName(form.getName());

		memberService.join(member);

		return "redirect:/";
	}

	@GetMapping("/members")
	public String list(Model model){
		List<Member> members = memberService.findMembers();
		model.addAttribute("members", members);
		return "members/memberList";
	}

}
