package com.ydual.mall.customer.service;

import javax.servlet.http.HttpSession;

import com.ydual.mall.common.utils.PageQueryUtil;
import com.ydual.mall.common.utils.PageResult;
import com.ydual.mall.customer.entity.MallUser;
import com.ydual.mall.customer.vo.NewBeeMallUserVO;

public interface NewBeeMallUserService {
    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getNewBeeMallUsersPage(PageQueryUtil pageUtil);
    
    /**
     * 根据用户loginName获得用户
     * 
     * @param userId
     * @return
     */
    MallUser getNewBeeMallUserByLoginName(String loginName);

    /**
     * 用户注册
     *
     * @param loginName
     * @param password
     * @return
     */
    String register(String loginName, String password);

    /**
     * 登录
     *
     * @param loginName
     * @param passwordMD5
     * @param httpSession
     * @return
     */
    String login(String loginName, String passwordMD5, HttpSession httpSession);

    /**
     * 用户信息修改并返回最新的用户信息
     *
     * @param mallUser
     * @return
     */
    NewBeeMallUserVO updateUserInfo(MallUser mallUser, HttpSession httpSession);

    /**
     * 用户禁用与解除禁用(0-未锁定 1-已锁定)
     *
     * @param ids
     * @param lockStatus
     * @return
     */
    Boolean lockUsers(Integer[] ids, int lockStatus);
}
