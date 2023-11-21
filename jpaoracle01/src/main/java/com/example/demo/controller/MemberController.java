package com.example.demo.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	// 회원가입 폼
	@RequestMapping("memberform")
	public String memberform() {
		return "memberform";
	}
	
	// 회원가입
	@RequestMapping("member")
	public String member(Member member) {
		Member result = service.member(member);		// insert SQL문 실행
		System.out.println("member:"+ result);
		return "loginform";
	}
	
	// 로그인 폼
	@RequestMapping("loginform")
	public String loginform() {
		return "loginform";
	}
	
	// 로그인
	@RequestMapping("login")
	public String login(Member member, HttpSession session, Model model) {
		Optional<Member> opt = service.getMember(member.getId());
		int result = 0;
		if(opt.isPresent()) {
			if(opt.get().getPasswd().equals(member.getPasswd())) { //비번일치
				result = 1;		// 로그인 성공 : 회원인증 성공
				session.setAttribute("id", member.getId());  // 세션 설정
			}else { 		    //비번 불일치
				result = -1;
			}
		}
		model.addAttribute("result", result);
		return "loginresult";
	}
	
	// 로그인 성공후 main page이동
	@RequestMapping("main")
	public String main() {
		return "main";
	}
	
	// 로그아웃
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();    // 세션 삭제
		return "logout";
	}
	
	// 정보 수정 폼
	@RequestMapping("updateform")
	public String updateform(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		Optional<Member> opt = service.getMember(id);	// 회원 1명 검색
		model.addAttribute("member", opt.get());
		
		return "updateform";
	}
	
	// 정보 수정
	@RequestMapping("update")
	public String update(Member member, Model model) {
		Optional<Member> opt = service.getMember(member.getId()); // 회원 1명 검색
		int result = 0;
		if(opt.isPresent()) {
			if(opt.get().getPasswd().equals(member.getPasswd())) { //비번일치
				Member db = service.update(member);	  // update SQL문 실행
				result = 1;		
			}else { 		    //비번 불일치
				result = -1;
			}
		}
		model.addAttribute("result", result);
		return "updateresult";
	}
	
	// 회원탈퇴 폼
	@RequestMapping("deleteform")
	public String deleteform() {
		return "deleteform";
	}
	
	// 회원탈퇴
	@RequestMapping("delete")
	public String delete(Member member, HttpSession session, Model model) {
		Optional<Member> opt = service.getMember(member.getId());  // 회원 1명 검색
		int result = 0;
		if(opt.isPresent()) {
			if(opt.get().getPasswd().equals(member.getPasswd())) { // 비번일치
				service.delete(member);	  	// delete SQL문 실행
				result = 1;		
			}else { 		    			// 비번 불일치
				result = -1;
			}
		}
		session.invalidate();               // 세션 삭제
		model.addAttribute("result", result);		
		return "deleteresult";
	}
	
	
}
