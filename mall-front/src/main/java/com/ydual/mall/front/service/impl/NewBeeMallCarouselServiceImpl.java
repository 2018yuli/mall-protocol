package com.ydual.mall.front.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.ydual.mall.common.constants.ServiceResultEnum;
import com.ydual.mall.common.utils.MyBeanUtil;
import com.ydual.mall.common.utils.PageQueryUtil;
import com.ydual.mall.common.utils.PageResult;
import com.ydual.mall.front.controller.vo.NewBeeMallIndexCarouselVO;
import com.ydual.mall.front.dao.CarouselMapper;
import com.ydual.mall.front.entity.Carousel;
import com.ydual.mall.front.service.NewBeeMallCarouselService;

@Service
public class NewBeeMallCarouselServiceImpl implements NewBeeMallCarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public PageResult getCarouselPage(PageQueryUtil pageUtil) {
        List<Carousel> carousels = carouselMapper.findCarouselList(pageUtil);
        int total = carouselMapper.getTotalCarousels(pageUtil);
        PageResult pageResult = new PageResult(carousels, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public String saveCarousel(Carousel carousel) {
        if (carouselMapper.insertSelective(carousel) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String updateCarousel(Carousel carousel) {
        Carousel temp = carouselMapper.selectByPrimaryKey(carousel.getCarouselId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        temp.setCarouselRank(carousel.getCarouselRank());
        temp.setRedirectUrl(carousel.getRedirectUrl());
        temp.setCarouselUrl(carousel.getCarouselUrl());
        temp.setUpdateTime(new Date());
        if (carouselMapper.updateByPrimaryKeySelective(temp) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public Carousel getCarouselById(Integer id) {
        return carouselMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        if (ids.length < 1) {
            return false;
        }
        //删除数据
        return carouselMapper.deleteBatch(ids) > 0;
    }

    @Override
    public List<NewBeeMallIndexCarouselVO> getCarouselsForIndex(int number) {
        List<NewBeeMallIndexCarouselVO> newBeeMallIndexCarouselVOS = new ArrayList<>(number);
        List<Carousel> carousels = carouselMapper.findCarouselsByNum(number);
        if (!CollectionUtils.isEmpty(carousels)) {
            newBeeMallIndexCarouselVOS = MyBeanUtil.copyList(carousels, NewBeeMallIndexCarouselVO.class);
        }
        return newBeeMallIndexCarouselVOS;
    }
}
