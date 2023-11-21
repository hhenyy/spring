-- 게시판
select * from tab;
select * from board;

create table board (
	num number primary key, 			-- primary key
	writer varchar2(20) not null, 		-- 작성자
	subject varchar2(50) not null, 		-- 제목
	content varchar2(500) not null, 	-- 내용
	email varchar2(30) , 				-- 이메일
	readcount number default 0, 		-- 조회수
	passwd varchar2(12) not null, 		-- 비밀번호
	ref number not null, 				-- 답변글끼리 그룹
	re_step number not null, 			-- 댓글 출력 순서
	re_level number not null, 			-- 댓글 레벨
	ip varchar2(20) not null, 			-- 작성자 ip
	reg_date date not null, 			-- 작성일
	del char(1)
);
