package com.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.java.beans.InUse;
import com.java.dao.BusDao;
public class InUseDao {

	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template=template;
	}
	
	public int saveInUse(InUse i) {
		String sql="insert into inuse (departureDate,departureTime,busId,driverId,routeId) values('"+i.getDepartureDate()+"','"+i.getDepartureTime()+"',"+i.getBusId()+","+i.getDriverId()+","+i.getRouteId()+")";
		return template.update(sql);
	}
	
	public InUse getInUseById(int id) {
		String sql ="SELECT * FROM (SELECT inuse.inUseId, inuse.departureDate ,inuse.departureTime, inuse.driverId, inuse.busId, inuse.routeId, bus.busTypeId, driver.driverName, driver.driverPhone, route.departurePoint, route.destinationPoint, route.fare, route.timeRequired FROM inuse, bus, driver, route WHERE inuse.busid=bus.busid AND inuse.driverid=driver.driverid AND inuse.routeid=route.routeid AND inuse.inUseId="+id+" ) AS a JOIN (SELECT * FROM bustype) AS b ON a.busTypeId=b.busTypeId;";
		return template.queryForObject(sql, new RowMapper<InUse>() {
			public InUse mapRow(ResultSet rs, int row) throws SQLException {
				InUse i= new InUse();
				i.setInUseId(rs.getInt(1));
				i.setDepartureDate(rs.getString(2));
				i.setDepartureTime(rs.getString(3));
				
				i.setDriverId(rs.getInt(4));
				
				i.setBusId(rs.getInt(5));
				
				i.setRouteId(rs.getInt(6));
				
				i.setBusTypeId(rs.getInt(7));
				
				i.setDriverName(rs.getString(8));
				i.setDriverPhone(rs.getString(9));
				
				i.setDeparturePoint(rs.getString(10));
				i.setDestinationPoint(rs.getString(11));
				
				i.setFare(rs.getInt(12));
				i.setTimeRequired(rs.getString(13));
				
				i.setBusTypeName(rs.getString(15));
				i.setNumberOfSeats(rs.getInt(16));
				
				return i;
			}
		});
	}

	public List<InUse> getCurrentInUses(String currentDate){
		return template.query("SELECT * FROM (SELECT inuse.inUseId, inuse.departureDate ,inuse.departureTime, inuse.driverId, inuse.busId, inuse.routeId, bus.busTypeId, driver.driverName, driver.driverPhone, route.departurePoint, route.destinationPoint, route.fare, route.timeRequired FROM inuse, bus, driver, route WHERE inuse.busid=bus.busid AND inuse.driverid=driver.driverid AND inuse.routeid=route.routeid AND inuse.departuredate='"+currentDate+"' ) AS a JOIN (SELECT * FROM bustype) AS b ON a.busTypeId=b.busTypeId;", new RowMapper<InUse>() {
			public InUse mapRow(ResultSet rs,int row) throws SQLException{
			
				InUse i= new InUse();
				i.setInUseId(rs.getInt(1));
				i.setDepartureDate(rs.getString(2));
				i.setDepartureTime(rs.getString(3));
				
				i.setDriverId(rs.getInt(4));
				
				i.setBusId(rs.getInt(5));
				
				i.setRouteId(rs.getInt(6));
				
				i.setBusTypeId(rs.getInt(7));
				
				i.setDriverName(rs.getString(8));
				i.setDriverPhone(rs.getString(9));
				
				i.setDeparturePoint(rs.getString(10));
				i.setDestinationPoint(rs.getString(11));
				
				i.setFare(rs.getInt(12));
				i.setTimeRequired(rs.getString(13));
				
				i.setBusTypeName(rs.getString(15));
				i.setNumberOfSeats(rs.getInt(16));
				
				return i;
			}
		});
	}
	
	public List<InUse> getDesiredInUses(InUse inuse){
		return template.query("SELECT * FROM (SELECT inuse.inUseId, inuse.departureDate ,inuse.departureTime, inuse.driverId, inuse.busId, inuse.routeId, bus.busTypeId, driver.driverName, driver.driverPhone, route.departurePoint, route.destinationPoint, route.fare, route.timeRequired FROM inuse, bus, driver, route WHERE inuse.busid=bus.busid AND inuse.driverid=driver.driverid AND inuse.routeid=route.routeid AND inuse.departuredate='"+inuse.getDesiredDate()+"' ) AS a JOIN (SELECT * FROM bustype) AS b ON a.busTypeId=b.busTypeId;", new RowMapper<InUse>() {
			public InUse mapRow(ResultSet rs,int row) throws SQLException{
			
				InUse i= new InUse();
				i.setInUseId(rs.getInt(1));
				i.setDepartureDate(rs.getString(2));
				i.setDepartureTime(rs.getString(3));
				
				i.setDriverId(rs.getInt(4));
				
				i.setBusId(rs.getInt(5));
				
				i.setRouteId(rs.getInt(6));
				
				i.setBusTypeId(rs.getInt(7));
				
				i.setDriverName(rs.getString(8));
				i.setDriverPhone(rs.getString(9));
				
				i.setDeparturePoint(rs.getString(10));
				i.setDestinationPoint(rs.getString(11));
				
				i.setFare(rs.getInt(12));
				i.setTimeRequired(rs.getString(13));
				
				i.setBusTypeName(rs.getString(15));
				i.setNumberOfSeats(rs.getInt(16));
				
				return i;
			}
		});
	}
	public List<InUse> getInUses(){
		return template.query("SELECT DISTINCT * FROM (SELECT inuse.inUseId, inuse.departureDate ,inuse.departureTime, inuse.driverId, inuse.busId, inuse.routeId, bus.busTypeId, driver.driverName, driver.driverPhone, route.departurePoint, route.destinationPoint, route.fare, route.timeRequired FROM inuse, bus, driver, route WHERE inuse.busid=bus.busid AND inuse.driverid=driver.driverid AND inuse.routeid=route.routeid) AS a JOIN (SELECT * FROM bustype) AS b ON a.busTypeId=b.busTypeId order by a.departureDate DESC;", new RowMapper<InUse>() {
			public InUse mapRow(ResultSet rs,int row) throws SQLException{
			
				InUse i= new InUse();
				i.setInUseId(rs.getInt(1));
				i.setDepartureDate(rs.getString(2));
				i.setDepartureTime(rs.getString(3));
				
				i.setDriverId(rs.getInt(4));
				
				i.setBusId(rs.getInt(5));
				
				i.setRouteId(rs.getInt(6));
				
				i.setBusTypeId(rs.getInt(7));
				
				i.setDriverName(rs.getString(8));
				i.setDriverPhone(rs.getString(9));
				
				i.setDeparturePoint(rs.getString(10));
				i.setDestinationPoint(rs.getString(11));
				
				i.setFare(rs.getInt(12));
				i.setTimeRequired(rs.getString(13));
				
				i.setBusTypeName(rs.getString(15));
				i.setNumberOfSeats(rs.getInt(16));
				
				return i;
			}
		});
	}
	
	
	public int updateInUse(InUse i) {
		String sql="update inuse set departureDate='"+i.getDepartureDate()+"', departureTime='"+i.getDepartureTime()+"',busId="+i.getBusId()+",driverId="+i.getDriverId()+",routeId="+i.getRouteId()+" where routeId="+i.getRouteId()+""; 
	    return  template.update(sql);
	}
	
	public int deleteInUse(int id){ 
		 String sql="delete from inuse where inUseId="+id+""; 
		 return template.update(sql); 
		} 
	
	public int getInUseCount() {
		String sql="SELECT COUNT(*) FROM inuse";
		return template.queryForObject(sql,Integer.class);
	}

	
//	public List<Emp> getEmployeesByPage(int pageid,int total){ 
//		 String sql="select * from employee limit "+(pageid-1)+","+total; 
//		 System.out.println(sql); 
//		 return template.query(sql,new RowMapper<Emp>(){ 
//		 public Emp mapRow(ResultSet rs, int row) throws SQLException { 
//		 Emp e=new Emp(); 
//		 String name=rs.getString(2); 
//		 System.out.println(name); 
//		 e.setId(rs.getInt(1)); 
//		 e.setName(name); 
//		 e.setAddress(rs.getString(4)); 
//		 e.setSalary(rs.getFloat(3)); 
//		 return e; 
//		 } 
//		 }); 
//		} 
}
