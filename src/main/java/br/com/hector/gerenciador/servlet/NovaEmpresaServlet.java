package br.com.hector.gerenciador.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Cadastrando nova empresa");
        //pela na propria URL
        String nomeEmpresa = request.getParameter("nome");

        //joga na classe empresa
        Empresa empresa = new Empresa();
        empresa.setNome(nomeEmpresa);

        //joga no banco de dados "fake"
        Banco banco = new Banco();
        banco.adiciona(empresa);

        //chamar o JSP
//        RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//        request.setAttribute("empresa", empresa.getNome());
//        rd.forward(request, response);

        //client-side redirect, pelo navegador. Devolve um codigo 301 ou 302.
        response.sendRedirect("listaEmpresas");

    }
}
