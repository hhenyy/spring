package com.example.demo.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "members")					// members 테이블 생성	
public class Member {

	@Id										// 기본키 설정
	private String id;
	private String passwd;
	private String name;
	private String email;
	
	@CreationTimestamp						// 회원가입 시간
	private Timestamp regdate;
	
	@UpdateTimestamp						// 회원수정 시간
	private Timestamp updatedate;
}
