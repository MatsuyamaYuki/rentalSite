package jp.ken.rentalSite;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.ken.rentalSite.model.StockModel;
import jp.ken.search.dao.SearchDAO;
import jp.ken.search.entity.Stock;


@Controller
@SessionAttributes("stockModel")
public class SearchController {
	@ModelAttribute
	public StockModel setUpStockModel() {
	return new StockModel();
}

	private static ApplicationContext context=new ClassPathXmlApplicationContext("search.xml");
	@SuppressWarnings("unchecked")
	private static SearchDAO<Stock> searchDAO=(SearchDAO<Stock>)context.getBean("searchDAO");

	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String toSearchList(Model model) {
		System.out.println("ここまで動いた");
		StockModel sModel=new StockModel();
		model.addAttribute("stockModel",sModel);
		return "searchList";
	}


	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String searchList(@Validated @ModelAttribute StockModel sModel,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "searchList";
		}else {
			System.out.println("動いた→" + sModel.getStockType());
			List<Stock> list=searchDAO.searchList(sModel.getStockName(),sModel.getStockType());
			model.addAttribute("title","検索結果");
			model.addAttribute("searchList",list);
			return "searchList";
		}
	}
}
