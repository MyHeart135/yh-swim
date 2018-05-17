package com.yh.swim.service.product.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.swim.dao.product.BrandDao;
import com.yh.swim.domain.condition.product.BrandCondition;
import com.yh.swim.domain.pojo.product.Brand;
import com.yh.swim.service.product.BrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("brandService")
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandDao brandDao;

    /**
     * 查询Brand分页对象
     *
     * @param condition 查询条件
     * @return
     */
    @Override
    public PageInfo<Brand> selectBrandPage(BrandCondition condition) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize(), condition.getOrderBy());
        List<Brand> brandList = brandDao.findBrandList(condition);
        PageInfo<Brand> pageInfo = new PageInfo<>(brandList);
        return pageInfo;
    }

    /**
     * 根据主键获取记录
     *
     * @param id
     * @return
     */
    @Override
    public Brand get(Long id) {
        return brandDao.get(id);
    }
}
