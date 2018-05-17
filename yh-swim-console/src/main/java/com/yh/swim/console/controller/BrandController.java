package com.yh.swim.console.controller;

import com.github.pagehelper.PageInfo;
import com.yh.swim.domain.condition.product.BrandCondition;
import com.yh.swim.domain.pojo.product.Brand;
import com.yh.swim.service.product.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 品牌管理控制器
 *
 * @author yanhuan
 */
@Controller
public class BrandController {

    @Resource
    private BrandService brandService;

    /**
     * 跳转到品牌修改页面
     */
    @RequestMapping(value = "/brand/toEdit")
    public String toEdit(Long id, Model model) {
        Brand brand = brandService.get(id);
        model.addAttribute("brand", brand);
        return "brand/edit";
    }

    /**
     * 查询品牌集合，用于分页展示
     */
    @RequestMapping(value = "/brand/list")
    public String list(BrandCondition brandCondition, Model model) {
        PageInfo<Brand> brandPageInfo = brandService.selectBrandPage(brandCondition);
        model.addAttribute("page", brandPageInfo);
        model.addAttribute("name", brandCondition.getName());
        if (null != brandCondition.getIsDisplay()) {
            model.addAttribute("isDisplay", brandCondition.getIsDisplay());
        } else {
            model.addAttribute("isDisplay", 1);
        }
        StringBuilder params = new StringBuilder();
        if (StringUtils.isNotEmpty(brandCondition.getName())) {
            params.append("name=").append(brandCondition.getName());
        }
        if (brandCondition.getIsDisplay() != null) {
            params.append("&isDisplay=").append(brandCondition.getIsDisplay());
        } else {
            params.append("&isDisplay=0");
        }
        List<String> pageView = pageView("/brand/list", params.toString(), brandPageInfo);
        model.addAttribute("pageView", pageView);
        return "brand/list";
    }

    /**
     * 取分页信息
     */
    private List<String> pageView(String url, String params, PageInfo<Brand> brandPageInfo) {
        List<String> pageView = new ArrayList();
        int pageNum = brandPageInfo.getPageNum();
        if (pageNum != 1) {
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNum=1'\"><font size=2>首页</font></a>");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNum=" + (pageNum - 1) + "'\"><font size=2>上一页</font></a>");
        } else {
            pageView.add("<font size=2>首页</font>");
            pageView.add("<font size=2>上一页</font>");
        }
        if (brandPageInfo.getLastPage() <= 10) {
            for (int i = 0; i < brandPageInfo.getLastPage(); i++) {
                if (i + 1 == pageNum) {
                    pageView.add("<strong>" + pageNum + "</strong>");
                    i++;
                    if (pageNum == brandPageInfo.getLastPage()) {
                        break;
                    }
                }
                pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNum=" + (i + 1) + "'\">" + (i + 1) + "</a>");
            }
        } else if (brandPageInfo.getLastPage() <= 20) {
            int l = 0;
            int r = 0;
            if (pageNum < 5) {
                l = pageNum - 1;
                r = 10 - l - 1;
            } else if (brandPageInfo.getLastPage() - pageNum < 5) {
                r = brandPageInfo.getLastPage() - pageNum;
                l = 9 - r;
            } else {
                l = 4;
                r = 5;
            }
            int tmp = pageNum - l;
            for (int i = tmp; i < tmp + 10; i++) {
                if (i == pageNum) {
                    pageView.add("<strong>" + pageNum + "</strong>");
                    i++;
                    if (pageNum == brandPageInfo.getLastPage()) {
                        break;
                    }
                }
                pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNum=" + i + "'\">" + i + "</a>");
            }
        } else if (pageNum < 7) {
            for (int i = 0; i < 8; i++) {
                if (i + 1 == pageNum) {
                    pageView.add("<strong>" + pageNum + "</strong>");
                    i++;
                }
                pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNum=" + (i + 1) + "'\">" + (i + 1) + "</a>");
            }
            pageView.add("...");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNum=" + (brandPageInfo.getLastPage() - 1) + "'\">" + (brandPageInfo.getLastPage() - 1) + "</a>");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNum=" + brandPageInfo.getLastPage() + "'\">" + brandPageInfo.getLastPage() + "</a>");
        } else if (pageNum > brandPageInfo.getLastPage() - 6) {
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNum=" + 1 + "'\">" + 1 + "</a>");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNum=" + 2 + "'\">" + 2 + "</a>");
            pageView.add("...");
            for (int i = brandPageInfo.getLastPage() - 8; i < brandPageInfo.getLastPage(); i++) {
                if (i + 1 == pageNum) {
                    pageView.add("<strong>" + pageNum + "</strong>");
                    i++;
                    if (pageNum == brandPageInfo.getLastPage()) {
                        break;
                    }
                }
                pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNum=" + (i + 1) + "'\">" + (i + 1) + "</a>");
            }
        } else {
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNum=" + 1 + "'\">" + 1 + "</a>");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNum=" + 2 + "'\">" + 2 + "</a>");
            pageView.add("...");

            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNum=" + (pageNum - 2) + "'\">" + (pageNum - 2) + "</a>");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNum=" + (pageNum - 1) + "'\">" + (pageNum - 1) + "</a>");
            pageView.add("<strong>" + pageNum + "</strong>");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNum=" + (pageNum + 1) + "'\">" + (pageNum + 1) + "</a>");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNum=" + (pageNum + 2) + "'\">" + (pageNum + 2) + "</a>");

            pageView.add("...");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNum=" + (brandPageInfo.getLastPage() - 1) + "'\">" + (brandPageInfo.getLastPage() - 1) + "</a>");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNum=" + brandPageInfo.getLastPage() + "'\">" + brandPageInfo.getLastPage() + "</a>");
        }
        if (pageNum != brandPageInfo.getLastPage()) {
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNum=" + (pageNum + 1) + "'\"><font size=2>下一页</font></a>");
            pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNum=" + brandPageInfo.getLastPage() + "'\"><font size=2>尾页</font></a>");
        } else {
            pageView.add("<font size=2>下一页</font>");
            pageView.add("<font size=2>尾页</font>");
        }
        pageView.add("共<var>" + brandPageInfo.getLastPage() + "</var>页 到第<input type='text' id='pageNum'  size='3' />页 <input type='button' id='skip' class='hand btn60x20' value='确定' onclick=\"javascript:window.location.href = '" + url + "?" + params + "&pageNum=' + $('#pageNum').val() \"/>");
        return pageView;
    }
}
