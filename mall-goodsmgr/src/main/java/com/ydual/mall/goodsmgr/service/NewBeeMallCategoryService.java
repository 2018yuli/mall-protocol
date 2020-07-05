package com.ydual.mall.goodsmgr.service;

import java.util.List;

import com.ydual.mall.common.utils.PageQueryUtil;
import com.ydual.mall.common.utils.PageResult;
import com.ydual.mall.goodsmgr.controller.vo.NewBeeMallIndexCategoryVO;
import com.ydual.mall.goodsmgr.controller.vo.SearchPageCategoryVO;
import com.ydual.mall.goodsmgr.entity.GoodsCategory;

public interface NewBeeMallCategoryService {
    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getCategorisPage(PageQueryUtil pageUtil);

    String saveCategory(GoodsCategory goodsCategory);

    String updateGoodsCategory(GoodsCategory goodsCategory);

    GoodsCategory getGoodsCategoryById(Long id);

    Boolean deleteBatch(Integer[] ids);

    /**
     * 返回分类数据(首页调用)
     *
     * @return
     */
    List<NewBeeMallIndexCategoryVO> getCategoriesForIndex();

    /**
     * 返回分类数据(搜索页调用)
     *
     * @param categoryId
     * @return
     */
    SearchPageCategoryVO getCategoriesForSearch(Long categoryId);

    /**
     * 根据parentId和level获取分类列表
     *
     * @param parentIds
     * @param categoryLevel
     * @return
     */
    List<GoodsCategory> selectByLevelAndParentIdsAndNumber(List<Long> parentIds, int categoryLevel);
}
