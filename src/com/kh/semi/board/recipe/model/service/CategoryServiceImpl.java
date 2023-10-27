package com.kh.semi.board.recipe.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kh.semi.board.recipe.model.dao.CategoryDao;
import com.kh.semi.board.recipe.model.vo.RecipeCategory;
import com.kh.semi.common.model.vo.PageInfo;
import com.kh.semi.common.template.Template;

public class CategoryServiceImpl implements CategoryService {
	
	private CategoryDao categoryDao = new CategoryDao();

	// 카테고리 리스트 조회
	@Override
	public ArrayList<RecipeCategory> selectCategoryList(PageInfo pi) {
		
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<RecipeCategory> list = categoryDao.selectCategoryList(sqlSession, pi);
		
		sqlSession.close();
		
		return list;
	}	// selectCategoryList
	
	
	// 카테고리 리스트 행 수 조회
	@Override
	public int selectCategoryListCount() {
		
		SqlSession sqlSession = Template.getSqlSession();
		int selectCategoryListCount = categoryDao.selectCategoryListCount(sqlSession);
		
		sqlSession.close();
		
		return selectCategoryListCount;
	}	// selectCategoryListCount

	
	// 카테고리 추가 요청
	@Override
	public int insertCategory(String recipeCategoryName) {
		
		SqlSession sqlSession = Template.getSqlSession();
		int result = categoryDao.insertCategory(sqlSession, recipeCategoryName);
		// System.out.println(result);
		
		sqlSession.close();
		
		return result;
	}

	@Override
	public int deleteCategory(int categoryNo, int categoryCount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCategory(String categoryName, String categoryUpdateName) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public ArrayList<RecipeCategory> checkCategory(String checkCategoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int duplicateCheckCategory(String addCategoryName) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}	// CategoryServiceImpl