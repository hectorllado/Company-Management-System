package br.com.hector.gerenciador.servlet;

import br.com.hector.gerenciador.modelo.Banco;
import br.com.hector.gerenciador.modelo.Empresa;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Cadastrando nova empresa");
        //pela na propria URL
        String nomeEmpresa = request.getParameter("nome");
        Integer id = Integer.valueOf(request.getParameter("id"));


        Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaPelaId(id);

        empresa.setNome(nomeEmpresa);

        response.sendRedirect("entrada?acao=listaEmpresas");
    }

}
