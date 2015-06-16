package com.fanglei.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.fanglei.web.domain.User;

public class UserDaoImpl {
	
	private NamedParameterJdbcTemplate jdbc;
	
	public void setDataSource(DataSource jdbc){
		this.jdbc= new NamedParameterJdbcTemplate(jdbc);
	}
	
	RowMapper<User> rowMapper=new RowMapper<User>(){
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setAge(rs.getInt("age"));
			user.setEmail(rs.getString("email"));
			return user;
		}
	};
	
	public List<User> getUsers(){
		return jdbc.getJdbcOperations().query("select * from Users", rowMapper);
	}
	
	public User getUserById(int id){
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource("id", id);
		
		return jdbc.queryForObject("select * from Users where id=:id", paramSource, rowMapper);
	}
	
	
	/*
	public boolean creatUser(){
		return true;
	}
	
	public boolean deleteUser(){
		return true;
	}
	
	public boolean updateUser(){
		return true;
	}
*/
}