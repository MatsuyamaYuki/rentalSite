package jp.ken.rentalSite;

import java.util.List;

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

import jp.ken.rentalsyte.entity.Stock;
import jp.ken.rentalsyte.model.StockModel;
import jp.ken.rentalsyte.model.ErrorCheckGroup1;
import jp.ken.rentalSite.StockRegistController.GroupOrder;
import jp.ken.rentalsyte.dao.DAO;
import jp.ken.rentalsyte.entity.;


@Controller
@RequestMapping("regist")
public class StockRegistController {

	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	@SuppressWarnings("unchecked")
	private static StockDAO<Stock> stoDAO =(StockDAO<Stock>)context.getBean("stockDAO");

	private DepartmentsDAO<Departments> deptDAO=null;

	@GroupSequence({Default.class,ErrorCheckGroup1.class})
	interface GroupOrder{}

	@RequestMapping(method=RequestMethod.GET)
	public String toRegist(Model model) {
		StockModel sModel=new StockModel();
		model.addAttribute("stockModel",sModel);
		model.addAttribute("deptList",this.makeSelectDepartments());
		return "registStockData";
	}

	@RequestMapping(method=RequestMethod.POST, params="regist")
	public String regist(@Validated(GroupOrder.class)@ModelAttribute StockModel sModel,
			BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("errorMessage","エラーが発生しています");
			model.addAttribute("deptList",this.makeSelectDepartments());
			return "registEmployeesData";
		}else {
			Stock sto=new Stock();
			BeanUtils.copyProperties(sModel, sto);
			if(stoDAO.insertEmployeesData(sto)) {
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
	model.addAttribute("deptList",this.makeSelectDepartments());
	return "registStockData";
		}
    @SuppressWarnings("unchecked")
    private List<Departments>makeSelectDepartments(){
    	if(deptDAO==null) {
    		deptDAO=(DepartmentsDAO<Departments>)context.getBean("departmentsDAO");
    	}
    	return deptDAO.allList();
	}

}

}
