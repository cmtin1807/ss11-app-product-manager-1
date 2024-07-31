package com.example.app_product_manager.controller;

import com.example.app_product_manager.model.Product;
import com.example.app_product_manager.service.IProductService;
import com.example.app_product_manager.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    protected final IProductService productService = new ProductService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewProduct(request, response);
                break;
            default:
                listProducts(request, response);
                break;

        }

    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = productService.findAllProducts();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        try{
            requestDispatcher.forward(request,response);
        }
        catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findProductById(id);
        request.setAttribute("product", product);
        RequestDispatcher requestDispatcher;
        if(product == null) {
            requestDispatcher = request.getRequestDispatcher("error.jsp");
        }
        else {
            requestDispatcher = request.getRequestDispatcher("product/view.jsp");
        }
        try{
            requestDispatcher.forward(request,response);
        }
        catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findProductById(id);
        RequestDispatcher requestDispatcher;
        if (product == null) {
            requestDispatcher = request.getRequestDispatcher("error.jsp");
        }
        else {
            request.setAttribute("product", product);
            requestDispatcher = request.getRequestDispatcher("product/delete.jsp");
        }
        try{
            requestDispatcher.forward(request,response);
        }
        catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findProductById(id);
        request.setAttribute("product", product);
        RequestDispatcher requestDispatcher;
        if(product == null) {
            requestDispatcher = request.getRequestDispatcher("error.jsp");
        }
        else {
            requestDispatcher = request.getRequestDispatcher("product/edit.jsp");
        }
        try{
            requestDispatcher.forward(request,response);
        }
        catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
        try{
            requestDispatcher.forward(request,response);
        }
        catch (ServletException | IOException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action="";
        }
        switch (action) {
            case "create":
                createProduct(req,resp);
                break;
                case "edit":
                    editProduct(req,resp);
                    break;
                    case "delete":
                        deleteProduct(req,resp);
                        break;
            default:
                break;

        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findProductById(id);
        RequestDispatcher requestDispatcher;
        if(product == null) {
            requestDispatcher = req.getRequestDispatcher("error.jsp");
        }
        else {
            productService.deleteProduct(product.getId());
            try{
                resp.sendRedirect("/products");
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    private void editProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String company = req.getParameter("company");
        String description = req.getParameter("description");
        Double price = Double.parseDouble(req.getParameter("price"));
        Product product = productService.findProductById(id);
        RequestDispatcher requestDispatcher;
        if(product == null) {
            requestDispatcher = req.getRequestDispatcher("error.jsp");
        }
        else {
            product.setName(name);
            product.setCompany(company);
            product.setDescription(description);
            product.setPrice(price);
            productService.updateProduct(id,product);
            req.setAttribute("product", product);
            req.setAttribute("message", "Product information was updated");
            requestDispatcher = req.getRequestDispatcher("product/edit.jsp");
        }
        try {
            requestDispatcher.forward(req,resp);
            resp.sendRedirect("/products");
        }
        catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String company = req.getParameter("company");
        String description = req.getParameter("description");
        Double price = Double.parseDouble(req.getParameter("price"));
        Product product = new Product(id, name, company, description, price);
        productService.saveProduct(product);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("product/create.jsp");
        req.setAttribute("message", "New product created");
        try {
            resp.sendRedirect("/products");
        }
        catch ( IOException e) {
            e.printStackTrace();
        }

    }
}
