/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mockupcode.hibernatelazy.servlet;

import com.mockupcode.hibernatelazy.domain.Parent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author San
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    @Resource
    private UserTransaction ut;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = null;
        Parent parent = null;
        try {
            Context ctx = new InitialContext();
            em = (EntityManager) ctx.lookup("java:comp/env/persistence/eme");
        } catch (NamingException ex) {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ut.begin();
            parent = em.find(Parent.class, 1l);
            System.out.println("end transaction");
            ut.commit();
        } catch (Exception ex) {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("get non transaction");
        System.out.println(parent.getChilds().size());
        resp.getWriter().println(parent.getChilds().size());
    }
}
