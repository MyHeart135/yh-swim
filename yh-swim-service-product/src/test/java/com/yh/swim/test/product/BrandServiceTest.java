package com.yh.swim.test.product;


import com.github.pagehelper.PageInfo;
import com.yh.swim.BaseTest;
import com.yh.swim.domain.condition.product.BrandCondition;
import com.yh.swim.domain.pojo.product.Brand;
import com.yh.swim.service.product.BrandService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class BrandServiceTest extends BaseTest {

    private static Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @Resource
    protected BrandService brandService;

    @Test
    public void testGetPage(){
        BrandCondition condition = new BrandCondition();
        condition.setName("（");
        condition.setPageNum(2);
        condition.setPageSize(4);
        PageInfo<Brand> brandPageInfo = brandService.selectBrandPage(condition);
        System.out.println(brandPageInfo.getList().size());
    }
}
