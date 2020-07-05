package com.ydual.mall.front.controller.mall;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ydual.mall.common.constants.Constants;
import com.ydual.mall.common.utils.MyBeanUtil;
import com.ydual.mall.common.utils.PageQueryUtil;
import com.ydual.mall.goodsmgr.controller.vo.NewBeeMallGoodsDetailVO;
import com.ydual.mall.goodsmgr.controller.vo.SearchPageCategoryVO;
import com.ydual.mall.goodsmgr.entity.NewBeeMallGoods;
import com.ydual.mall.goodsmgr.service.NewBeeMallCategoryService;
import com.ydual.mall.goodsmgr.service.NewBeeMallGoodsService;


@Controller
public class GoodsController {

    @Resource
    private NewBeeMallGoodsService newBeeMallGoodsService;
    @Resource
    private NewBeeMallCategoryService newBeeMallCategoryService;

    @RequestMapping({"/search", "/search.html"})
    public String searchPage(@RequestParam Map<String, Object> params, HttpServletRequest request) {
        if (StringUtils.isEmpty(params.get("page"))) {
            params.put("page", 1);
        }
        params.put("limit", Constants.GOODS_SEARCH_PAGE_LIMIT);
        //封装分类数据
        if (params.containsKey("goodsCategoryId") && !StringUtils.isEmpty(params.get("goodsCategoryId") + "")) {
            Long categoryId = Long.valueOf(params.get("goodsCategoryId") + "");
            SearchPageCategoryVO searchPageCategoryVO = newBeeMallCategoryService.getCategoriesForSearch(categoryId);
            if (searchPageCategoryVO != null) {
                request.setAttribute("goodsCategoryId", categoryId);
                request.setAttribute("searchPageCategoryVO", searchPageCategoryVO);
            }
        }
        //封装参数供前端回显
        if (params.containsKey("orderBy") && !StringUtils.isEmpty(params.get("orderBy") + "")) {
            request.setAttribute("orderBy", params.get("orderBy") + "");
        }
        String keyword = "";
        //对keyword做过滤 去掉空格
        if (params.containsKey("keyword") && !StringUtils.isEmpty((params.get("keyword") + "").trim())) {
            keyword = params.get("keyword") + "";
        }
        request.setAttribute("keyword", keyword);
        params.put("keyword", keyword);
        //封装商品数据
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        request.setAttribute("pageResult", newBeeMallGoodsService.searchNewBeeMallGoods(pageUtil));
        return "thymeleaf/mall/search";
    }

    @RequestMapping("/goods/detail/{goodsId}")
    public String detailPage(@PathVariable("goodsId") Long goodsId, HttpServletRequest request) {
        if (goodsId < 1) {
            return "thymeleaf/error/error_5xx";
        }
        NewBeeMallGoods goods = newBeeMallGoodsService.getNewBeeMallGoodsById(goodsId);
        if (goods == null) {
            return "thymeleaf/error/error_404";
        }
        NewBeeMallGoodsDetailVO goodsDetailVO = new NewBeeMallGoodsDetailVO();
        MyBeanUtil.copyProperties(goods, goodsDetailVO);
        goodsDetailVO.setGoodsCarouselList(goods.getGoodsCarousel().split(","));
        request.setAttribute("goodsDetail", goodsDetailVO);
        return "thymeleaf/mall/detail";
    }

}
