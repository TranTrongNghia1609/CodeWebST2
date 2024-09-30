package vn.iostar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import com.google.protobuf.Message;

import vn.iostar.configs.DBconect;
import vn.iostar.configs.DBconection;
import vn.iostar.dao.ICategoryDao;
import vn.iostar.models.CategoryModel;
import vn.iostar.services.ICategoryService;
import vn.iostar.services.impl.CategoryServiceImpl;

public class CategoryDaoImpl implements ICategoryDao {

	public DBconect conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	public List<CategoryModel> findAll() {
		String sql = "Select * from categories";
		List<CategoryModel> list = new ArrayList<>();
		try {
			Connection conn = new DBconect().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				list.add(category);
			}
			conn.close();
			ps.close();
			rs.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public CategoryModel findById(int id) {
		String sql = "Select * from categories where categoryid = ?";

		try {
			Connection conn = new DBconect().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				return category;
			}
			conn.close();
			ps.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(CategoryModel category) {
		String sql = "INSERT INTO categories(categoryname,images,status) VALUES (?,?,?)";

		try {
			Connection conn = new DBconect().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.executeUpdate();
			conn.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(CategoryModel category) {
		String sql = "UPDATE categories SET categoryname = ?, images=?, status =? WHERE categoryid = ?";

		try {
			Connection conn = new DBconect().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getCategoryid());
			ps.executeUpdate();
			conn.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(int id) {
		String sql = "DELETE FROM categories WHERE categoryid = ?";

		try {
			Connection conn = new DBconect().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			conn.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<CategoryModel> findName(String keyword) {
		String sql = "Select * from categories where categoryname like ?";
		List<CategoryModel> list = new ArrayList<>();
		try {
			Connection conn = new DBconect().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "% " + keyword + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				list.add(category);
			}
			conn.close();
			ps.close();
			rs.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		ICategoryDao dao = new CategoryDaoImpl();
		ICategoryService service = new CategoryServiceImpl();
		CategoryModel model = new CategoryModel();
		model = dao.findById(2);
		System.out.println(model); // Sẽ gọi category.toString()
		
	}

}
