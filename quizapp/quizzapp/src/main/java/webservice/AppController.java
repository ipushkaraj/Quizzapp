package webservice;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.RestController;

import dao.LoginAndRegisterTransaction;
import pojo.QuestionCreator;
import pojo.TestHistory;
import pojo.User;

@Controller
public class AppController {
	@RequestMapping("/login")
	public String loginController() {
		return "login";
	}
	
	
	@RequestMapping("/register" )
	public String signUpController() {
		return "registerUser";
	}
	
	@RequestMapping("/home" )
	public ModelAndView homeController( ModelAndView modelAndView) {
		modelAndView.addObject("user", LoginAndRegisterTransaction.user);
		modelAndView.setViewName("homepage");
		return modelAndView;
	}
	

	@RequestMapping("/editProfile" )
	public ModelAndView editProfile(ModelAndView andView) {
		andView.addObject("userToEdit",LoginAndRegisterTransaction.user);
		andView.setViewName("registerUser");
		return andView;
	}
	
	@RequestMapping("/logout" )
	public ModelAndView userLogout(ModelAndView andView,HttpSession session) {
		User.valueChanger();
		session.removeAttribute("subject");
		session.removeAttribute("id");
		session.removeAttribute("list");
		andView.setViewName("login");
		return andView;
	}
	
	@RequestMapping("/quizApp" )
	public ModelAndView quizApp(ModelAndView andView) {
		ArrayList<QuestionCreator> list=new ArrayList<QuestionCreator>();
		list.add(new QuestionCreator("What Is Your Name", "Sajjad", "Sasas", "Das", "Shah"));
		list.add(new QuestionCreator("What Is Your Name", "Sajjad", "Sasas", "Das", "Shah"));
		andView.addObject("list", list);
		andView.setViewName("quizpage");
		return andView;
	}
	
	
	@RequestMapping("testHistory")
	public ModelAndView testHistory(ModelAndView andView) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/dao/daoConfig.xml");
		LoginAndRegisterTransaction transaction = context.getBean(LoginAndRegisterTransaction.class);
		ArrayList<TestHistory> list=transaction.testHistory();
			andView.addObject("list", list);
			andView.setViewName("testHistory");
		return andView;
		
	}
	
	
	
	
	@RequestMapping("/deleteAccount" )
	public ModelAndView deleteAccount(ModelAndView andView) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/dao/daoConfig.xml");
		LoginAndRegisterTransaction transaction=context.getBean(LoginAndRegisterTransaction.class);
		transaction.deleteUserAccount();
		User.valueChanger();
		andView.setViewName("redirectToLogin");
		return andView;
	}
	
}
