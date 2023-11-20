package test01.service;

import java.util.List;

import org.springframework.stereotype.Service;

import test01.mapper.MemberDao;
import  test01.model.Member;

@Service
public class MemberService{
	
	private MemberDao md;
	
	public int insert(Member member) {
		return md.insert(member);
	}

	public Member select(String id) {
		return md.select(id);
	}

	public List<Member> list() {
		return md.list();
	}

	public int update(String id) {
		return md.update(id);
	}

	public int delete(String id) {
		return md.delete(id);
	}

}
