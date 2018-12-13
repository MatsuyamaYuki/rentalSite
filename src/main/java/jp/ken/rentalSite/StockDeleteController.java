package jp.ken.rentalSite;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.StockDAO;
import jp.ken.rentalSite.entity.Stock;

@Controller
@RequestMapping("delete")
public class StockDeleteController {

	private static ApplicationContext context=new ClassPathXmlApplicationContext("stockSpring.xml");

	@SuppressWarnings("unchecked")
	private static StockDAO<Stock> stoDAO=(StockDAO<Stock>)context.getBean("stockDAO");

	@RequestMapping(method=RequestMethod.GET)
	public String toDelete(@RequestParam int paramId,Model model) {
		Stock sto=stoDAO.getById(paramId);
		model.addAttribute("deleteStockData",sto);
		return "deleteStockData";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String delete(@RequestParam int stock_id,Model model) {
		if(stoDAO.deleteStockData(stock_id)==1) {
			return "redirect:/change";
		}else {
			model.addAttribute("errorMessage","SQLエラーが発生しています");
			return "deleteStockData";
		}
		}
	}
