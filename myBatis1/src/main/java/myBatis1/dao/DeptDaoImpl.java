package myBatis1.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import myBatis1.model.Dept;

@Repository
public class DeptDaoImpl implements DeptDao {
	//myBatis환경설정파일에서 db연동시 완벽하게 DI 를 쓰지못함.
	private static SqlSession session;
	//SqlSession: sql을 실행시켜주는 메소드를 제공하기때문에 구해오는것.
	static {
	    try { 
	    	Reader reader = Resources.getResourceAsReader("configuration.xml");
		      SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		      session = ssf.openSession(true); //auto commit
		      reader.close(); 
		} catch (IOException e) {
		  System.out.println("read file error : "+e.getMessage());
		}
	}
	public List<Dept> list() {
		return session.selectList("deptns.list"); 
	//mapper가 1개일때는 namespace(논리적영역 이름)생략가능,namespace="deptns"
	}
	public Dept select(int deptno) {
		return session.selectOne("deptns.select",deptno);
	  //object형으로 받기때문에 Dept 자료형으로 지동다운캐스팅 되어 값을 돌려줌 
	}
	public int update(Dept dept) {
		return session.update("deptns.update",dept);
		//수정되면 1개만 수정되기때문에 int형인 1을 돌려줌 
	}
	public int delete(int deptno) {
		return session.delete("deptns.delete",deptno);
	}
}