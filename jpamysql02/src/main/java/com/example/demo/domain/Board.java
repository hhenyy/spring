package com.example.demo.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="boards")									// boards 테이블 생성
public class Board {
	@Id													// 기본키 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment : 번호 자동 증가   
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
