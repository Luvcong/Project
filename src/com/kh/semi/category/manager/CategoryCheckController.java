package com.kh.semi.category.manager;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.board.recipe.model.service.CategoryServiceImpl;
import com.kh.semi.board.recipe.model.vo.RecipeCategory;

/**
 * Servlet implementation class CategoryCheckController
 */
@WebServlet("/jhcheck.ct")
public class CategoryCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryServiceImpl categoryServiceImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryCheckController() {
        super();
        categoryServiceImpl = new CategoryServiceImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) post
		request.setCharacterEncoding("UTF-8");
		// 2) 값
		String checkCategoryName = request.getParameter("checkCategoryName");
		// 3) 가공xx
		// 4) 요청
		ArrayList<RecipeCategory> list = categoryServiceImpl.checkCategory(checkCategoryName);
		// 5) 응답화면
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(list, response.getWriter());

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
