package jp.ken.rentalsite;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("menu")
public class StockMenuController {

	@RequestMapping(method=RequestMethod.GET)
		public String menu() {
			return "stock_main";
		}
	}
