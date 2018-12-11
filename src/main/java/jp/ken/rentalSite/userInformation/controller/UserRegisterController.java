package jp.ken.rentalSite.userInformation.controller;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.ken.rentalSite.model.ErrorCheckGroup1;
import jp.ken.rentalSite.model.UserInformationModel;

@Controller
public class UserRegisterController {

	@GroupSequence({ Default.class,ErrorCheckGroup1.class })
	interface GroupOrder1 {}


	@RequestMapping(value="/AccountRegister", method=RequestMethod.GET)
	public String regit(Model model) {
		UserInformationModel uModel = new UserInformationModel();
		model.addAttribute("UserInformationModel",uModel);
		return "user_register";
	}

	@RequestMapping(value="/AccountRegister",method=RequestMethod.POST)
	public String confirm(@ModelAttribute UserInformationModel uModel,BindingResult result,Model model) {
		model.addAttribute("userMail",uModel.getUserMail());
		model.addAttribute("userPassword",uModel.getUserPassword());
		model.addAttribute("plan",uModel.getPlan());
		model.addAttribute("zip",uModel.getZip());
		model.addAttribute("userAddress",uModel.getUserAddress());
		model.addAttribute("userTel",uModel.getUserTel());
		model.addAttribute("userName",uModel.getUserName());
		model.addAttribute("userBirthDay",uModel.getUserBirthday());
		model.addAttribute("cardNumber",uModel.getCardNumber());
		model.addAttribute("gender",uModel.getGender());

		return "user_register";
	}

}