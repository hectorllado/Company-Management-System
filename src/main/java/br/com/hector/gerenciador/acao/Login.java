package br.com.hector.gerenciador.acao;

import br.com.hector.gerenciador.modelo.Banco;
import br.com.hector.gerenciador.modelo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login implements Acao {
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        System.out.println("Logando.... " + login);

        Banco banco = new Banco();
        Usuario usuario = banco.existeUsuario(login,senha);

        if(usuario != null) {
            System.out.println("usuário existe");
            //pega os cookies e o id de acesso
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuarioLogado", usuario);
            return "redirect:entrada?acao=ListaEmpresa";
        } else
        {
            System.out.println("usuário nao existe");
            return "redirect:entrada?acao=LoginForm";
        }
    }
}
