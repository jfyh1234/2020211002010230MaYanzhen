package com.MaYanzhen.controller;

import com.MaYanzhen.dao.IUserDao;
import com.MaYanzhen.dao.UserDao;
import com.MaYanzhen.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        con =(Connection)getServletContext().getAttribute("dbConn");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        IUserDao iUserDao = new UserDao();
        try {
            User userInfo = iUserDao.findById(con, id);
            request.setAttribute("userInfo",userInfo);
            request.getRequestDispatcher("WEB-INF/views/updateUesr.jsp").forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name,password,email,gender;
        Integer id = Integer.valueOf(request.getParameter("id"));
        name = request.getParameter("username");
        password = request.getParameter("password");
        email = request.getParameter("email");
        gender = request.getParameter("gender");
        Date date = Date.valueOf(request.getParameter("birth"));
        User user = new User(id, name, password, email, gender, date);

        IUserDao iUserDao = new UserDao();
        try {
            int i = iUserDao.updateUser(con, user);
            if (i != 0){
                request.getSession().setAttribute("user",iUserDao.findById(con,id));
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request, response);
            }else {
                request.setAttribute("message","update Error!!!");
                request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
