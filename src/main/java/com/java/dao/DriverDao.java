package com.java.dao;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.java.beans.Driver;
import com.java.beans.InUse;
import com.java.beans.Manager;

import util.PasswordEncoder;

public class DriverDao {

	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template=template;
	}
	public int authenticateDriver(Driver driver) throws NoSuchAlgorithmException, IOException {	
		String   email=driver.getDriverEmail();
   	    String   hashedPassword=PasswordEncoder.encodePassword(driver.getDriverPassword());
		String sql="SELECT count(*) FROM  driver where driverEmail='"+email+"' and driverPassword='"+hashedPassword+"'";
		return template.queryForObject(sql,Integer.class);			
	}	
	public Driver getDriver(Driver driver) throws NoSuchAlgorithmException, IOException {
		String hashedPassword=PasswordEncoder.encodePassword(driver.getDriverPassword());		
		String sql = "select * from driver where driverEmail='"+driver.getDriverEmail()+"' and driverPassword='"+hashedPassword+"' ";
		return template.queryForObject(sql, new RowMapper<Driver>() {
			public Driver mapRow(ResultSet rs, int row) throws SQLException {
				Driver m= new Driver();
		        m.setDriverId(rs.getInt(1));
		        m.setDriverName(rs.getString(2));
		        m.setDriverAddress(rs.getString(3));
		        m.setDriverPhone(rs.getString(4));
		        m.setDriverEmail(rs.getString(5));
		        m.setDriverPassword(rs.getString(6));
				return m;
			}
		});
	}
	public Driver getDriverForInfo(int id) throws NoSuchAlgorithmException, IOException {
	
		String sql = "select * from driver where driverId="+id+"";
		return template.queryForObject(sql, new RowMapper<Driver>() {
			public Driver mapRow(ResultSet rs, int row) throws SQLException {
				Driver m= new Driver();
		        m.setDriverId(rs.getInt(1));
		        m.setDriverName(rs.getString(2));
		        m.setDriverAddress(rs.getString(3));
		        m.setDriverPhone(rs.getString(4));
		        m.setDriverEmail(rs.getString(5));
		        m.setDriverPassword(rs.getString(6));
				return m;
			}
		});
	}
	public List<Driver> getAllDriverTrip(int driverId) throws NoSuchAlgorithmException, IOException{
		return template.query("SELECT * FROM (SELECT  inuse.departureDate ,inuse.departureTime, inuse.driverId, inuse.busId, inuse.routeId, bus.busTypeId, driver.driverName, driver.driverPhone, route.departurePoint, route.destinationPoint, route.fare, route.timeRequired FROM inuse, bus, driver, route WHERE inuse.busId=bus.busId AND inuse.driverId=driver.driverId AND inuse.routeId=route.routeId AND driver.driverId='"+driverId+"') AS a JOIN (SELECT * FROM bustype) AS b ON a.busTypeId=b.busTypeId;", new RowMapper<Driver>() {
			public Driver mapRow(ResultSet rs,int row) throws SQLException{			
				Driver d= new Driver();
				d.setDepartureDate(rs.getString(1));
				d.setDepartureTime(rs.getString(2));
				d.setDriverId(rs.getInt(3));
				d.setBusId(rs.getInt(4));
				d.setRouteId(rs.getInt(5));
				d.setDriverName(rs.getString(7));
				d.setDriverPhone(rs.getString(8));
				d.setDeparturePoint(rs.getString(9));
				d.setDestinationPoint(rs.getString(10));
				d.setFare(rs.getInt(11));
				d.setTimeRequired(rs.getInt(12));
				d.setBusTypeName(rs.getString(14));				
				return d;
			}
		});
	}
	public int updateDriverInfo(Driver d) {
		String sql="update driver set driverName='"+d.getDriverName()+"', driverAddress='"+d.getDriverAddress()+"',driverPhone='"+d.getDriverPhone()+"',driverEmail='"+d.getDriverEmail()+"' where driverId="+d.getDriverId()+""; 
	    return  template.update(sql);
	}
	public int updateDriverPassword(Driver  d) throws NoSuchAlgorithmException, IOException {
		String password=PasswordEncoder.encodePassword(d.getNewPassword());
		String sql="update driver set driverPassword='"+password+"' where driverId="+d.getDriverId()+""; 
	    return  template.update(sql);
	}
	
	public List<Driver> getDesiredDriverTrip(Driver driver) throws NoSuchAlgorithmException, IOException{	
		return template.query("SELECT * FROM (SELECT  inuse.departureDate ,inuse.departureTime, inuse.driverId, inuse.busId, inuse.routeId, bus.busTypeId, driver.driverName, driver.driverPhone, route.departurePoint, route.destinationPoint, route.fare, route.timeRequired FROM inuse, bus, driver, route WHERE inuse.busid=bus.busid AND inuse.driverid= driver.driverId AND inuse.routeid=route.routeid and inuse.departuredate='"+driver.getDesiredDate()+"' and  driver.driverId='"+driver.getDriverId()+"' ) AS a JOIN (SELECT * FROM bustype) AS b ON a.busTypeId=b.busTypeId;", new RowMapper<Driver>() {
			public Driver mapRow(ResultSet rs,int row) throws SQLException{
			
				Driver d= new Driver();
				d.setDepartureDate(rs.getString(1));
				d.setDepartureTime(rs.getString(2));
				d.setDriverId(rs.getInt(3));
				d.setBusId(rs.getInt(4));
				d.setRouteId(rs.getInt(5));
				d.setDriverName(rs.getString(7));
				d.setDriverPhone(rs.getString(8));
				d.setDeparturePoint(rs.getString(9));
				d.setDestinationPoint(rs.getString(10));
				d.setFare(rs.getInt(11));
				d.setTimeRequired(rs.getInt(12));
				d.setBusTypeName(rs.getString(14));				
				return d;
			}
		});
	}

	public Driver getDriverById(int driverId) {
		String sql = "select * from driver where driverId=" + driverId;
		return template.queryForObject(sql, new RowMapper<Driver>() {
			public Driver mapRow(ResultSet rs, int row) throws SQLException {
				Driver d= new Driver();
				d.setDriverId(rs.getInt(1));
				d.setDriverName(rs.getString(2));
				d.setDriverAddress(rs.getString(3));
				d.setDriverPhone(rs.getString(4));
				d.setDriverEmail(rs.getString(5));
				d.setDriverPassword(rs.getString(6));
				return d;
			}
		});
	}
	
	public List<Driver> getDrivers(){
		List <Driver> driverList=template.query("select * from driver", new RowMapper<Driver>() {
			public Driver mapRow(ResultSet rs,int row) throws SQLException{
				Driver d=new Driver();
				
				d.setDriverId(rs.getInt(1));
				d.setDriverName(rs.getString(2));
				d.setDriverAddress(rs.getString(3));
				d.setDriverPhone(rs.getString(4));
				d.setDriverEmail(rs.getString(5));
				d.setDriverPassword(rs.getString(6));
				return d;
			}
		});
		return driverList;
	}
	public List<Driver> getDesiredDrivers(String localDate){
		return template.query("SELECT driverId,driverName,driverAddress,driverPhone,driverEmail FROM driver WHERE driverId NOT IN (SELECT driverId FROM inuse WHERE departureDate='"+localDate+"') order by driverId", new RowMapper<Driver>() {
			public Driver mapRow(ResultSet rs,int row) throws SQLException{
				Driver d=new Driver();				
				d.setDriverId(rs.getInt(1));
				d.setDriverName(rs.getString(2));
				d.setDriverAddress(rs.getString(3));
				d.setDriverPhone(rs.getString(4));
				d.setDriverEmail(rs.getString(5));
				return d;
			}
		});
	}
	public int getDriverCount() {
		String sql="SELECT COUNT(*) FROM driver";
		return template.queryForObject(sql,Integer.class);
	}	
	public int saveDriver(Driver d) throws NoSuchAlgorithmException, IOException {
		String hashedPassword=PasswordEncoder.encodePassword(d.getDriverPassword());
		String sql="insert into driver (driverName,driverAddress,driverPhone,driverEmail,driverPassword) values('"+d.getDriverName()+"','"+d.getDriverAddress()+"','"+d.getDriverPhone()+"','"+d.getDriverEmail()+"','"+hashedPassword+"') ";
		return template.update(sql);
	}
	
	public int checkDriverDuplicate(Driver driver) {
		String sql="SELECT COUNT(*) FROM driver WHERE driverEmail='"+driver.getDriverEmail()+"'";
		int count=template.queryForObject(sql,Integer.class);
		return count;
	}
	public int confirmDriverForDelete(int driverId) {
		String sql="SELECT COUNT(*) FROM inuse WHERE driverId='"+driverId+"'";
		int count=template.queryForObject(sql,Integer.class);
		return count;
	}
	
	
	public int deleteDriver(int id){ 
		 String sql="delete from driver where driverId="+id+""; 
		 return template.update(sql); 
		} 

	public List<Driver> getDriverByPage(int pageid,int total){ 
		 String sql="select * from driver limit "+(pageid-1)+","+total; 
		 System.out.println(sql); 
		 return template.query(sql,new RowMapper<Driver>(){ 
		 public Driver mapRow(ResultSet rs, int row) throws SQLException { 
		 Driver e=new Driver(); 
		 String name=rs.getString(2); 
		 System.out.println(name); 
		 e.setDriverId(rs.getInt(1)); 
		 e.setDriverName(rs.getString(2));
		 e.setDriverAddress(rs.getString(3)); 
		 e.setDriverPhone(rs.getString(4));
		 e.setDriverEmail(rs.getString(5)); 
		 e.setDriverPassword(rs.getString(6));
		 return e; 
		 } 
		 }); 
		} 

}
