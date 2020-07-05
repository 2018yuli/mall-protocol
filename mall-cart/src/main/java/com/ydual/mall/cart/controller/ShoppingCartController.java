package com.ydual.mall.cart.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ydual.mall.cart.controller.vo.NewBeeMallShoppingCartItemVO;
import com.ydual.mall.cart.entity.NewBeeMallShoppingCartItem;
import com.ydual.mall.cart.service.NewBeeMallShoppingCartService;
import com.ydual.mall.common.constants.Constants;
import com.ydual.mall.common.constants.ServiceResultEnum;
import com.ydual.mall.common.utils.Result;
import com.ydual.mall.common.utils.ResultGenerator;
import com.ydual.mall.customer.vo.NewBeeMallUserVO;

@Controller
public class ShoppingCartController {

    @Resource
    private NewBeeMallShoppingCartService newBeeMallShoppingCartService;

    @RequestMapping(value="/shop-cart", method=RequestMethod.GET)
    public String cartListPage(HttpServletRequest request,
                               HttpSession httpSession) {
        NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        int itemsTotal = 0;
        int priceTotal = 0;
        List<NewBeeMallShoppingCartItemVO> myShoppingCartItems = newBeeMallShoppingCartService.getMyShoppingCartItems(user.getUserId());
        if (!CollectionUtils.isEmpty(myShoppingCartItems)) {
            //订单项总数
            itemsTotal = myShoppingCartItems.stream().mapToInt(NewBeeMallShoppingCartItemVO::getGoodsCount).sum();
            if (itemsTotal < 1) {
                return "thymeleaf/error/error_5xx";
            }
            //总价
            for (NewBeeMallShoppingCartItemVO newBeeMallShoppingCartItemVO : myShoppingCartItems) {
                priceTotal += newBeeMallShoppingCartItemVO.getGoodsCount() * newBeeMallShoppingCartItemVO.getSellingPrice();
            }
            if (priceTotal < 1) {
                return "thymeleaf/error/error_5xx";
            }
        }
        request.setAttribute("itemsTotal", itemsTotal);
        request.setAttribute("priceTotal", priceTotal);
        request.setAttribute("myShoppingCartItems", myShoppingCartItems);
        return "thymeleaf/mall/cart";
    }

    @RequestMapping(value="/shop-cart",method=RequestMethod.POST)
    @ResponseBody
    public Result saveNewBeeMallShoppingCartItem(@RequestBody NewBeeMallShoppingCartItem newBeeMallShoppingCartItem,
                                                 HttpSession httpSession) {
        NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        newBeeMallShoppingCartItem.setUserId(user.getUserId());
        //todo 判断数量
        String saveResult = newBeeMallShoppingCartService.saveNewBeeMallCartItem(newBeeMallShoppingCartItem);
        //添加成功
        if (ServiceResultEnum.SUCCESS.getResult().equals(saveResult)) {
            return ResultGenerator.genSuccessResult();
        }
        //添加失败
        return ResultGenerator.genFailResult(saveResult);
    }

    @RequestMapping(value="/shop-cart",method=RequestMethod.PUT)
    @ResponseBody
    public Result updateNewBeeMallShoppingCartItem(@RequestBody NewBeeMallShoppingCartItem newBeeMallShoppingCartItem,
                                                   HttpSession httpSession) {
        NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        newBeeMallShoppingCartItem.setUserId(user.getUserId());
        //todo 判断数量
        String saveResult = newBeeMallShoppingCartService.updateNewBeeMallCartItem(newBeeMallShoppingCartItem);
        //修改成功
        if (ServiceResultEnum.SUCCESS.getResult().equals(saveResult)) {
            return ResultGenerator.genSuccessResult();
        }
        //修改失败
        return ResultGenerator.genFailResult(saveResult);
    }

    @RequestMapping("/shop-cart/{newBeeMallShoppingCartItemId}")
    @ResponseBody
    public Result updateNewBeeMallShoppingCartItem(@PathVariable("newBeeMallShoppingCartItemId") Long newBeeMallShoppingCartItemId,
                                                   HttpSession httpSession) {
        NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        Boolean deleteResult = newBeeMallShoppingCartService.deleteById(newBeeMallShoppingCartItemId);
        //删除成功
        if (deleteResult) {
            return ResultGenerator.genSuccessResult();
        }
        //删除失败
        return ResultGenerator.genFailResult(ServiceResultEnum.OPERATE_ERROR.getResult());
    }

    @RequestMapping("/shop-cart/settle")
    public String settlePage(HttpServletRequest request,
                             HttpSession httpSession) {
        int priceTotal = 0;
        NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        List<NewBeeMallShoppingCartItemVO> myShoppingCartItems = newBeeMallShoppingCartService.getMyShoppingCartItems(user.getUserId());
        if (CollectionUtils.isEmpty(myShoppingCartItems)) {
            //无数据则不跳转至结算页
            return "/shop-cart";
        } else {
            //总价
            for (NewBeeMallShoppingCartItemVO newBeeMallShoppingCartItemVO : myShoppingCartItems) {
                priceTotal += newBeeMallShoppingCartItemVO.getGoodsCount() * newBeeMallShoppingCartItemVO.getSellingPrice();
            }
            if (priceTotal < 1) {
                return "error/error_5xx";
            }
        }
        request.setAttribute("priceTotal", priceTotal);
        request.setAttribute("myShoppingCartItems", myShoppingCartItems);
        return "thymeleaf/mall/order-settle";
    }
}
