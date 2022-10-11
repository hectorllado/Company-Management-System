package br.com.hector.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Monitoramento Filter");

        long antes = System.currentTimeMillis();

        String acao = servletRequest.getParameter("acao");

        //executa a ação
        filterChain.doFilter(servletRequest, servletResponse);

        long depois = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + acao + " -> " + (depois - antes));

    }
}
