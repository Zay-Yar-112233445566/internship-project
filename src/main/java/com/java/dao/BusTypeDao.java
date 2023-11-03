package com.java.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.java.beans.BusType;

public class BusTypeDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int saveBusType(BusType bt) {
		String sql = "insert into bustype (busTypeName,numberOfSeats) values('" + bt.getBusTypeName() + "',"
				+ bt.getNumberOfSeats() + ") ";
		return template.update(sql);
	}


	public BusType getBusTypeById(int id) {
		String sql = "select * from busType where busTypeId=" + id;
		BusType busType= template.queryForObject(sql, new RowMapper<BusType>() {
			public BusType mapRow(ResultSet rs, int row) throws SQLException {
				BusType b = new BusType();
				b.setBusTypeId(rs.getInt(1));
				b.setBusTypeName(rs.getString(2));
				b.setNumberOfSeats(rs.getInt(3));
				return b;
			}
		});
		return busType;
	}

	public List<BusType> getBusTypes() {
		List<BusType> busTypeList= template.query("select * from bustype", new RowMapper<BusType>() {
			public BusType mapRow(ResultSet rs, int row) throws SQLException {
				BusType bt = new BusType();

				bt.setBusTypeId(rs.getInt(1));
				bt.setBusTypeName(rs.getString(2));
				bt.setNumberOfSeats(rs.getInt(3));
				return bt;
			}
		});
		return busTypeList;
	}

	public int getBusTypeCount() {
		String sql = "SELECT COUNT(*) FROM bustype";
		return template.queryForObject(sql, Integer.class);
	}
	
	public int checkBusTypeDuplicate(BusType busType) {
		String sql="SELECT COUNT(*) FROM bustype WHERE busTypeName='"+busType.getBusTypeName()+"' and numberOfSeats='"+busType.getNumberOfSeats()+"'";
		int count=template.queryForObject(sql,Integer.class);
		return count;
	}	
	public int confirmBusTypeForDelete(int busTypeId) {
		String sql="SELECT COUNT(*) FROM bus WHERE busTypeId='"+busTypeId+"'";
		int count=template.queryForObject(sql,Integer.class);
		return count;
	}	
	public void updateBusType(BusType bt) {
		String sql = "update bustype set busTypeName='" + bt.getBusTypeName() + "', numberOfSeats="
				+ bt.getNumberOfSeats() + " where busTypeId=" + bt.getBusTypeId() + "";
		template.update(sql);
	}

	public int deleteBusType(int id) {
		String sql = "delete from bustype where busTypeId=" + id + "";
		return template.update(sql);
	}

}
