package com.yh.swim.domain.condition.product;


import com.yh.swim.domain.BasePageCondition;

import java.math.BigDecimal;

/**
 * 查询条件对象
 *
 * @author yanhuan
 */
public class BrandCondition extends BasePageCondition {

    /**
     * 品牌名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 图片URL
     */
    private String imgUrl;
    /**
     * 排序  越大越靠前
     */
    private Integer sort;
    /**
     * 是否可用   0 不可用 1 可用
     */
    private Integer isDisplay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(Integer isDisplay) {
        this.isDisplay = isDisplay;
    }
}
