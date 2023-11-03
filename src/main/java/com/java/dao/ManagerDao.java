package com.java.dao;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.java.beans.Bus;
import com.java.beans.Driver;
import com.java.beans.Manager;

import util.PasswordEncoder;

public class ManagerDao {

	
	PasswordEncoder passwordEncoder;
	private String  hashedPassword;
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template=template;
	}
	
	public int authenticateManager(Manager manager) throws NoSuchAlgorithmException, IOException {
		
		String email=manager.getManagerEmail();
	    hashedPassword=PasswordEncoder.encodePassword(manager.getManagerPassword());
		
		String sql="SELECT count(*) FROM  manager where managerEmail= '"+email+"' and managerPassword='"+hashedPassword+"' ";
		return template.queryForObject(sql,Integer.class);		
	}	
	
	public Manager getManager(Manager manager) throws NoSuchAlgorithmException, IOException {
		hashedPassword=PasswordEncoder.encodePassword(manager.getManagerPassword());
		
		String sql = "select * from manager where managerEmail='"+manager.getManagerEmail()+"' and managerPassword='"+hashedPassword+"' ";
		return template.queryForObject(sql, new RowMapper<Manager>() {
			public Manager mapRow(ResultSet rs, int row) throws SQLException {
				Manager m= new Manager();
		        m.setManagerId(rs.getInt(1));
		        m.setManagerName(rs.getString(2));
		        m.setEducationalBackground(rs.getString(3));
		        m.setManagerPhone(rs.getString(4));
		        m.setManagerEmail(rs.getString(5));
		        m.setManagerPassword(rs.getString(6));
				return m;
			}
		});
	}
	
	public int updateManager(Manager m) {
		String sql="update manager set  managerName='"+m.getManagerName()+"', managerEmail='"+m.getManagerEmail()+"' ,educationalBackground='"+m.getEducationalBackground()+"',managerPhone='"+m.getManagerPhone()+"' where managerId="+m.getManagerId()+" "; 
	    return  template.update(sql);
	}
	public int updateManagerPassword(Manager  m) throws NoSuchAlgorithmException, IOException {
		String password=PasswordEncoder.encodePassword(m.getNewPassword());
		String sql="update manager set managerPassword='"+password+"' where managerId="+m.getManagerId()+""; 
	    return  template.update(sql);
	}
	
	public Manager getManagerById() {
		String sql = "select * from manager";
		return template.queryForObject(sql, new RowMapper<Manager>() {
			public Manager mapRow(ResultSet rs, int row) throws SQLException {
				Manager m= new Manager();
				m.setManagerId(rs.getInt(1));
				m.setManagerName(rs.getString(2));
				m.setEducationalBackground(rs.getString(3));
				m.setManagerPhone(rs.getString(4));
				m.setManagerEmail(rs.getString(5));
				m.setManagerPassword(rs.getString(6));
				return m;
			}
		});
	}

}

