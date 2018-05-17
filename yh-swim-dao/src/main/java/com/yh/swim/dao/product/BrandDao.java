package com.yh.swim.dao.product;

import com.yh.swim.domain.condition.product.BrandCondition;
import com.yh.swim.domain.pojo.product.Brand;

import java.util.List;

/**
 * bbs_brand表DAO
 *
 * @author yanhuan
 */
public interface BrandDao {

    /**
     * 查询品牌记录集合
     *
     * @param brandCondition 查询条件
     * @return List<Brand>
     */
    List<Brand> findBrandList(BrandCondition brandCondition);

    /**
     * 插入品牌数据
     *
     * @param brand 品牌对象
     * @return 受影响的行数
     */
    Integer insert(Brand brand);

    /**
     * 根据主键获取记录
     *
     * @param id
     * @return
     */
    Brand get(Long id);
}
