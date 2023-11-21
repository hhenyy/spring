package com.example.demo.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="boards")									// boards 테이블 생성
@SequenceGenerator(name="boards_seq_gen", 			    // 시퀀스 제너레이터 이름
 sequenceName="boards_seq", 							// 시퀀스 이름
 initialValue=1, 										// 시작값
 allocationSize=1 )									    // 증가값	
public class Board {
	
	@Id													// 기본키 설정
//	@GeneratedValue(strategy = GenerationType.AUTO)     // JPA 구현체(Hibernate)가 자동으로 생성 방식을 결정
	                                                    // hibernate_sequence가 자동으로 생성된다.
	@GeneratedValue(strategy = GenerationType.SEQUENCE, // 사용할 전략을 시퀀스로 선택
    				generator="boards_seq_gen" )		// 생성기를 boards_seq_gen으로 설정 
	private int no;	
	private String writer;
	private String passwd;
	private String subject;
	private String content;	
	
	@CreationTimestamp
	private Timestamp regdate;	
	
	@UpdateTimestamp
	private Timestamp updatedate;
}
