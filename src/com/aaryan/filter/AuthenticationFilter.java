package com.aaryan.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({
    "/AddtoCart", 
    "/OrderServlet", 
    "/userHome.jsp", 
    "/cartDetails.jsp",
    "/AddProductSrv", 
    "/RemoveProductSrv",
    "/UpdateProductSrv",
    "/adminViewProduct.jsp",
    "/addProduct.jsp",
    "/removeProduct.jsp",
    "/updateProduct.jsp",
    "/ShipmentServlet"
})
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);
        
        // Check if user is logged in
        String username = (session != null) ? (String) session.getAttribute("username") : null;
        String password = (session != null) ? (String) session.getAttribute("password") : null;

        if (username == null || password == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp?message=Session Expired, Login Again to Continue!");
            return;
        }

        // Check admin access for admin paths
        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        String userType = (session != null) ? (String) session.getAttribute("usertype") : null;

        if (path.startsWith("/AddProductSrv") || path.startsWith("/RemoveProductSrv") 
            || path.startsWith("/UpdateProductSrv") || path.startsWith("/adminViewProduct.jsp") 
            || path.startsWith("/addProduct.jsp") || path.startsWith("/removeProduct.jsp") 
            || path.startsWith("/updateProduct.jsp") || path.startsWith("/ShipmentServlet")) {
            
            if (!"admin".equalsIgnoreCase(userType)) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp?message=Access Denied, Login As Admin!");
                return;
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code
    }
}