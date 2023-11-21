package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, String>{

//	@Override
//	default <S extends Member> S save(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
//	@Override
//	default Optional<Member> findById(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
//	@Override
//	default void delete(Member entity) {
//		// TODO Auto-generated method stub		
//	}
	
//	public Member save(Member member);               // 회원가입, 정보수정
//	public Optional<Member> findById(String id);     // 로그인, 수정폼
//	public void delete(Member member);     			 // 회원탈퇴
	
}
