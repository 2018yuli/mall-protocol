package com.ydual.mall.front.service;

import java.util.List;

import com.ydual.mall.common.utils.PageQueryUtil;
import com.ydual.mall.common.utils.PageResult;
import com.ydual.mall.front.controller.vo.NewBeeMallIndexCarouselVO;
import com.ydual.mall.front.entity.Carousel;

public interface NewBeeMallCarouselService {
    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getCarouselPage(PageQueryUtil pageUtil);

    String saveCarousel(Carousel carousel);

    String updateCarousel(Carousel carousel);

    Carousel getCarouselById(Integer id);

    Boolean deleteBatch(Integer[] ids);

    /**
     * 返回固定数量的轮播图对象(首页调用)
     *
     * @param number
     * @return
     */
    List<NewBeeMallIndexCarouselVO> getCarouselsForIndex(int number);
}
