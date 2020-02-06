/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dal.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import model.Account;

/**
 *
 * @author sanhpv
 */
public class loginProcess extends HttpServlet {

    @Resource(name = "ds")
    private DataSource ds;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void init(ServletConfig config)
            throws ServletException {
        try {
            InitialContext initContext = new InitialContext();
            Context env = (Context) initContext.lookup("java:comp/env");
            ds = (DataSource) env.lookup("jdbc/MyBlog");
        } catch (NamingException ex) {
            Logger.getLogger(loginProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        try {
            conn = ds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(loginProcess.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String action = request.getParameter("action");
        if (action == null) {
            request.getRequestDispatcher("controller?action=login").forward(request, response);
        }

        DBContext db = new DBContext(conn);
        Account account = null;
        try {
            account = db.getAccountByUsernameAndPassword(username, password);
        } catch (SQLException ex) {
            Logger.getLogger(loginProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (account == null) {
            if (action.equals("dologin")) {
                request.setAttribute("username", username);
                request.setAttribute("mess", "Username or password is error");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            request.getSession().setAttribute("account", account);
            response.sendRedirect("index.jsp");
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(loginProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
