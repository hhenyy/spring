package test01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import test01.model.Member;
import test01.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	@RequestMapping("MemberInsertForm.do")
	public String insertForm() {
		System.out.println("mc-insertform");
		
		return "MemberInsertForm";
	}
	
	@RequestMapping("MemberInsert.do")
	public String insert(Member member, Model model) {
		System.out.println("mc-insert");
		
		int result = ms.insert(member);
		return "MemberInsert";
	}

	
}
