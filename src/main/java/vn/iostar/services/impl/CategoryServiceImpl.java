package vn.iostar.services.impl;

import java.util.List;

import vn.iostar.dao.ICategoryDao;
import vn.iostar.dao.impl.CategoryDaoImpl;
import vn.iostar.models.CategoryModel;
import vn.iostar.services.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {
	public ICategoryDao categoryDao = new CategoryDaoImpl();
	@Override
	public List<CategoryModel> findAll() {
		
		return categoryDao.findAll();
	}

	@Override
	public CategoryModel findById(int id) {	
		return categoryDao.findById(id);
	}

	@Override
	public void insert(CategoryModel category) {
		categoryDao.insert(category);
		
	}

	@Override
	public void update(CategoryModel category) {
		CategoryModel cate = new CategoryModel();
		cate = categoryDao.findById(category.getCategoryid());
		if(cate != null)
		{
			categoryDao.update(category);
		}
		
	}

	@Override
	public void delete(int id) {
		CategoryModel cate = new CategoryModel();
		cate = categoryDao.findById(id);
		if(cate != null)
		{
			categoryDao.delete(id);
		}
		
	}

	@Override
	public List<CategoryModel> findName(String keyword) {
		// TODO Auto-generated method stub
		return categoryDao.findName(keyword);
	}

}
