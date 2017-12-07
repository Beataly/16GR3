/**
 * 
 */
package com.qhit.sbm.provider.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbm.provider.bean.Provider;
import com.qhit.sbm.provider.service.ProviderService;
import com.qhit.sbm.provider.service.impl.ProviderServiceimpl;

/**
 * @author admin
 * 2017年11月13日
 */
public class ProviderServlet extends HttpServlet {
	private ProviderService providerService = new ProviderServiceimpl();

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "getAllProvider":
			getAllProvider(request, response);
			break;
		case "addAccount":
			addAccount(request,response);
			break;
		default:
			break;
		}
	}


	


	private void addAccount(HttpServletRequest request, HttpServletResponse response) {
		
	}

	// 查询所有的供应商
	private void getAllProvider(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String action = request.getParameter("action");
		List<Provider> list = providerService.getAllProvider();
		
		request.setAttribute("providers", list);
		if(action.equals("add")){
			//查完之后:如果是添加账单，转发到添加账单的页面
			RequestDispatcher rqDispatcher = request.getRequestDispatcher("jsp/modify.jsp");
			rqDispatcher.forward(request, response);
		}else{
			//查完之后：如果是修改账单，那就转发到修改账单的页面
			RequestDispatcher rqDispatcher = request.getRequestDispatcher("jsp/updateAccount.jsp");
			rqDispatcher.forward(request, response);
		}
		
	}

}
