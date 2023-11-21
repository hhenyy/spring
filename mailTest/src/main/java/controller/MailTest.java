package controller;

import java.util.Random;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailTest {

	@RequestMapping("/send.do")
	public String send(Model model) {

		Random random = new Random();//난수발생
		int a = random.nextInt(100);

		// Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.naver.com";
		String hostSMTPid = "hsham418@naver.com"; //메일주소
		String hostSMTPpwd = "hs6153364@"; 	// 비밀번호 입력

		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "hsham418@naver.com";
		String fromName = "친절한 홍길동씨";
		String subject = "Overflow인증메일입니다.";

		// 받는 사람 E-Mail 주소
		String mail = "hsham418@naver.com";

		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(587); //네이버에서 설정된 SMTP 포트 : 587

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg("<p align = 'center'>Overflow에 오신것을 환영합니다.</p><br>" 
							 + "<div align='center'> 인증번호 : " + a + "</div>");
			email.send();
		} catch (Exception e) {
			System.out.println(e);
		}		
		model.addAttribute("result", "good~!!\n 등록된 E-Mail 확인");

		return "result";
	}
}
