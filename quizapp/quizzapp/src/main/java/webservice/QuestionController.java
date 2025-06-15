package webservice;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import dao.QuestionTransaction;
import pojo.QuestionCreator;
@RestController
public class QuestionController {
	static int count = 0;
		static int i=0;
		String answer[]=new String[10];
		
	@GetMapping("Mathstart")
	public ModelAndView startTest(ModelAndView andView, HttpSession session) {
		QuestionTransaction transaction=new QuestionTransaction();
		ArrayList<QuestionCreator> list = transaction.bioQuestionProvider();
		if(list.isEmpty()) {
			andView.setViewName("error");
			return andView;
		}else {
		session.setAttribute("list", list);
		QuestionCreator creator = list.get(count);
		if(QuestionController.count<10) {
		andView.addObject("list", creator);
		andView.setViewName("quizpage");
		return andView;
		}
		else {
			andView.setViewName("result");
			return  andView;
		}
	}
	}

	@GetMapping("Mathnext")
	public ModelAndView nextQuestion(ModelAndView andView, HttpSession session,@RequestParam("option1") String option1) {
		
		QuestionController.count++;
		
		answer[i]=option1;
		i++;
		if(QuestionController.count<10) {
		ArrayList<QuestionCreator> list=  (ArrayList<QuestionCreator>)session.getAttribute("list");
		andView.addObject("list", list.get(count));
		andView.setViewName("quizpage");
		return andView;
		}
		else
		{
			 int result=0;
			count=0;
			i=0;
			for(String s:answer) {
				if (s.charAt(s.length()-1)=='#') {
					result++;
				}
			}
			andView.addObject("answer",answer);
			andView.addObject("result",result);
			andView.setViewName("result");
			return andView;
		}
	}

	
	@GetMapping("Chemstart")
	public ModelAndView startChemTest(ModelAndView andView, HttpSession session) {
		QuestionTransaction transaction=new QuestionTransaction();
		ArrayList<QuestionCreator> list = transaction.chemQuestionProvider();
		if(list.isEmpty()) {
			andView.setViewName("error");
			return andView;
		}else {
		session.setAttribute("list", list);
		QuestionCreator creator = list.get(count);
		if(QuestionController.count<10) {
		andView.addObject("list", creator);
		andView.setViewName("quizpage");
		return andView;
		}
		else {
			andView.setViewName("result");
			return  andView;
		}
	}
	}

	
	
	@GetMapping("Phystart")
	public ModelAndView startPhyTest(ModelAndView andView, HttpSession session) {
		QuestionTransaction transaction=new QuestionTransaction();
		ArrayList<QuestionCreator> list = transaction.phyQuestionProvider();
		if(list.isEmpty()) {
			andView.setViewName("error");
			return andView;
		}else {
		session.setAttribute("list", list);
		QuestionCreator creator = list.get(count);
		if(QuestionController.count<10) {
		andView.addObject("list", creator);
		andView.setViewName("quizpage");
		return andView;
		}
		else {
			andView.setViewName("result");
			return  andView;
		}
	}
	}


	
}
