-- 회원관리
select * from tab;
select * from member;

create table member(
	id varchar2(30) primary key,
    passwd varchar2(300)
);