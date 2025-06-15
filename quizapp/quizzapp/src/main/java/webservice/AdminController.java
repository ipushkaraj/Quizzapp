package webservice;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.ErrorProvider;
import dao.QuestionTransaction;
import pojo.QuestionCreator;

@Controller
public class AdminController {
	@RequestMapping("/afteradminlogin")
	public ModelAndView adminHome(ModelAndView modelAndView, @RequestParam("email") String email,
			@RequestParam("password") String pass) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/dao/daoConfig.xml");
		ServiceLayer layer = context.getBean(ServiceLayer.class);
		String Authenticator = layer.validateAdmin(email, pass);
		if (Authenticator.equals("Authenticate")) {
			modelAndView.setViewName("questionCreator");
			return modelAndView;
		} else {
			modelAndView.addObject("authenticator", Authenticator);
			modelAndView.setViewName("adminLogin");
			return modelAndView;
		}
	}

	@RequestMapping("/adminlogin")
	public ModelAndView admin(ModelAndView modelAndView) {
		modelAndView.setViewName("adminLogin");
		return modelAndView;
	}

	@RequestMapping("/dummy")
	public ModelAndView dummy(ModelAndView modelAndView, @RequestParam("subject") String subject, HttpSession session) {

		session.setAttribute("subject", subject);
		modelAndView.setViewName("redirectToAdminHome");
		return modelAndView;
	}

	@RequestMapping("/adminHome")
	public ModelAndView adminHome(ModelAndView modelAndView) {
		modelAndView.setViewName("questionCreator");
		return modelAndView;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(ModelAndView modelAndView, @RequestParam("getquestionid") String question,
			HttpSession session) {
		int id = Integer.parseInt(question);
		session.setAttribute("id", question);
		String subject = (String) session.getAttribute("subject");
		ApplicationContext context = new ClassPathXmlApplicationContext("/dao/daoConfig.xml");
		QuestionTransaction transaction = context.getBean(QuestionTransaction.class);
		System.out.println(subject);
		if (subject.equals("Biology")) {
			QuestionCreator creator = transaction.getSingleQuestionOfBio(id);
			modelAndView.addObject("creator", creator);
			modelAndView.setViewName("edit");
			return modelAndView;
		} else if (subject.equals("Chemistry")) {
			QuestionCreator creator = transaction.getSingleQuestionOfChem(id);
			modelAndView.addObject("creator", creator);
			modelAndView.setViewName("edit");
			return modelAndView;
		} else if (subject.equals("Physics")) {
			QuestionCreator creator = transaction.getSingleQuestionOfPhy(id);
			modelAndView.addObject("creator", creator);
			modelAndView.setViewName("edit");
			return modelAndView;
		} else {
			modelAndView.setViewName("questionCreator");
			return modelAndView;
		}

	}

	@RequestMapping("/subjectselector")
	public ModelAndView subjectSelector(ModelAndView modelAndView) {
		modelAndView.setViewName("adminHome");
		return modelAndView;
	}

	@RequestMapping("/Delete")
	public ModelAndView deleteRecord(ModelAndView modelAndView, HttpSession session,
			@RequestParam("questionUniqueId") String id) {
		String subject = (String) session.getAttribute("subject");
		ApplicationContext context = new ClassPathXmlApplicationContext("/dao/daoConfig.xml");
		QuestionTransaction transaction = context.getBean(QuestionTransaction.class);
		
		if (subject.equals("Biology")) {
			transaction.deleteQuestionsOfBiology(id);
		} else if (subject.equals("Chemistry")) {
			transaction.deleteQuestionsOfChemistry(id);
		} else if (subject.equals("Physics")) {
			transaction.deleteQuestionsOfPhysics(id);
		}
		modelAndView.setViewName("redirectToAdminHome");
		return modelAndView;
	}

	@RequestMapping("/getquestions")
	public ModelAndView getAllQuestions(ModelAndView modelAndView, HttpSession session) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/dao/daoConfig.xml");
		QuestionTransaction transaction = context.getBean(QuestionTransaction.class);
		String subject = (String) session.getAttribute("subject");
		if (subject.equals("Biology")) {
			ArrayList<QuestionCreator> list = transaction.getAllQuestionsBiology();
			modelAndView.addObject("list", list);
			modelAndView.setViewName("questionlist");

			return modelAndView;
		} else if (subject.equals("Chemistry")) {
			ArrayList<QuestionCreator> list = transaction.getAllQuestionsOfChemistry();
			modelAndView.addObject("list", list);
			modelAndView.setViewName("questionlist");
			return modelAndView;
		} else if (subject.equals("Physics")) {
			ArrayList<QuestionCreator> list = transaction.getAllQuestionsOfPhysics();
			modelAndView.addObject("list", list);
			modelAndView.setViewName("questionlist");
			return modelAndView;
		} else {
			modelAndView.setViewName("error");
			return modelAndView;
		}
	}

	@RequestMapping("/editprocess")
	public ModelAndView editRecord(ModelAndView modelAndView, HttpSession session, @RequestParam("Question") String question,
			@RequestParam("option1") String option1, @RequestParam("option2") String option2,
			@RequestParam("option3") String option3, @RequestParam("option4") String option4) {
		
		String subject = (String) session.getAttribute("subject");
		ApplicationContext context = new ClassPathXmlApplicationContext("/dao/daoConfig.xml");
		QuestionTransaction transaction = context.getBean(QuestionTransaction.class);
		QuestionCreator creator = context.getBean(QuestionCreator.class);
		creator.setQuestion(question);
		creator.setOption1(option1);
		creator.setOption2(option2);
		creator.setOption3(option3);
		creator.setOption4(option4);
		creator.setQuestionUniqueId(((String)session.getAttribute("id")));
		System.out.println(subject);
		if (!subject.isBlank()) {
			if (subject.equals("Biology")) {
				transaction.updateQuestionsOfBiology(creator);
				modelAndView.setViewName("redirectToAdminHome");
				return modelAndView;
			} else if (subject.equals("Chemistry")) {
				transaction.updateQuestionsOfChemistry(creator);
				modelAndView.setViewName("redirectToAdminHome");
				return modelAndView;
			} else if (subject.equals("Physics")) {
				transaction.updateQuestionsOfPhysics(creator);
				modelAndView.setViewName("redirectToAdminHome");
				return modelAndView;
			} else {
				modelAndView.setViewName("error");
				return modelAndView;
			}
		} else {
			modelAndView.setViewName("error");
			return modelAndView;
		}

	}

	@RequestMapping("/savequestion")
	public ModelAndView saveQuestion(ModelAndView modelAndView, @RequestParam("subject") String subject,
			@RequestParam("Question") String question, @RequestParam("option1") String option1,
			@RequestParam("option2") String option2, @RequestParam("option3") String option3,
			@RequestParam("option4") String option4) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/dao/daoConfig.xml");
		QuestionTransaction transaction = context.getBean(QuestionTransaction.class);
		QuestionCreator creator = context.getBean(QuestionCreator.class);
		creator.setQuestion(question);
		creator.setOption1(option1);
		creator.setOption2(option2);
		creator.setOption3(option3);
		creator.setOption4(option4);
		if (!subject.isBlank()) {
			if (subject.equals("Biology")) {
				ErrorProvider provider = transaction.addQuestionsOfBiology(creator);
				modelAndView.addObject("provider", provider);
				modelAndView.setViewName("questionCreator");
				return modelAndView;
			} else if (subject.equals("Chemistry")) {
				ErrorProvider provider = transaction.addQuestionsOfChemistry(creator);
				modelAndView.addObject("provider", provider);
				modelAndView.setViewName("questionCreator");
				return modelAndView;
			} else if (subject.equals("Physics")) {
				ErrorProvider provider = transaction.addQuestionsOfPhysics(creator);
				modelAndView.setViewName("questionCreator");
				modelAndView.addObject("provider", provider);
				return modelAndView;
			} else {
				modelAndView.setViewName("error");
				return modelAndView;
			}
		} else {
			modelAndView.setViewName("error");
			return modelAndView;
		}

	}

}
