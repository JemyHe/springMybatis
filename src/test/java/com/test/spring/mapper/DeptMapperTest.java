package com.test.spring.mapper;

import com.test.spring.entity.Dept;
import com.test.spring.page.Search;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by 何冠雄 on 2018/2/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class DeptMapperTest {

    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void save() throws Exception {
        Dept dept = new Dept();
        dept.setDeptno(50);
        dept.setDname("测试部");
        dept.setLoc("北京");
        deptMapper.save(dept);
    }

    @Test
    public void update() throws Exception {
        Dept dept = new Dept();
        dept.setDeptno(50);
        dept.setDname("测试部");
        dept.setLoc("西安");
        deptMapper.update(dept);
    }

    @Test
    public void delete() throws Exception {
        deptMapper.delete(50);
    }

    @Test
    public void findById() throws Exception {
        Dept byId = deptMapper.findById(20);
        System.out.println(byId);
    }

    @Test
    public void findAll() throws Exception {
        List<Dept> all = deptMapper.findAll();
        for(Dept a:all){
            System.out.println(a);
        }
    }

    @Test
    public void findByPage() throws Exception {
        Map<String,Object> params = new HashMap<String, Object>();
        List<Dept> byPage = deptMapper.findByPage(new Search(2, 2, params));
        for (Dept a:byPage){
            System.out.println(a);
        }
    }

    @Test
    public void count() throws Exception {
    }

}