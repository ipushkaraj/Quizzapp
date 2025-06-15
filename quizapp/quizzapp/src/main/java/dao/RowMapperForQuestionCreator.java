package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pojo.QuestionCreator;

@Component
public class RowMapperForQuestionCreator implements RowMapper<QuestionCreator> {

	@Override
	public QuestionCreator mapRow(ResultSet rs, int rowNum) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("dao/daoConfig.xml");
		QuestionCreator creator=context.getBean(QuestionCreator.class);
		creator.setQuestion(rs.getString(1));
		creator.setOption1(rs.getString(2));
		creator.setOption2(rs.getString(3));
		creator.setOption3(rs.getString(4));
		creator.setOption4(rs.getString(5));
		creator.setQuestionUniqueId(rs.getString(6));
		return creator;
	}
		
}
