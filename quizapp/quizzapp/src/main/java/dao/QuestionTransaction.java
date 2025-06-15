package dao;

import java.util.ArrayList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pojo.QuestionCreator;
import webservice.ServiceLayer;

@Component
public class QuestionTransaction {

	private String bioquestion = "select * from questionbankbiology order by random() limit 10";
	private String phyquestion = "select * from questionbankphy order by random() limit 10";
	private String chemquestion = "select * from questionbankchem order by random() limit 10";

	private String allBioQuestion = "select * from questionbankbiology";
	private String allChemQuestion = "select * from questionbankchem";
	private String allPhyQuestion = "select * from questionbankphy";

	private String getSingleQuestionOfBio = "select * from questionbankbiology where questionid=?";
	private String getSingleQuestionOfPhy = "select * from questionbankphy where questionid=?";
	private String getSingleQuestionOfChem = "select * from questionbankchem where questionid=?";

	private String deleteBioQuestion = "delete from questionbankbiology where questionid=?";
	private String deleteChemQuestion = "delete from questionbankchem where questionid=?";
	private String deletePhyQuestion = "delete from questionbankphy where questionid=?";

	private String updateBio = "UPDATE public.questionbankbiology\r\n"
			+ "	SET question=?, option1=?, option2=?, option3=?, option4=?\r\n" + "	WHERE  questionid=?";

	private String updateChem = "UPDATE public.questionbankchem\r\n"
			+ "	SET question=?, option1=?, option2=?, option3=?, option4=?\r\n" + "	WHERE  questionid=?";

	private String updatePhy = "UPDATE public.questionbankphy\r\n"
			+ "	SET question=?, option1=?, option2=?, option3=?, option4=?\r\n" + "	WHERE  questionid=?";

	private String insertIntoBio = "INSERT INTO public.questionbankbiology(\r\n"
			+ "	question, option1, option2, option3, option4, questionid)\r\n" + "	VALUES (?, ?, ?, ?, ?, ?)";

	private String insertIntoPhy = "INSERT INTO public.questionbankphy(\r\n"
			+ "	question, option1, option2, option3, option4, questionid)\r\n" + "	VALUES (?, ?, ?, ?, ?, ?)";

	private String insertIntoChem = "INSERT INTO public.questionbankchem(\r\n"
			+ "	question, option1, option2, option3, option4, questionid)\r\n" + "	VALUES (?, ?, ?, ?, ?, ?)";

