package jp.ken.rentalSite;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.StockDAO;
import jp.ken.rentalSite.entity.Stock;
import jp.ken.rentalSite.model.ErrorCheckGroup1;
import jp.ken.rentalSite.model.StockModel;

@Controller
@RequestMapping("edit")
public class StockEditController {

	private static ApplicationContext context=new ClassPathXmlApplicationContext("stockSpring.xml");

	@SuppressWarnings("unchecked")
	private static StockDAO<Stock> stoDAO=(StockDAO<Stock>)context.getBean("stockDAO");

	@GroupSequence({Default.class,ErrorCheckGroup1.class})
	interface GroupOrder{}

	@RequestMapping(method=RequestMethod.GET)
	public String toEdit(@RequestParam int paramId,Model model) {
		Stock sto=stoDAO.getById(paramId);
		StockModel sModel=new StockModel();
		BeanUtils.copyProperties(sto,sModel);
		sModel.setStock_id(new Integer(paramId).toString());
		model.addAttribute("stockModel",sModel);
		return "editStockData";
	}
	@RequestMapping(method=RequestMethod.POST, params="edit")
	public String edit(@RequestParam int stock_id,@Validated(GroupOrder.class)@ModelAttribute StockModel sModel,
			BindingResult result,Model model) {
		if(result.hasErrors()) {
			sModel.setStock_id(new Integer(stock_id).toString());
			model.addAttribute("stockModel",sModel);
			return "editEmployeesData";
		}else {
			Stock sto=new Stock();
			BeanUtils.copyProperties(sModel, sto);
			if(stoDAO.updateEmployeesData(sto)==1) {
			return "redirect:/change";
		}else {
			model.addAttribute("errorMessage","SQLエラーが発生しています");
			return "editStockData";
		}
		}
	}
	@RequestMapping(method=RequestMethod.POST,params="reset")
	public String reset(@RequestParam int stock_Id,Model model) {
		Stock sto=stoDAO.getById(stock_Id);
		StockModel sModel=new StockModel();
		BeanUtils.copyProperties(sto,sModel);
		sModel.setStock_id(new Integer(stock_Id).toString());
		model.addAttribute("stockModel",sModel);
		return "editStockData";
	}
  }

