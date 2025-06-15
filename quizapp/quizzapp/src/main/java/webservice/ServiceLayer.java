package webservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import dao.LoginAndRegisterTransaction;
import pojo.Administrator;
import pojo.User;

@Component
public class ServiceLayer {

	public String validateUser(String email, String password) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/dao/daoConfig.xml");
		User profile = context.getBean(User.class);
		LoginAndRegisterTransaction transaction = context.getBean("loginAndRegisterTransaction",
				LoginAndRegisterTransaction.class);
		profile = transaction.getResourceForLoginValidation(email, " ");
		if (profile.getEmail() != null) {
			if (email.equals(profile.getEmail())) {
				if (password.equals(profile.getPassword())) {
					return "Authenticate";
				} else {
					return "Incorrect Password";
				}
			} else {
				return "Incorrect Email or you did not have an acccount ";
			}
		} else {
			return "Email is Not Registerd Or Incorrect Email";
		}

	}

	public static int uniqueIdGenerator() {
		double f = Math.random() / Math.nextDown(1.0);
		int x = (int) (10000 * (1.0 - f) + 90000 * f);
		return x;
	}

	public static String terminateMessage() {
		return "Terminate Test";
	}

	public String validateAdmin(String email, String password) {
		if (email.equals(Administrator.email)) {
			if (password.equals(Administrator.password)) {
				return "Authenticate";
			} else {
				return "Incorrect password";
			}
		} else {
			return "incorrect Email";
		}

	}

}
