package com.myhome.security1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.security1.mapper.MemberMapper;
import com.myhome.security1.model.Member;

@Service
public class MemberService {

	@Autowired
	private MemberMapper dao;

	public int insert(Member member) {
		return dao.insert(member);
	}

	public Member select(String id) {
		return dao.select(id);
	}

	public int update(Member member) {
		return dao.update(member);
	}

	public int delete(String id) {
		return dao.delete(id);
	}
}
