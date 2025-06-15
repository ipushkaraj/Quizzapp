package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pojo.TestHistory;
@Component
public class RowMapperForTestHistory implements RowMapper<TestHistory> {

	@Override
	public TestHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("/dao/daoConfig.xml");
		TestHistory history = context.getBean(TestHistory.class);
		history.setName(rs.getString(7));
		history.setScore(rs.getInt(4));
		history.setUserId(rs.getInt(1));
		history.setTestID(rs.getInt(2));
		history.setStatus(rs.getString(3));
		return history;
	}

}
