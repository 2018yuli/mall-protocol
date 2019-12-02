package com.ydual.mall.customer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ydual.mall.common.pageutil.Page;
import com.ydual.mall.common.utils.format.DateFormatHelper;
import com.ydual.mall.common.utils.json.JsonHelper;
import com.ydual.mall.customer.service.ICustomerService;
import com.ydual.mall.customer.vo.CustomerModel;
import com.ydual.mall.customer.vo.CustomerQueryModel;
import com.ydual.mall.customer.vo.CustomerWebModel;

/**
 * @author l8989
 *
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private ICustomerService ics = null;

	/**
	 * 页面跳转 新增页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "toAdd", method = RequestMethod.GET)
	public String toAdd() {

		return "customer/add";
	}

	/**
	 * 新增
	 * 
	 * @param cm
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@ModelAttribute("cm") CustomerModel cm) {
		cm.setRegisterTime(DateFormatHelper.long2str(System.currentTimeMillis()));
		ics.create(cm);
		return "customer/success";
	}

	/**
	 * 页面跳转，更新
	 * 
	 * @param model
	 * @param customerUuid
	 * @return
	 */
	@RequestMapping(value = "toUpdate/{customerUuid}", method = RequestMethod.GET)
	public String toUpdate(Model model, @PathVariable("customerUuid") int customerUuid) {
		CustomerModel cm = ics.getByUuid(customerUuid);
		model.addAttribute("cm", cm);
		return "customer/update";
	}

	/**
	 * 更新
	 * 
	 * @param cm
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String post(@ModelAttribute("cm") CustomerModel cm) {
		ics.update(cm);
		return "customer/success";
	}

	/**
	 * 页面跳转，删除
	 * 
	 * @param model
	 * @param customerUuid
	 * @return
	 */
	@RequestMapping(value = "toDelete/{customerUuid}", method = RequestMethod.GET)
	public String toDelete(Model model, @PathVariable("customerUuid") int customerUuid) {
		CustomerModel cm = ics.getByUuid(customerUuid);
		model.addAttribute("cm", cm);
		return "customer/delete";
	}

	/**
	 * 删除
	 * 
	 * @param customerUuid
	 * @return
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String post(@RequestParam("uuid") int customerUuid) {
		ics.delete(customerUuid);
		return "customer/success";
	}

	/**
	 * 列表
	 * 
	 * @param wm
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "toList", method = RequestMethod.GET)
	public String toList(@ModelAttribute("wm") CustomerWebModel wm, Model model) {
		CustomerQueryModel cqm = null;
		if (wm.getQueryJsonStr() == null || wm.getQueryJsonStr().trim().length() == 0) {
			cqm = new CustomerQueryModel();
		} else {
			cqm = (CustomerQueryModel) JsonHelper.str2Object(wm.getQueryJsonStr(), CustomerQueryModel.class);
		}

		cqm.getPage().setNowPage(wm.getNowPage());
		if (wm.getPageShow() > 0) {
			cqm.getPage().setPageShow(wm.getPageShow());
		}

		Page<CustomerModel> dbPage = ics.getByConditionPage(cqm);

		//
		model.addAttribute("wm", wm);
		model.addAttribute("page", dbPage);

		return "customer/list";
	}

	/**
	 * 页面跳转，列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "toQuery", method = RequestMethod.GET)
	public String toQuery() {
		return "customer/query";
	}

}
