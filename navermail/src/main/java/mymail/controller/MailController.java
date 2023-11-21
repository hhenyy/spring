package mymail.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mymail.model.Mail;

@Controller
public class MailController {
	
	@Autowired
	private JavaMailSender jMailSender;
	
	@RequestMapping(value="mailform.do", method=RequestMethod.GET)
	public String mailform() {
		return "mailform";
	}
	
	@RequestMapping(value="mailsend.do", method=RequestMethod.POST)
	public String mailsend(Mail mail, Model model) {
		MimeMessage mms = jMailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mms, true, "utf-8");
			messageHelper.setSubject(mail.getSubject());
			messageHelper.setText(mail.getContent(), true);
			messageHelper.setFrom(mail.getSendmail());
			messageHelper.setTo(mail.getReceivemail());
			jMailSender.send(mms);
			
			model.addAttribute("result", 1);
			model.addAttribute("message", "입력하신 이메일로 발송");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("result", -1);
			model.addAttribute("message", "메일 보내기 실패");
		}
		return "mailresult";
	}
}
