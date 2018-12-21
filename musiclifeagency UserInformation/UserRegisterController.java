package jp.ken.musiclifeagency.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.ken.musiclifeagency.model.ErrorCheckGroup1;
import jp.ken.musiclifeagency.model.ListDataModel;
import jp.ken.musiclifeagency.model.PlanListModel;
import jp.ken.musiclifeagency.model.UserInformationModel;

@Controller
public class UserRegisterController {

	@GroupSequence({ Default.class,ErrorCheckGroup1.class })
	interface GroupOrder1 {}

	private List<ListDataModel> getYearList(){
		List<ListDataModel> yearList = new ArrayList<ListDataModel>();
		Calendar cal = Calendar.getInstance();
		for(int i = 1900; i <=cal.get(Calendar.YEAR);i++) {
			yearList.add(new ListDataModel(Integer.toString(i), Integer.toString(i)));
		}
		return yearList;
	}

	private List<ListDataModel> getMonthList(){
		List<ListDataModel> monthList = new ArrayList<ListDataModel>();
			for (int i = 1; i <=12;i++) {
				monthList.add(new ListDataModel(Integer.toString(i),Integer.toString(i)));
			}
			return monthList;
	}

	private List<ListDataModel> getDayList(){
		List<ListDataModel> dayList = new ArrayList<ListDataModel>();
			for (int i = 1;i <= 31;i++) {
				dayList.add(new ListDataModel(Integer.toString(i),Integer.toString(i)));
			}
		return dayList;
	}

	private List<PlanListModel> getPlanList(){
		List<PlanListModel> planLists = new ArrayList<PlanListModel>();

//		planLists.add(new PlanListModel("プラン名","月額料金", "上限レンタル枚数", "備考"));
		planLists.add(new PlanListModel("お試し","315","2","新規登録月の月末限定"));
		planLists.add(new PlanListModel("Bronze","1050","6",""));
		planLists.add(new PlanListModel("Silver","2100","12",""));
		planLists.add(new PlanListModel("Gold","5250","9999",""));
		return planLists;
	}


	@RequestMapping(value="/AccountRegister", method=RequestMethod.GET)
	public String regit(Model model) {
		UserInformationModel uModel = new UserInformationModel();
		model.addAttribute("UserInformationModel",uModel);
		model.addAttribute("year",getYearList());
		model.addAttribute("month",getMonthList());
		model.addAttribute("day",getDayList());
		model.addAttribute("planLists",getPlanList());
		return "userRegister";
	}

	@RequestMapping(value="/AccountRegister",method=RequestMethod.POST)
	public String confirm(@ModelAttribute UserInformationModel uModel,BindingResult result,Model model) {
		model.addAttribute("UserInformationModel", uModel);
		model.addAttribute("userMail",uModel.getUserMail());
		model.addAttribute("userPassword",uModel.getUserPassword());
		model.addAttribute("plan",uModel.getPlan());
		model.addAttribute("zip",uModel.getZip());
		model.addAttribute("userAddress",uModel.getUserAddress());
		model.addAttribute("userTel",uModel.getUserTel());
		model.addAttribute("userName",uModel.getUserName());
		model.addAttribute("userBirthDay",uModel.getUserBirthday());
		model.addAttribute("year",uModel.getYear());
		model.addAttribute("month",uModel.getMonth());
		model.addAttribute("day",uModel.getDay());
		model.addAttribute("cardName", uModel.getCardName());
		model.addAttribute("cardNumber",uModel.getCardNumber());
		model.addAttribute("cardYear",uModel.getCardYear());
		model.addAttribute("cardMonth",uModel.getCardMonth());
		model.addAttribute("gender",uModel.getGender());

		return "userRegisterConfirm";
	}

	@RequestMapping(value="/registerAccount", method=RequestMethod.POST)
	public String connectToDB(@ModelAttribute UserInformationModel uModel,Model model) {
		Connection con = null;
		Statement st = null;
		String sql = "";

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			st = con.createStatement();
			sql += "INSERT INTO rentsite_database.userinformation";
			sql += "VALUES('";
			sql += uModel.getUserMail() +"',";
			sql += "'" + uModel.getUserPassword() + "',";
			sql += "'" + uModel.getGender() + "',";
			sql += "'" + uModel.getPlan() + "',";
			sql += "'" + uModel.getZip() + "',";
			sql += "'" + uModel.getUserAddress() + "',";
			sql += "'" + uModel.getUserTel() + "',";
			sql += "'" + uModel.getUserName() + "',";
			sql += "'" + uModel.getYear() + "-" + uModel.getMonth() + "-" + uModel.getDay() + "',";
			sql += "'" + uModel.getCardName() + "',";
			sql += "'" + uModel.getCardNumber() + "',";
			sql += "'" + uModel.getCardMonth() + "',";
			sql += "'" + uModel.getCardYear() + "'";

			st.executeUpdate(sql);
			return "accountRegisterSuccess";

		}catch(Exception e) {
			e.printStackTrace();
			return "accountRegisterError";
		}finally {
			try {
				st.close();
				con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}