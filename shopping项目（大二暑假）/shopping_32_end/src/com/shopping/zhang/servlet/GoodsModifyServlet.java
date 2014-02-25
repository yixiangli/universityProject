package com.shopping.zhang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.shopping.po.Goods;
import com.shopping.zhang.service.impl.CategoryServiceImpl;
import com.shopping.zhang.service.impl.GoodsServiceImpl;
import com.shopping.util.ChangFileName;

public class GoodsModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 3603661802434039404L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.����smartupload����
		SmartUpload smartUpload = new SmartUpload();
		// 2��ʼ��
		smartUpload.initialize(this.getServletConfig(), request, response);
		smartUpload.setCharSet("UTF-8");
		// 3�����ϴ��ļ�
		String newFilePath = null;
		try {
			smartUpload.upload();
			String ext = smartUpload.getFiles().getFile(0).getFileExt();
			// �õ��ͻ���ip
			// String ip = request.getRemoteAddr();
			// �õ��������ļ�ȫ��
			String newFileName = ChangFileName.getFileName() + "." + ext;
			// �����ܹ������ļ������ڹ����ռ��images��
			String filepath = this.getServletContext().getRealPath("/")
					+ "images\\goods\\" + newFileName;
			newFilePath = "images/goods/" + newFileName;

			smartUpload.getFiles().getFile(0).saveAs(filepath);
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}

		String gname = smartUpload.getRequest().getParameter("gname");
		float gdiscount = Float.parseFloat(smartUpload.getRequest().getParameter("gdiscount"));
		float marketPrice = Float.parseFloat(smartUpload.getRequest().getParameter("marketPrice"));
		float salPrice = Float.parseFloat(smartUpload.getRequest().getParameter("salPrice"));
		String info = smartUpload.getRequest().getParameter("info");
		int bargainPrice = Integer.parseInt(smartUpload.getRequest().getParameter("bargainPrice"));
		int sortId = Integer.parseInt(smartUpload.getRequest().getParameter("typeID"));
		int id = Integer.parseInt(smartUpload.getRequest().getParameter("id"));

		Goods good = new Goods();
		good.setGname(gname);
		good.setGdiscount(gdiscount);
		good.setMarketPrice(marketPrice);
		good.setSalPrice(salPrice);
		good.setInfo(info);
		good.setPhoto(newFilePath);
		good.setBargainPrice(bargainPrice);
		good.setSort(CategoryServiceImpl.getInstance().showCategoryById(sortId));
		good.setId(id);

		GoodsServiceImpl.getInstance().updateGoodsById(good, id);
		response.sendRedirect("GoodsManage.jsp");
	}

}
