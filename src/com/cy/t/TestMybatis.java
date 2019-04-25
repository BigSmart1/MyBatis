package com.cy.t;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @ClassName TestMybatis
 * @Description TODD
 * @Author BigPig
 * @Date 2019/4/25 16:47
 * @Version 1.0
 **/
public class TestMybatis {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        System.out.println("=================增加====================");
        category cas=new category();
        cas.setName("测试3");
        //提交
        session.insert("insertCategory",cas);
        listAll(session);

        System.out.println("=================删除====================");
        cas.setId(2);
        session.delete("deleteCategory",cas);
        listAll(session);



        //session提交
        session.commit();
        //session关闭
        session.close();


    }

    private static void listAll(SqlSession session)
    {
        List<category> cs = session.selectList("listCategory");
        for (category c : cs) {
            System.out.println(c.getName());
        }

    }

    private static void listAllP(SqlSession session) {
        List<Product> ls = session.selectList("listProduct");
        for (Product c : ls) {
            System.out.println(c.getName() + "有" + c.getPrice());
        }
    }
}


