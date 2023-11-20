package com.myhome.security1.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.myhome.security1.model.Member;

@Mapper
public interface MemberMapper {

	int insert(Member member);

	Member select(String id);

	int update(Member member);

	int delete(String id);
}
