package jp.ken.rentalsite;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.ken.rentalsite.dao.StockDAO;
import jp.ken.rentalsite.entity.Stock;
import jp.ken.rentalsite.model.StockModel;

@Controller
@RequestMapping("change")
public class StockChangeController {
	private static ApplicationContext context=new ClassPathXmlApplicationContext("stockSpring.xml");

	@SuppressWarnings("unchecked")
	private static StockDAO<Stock> stoDAO=(StockDAO<Stock>)context.getBean("stockDAO");

	@RequestMapping(method=RequestMethod.GET)
	public String changeList(Model model) {
	    StockModel sModel=new StockModel();
	    model.addAttribute("stockModel",sModel);
		List<Stock>list=stoDAO.allList();
		model.addAttribute("changeStockList",list);
		return "changeStockData";
	}
}
