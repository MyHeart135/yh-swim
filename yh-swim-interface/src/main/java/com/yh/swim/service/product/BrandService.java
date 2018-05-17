package com.yh.swim.service.product;

import com.github.pagehelper.PageInfo;
import com.yh.swim.domain.condition.product.BrandCondition;
import com.yh.swim.domain.pojo.product.Brand;

/**
 * 品牌管理服务
 */
public interface BrandService {

    /**
     * 查询分页对象
     *
     * @param condition 查询条件
     * @return 分页对象
     */
    PageInfo<Brand> selectBrandPage(BrandCondition condition);

    /**
     * 根据主键获取记录
     *
     * @param id
     * @return
     */
    Brand get(Long id);

}
