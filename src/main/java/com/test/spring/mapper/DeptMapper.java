package com.test.spring.mapper;

import com.test.spring.entity.Dept;
import com.test.spring.page.Search;

import java.util.List;

/**
 * Created by 何冠雄 on 2018/2/8.
 */
public interface DeptMapper {

    void save(Dept dept);
    void update(Dept dept);
    void delete(int deptno);
    Dept findById(int deptno);
    List<Dept> findAll();
    List<Dept> findByPage(Search search);
    int count(Search search);


}
