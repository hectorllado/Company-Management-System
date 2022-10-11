package br.com.hector.gerenciador.acao;

import br.com.hector.gerenciador.modelo.Banco;
import br.com.hector.gerenciador.modelo.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MostraEmpresa implements Acao {
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //captura o ID e transforma em int
        Integer id = Integer.valueOf(req.getParameter("id"));

        Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaPelaId(id);

        req.setAttribute("empresa", empresa);

        return "forward:formAlteraEmpresa.jsp";

    }
}
