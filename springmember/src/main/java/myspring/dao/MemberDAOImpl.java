package myspring.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.model.MemberBean;

@Repository
public class MemberDAOImpl {
	
	@Autowired
	private SqlSession sqlSession;	


	/***** 아이디 중복 체크 *****/
//	@Transactional
	public int checkMemberId(String id) throws Exception {
		int re = -1;	// 사용 가능한 ID
		MemberBean mb = sqlSession.selectOne("login_check", id);
		if (mb != null)
			re = 1; 	// 중복id
		return re;
	}
	

	/* 비번 검색 */
//	@Transactional
	public MemberBean findpwd(MemberBean pm) throws Exception {
		return sqlSession.selectOne("pwd_find", pm);
	}

	/* 회원저장 */
//	@Transactional
	public void insertMember(MemberBean m) throws Exception {
		sqlSession.insert("member_join", m);
	}

	/* 로그인 인증 체크 */
//	@Transactional
	public MemberBean userCheck(String id) throws Exception {
		return sqlSession.selectOne("login_check", id);
	}

	/* 회원수정 */
//	@Transactional
	public void updateMember(MemberBean member) throws Exception {
		sqlSession.update("member_edit", member);
	}

	/* 회원삭제 */
//	@Transactional
	public void deleteMember(MemberBean delm) throws Exception {
		sqlSession.update("member_delete", delm);
	}
}





