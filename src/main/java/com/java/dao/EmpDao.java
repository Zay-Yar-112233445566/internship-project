package com.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.java.beans.Emp;

public class EmpDao {

	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template=template;
	}
	
	public int save(Emp p) {
		String sql="insert into employee (name,salary,address) values('"+p.getName()+"',"+p.getSalary()+",'"+p.getAddress()+"') ";
		return template.update(sql);
	}
	@SuppressWarnings("deprecation")
	public Emp getEmpById(int id) {
		String sql="select * from employee where id=?";
		return template.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));
	}
	
	public List<Emp> getEmployees(){
		return template.query("select * from employee", new RowMapper<Emp>() {
			public Emp mapRow(ResultSet rs,int row) throws SQLException{
				Emp e=new Emp();
				
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getFloat(3));
				e.setAddress(rs.getString(4));
				
				return e;
			}
		});
	}
	
	
	public int update(Emp p) {
		String sql="update employee set name='"+p.getName()+"', salary="+p.getSalary()+",address='"+p.getAddress()+"' where id="+p.getId()+""; 
	    return  template.update(sql);
	}
	
	public int delete(int id){ 
		 String sql="delete from employee where id="+id+""; 
		 return template.update(sql); 
		} 

	
	public List<Emp> getEmployeesByPage(int pageid,int total){ 
		 String sql="select * from employee limit "+(pageid-1)+","+total; 
		 System.out.println(sql); 
		 return template.query(sql,new RowMapper<Emp>(){ 
		 public Emp mapRow(ResultSet rs, int row) throws SQLException { 
		 Emp e=new Emp(); 
		 String name=rs.getString(2); 
		 System.out.println(name); 
		 e.setId(rs.getInt(1)); 
		 e.setName(name); 
		 e.setAddress(rs.getString(4)); 
		 e.setSalary(rs.getFloat(3)); 
		 return e; 
		 } 
		 }); 
		} 	
}
