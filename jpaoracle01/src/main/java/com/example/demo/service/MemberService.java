package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository dao;
	
	public Member member(Member member) {
		// TODO Auto-generated method stub
		return dao.save(member);
	}

	public Optional<Member> getMember(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	public Member update(Member member) {
		// TODO Auto-generated method stub
		return dao.save(member);
	}

	public void delete(Member member) {
		// TODO Auto-generated method stub
		dao.delete(member);
	}

}
