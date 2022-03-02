package n3plus_defaultset;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resource/spring/context-*.xml"})
public class MybatisTest {
    @Inject
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testFactory(){
        System.out.println(sqlSessionFactory);
    }

    @Test
    public void testSession() throws Exception{
        try{
            SqlSession sqlSession = sqlSessionFactory.openSession();
            System.out.println(sqlSession);
            
            HashMap obj = (HashMap)sqlSession.selectOne("com.n3plus.test.getTest", null);
            System.out.println(obj.values());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}