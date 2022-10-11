package br.com.hector.gerenciador.servlet;

import br.com.hector.gerenciador.modelo.Banco;
import br.com.hector.gerenciador.modelo.Empresa;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


//@WebServlet("/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Mostrando empresa");
        //pela na propria URL
        String paramId = request.getParameter("id");
        //captura o ID
        Integer id = Integer.valueOf(paramId);

        Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaPelaId(id);

        request.setAttribute("empresa", empresa);
        RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
        rd.forward(request, response);
    }

}
