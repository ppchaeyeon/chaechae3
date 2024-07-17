package class272.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	private static SqlSessionFactory sqlSessionFactory;

	static {
		
		try {
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			
			Reader rd = Resources.getResourceAsReader("config/mybatis-config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(rd);
			
			rd.close();
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}
	
	/**
	 * SqlSession객체를 제공하는 메서드
	 * @return SqlSession객체
	 */
	public static SqlSession getSqlSession() {
		
		return sqlSessionFactory.openSession();
	}
	
	/**
	 * SqlSession객체를 제공하는 메서드
	 * @param autoCommit 오토커밋 여부
	 * @return SqlSession객체
	 */
	public static SqlSession getSqlSession(boolean autoCommit) {

		return sqlSessionFactory.openSession(autoCommit);
	}
	
}