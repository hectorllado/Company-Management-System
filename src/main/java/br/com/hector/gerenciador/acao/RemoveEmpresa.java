package br.com.hector.gerenciador.acao;

import br.com.hector.gerenciador.modelo.Banco;
import br.com.hector.gerenciador.modelo.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RemoveEmpresa implements Acao {
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //pela na propria URL
        String paramId = req.getParameter("id");
        //captura o ID
        Integer id = Integer.valueOf(paramId);

        Banco banco = new Banco();
        banco.remove(id);

        return "redirect:entrada?acao=ListaEmpresa";

    }
}
