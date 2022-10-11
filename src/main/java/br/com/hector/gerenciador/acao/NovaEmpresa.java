package br.com.hector.gerenciador.acao;

import br.com.hector.gerenciador.modelo.Banco;
import br.com.hector.gerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NovaEmpresa implements Acao {
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        return "redirect:entrada?acao=ListaEmpresa";
    }
}
