package jp.ken.rentalSite;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.StockDAO;
import entity.Stock;

@Controller
public class StockListController {

	private static ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");

	@SuppressWarnings("unchecked")
	private static StockDAO<Stock> stoDAO=(StockDAO<Stock>)context.getBean("stockDAO");

	@RequestMapping(value="/stoList",method=RequestMethod.GET)
	public String stoList(Model model) {
		List<Stock>list=stoDAO.allList();
		model.addAttribute("message","在庫リスト");
		model.addAttribute("stoList",list);
		return "listStockData";
	}
}
