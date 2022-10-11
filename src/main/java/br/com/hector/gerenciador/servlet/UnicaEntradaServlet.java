package br.com.hector.gerenciador.servlet;

import br.com.hector.gerenciador.acao.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebServlet("/entrada")

//desabilitado -> agora é ControladorFilter
public class UnicaEntradaServlet extends HttpServlet {
    String nome;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramAcao = request.getParameter("acao");

        String nomeDaClasse = "br.com.hector.gerenciador.acao." + paramAcao;

        try {
            Class classe = Class.forName(nomeDaClasse); //carrega a classe com o nome
            Acao acao = (Acao) classe.newInstance();
            nome = acao.executa(request, response);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (InstantiationException e) {
            throw new ServletException(e);
        } catch (IllegalAccessException e) {
            throw new ServletException(e);
        }


//        if(paramAcao.equals("listaEmpresas")) {
//
//            ListaEmpresa listaEmpresa = new ListaEmpresa();
//            nome = listaEmpresa.executa(request, response);
//
//        }
//
//        if(paramAcao.equals("removeEmpresa")) {
//            RemoveEmpresa removeEmpresa = new RemoveEmpresa();
//            nome = removeEmpresa.executa(request,response);
//        }
//
//        if(paramAcao.equals("mostraEmpresa")) {
//            MostraEmpresa mostraEmpresa = new MostraEmpresa();
//            nome = mostraEmpresa.executa(request,response);
//        }
//
//        if(paramAcao.equals("alteraEmpresa")) {
//            AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
//            nome = alteraEmpresa.executa(request,response);
//        }
//
//        if(paramAcao.equals("novaEmpresa")) {
//            NovaEmpresa novaEmpresa = new NovaEmpresa();
//            nome = novaEmpresa.executa(request,response);
//        }
//
//        if(paramAcao.equals("novaEmpresaForm")) {
//            NovaEmpresaForm novaEmpresaForm = new NovaEmpresaForm();
//            nome = novaEmpresaForm.executa(request,response);
//        }

        String[] tipoEndereco = nome.split(":");
        if(tipoEndereco[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/" + tipoEndereco[1]);
            rd.forward(request, response);
            System.out.println(tipoEndereco[0]);
        }
        else {
            response.sendRedirect(tipoEndereco[1]);
            System.out.println(tipoEndereco[0]);
        }


    }

}
