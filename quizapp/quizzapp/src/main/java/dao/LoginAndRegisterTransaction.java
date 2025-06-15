package dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
import pojo.TestHistory;
import pojo.User;
import webservice.AppController;
import webservice.ServiceLayer;

@Component
public class LoginAndRegisterTransaction {
	private String getResourceForLoginValidationCommand = "select * from quizzapp where useremail=? or uniqueid=?";
	private String addUserDetails = "insert into quizzapp(username,useremail,usernumber,userpassword,uniqueId) values(?,?,?,?,?)";
	private String userUpdateQuery = "UPDATE quizzapp SET username=?,usernumber=?,userpassword=?,useremail=? WHERE  uniqueid=?";
	private String deleteQuery = "delete from quizzapp where uniqueId=?";
	private String testHistoryQuery ="select * from previoustesthistory where userid=?";
	
	public static User user = new User();

	public User getResourceForLoginValidation(String email, String uni) {

		ApplicationContext context = new ClassPathXmlApplicationContext("/dao/daoConfig.xml");
		ImplOfUserRM ofUserRM = context.getBean(ImplOfUserRM.class);
		// static User user=context.getBean("user",User.class);
		JdbcTemplate template = (JdbcTemplate) context.getBean("jdbcTemplate");
		try {

			user = template.queryForObject(getResourceForLoginValidationCommand, ofUserRM, email, uni);

		} catch (DataAccessException e) {

		}
		return user;
	}

	public ErrorProvider addUserData(User profile) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate template = (JdbcTemplate) context.getBean("jdbcTemplate");
		ErrorProvider provider = context.getBean(ErrorProvider.class);

		try {
			provider.setRow(template.update(addUserDetails, profile.getName(), profile.getEmail(),
					Long.parseLong(profile.getNumber()), profile.getPassword(),ServiceLayer.uniqueIdGenerator()));
		} catch (DataAccessException e) {
			provider.setError(e.getMessage());

		}
		return provider;
	}

	public ErrorProvider userUpdateTransaction(User profile) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate template = (JdbcTemplate) context.getBean("jdbcTemplate");
		LoginAndRegisterTransaction transaction = context.getBean(LoginAndRegisterTransaction.class);
		ErrorProvider provider = context.getBean(ErrorProvider.class);
	
		try {

			provider.setRow(template.update(userUpdateQuery, profile.getName(), Long.parseLong(profile.getNumber()),
					profile.getPassword(), profile.getEmail(),
					String.valueOf(LoginAndRegisterTransaction.user.getUniqueID())));
			if (provider.getRow() > 0) {
				LoginAndRegisterTransaction.user = transaction.getResourceForLoginValidation(" ",
						String.valueOf(LoginAndRegisterTransaction.user.getUniqueID()));
			}
		} catch (DataAccessException e) {
			provider.setError(e.getMessage());

		}
		return provider;
	}

	public ErrorProvider deleteUserAccount() {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		ErrorProvider errorProvider = context.getBean(ErrorProvider.class);
		try {
			errorProvider.setRow(
					jdbcTemplate.update(deleteQuery, String.valueOf(LoginAndRegisterTransaction.user.getUniqueID())));
			
		} catch (DataAccessException e) {
			errorProvider.setError(e.getMessage());
		}
		return errorProvider;

	}

	public ArrayList<TestHistory> testHistory() {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		RowMapperForTestHistory testHistory = context.getBean(RowMapperForTestHistory.class);
		ArrayList<TestHistory> list = new ArrayList<TestHistory>();
		try {
			list = (ArrayList<TestHistory>) jdbcTemplate.query(testHistoryQuery, testHistory,
					LoginAndRegisterTransaction.user.getUniqueID());
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
}
