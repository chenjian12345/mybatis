import com.cj.mapper.ClassMapper;
import com.cj.mapper.StudentMapper;
import com.cj.pojo.*;
import com.cj.pojo.Class;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {

    public static void main(String[] args)
    {
        // mybatis的配置文件
        String resource = "mybatis.xml";
        // 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        // 构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();

        // 映射sql的标识字符串，
        String statement = "mapper.Student.findAll???";
        // 执行sql
        List<Student> studentList = session.selectList(statement);
        for (Student student : studentList)
        {
            System.out.println(student.toString());
        }

        session.commit();
        session.close();
    }

    @Test
    public void addStudent()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.Student.addStudent";

        Student student = new Student();
        student.setStudentId("005");
        student.setStudentName("王大锤");
        student.setClassId("001");
        student.setAge(18);
        student.setActive((byte) 1);

        int num = session.insert(statement, student);

        System.out.println(num);

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

        String statement = "mapper.Student.deleteByStudentId";

        Student student = new Student();
        student.setStudentId("005");

        int num = session.delete(statement, student);

        System.out.println(num);

        session.commit();
        session.close();
    }

    @Test
    public void findByStudentId()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.Student.findByStudentId";

        Student student = session.selectOne(statement, "003");

        System.out.println(student.toString());

        session.commit();
        session.close();
    }

    @Test
    public void updateStudent()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.Student.updateStudent";

        Student student = new Student();
        student.setStudentId("004");
        student.setStudentName("王大锤");

        int num = session.update(statement, student);
        
        System.out.println(num);

        session.commit();
        session.close();
    }

    @Test
    public void findByStudentName()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.Student.findByStudentName";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("studentName", "张大炮");

        List<Student> studentList = session.selectList(statement, map);
        for (Student student : studentList)
        {
            System.out.println(student.toString());
        }

        session.commit();
        session.close();
    }

    @Test
    public void findByStudentNameLike()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.Student.findByStudentNameLike";

        Student student1 = new Student();
        student1.setStudentName("天");

        List<Student> studentList = session.selectList(statement, student1);
        for (Student student : studentList)
        {
            System.out.println(student.toString());
        }

        session.commit();
        session.close();
    }

    @Test
    public void findByStudentIdAndStudentNameLike()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.Student.findByStudentIdAndStudentNameLike";

        Student student1 = new Student();
//        student1.setStudentId("002");
        student1.setStudentName("天");

        List<Student> studentList = session.selectList(statement, student1);
        for (Student student : studentList)
        {
            System.out.println(student.toString());
        }

        session.commit();
        session.close();
    }

    @Test
    public void findByAgeGreaterThanAndStudentName()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.Student.findByAgeGreaterThanAndStudentName";

        Student student1 = new Student();
        student1.setStudentName("天");
        student1.setAge(2);

        List<Student> studentList = session.selectList(statement, student1);
        for (Student student : studentList)
        {
            System.out.println(student.toString());
        }

        session.commit();
        session.close();
    }

    @Test
    public void findAll1()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.Class.findAll";

        List<Class> classList = session.selectList(statement);
        for (Class class1 : classList)
        {
            System.out.println(class1.toString());
        }

        session.commit();
        session.close();
    }

    @Test
    public void findByClassId()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.Class.findByClassId";

        Class c = new Class();
        c.setClassId("001");

        List<Class> classList = session.selectList(statement, c);
        for (Class class1 : classList)
        {
            System.out.println(class1.toString());
        }

        session.commit();
        session.close();
    }

    @Test
    public void findAllLeftJoinClass()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.Student.findAllLeftJoinClass";

        List<Student> studentList = session.selectList(statement);
        for (Student student : studentList)
        {
            System.out.println(student.toString());
        }

        session.commit();
        session.close();
    }

    @Test
    public void findByStudentNameAndAgeAndActive()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.Student.findByStudentNameAndAgeAndActive";

        Student student1 = new Student();
        student1.setStudentName("天");
        student1.setAge(2);

        List<Student> studentList = session.selectList(statement, student1);
        for (Student student : studentList)
        {
            System.out.println(student.toString());
        }

        session.commit();
        session.close();
    }

    @Test
    public void findByStudentIds()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.Student.findByStudentIds";

        List<String> studentIdList= new ArrayList<String>();
        studentIdList.add("001");
        studentIdList.add("002");

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("studentIdList", studentIdList);
        map1.put("age", 2);

        List<Student> studentList = session.selectList(statement, map1);
        for (Student student : studentList)
        {
            System.out.println(student.toString());
        }

        session.commit();
        session.close();
    }

    @Test
    public void findAll2()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> studentList = mapper.findAll();
        for (Student student : studentList)
        {
            System.out.println(student.toString());
        }

        session.commit();
        session.close();
    }

    @Test
    public void findAll3()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        ClassMapper mapper = session.getMapper(ClassMapper.class);

        List<Class> classList = mapper.findAll();
        for (Class class1 : classList)
        {
            System.out.println(class1.toString());
        }

        session.commit();
        session.close();
    }

    @Test
    public void findByStudentId1()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> studentList = mapper.findByStudentId("001");
        for (Student student : studentList)
        {
            System.out.println(student.toString());
        }

        session.commit();
        session.close();
    }

    @Test
    public void findAllTeacher()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.Teacher.findAll";

        List<Teacher> teacherList = session.selectList(statement);
        for (Teacher teacher : teacherList)
        {
            System.out.println(teacher.toString());
        }

        session.commit();
        session.close();
    }

    @Test
    public void findAllClassAndTeacher()
    {
        String resource = "mybatis.xml";
        InputStream is = MyTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        String statement = "mapper.TeacherClass.findAll";

        List<TeacherClass> teacherClassList = session.selectList(statement);
        for (TeacherClass teacherClass : teacherClassList)
        {
            System.out.println(teacherClass.toString());
        }

        session.commit();
        session.close();
    }
}