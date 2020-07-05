package com.ydual.mall.admin.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
import com.ydual.mall.admin.entity.AdminUser;

@Repository
public interface AdminUserMapper {
    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    /**
     * 登陆方法
     *
     * @param userName
     * @param password
     * @return
     */
    /**
	 * 当执行login查询方法时，系统首先会从缓存中获取userId对应的实体
	 * 如果实体还没有被缓存，则执行查询方法并将查询结果放入缓存中
	 */
    @ReadThroughSingleCache(namespace = "admin", expiration = 3600)
    AdminUser login(@ParameterValueKeyProvider @Param("userName") String userName, @Param("password") String password);

    AdminUser selectByPrimaryKey(Integer adminUserId);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);
}