	public ArrayList<QuestionCreator> bioQuestionProvider() {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		RowMapperForQuestionCreator testHistory = context.getBean(RowMapperForQuestionCreator.class);
		ArrayList<QuestionCreator> list = new ArrayList<QuestionCreator>();
		try {
			list = (ArrayList<QuestionCreator>) jdbcTemplate.query(bioquestion, testHistory);
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public ArrayList<QuestionCreator> phyQuestionProvider() {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		RowMapperForQuestionCreator testHistory = context.getBean(RowMapperForQuestionCreator.class);
		ArrayList<QuestionCreator> list = new ArrayList<QuestionCreator>();
		try {
			list = (ArrayList<QuestionCreator>) jdbcTemplate.query(phyquestion, testHistory);
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public ArrayList<QuestionCreator> chemQuestionProvider() {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		RowMapperForQuestionCreator testHistory = context.getBean(RowMapperForQuestionCreator.class);
		ArrayList<QuestionCreator> list = new ArrayList<QuestionCreator>();
		try {
			list = (ArrayList<QuestionCreator>) jdbcTemplate.query(chemquestion, testHistory);
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public ArrayList<QuestionCreator> getAllQuestionsBiology() {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		RowMapperForQuestionCreator testHistory = context.getBean(RowMapperForQuestionCreator.class);
		ArrayList<QuestionCreator> list = new ArrayList<QuestionCreator>();
		try {
			list = (ArrayList<QuestionCreator>) jdbcTemplate.query(allBioQuestion, testHistory);
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return list;

	}

	public ArrayList<QuestionCreator> getAllQuestionsOfChemistry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		RowMapperForQuestionCreator testHistory = context.getBean(RowMapperForQuestionCreator.class);
		ArrayList<QuestionCreator> list = new ArrayList<QuestionCreator>();
		try {
			list = (ArrayList<QuestionCreator>) jdbcTemplate.query(allChemQuestion, testHistory);
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public ArrayList<QuestionCreator> getAllQuestionsOfPhysics() {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		RowMapperForQuestionCreator testHistory = context.getBean(RowMapperForQuestionCreator.class);
		ArrayList<QuestionCreator> list = new ArrayList<QuestionCreator>();
		try {
			list = (ArrayList<QuestionCreator>) jdbcTemplate.query(allPhyQuestion, testHistory);
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public ErrorProvider deleteQuestionsOfPhysics(String id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		ErrorProvider provider = context.getBean(ErrorProvider.class);

		try {
			provider.setRow(jdbcTemplate.update(deletePhyQuestion, Integer.parseInt(id)));
		} catch (DataAccessException e) {
			provider.setError(e.getMessage());
		}
		return provider;

	}

	public ErrorProvider deleteQuestionsOfBiology(String id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		ErrorProvider provider = context.getBean(ErrorProvider.class);

		try {
			provider.setRow(jdbcTemplate.update(deleteBioQuestion, Integer.parseInt(id)));
		} catch (DataAccessException e) {
			provider.setError(e.getMessage());
			System.out.println(e.getMessage());
		}
		return provider;

	}

	public ErrorProvider deleteQuestionsOfChemistry(String id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		ErrorProvider provider = context.getBean(ErrorProvider.class);

		try {
			provider.setRow(jdbcTemplate.update(deleteChemQuestion, Integer.parseInt(id)));
		} catch (DataAccessException e) {
			provider.setError(e.getMessage());
		}
		return provider;

	}

	public ErrorProvider updateQuestionsOfBiology(QuestionCreator creator) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		ErrorProvider provider = context.getBean(ErrorProvider.class);
		try {
			provider.setRow(jdbcTemplate.update(updateBio, creator.getQuestion(), creator.getOption1(),
					creator.getOption2(), creator.getOption3(), creator.getOption4(), Integer.parseInt(creator.getQuestionUniqueId())));
		} catch (DataAccessException e) {
			provider.setError(e.getMessage());
			System.out.println(e.getMessage());
		}
		return provider;
	}

	public ErrorProvider updateQuestionsOfChemistry(QuestionCreator creator) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		ErrorProvider provider = context.getBean(ErrorProvider.class);
		try {
			provider.setRow(jdbcTemplate.update(updateChem, creator.getQuestion(), creator.getOption1(),
					creator.getOption2(), creator.getOption3(), creator.getOption4(),Integer.parseInt(creator.getQuestionUniqueId())));
		} catch (DataAccessException e) {
			provider.setError(e.getMessage());
			System.out.println(e.getMessage());
		}
		return provider;
	}

	public ErrorProvider updateQuestionsOfPhysics(QuestionCreator creator) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		ErrorProvider provider = context.getBean(ErrorProvider.class);
		try {
			provider.setRow(jdbcTemplate.update(updatePhy, creator.getQuestion(), creator.getOption1(),
					creator.getOption2(), creator.getOption3(), creator.getOption4(), Integer.parseInt(creator.getQuestionUniqueId())));
		} catch (DataAccessException e) {
			provider.setError(e.getMessage());
			System.out.println(e.getMessage());
		}
		return provider;
	}

	public ErrorProvider addQuestionsOfPhysics(QuestionCreator creator) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		ErrorProvider provider = context.getBean(ErrorProvider.class);
		try {
			provider.setRow(jdbcTemplate.update(insertIntoPhy, creator.getQuestion(), creator.getOption1(),
					creator.getOption2(), creator.getOption3(), creator.getOption4(),
					ServiceLayer.uniqueIdGenerator()));
		} catch (DataAccessException e) {
			provider.setError(e.getMessage());
			System.out.println(e.getMessage());
		}
		return provider;

	}

	public ErrorProvider addQuestionsOfChemistry(QuestionCreator creator) {

		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		ErrorProvider provider = context.getBean(ErrorProvider.class);
		try {
			provider.setRow(jdbcTemplate.update(insertIntoChem, creator.getQuestion(), creator.getOption1(),
					creator.getOption2(), creator.getOption3(), creator.getOption4(),
					ServiceLayer.uniqueIdGenerator()));
		} catch (DataAccessException e) {
			provider.setError(e.getMessage());
			System.out.println(e.getMessage());
		}
		return provider;
	}

	public ErrorProvider addQuestionsOfBiology(QuestionCreator creator) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		ErrorProvider provider = context.getBean(ErrorProvider.class);
		try {
			provider.setRow(jdbcTemplate.update(insertIntoBio, creator.getQuestion(), creator.getOption1(),
					creator.getOption2(), creator.getOption3(), creator.getOption4(),
					ServiceLayer.uniqueIdGenerator()));
		} catch (DataAccessException e) {
			provider.setError(e.getMessage());
			System.out.println(e.getMessage());
		}
		return provider;

	}

	public QuestionCreator getSingleQuestionOfBio(int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		RowMapperForQuestionCreator testHistory = context.getBean(RowMapperForQuestionCreator.class);
		QuestionCreator creator = context.getBean(QuestionCreator.class);

		try {
			creator = jdbcTemplate.queryForObject(getSingleQuestionOfBio, testHistory, id);
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return creator;

	}

	public QuestionCreator getSingleQuestionOfChem(int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		RowMapperForQuestionCreator testHistory = context.getBean(RowMapperForQuestionCreator.class);
		QuestionCreator creator = context.getBean(QuestionCreator.class);

		try {
			creator = jdbcTemplate.queryForObject(getSingleQuestionOfChem, testHistory, id);
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return creator;

	}

	public QuestionCreator getSingleQuestionOfPhy(int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		RowMapperForQuestionCreator testHistory = context.getBean(RowMapperForQuestionCreator.class);
		QuestionCreator creator = context.getBean(QuestionCreator.class);

		try {
			creator = jdbcTemplate.queryForObject(getSingleQuestionOfPhy, testHistory, id);
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return creator;

	}
}
