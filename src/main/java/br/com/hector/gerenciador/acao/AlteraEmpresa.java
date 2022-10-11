package br.com.hector.gerenciador.acao;

import br.com.hector.gerenciador.modelo.Banco;
import br.com.hector.gerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AlteraEmpresa implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //pela na propria URL
        System.out.println("Alterando a empresa");
        //pela na propria URL
        String nomeEmpresa = request.getParameter("nome");
        Integer id = Integer.valueOf(request.getParameter("id"));


        Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaPelaId(id);

        empresa.setNome(nomeEmpresa);

        return "redirect:entrada?acao=ListaEmpresa";
    }
}
