package com.myhome.security1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myhome.security1.model.Member;
import com.myhome.security1.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService service; 
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;	
	
	@RequestMapping("memberform")
	public String memberform() {
		return "memberform";
	}
	
	@RequestMapping("memberinsert")
	public String memberinsert(Member member, Model model) {
		
		int result = 0;
		Member db = service.select(member.getId());
		
		if(db == null) {	// 사용 가능한 id
			String encpassword = passwordEncoder.encode(member.getPasswd());
			System.out.println("비번 암호화:"+ encpassword);
			member.setPasswd(encpassword);
			
			result = service.insert(member);			
		}else {             // 중복 id
			result = -1;
		}		
		model.addAttribute("result", result);
		
		return "insertresult";
	}
	
	@RequestMapping("loginform")
	public String loginform() {
		return "loginform";
	}
	
	@RequestMapping("login")
	public String login(Member member, HttpSession session, Model model) {
		int result = 0;
		Member db = service.select(member.getId());
		if(db != null) {
			// boolean  matches("입력한 password", "암호화된 password")
			if(passwordEncoder.matches(member.getPasswd(), db.getPasswd())) {
				session.setAttribute("id", member.getId());
				result = 1;
			}else {
				result = -2;
			}
		}
		model.addAttribute("result", result);
		
		return "loginresult";
	}
	
	@RequestMapping("mypage")
	public String mypage() {
		return "mypage";
	}
	
	@RequestMapping("updateform")
	public String updateform(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		Member member = service.select(id);
		model.addAttribute("member", member);		
		return "updateform";
	}
	
	@RequestMapping("update")
	public String update(Member member, Model model) {
		String encpassword = passwordEncoder.encode(member.getPasswd());
		System.out.println("수정된 비번 암호화:"+ encpassword);
		member.setPasswd(encpassword);
		
		int result = service.update(member);
		model.addAttribute("result", result);
		return "updateresult";
	}
	
	@RequestMapping("deleteform")
	public String deleteform() {		
		return "deleteform";
	}
	
	@RequestMapping("delete")
	public String delete(Member member, HttpSession session, Model model) {
		int result = 0;
		Member db = service.select(member.getId());
		
		// boolean  matches("입력한 password", "암호화된 password")
		if(passwordEncoder.matches(member.getPasswd(), db.getPasswd())) {
			result = service.delete(member.getId());
			session.invalidate();
		}else {
			result = -1;
		}
		model.addAttribute("result", result);
		return "deleteresult";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}
	
}
