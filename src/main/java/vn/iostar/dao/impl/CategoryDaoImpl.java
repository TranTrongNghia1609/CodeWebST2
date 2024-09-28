package vn.iostar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iostar.configs.DBconect;
import vn.iostar.configs.DBconection;
import vn.iostar.dao.ICategoryDao;
import vn.iostar.models.CategoryModel;

public class CategoryDaoImpl implements ICategoryDao {
	
	public DBconect conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	public List<CategoryModel> findAll() {
		String sql = "Select * from categories";
		List<CategoryModel> list = new ArrayList<>();
		try {
			Connection	conn = new DBconect().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


	public CategoryModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public void insert(CategoryModel category) {
		// TODO Auto-generated method stub
		
	}


	public void update(CategoryModel category) {
		// TODO Auto-generated method stub
		
	}


	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}


	public List<CategoryModel> findName(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
