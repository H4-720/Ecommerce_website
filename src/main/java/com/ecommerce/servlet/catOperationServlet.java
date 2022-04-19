package com.ecommerce.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.ecommerce.dao.catedao;
import com.ecommerce.dao.productdao;
import com.project.factoryProvider;
import com.project.tables.Product;
import com.project.tables.category;

/**
 * Servlet implementation class catOperationServlet
 */
@MultipartConfig
public class catOperationServlet extends HttpServlet {
	PrintWriter out = new PrintWriter(System.out);
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("operation");
		if(op.trim().equals("addcat")) {
			String title=request.getParameter("cattitle");
			String desp=request.getParameter("catdescription");
			
			category cate = new category();
			cate.setCattitle(title);
			cate.setCatdiscription(desp);
			catedao cd= new catedao(factoryProvider.getFactory());
			int catid = cd.savecate(cate);
			HttpSession hps = request.getSession();
			hps.setAttribute("message", "Category Added Successfully!");
			response.sendRedirect("admin.jsp");
			return;
		}else if(op.trim().equals("addproduct")) {
			
			String name = request.getParameter("pname");
			String desp = request.getParameter("pdesp");
			int price = Integer.parseInt(request.getParameter("pprice"));
			int discount = Integer.parseInt(request.getParameter("pdiscount"));
			int quantity = Integer.parseInt(request.getParameter("pquantity"));
			int catid = Integer.parseInt(request.getParameter("catid"));
			Part part = request.getPart("pPic");
			
			Product p = new Product();
			p.setPname(name);
			p.setPdesc(desp);
			p.setPprice(price);
			p.setPdiscount(discount);
			p.setPquantity(quantity);
			p.setPphoto(part.getSubmittedFileName());
			
			catedao cd = new catedao(factoryProvider.getFactory());
			category c = cd.getCategoryById(catid);
			p.setCate(c);
			
			productdao pd = new productdao(factoryProvider.getFactory());
			pd.saveProduct(p);
			
			String path = request.getRealPath("image")+File.separator+"propic"+File.separator+part.getSubmittedFileName();
			System.out.println(path);
			
			try {
				FileOutputStream fos = new FileOutputStream(path);
				InputStream is = part.getInputStream();
				byte []data = new byte[is.available()];
				is.read(data);
				fos.write(data);
				fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			HttpSession hps = request.getSession();
			hps.setAttribute("message", "Product Added Successfully!");
			response.sendRedirect("admin.jsp");
			return;
			
		}
	}

}
