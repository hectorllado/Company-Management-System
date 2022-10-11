package br.com.hector.gerenciador.acao;

import br.com.hector.gerenciador.modelo.Banco;
import br.com.hector.gerenciador.modelo.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ListaEmpresa implements Acao {

    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        if(session.getAttribute("usuarioLogado") == null) {
            return "redirect:entrada?acao=LoginForm";
        }


        Banco banco = new Banco();
        List<Empresa> lista = banco.getEmpresas();


        req.setAttribute("empresas", lista);

        return "forward:listaEmpresas.jsp";



    }
}
