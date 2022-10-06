package br.com.hector.gerenciador.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

@WebServlet("/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Removendo empresa");
        //pela na propria URL
        String paramId = req.getParameter("id");
        //captura o ID
        Integer id = Integer.valueOf(paramId);

        Banco banco = new Banco();
        banco.remove(id);

        resp.sendRedirect("listaEmpresas");


    }
}
