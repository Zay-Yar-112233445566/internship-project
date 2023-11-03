package com.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.java.beans.Bus;
import com.java.beans.Driver;

public class BusDao {

	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template=template;
	}
	
	public void saveBus(Bus b) {
		String sql="insert into bus (busTypeId) values("+b.getBusTypeId()+") ";
	     template.update(sql);
	}
	public Bus getBusById(int id) {
		String sql = "select bus.busId,bustype.busTypeId,bustype.busTypeName from bus inner join bustype on bus.busTypeId=bustype.busTypeId  where busId=" + id;
		return template.queryForObject(sql, new RowMapper<Bus>() {
			public Bus mapRow(ResultSet rs, int row) throws SQLException {
				Bus b= new Bus();
				b.setBusId(rs.getInt(1));
				b.setBusTypeId(rs.getInt(2));
				b.setBusTypeName(rs.getString(3));
				return b;
			}
		});
	}
	public List<Bus> getBuses(){
		 List<Bus> busList=template.query("select bus.busId,busType.busTypeName from bus inner join bustype on bus.busTypeId=bustype.busTypeId", new RowMapper<Bus>() {
			public Bus mapRow(ResultSet rs,int row) throws SQLException{
				Bus b=new Bus();	
				b.setBusId(rs.getInt(1));
				b.setBusTypeName(rs.getString(2));		
				return b;
			}
		});
		 return busList;
	}
	
	public List<Bus> getDesiredBuses(String localDate){
		List<Bus> busList= template.query("select bus.busId,busType.busTypeName from bus inner join bustype on bus.busTypeId=bustype.busTypeId WHERE busId NOT IN (SELECT busId FROM inuse WHERE departureDate='"+localDate+"') order by busId", new RowMapper<Bus>() {
			public Bus mapRow(ResultSet rs,int row) throws SQLException{
				Bus b=new Bus();				
				b.setBusId(rs.getInt(1));
				b.setBusTypeName(rs.getString(2));
				return b;
			}
		});
		 return busList;
	}
	
	public int getBusCount() {
		String sql="SELECT COUNT(*) FROM bus";
		return template.queryForObject(sql,Integer.class);
	}	
	
	
	public int confirmBusForDelete(int busId) {
		String sql="SELECT COUNT(*) FROM inuse WHERE busId='"+busId+"'";
		int count=template.queryForObject(sql,Integer.class);
		return count;
	}	
	public void updateBus(Bus b) {
		String sql="update bus set  busTypeId="+b.getBusTypeId()+" where busId="+b.getBusId()+""; 
	      template.update(sql);
	}
	
	public void deleteBus(int id){ 
		 String sql="delete from bus where busId="+id+""; 
		  template.update(sql); 
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
//	
//	SELECT bus.busId,busType.busTypeName FROM Employees E
//	INNER JOIN
//	(
//	    SELECT EID, (SR.Rate * AD.DaysAttended) Salary
//	    FROM SalaryRate SR
//	    INNER JOIN AttendanceDetails AD on AD.EID=SR.EID
//	) DT --Derived Table for inner join
//	ON DT.EID=E.EID
	
}
//SELECT bus.busId, bustype.`busTypeId`,busType.busTypeName FROM bus INNER JOIN bustype ON bus.busTypeId=bustype.busTypeId WHERE busId  IN (SELECT busId FROM inuse WHERE inUseId=1);
//SELECT driver.driverId, driver.driverName FROM driver WHERE driver.driverId IN (SELECT driverId FROM inuse WHERE inUseId=1);
//SELECT routeId,departurePoint,destinationPoint,timeRequired,fare FROM route WHERE route.`routeId` IN (SELECT routeId FROM inuse WHERE inUseId=1);
//Ko Arkar Query
//(SELECT route.*, inuse.* FROM route INNER JOIN inuse ON route.routeId=inuse.routeId WHERE departureDate='2022-07-23');

/*
 * SELECT * FROM (SELECT bustype.busTypeName, bus.* FROM bustype INNER JOIN bus ON bustype.`busTypeId`=bus.`busTypeId`) AS A JOIN 
  (SELECT route.destinationPoint, inuse.* FROM route INNER JOIN inuse ON route.routeId=inuse.routeId WHERE departureDate='2022-07-23') AS B ON 
       A.`busId`=B.busId;
 * 
 * */

/*
 * SELECT * FROM (SELECT   bustype.`busTypeId`, bustype.busTypeName, bus.busId FROM bustype INNER JOIN bus ON bustype.`busTypeId`=bus.`busTypeId`) AS A JOIN 
(SELECT route.`routeId`, route.`departurePoint`, route.destinationPoint, route.`timeRequired`,route.`fare`, inuse.inUseId, inuse.`departureDate`,inuse.`departureTime`, inuse.`driverId`,inuse.`busId`FROM route INNER JOIN inuse ON route.routeId=inuse.routeId WHERE departureDate='2022-07-23') AS B ON 
       A.`busId`=B.busId;*/


