package com.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.java.beans.Route;

public class RouteDao {

	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template=template;
	}
	
	public int saveRoute(Route r) {
		String sql="insert into route (departurePoint,destinationPoint,timeRequired,fare) values('"+r.getDeparturePoint()+"','"+r.getDestinationPoint()+"','"+r.getTimeRequired()+"',"+r.getFare()+") ";
		return template.update(sql);
	}
//	public Driver getDriverById(int id) {
//		String sql="select * from driver where driverId=?";
//		return template.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<Driver>(Driver.class));
//	}
	
	public Route getRouteById(int id) {
		String sql = "select * from route where routeId=" + id;
		return template.queryForObject(sql, new RowMapper<Route>() {
			public Route mapRow(ResultSet rs, int row) throws SQLException {
				Route r= new Route();
				r.setRouteId(rs.getInt(1));
				r.setDeparturePoint(rs.getString(2));
				r.setDestinationPoint(rs.getString(3));
				r.setTimeRequired(rs.getString(4));
				r.setFare(rs.getInt(5));
				return r;
			}
		});
	}
	public List<Route> getRoutes(){
		List<Route> routeList= template.query("select * from route", new RowMapper<Route>() {
			public Route mapRow(ResultSet rs,int row) throws SQLException{
				Route r=new Route();
				
				r.setRouteId(rs.getInt(1));
				r.setDeparturePoint(rs.getString(2));
				r.setDestinationPoint(rs.getString(3));
				r.setTimeRequired(rs.getString(4));
				r.setFare(rs.getInt(5));
				return r;
			}
		});
		return routeList;
	}
	public int getRouteCount() {
		String sql="SELECT COUNT(*) FROM route";
		return template.queryForObject(sql,Integer.class);
	}	
	public int checkRouteDuplicate(String departure,String destination) {
		String sql="SELECT COUNT(*) FROM route WHERE departurePoint='"+departure+"' and destinationPoint='"+destination+"'";
		int count=template.queryForObject(sql,Integer.class);
		return count;
	}	
	public int confirmRouteForDelete(int routeId) {
		String sql="SELECT COUNT(*) FROM inuse WHERE routeId='"+routeId+"'";
		int count=template.queryForObject(sql,Integer.class);
		return count;
	}	
	public void updateRoute(Route r) {
		String sql="update route set departurePoint='"+r.getDeparturePoint()+"', destinationPoint='"+r.getDestinationPoint()+"',timeRequired='"+r.getTimeRequired()+"',fare="+r.getFare()+" where routeId="+r.getRouteId()+""; 
	      template.update(sql);
	}
	
	public void deleteRoute(int id){ 
		 String sql="delete from route where routeId="+id+""; 
		  template.update(sql); 
		} 
}
