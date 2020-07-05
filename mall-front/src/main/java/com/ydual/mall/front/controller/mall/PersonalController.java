package com.ydual.mall.front.controller.mall;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ydual.mall.common.constants.Constants;
import com.ydual.mall.common.constants.ServiceResultEnum;
import com.ydual.mall.common.utils.MD5Util;
import com.ydual.mall.common.utils.Result;
import com.ydual.mall.common.utils.ResultGenerator;
import com.ydual.mall.customer.entity.MallUser;
import com.ydual.mall.customer.service.NewBeeMallUserService;
import com.ydual.mall.customer.vo.NewBeeMallUserVO;

@Controller
public class PersonalController {

    @Resource
    private NewBeeMallUserService newBeeMallUserService;

    @RequestMapping("/personal")
    public String personalPage(HttpServletRequest request,
                               HttpSession httpSession) {
        request.setAttribute("path", "personal");
        return "thymeleaf/mall/personal";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute(Constants.MALL_USER_SESSION_KEY);
        return "thymeleaf/mall/login";
    }

    @RequestMapping(value={"/login", "login.html"}, method = RequestMethod.GET)
    public String loginPage() {
        return "thymeleaf/mall/login";
    }

    @RequestMapping({"/register", "register.html"})
    public String registerPage() {
        return "thymeleaf/mall/register";
    }

    @RequestMapping("/personal/addresses")
    public String addressesPage() {
        return "thymeleaf/mall/addresses";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestParam("loginName") String loginName,
                        @RequestParam("verifyCode") String verifyCode,
                        @RequestParam("password") String password,
                        HttpSession httpSession) {
        if (StringUtils.isEmpty(loginName)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.LOGIN_NAME_NULL.getResult());
        }
        if (StringUtils.isEmpty(password)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.LOGIN_PASSWORD_NULL.getResult());
        }
        if (StringUtils.isEmpty(verifyCode)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.LOGIN_VERIFY_CODE_NULL.getResult());
        }
        String kaptchaCode = httpSession.getAttribute(Constants.MALL_VERIFY_CODE_KEY) + "";
        if (StringUtils.isEmpty(kaptchaCode) || !verifyCode.equals(kaptchaCode)) {
            // TODO 临时注释
        	// return ResultGenerator.genFailResult(ServiceResultEnum.LOGIN_VERIFY_CODE_ERROR.getResult());
        }
        //todo 清verifyCode
        String loginResult = newBeeMallUserService.login(loginName, MD5Util.MD5Encode(password, "UTF-8"), httpSession);
        //登录成功
        if (ServiceResultEnum.SUCCESS.getResult().equals(loginResult)) {
            return ResultGenerator.genSuccessResult();
        }
        //登录失败
        return ResultGenerator.genFailResult(loginResult);
    }

    @RequestMapping("/register")
    @ResponseBody
    public Result register(@RequestParam("loginName") String loginName,
                           @RequestParam("verifyCode") String verifyCode,
                           @RequestParam("password") String password,
                           HttpSession httpSession) {
        if (StringUtils.isEmpty(loginName)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.LOGIN_NAME_NULL.getResult());
        }
        if (StringUtils.isEmpty(password)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.LOGIN_PASSWORD_NULL.getResult());
        }
        if (StringUtils.isEmpty(verifyCode)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.LOGIN_VERIFY_CODE_NULL.getResult());
        }
        String kaptchaCode = httpSession.getAttribute(Constants.MALL_VERIFY_CODE_KEY) + "";
        if (StringUtils.isEmpty(kaptchaCode) || !verifyCode.equals(kaptchaCode)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.LOGIN_VERIFY_CODE_ERROR.getResult());
        }
        //todo 清verifyCode
        String registerResult = newBeeMallUserService.register(loginName, password);
        //注册成功
        if (ServiceResultEnum.SUCCESS.getResult().equals(registerResult)) {
            return ResultGenerator.genSuccessResult();
        }
        //注册失败
        return ResultGenerator.genFailResult(registerResult);
    }

    @RequestMapping("/personal/updateInfo")
    @ResponseBody
    public Result updateInfo(@RequestBody MallUser mallUser, HttpSession httpSession) {
        NewBeeMallUserVO mallUserTemp = newBeeMallUserService.updateUserInfo(mallUser,httpSession);
        if (mallUserTemp == null) {
            Result result = ResultGenerator.genFailResult("修改失败");
            return result;
        } else {
            //返回成功
            Result result = ResultGenerator.genSuccessResult();
            return result;
        }
    }
}
