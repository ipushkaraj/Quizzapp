package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import pojo.User;
@Component
public class ImplOfUserRM implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user=new User();
			user.setName(rs.getString(1));
			user.setNumber(rs.getString(2));
			user.setEmail(rs.getString(4));
			user.setPassword(rs.getString(3));
			user.setUniqueID((Integer.parseInt(rs.getString(5))));
		return user;
	}
}
