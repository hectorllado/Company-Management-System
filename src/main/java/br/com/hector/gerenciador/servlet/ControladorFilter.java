package br.com.hector.gerenciador.servlet;

import br.com.hector.gerenciador.acao.Acao;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControladorFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        System.out.println("ControladorFilter");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAcao = request.getParameter("acao");

        String nomeDaClasse = "br.com.hector.gerenciador.acao." + paramAcao;

        String nome;
        try {
            Class classe = Class.forName(nomeDaClasse);//carrega a classe com o nome
            Acao acao = (Acao) classe.newInstance();
            nome = acao.executa(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServletException(e);
        }


        String[] tipoEEndereco = nome.split(":");
        if(tipoEEndereco[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/" + tipoEEndereco[1]);
            rd.forward(request, response);
        } else {
            response.sendRedirect(tipoEEndereco[1]);

        }

    }

}
