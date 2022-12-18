package com.example.jsp;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try{
            int i = Integer.parseInt(request.getParameter("temperature"));
            out.println("<html><body>");
            out.println("<p style=\"font-size: 200%; text-align: center\">" + i + "</p>");
            if(i>0){
                out.println(" <p style=\"color:red; text-align: center; font-size: 200%\">Температура больше 0.</p>");
            } else if (i < 0 ){
                out.println(" <p style=\"color:blue; text-align: center; font-size: 200%\">Температура ниже 0.</p>");
            }
            else {
                out.println(" <p style=\"text-align: center; font-size: 200%\">Температура равна 0.</p>");
            }
            out.println("</body></html>");
        }catch (NumberFormatException e){
            out.println(" <p>Неверный формат</p>");
        }

    }

    public void destroy() {
    }
}