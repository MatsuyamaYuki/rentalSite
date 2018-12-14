package jp.ken.rentalsite;

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

import jp.ken.rentalsite.dao.StockDAO;
import jp.ken.rentalsite.entity.Stock;
import jp.ken.rentalsite.model.ErrorCheckGroup1;
import jp.ken.rentalsite.model.StockModel;

@Controller
@RequestMapping("regist")
public class StockRegistController {

	private static ApplicationContext context = new ClassPathXmlApplicationContext("stockSpring.xml");
	@SuppressWarnings("unchecked")
	private static StockDAO<Stock> stoDAO =(StockDAO<Stock>)context.getBean("stockDAO");

	@GroupSequence({Default.class,ErrorCheckGroup1.class})
	interface GroupOrder{}

	@RequestMapping(method=RequestMethod.GET)
	public String toRegist(Model model) {
		StockModel sModel=new StockModel();
		model.addAttribute("stockModel",sModel);
		return "registStockData";
	}

	@RequestMapping(method=RequestMethod.POST, params="regist")
	public String regist(@Validated(GroupOrder.class)@ModelAttribute StockModel sModel,
			BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("errorMessage","エラーが発生しています");
			return "registStockData";
		}else {
			Stock sto=new Stock();
			BeanUtils.copyProperties(sModel, sto);
			if(stoDAO.insertStockData(sto)) {
			return "resultStockData";
		}else {
			model.addAttribute("errorMessage","SQLエラーが発生しています");
			return "registStockData";
		}
	}
}

    @RequestMapping(method=RequestMethod.POST,params="reset")
    public String reset(Model model) {
	StockModel sModel = new StockModel();
	model.addAttribute("stockModel",sModel);
	return "registStockData";
	}
}



