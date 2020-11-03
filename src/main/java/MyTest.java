import com.cj.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MyTest {

    public static void main(String[] args)
    {
        // mybatis的配置文件
        String resource = "mybatis.xml";
        // 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        // 构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        // Reader reader = Resources.getResourceAsReader(resource);
        // 构建sqlSession的工厂
        // SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();

        // 映射sql的标识字符串，
        // me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
        // getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
        String statement = "mapper.User.findAll";
        // 映射sql的标识字符串
        // 执行查询返回一个唯一user对象的sql1
        List<User> userList = session.selectList(statement);
        for (User user : userList)
        {
            System.out.println("ID:" + user.getUserId() + ", NAME:" + user.getUserName());
        }

        session.commit();
        session.close();
    }

    @Test
    public void addUser()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.User.addUser";

        User user = new User();
        user.setUserId("004");
        user.setUserName("赵日天");
        user.setPassword("123456");
        user.setActive((byte) 1);

        session.insert(statement, user);

        session.commit();
        session.close();
    }

    @Test
    public void deleteUser()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.User.deleteById";

        User user = new User();
        user.setUserId("004");

        session.delete(statement, user);

        session.commit();
        session.close();
    }

    @Test
    public void findByUserId()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.User.findByUserId";

        User user = session.selectOne(statement, "003");
        System.out.println("id: " + user.getUserId() +", name: "+ user.getUserName());

        session.commit();
        session.close();
    }

    @Test
    public void updateUser()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.User.updateUser";

        User user = new User();
        user.setUserId("003");
        user.setUserName("张大炮1");
        user.setActive((byte) 0);

        session.update(statement, user);

        session.commit();
        session.close();
    }

    @Test
    public void findByUserName()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.User.findByUserName";

        List<User> userList = session.selectList(statement, "张大炮1");
        for (User user : userList)
        {
            System.out.println("ID:" + user.getUserId() + ", NAME:" + user.getUserName());
        }

        session.commit();
        session.close();
    }

    @Test
    public void findByUserNameLike()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.User.findByUserNameLike";

        List<User> userList = session.selectList(statement, "炮");
        for (User user : userList)
        {
            System.out.println("ID:" + user.getUserId() + ", NAME:" + user.getUserName());
        }

        session.commit();
        session.close();
    }

    @Test
    public void findByUserIdAndUserNameLike()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.User.findByUserIdAndUserNameLike";

        User user = new User();
        user.setUserId("001");
        user.setUserName("炮");

        List<User> userList = session.selectList(statement, user);
        for (User user1 : userList)
        {
            System.out.println("ID:" + user1.getUserId() + ", NAME:" + user1.getUserName());
        }

        session.commit();
        session.close();
    }

    @Test
    public void findByAgeGreaterThanAndUserName()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.User.findByAgeGreaterThanAndUserName";

        User user = new User();
        user.setAge(1);
        user.setUserName("炮");

//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("age", 1);
//        map.put("userName", "炮");

        List<User> userList = session.selectList(statement, user);
        for (User user1 : userList)
        {
            System.out.println("ID:" + user1.getUserId() + ", NAME:" + user1.getUserName());
        }

        session.commit();
        session.close();
    }
}