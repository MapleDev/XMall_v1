package com.xznn.web.servlet;

import com.xznn.domain.Category;
import com.xznn.domain.PageModel;
import com.xznn.domain.Product;
import com.xznn.service.CategoryService;
import com.xznn.service.ProductService;
import com.xznn.util.UUIDUtils;
import com.xznn.util.UploadUtils;
import com.xznn.web.base.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AdminProductServlet", value = "/AdminProductServlet")
public class AdminProductServlet extends BaseServlet {

    private static Logger logger = Logger.getLogger(AdminProductServlet.class);

    protected String findAllProductsWithPage(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        int num = Integer.parseInt(req.getParameter("num"));

        ProductService productService = new ProductService();
        PageModel pageModel = productService.findAllProductsWithPage(num, 10);
        req.setAttribute("page", pageModel);
        return "/admin/product/list.jsp";
    }

    protected String addProductUI(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        CategoryService categoryService = new CategoryService();
        List<Category> allCats = categoryService.findAllCats();
        req.setAttribute("allCats", allCats);
        return "/admin/product/add.jsp";
    }

    protected String addProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {

        Map<String, String> map = new HashMap<>();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        List<FileItem> fileItems = null;
        try {
            fileItems = servletFileUpload.parseRequest(req);

        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        if (fileItems != null) {
            for (FileItem fileItem : fileItems) {
                if (fileItem.isFormField()) {
                    map.put(fileItem.getFieldName(), fileItem.getString("utf-8"));
                } else {

                    String newFileName = UploadUtils.getUUIDName(fileItem.getName());

                    InputStream inputStream = fileItem.getInputStream();
                    String realPath = getServletContext().getRealPath("products/upload_img");
                    String dir = UploadUtils.getDir(newFileName);
                    String path = realPath + dir;
                    logger.warn("path = " + path);
                    File newDir = new File(path);
                    if (!newDir.exists()) {
                        newDir.mkdirs();
                    }
                    File newFileNameFile = new File(path, newFileName);
                    if (!newFileNameFile.exists()) {
                        newFileNameFile.createNewFile();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(newFileNameFile);
                    IOUtils.copy(inputStream, fileOutputStream);

                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly(fileOutputStream);

                    String pimage = "/products/upload_img" + dir + "/" + newFileName;
                    logger.warn("pimage = " + pimage);
                    map.put("pimage", pimage);
                }
            }
        }

        Product product = new Product();
        try {
            BeanUtils.populate(product, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        product.setPid(UUIDUtils.getId());
        product.setPdate(new Date());
        product.setPflag(0);
        logger.warn("product = " + product);

        ProductService productService = new ProductService();
        int i = productService.addProduct(product);
        logger.warn("addProduct rst = " + i);

        resp.sendRedirect(req.getContextPath() + "/AdminProductServlet?method=findAllProductsWithPage&num=1");
        return null;


/*

        //存储表单中数据
        Map<String, String> map = new HashMap<String, String>();
        //携带表单中的数据向servcie,dao
        Product product = new Product();
        try {
            //利用req.getInputStream();获取到请求体中全部数据,进行拆分和封装
            DiskFileItemFactory fac = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(fac);
            List<FileItem> list = upload.parseRequest(req);
            //4_遍历集合
            for (FileItem item : list) {
                if (item.isFormField()) {
                    //5_如果当前的FileItem对象是普通项
                    //将普通项上name属性的值作为键,将获取到的内容作为值,放入MAP中
                    // {username<==>tom,password<==>1234}
                    map.put(item.getFieldName(), item.getString("utf-8"));
                } else {
                    //6_如果当前的FileItem对象是上传项

                    //获取到原始的文件名称
                    String oldFileName = item.getName();
                    //获取到要保存文件的名称   1222.doc  123421342143214.doc
                    String newFileName = UploadUtils.getUUIDName(oldFileName);

                    //通过FileItem获取到输入流对象,通过输入流可以获取到图片二进制数据
                    InputStream is = item.getInputStream();
                    //获取到当前项目下products/3下的真实路径
                    //D:\tomcat\tomcat71_sz07\webapps\store_v5\products\3
                    String realPath = getServletContext().getRealPath("/products/3/");
                    String dir = UploadUtils.getDir(newFileName); // /f/e/d/c/4/9/8/4
                    String path = realPath + dir; //D:\tomcat\tomcat71_sz07\webapps\store_v5\products\3/f/e/d/c/4/9/8/4
                    //内存中声明一个目录
                    File newDir = new File(path);
                    if (!newDir.exists()) {
                        newDir.mkdirs();
                    }
                    //在服务端创建一个空文件(后缀必须和上传到服务端的文件名后缀一致)
                    File finalFile = new File(newDir, newFileName);
                    if (!finalFile.exists()) {
                        finalFile.createNewFile();
                    }
                    //建立和空文件对应的输出流
                    OutputStream os = new FileOutputStream(finalFile);
                    //将输入流中的数据刷到输出流中
                    IOUtils.copy(is, os);
                    //释放资源
                    IOUtils.closeQuietly(is);
                    IOUtils.closeQuietly(os);
                    //向map中存入一个键值对的数据 userhead<===> /image/11.bmp
                    // {username<==>tom,password<==>1234,userhead<===>image/11.bmp}
                    map.put("pimage", "/products/3/" + dir + "/" + newFileName);
                }
            }

            //7_利用BeanUtils将MAP中的数据填充到Product对象上
            BeanUtils.populate(product, map);
            product.setPid(UUIDUtils.getId());
            product.setPdate(new Date());
            product.setPflag(0);

            //8_调用servcie_dao将user上携带的数据存入数据仓库,重定向到查询全部商品信息路径
            ProductService ProductService=new ProductServiceImp();
            ProductService.saveProduct(product);

            resp.sendRedirect("/store_v5/AdminProductServlet?method=findAllProductsWithPage&num=1");


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
*/


    }

   /* protected String editProductUI(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String cname = req.getParameter("cname");
        String cid = req.getParameter("cid");

        Product product = new Product(cid, cname);
        req.setAttribute("product", product);

        return "admin/product/edit.jsp";
    }

    protected String updateProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String cname = req.getParameter("cname");
        String cid = req.getParameter("cid");

        ProductService productService = new ProductService();
        int i = productService.updateProduct(cname, cid);
        logger.warn("updateProduct = " + i);

        resp.sendRedirect(req.getContextPath() + "/AdminProductServlet?method=findAllCats");
        return null;
    }*/

    protected String deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String pid = req.getParameter("pid");

        ProductService productService = new ProductService();
        int i = productService.deleteProduct(pid);
        logger.warn("deleteProduct = " + i);

        resp.sendRedirect(req.getContextPath() + "/AdminProductServlet?method=findAllCats");
        return null;
    }

}
