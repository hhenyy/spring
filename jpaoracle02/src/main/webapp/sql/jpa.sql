-- Oracle

select * from tab;
select * from seq;

select * from boards;
select hibernate_sequence.nextval from dual;
select boards_sequence.nextval from dual;

purge recyclebin;
drop table boards purge;
drop sequence hibernate_sequence;
drop sequence boards_seq;

-- 테이블과 시퀀스는 직접 생성하지 않고 자동으로 생성된다.
create table boards(
	no number primary key,	
	writer varchar2(50),
	subject varchar2(200),
	content varchar2(1000),	
	regdate timestamp );
	
create sequence boards_seq;	


