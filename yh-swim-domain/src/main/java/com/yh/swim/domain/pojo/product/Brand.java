package com.yh.swim.domain.pojo.product;

import java.io.Serializable;

/**
 * 品牌类
 *
 * @author yanhuan
 */
public class Brand implements Serializable {

    /**
     * 品牌ID  bigint
     */
    private Long id;
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
     * 网址
     */
    private String webSite;
    /**
     * 排序  越大越靠前
     */
    private Integer sort;
    /**
     * 是否可用   0 不可用 1 可用
     */
    private Integer isDisplay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}
