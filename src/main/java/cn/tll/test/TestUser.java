package cn.tll.test;


import cn.tll.dao.UserDao;
import cn.tll.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author tll
 * @date 2020/05/06
 * 测试mybatis  命名要尊从驼峰命名规范
 */
public class TestUser {
    public static void main(String[] args)throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.创建SqlSessionFactory构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        //3.使用构建者创造Factory对象
        SqlSessionFactory factory = builder.build(in);

        //4.使用SqlSessionFactory生产SqlSession对象
        SqlSession session = factory.openSession();

        //5.使用SqlSession对象创建dao代理对象
        UserDao dao = session.getMapper(UserDao.class);

        //6.使用代理对象查询所有方法
        List<User> userList = dao.findAll();

        for (User user : userList) {
            System.out.println(user);
        }
        //7.释放资源
        session.close();
        in.close();
    }
}
