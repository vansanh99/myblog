/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dal.DBContext;
import dal.validate;
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

/**
 *
 * @author sanhpv
 */
public class SignupValid extends HttpServlet {

    @Resource(name = "ds")
    private DataSource ds;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
            Logger.getLogger(SignupValid.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("controller?action=signup").forward(request, response);
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
            Logger.getLogger(SignupValid.class.getName()).log(Level.SEVERE, null, ex);
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        validate val = new validate();
        String validName = val.checkInputName(username);
        String validPass = val.checkInputPassword(password);
        String rs;
        DBContext db = new DBContext(conn);
        try {
            db.Create(username, password);
        } catch (SQLException ex) {
            Logger.getLogger(SignupValid.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (validName.equals("ok") && validPass.equals("ok")) {
            try {
                if (db.isExists(username)) {
                    try (PrintWriter out = response.getWriter()) {
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Sign up confirmation</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1> Signup successfully!</h1></br>");
                        out.println("<a href=\"welcome.jsp\" >Welcome page</a>");
                        out.println("<a href=\"controller?action=login\" >Login</a>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                } else {
                    request.setAttribute("username", username);
                    request.setAttribute("errName", "The username exists");
                    request.getRequestDispatcher("signup.jsp").forward(request, response);
                }
//            processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(SignupValid.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (!validName.equals("ok")) {
                request.setAttribute("errName", validName);
            }
            if (!validPass.equals("ok")) {
                request.setAttribute("errPass", validPass);
            }
            request.setAttribute("username", username);
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SignupValid.class.getName()).log(Level.SEVERE, null, ex);
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
