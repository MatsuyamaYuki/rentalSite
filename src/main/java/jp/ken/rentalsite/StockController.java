package jp.ken.rentalsite;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.ken.rentalsite.model.StockModel;

@Controller
public class StockController {

	@RequestMapping(value="/stock",method=RequestMethod.GET)
	public String stock(Model model) {
		StockModel sModel=new StockModel();
		model.addAttribute("stockModel",sModel);
		return "stock_main";
	}

	@RequestMapping(value="/stock",method=RequestMethod.POST)
	public String display(@ModelAttribute StockModel sModel,Model model) {

		return "stock_main";

	}

}
