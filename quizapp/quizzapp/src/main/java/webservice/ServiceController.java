package webservice;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import dao.ErrorProvider;
import dao.LoginAndRegisterTransaction;
import pojo.TestHistory;
import pojo.User;

@Controller
public class ServiceController {

	@RequestMapping("/afterlogin")
	public ModelAndView afterLogin(@RequestParam("email") String name, @RequestParam("password") String password,
			ModelAndView model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/dao/daoConfig.xml");
		ServiceLayer layer = context.getBean(ServiceLayer.class);
		LoginAndRegisterTransaction transaction = context.getBean(LoginAndRegisterTransaction.class);
		User user = transaction.getResourceForLoginValidation(name," ");
		String result = layer.validateUser(name, password);
		System.out.println(result);
		if (result.equals("Authenticate")) {
			model.addObject("result", result);
			model.addObject("user", user);
			model.setViewName("homepage");
			return model;
		} else {
			model.addObject("result", result);
			model.setViewName("login");

			return model;
		}
	}

	@RequestMapping("afterregister")
	public ModelAndView afterRegister(@RequestParam("username") String username, @RequestParam("email") String email,
			@RequestParam("number") String number, @RequestParam("password") String password, ModelAndView model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/dao/daoConfig.xml");
		LoginAndRegisterTransaction transaction = context.getBean(LoginAndRegisterTransaction.class);

		User user = context.getBean(User.class);
		user.setName(username);
		user.setEmail(email);
		user.setPassword(password);
		user.setNumber(number);
		ErrorProvider errorProvider = transaction.addUserData(user);
		if (errorProvider.getRow() > 0) {
			model.setViewName("login");
		} else {
			model.addObject("errorProvider", errorProvider.getError());
			model.setViewName("registerUser");
		}
		return model;
	}

	@RequestMapping("updateUser")
	public ModelAndView updateUser(@RequestParam("username") String username, @RequestParam("email") String email,
			@RequestParam("number") String number, @RequestParam("password") String password, ModelAndView model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/dao/daoConfig.xml");
		LoginAndRegisterTransaction transaction = context.getBean(LoginAndRegisterTransaction.class);
		User user = context.getBean(User.class);
		user.setName(username);
		user.setEmail(email);
		user.setPassword(password);
		user.setNumber(number);
		user.setUniqueID(ServiceLayer.uniqueIdGenerator());
		ErrorProvider errorProvider = transaction.userUpdateTransaction(user);
		if (errorProvider.getRow() > 0) {
			LoginAndRegisterTransaction.user = transaction
					.getResourceForLoginValidation(" ",String.valueOf(LoginAndRegisterTransaction.user.getUniqueID()));
			model.setViewName("redirectToHome");
		} else {
			model.addObject("errorProvider", errorProvider.getError());
			model.setViewName("registerUser");
		}
		return model;
	}
	
	
	
}
