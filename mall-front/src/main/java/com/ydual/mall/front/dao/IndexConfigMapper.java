package com.ydual.mall.front.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ydual.mall.common.utils.PageQueryUtil;
import com.ydual.mall.front.entity.IndexConfig;

@Repository
public interface IndexConfigMapper {
    int deleteByPrimaryKey(Long configId);

    int insert(IndexConfig record);

    int insertSelective(IndexConfig record);

    IndexConfig selectByPrimaryKey(Long configId);

    int updateByPrimaryKeySelective(IndexConfig record);

    int updateByPrimaryKey(IndexConfig record);

    List<IndexConfig> findIndexConfigList(PageQueryUtil pageUtil);

    int getTotalIndexConfigs(PageQueryUtil pageUtil);

    int deleteBatch(Long[] ids);

    List<IndexConfig> findIndexConfigsByTypeAndNum(@Param("configType") int configType, @Param("number") int number);
}