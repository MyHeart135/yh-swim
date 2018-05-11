package com.yh.swim.dao;

import com.yh.swim.domain.condition.SalaryCondition;
import com.yh.swim.domain.pojo.Salary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Dao:salary表
 * Created by yanhuan1 on 2018/1/16.
 */
public interface SalaryDao {

    Integer insert(Salary salary);

    Integer update(Salary salary);

    Integer delete(Long id);

    Salary getSalaryByCondition(SalaryCondition condition);

    List<Salary> findSalaryList(SalaryCondition condition);

    List<Salary> findSalaryPage(SalaryCondition condition);

    /**
     * 批量插入方法
     */
    Integer batchInsert(@Param("list") List<Salary> salaryList);

    /**
     * 批量删除方法
     */
    Integer batchDelete(@Param("list") List<Long> idList);

    /**
     * 批量插入或更新方法（不存在就插入，否则更新）
     */
    Integer batchInsertOrUpdate(@Param("list") List<Salary> salaryList);

    /**
     * 物理删除
     */
    Integer deletePhysics(@Param("id") Long id);

    List<Salary> findByDateSub(Integer days);
}
