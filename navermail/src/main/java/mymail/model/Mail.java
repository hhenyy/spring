package mymail.model;

public class Mail {

	private String sendmail;
	private String receivemail;	
	private String subject;
	private String content;
	
	public String getSendmail() {
		return sendmail;
	}
	public void setSendmail(String sendmail) {
		this.sendmail = sendmail;
	}
	public String getReceivemail() {
		return receivemail;
	}
	public void setReceivemail(String receivemail) {
		this.receivemail = receivemail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
