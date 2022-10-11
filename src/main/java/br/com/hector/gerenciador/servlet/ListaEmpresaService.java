package br.com.hector.gerenciador.servlet;

import br.com.hector.gerenciador.modelo.Banco;
import br.com.hector.gerenciador.modelo.Empresa;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/empresas")
public class ListaEmpresaService extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Empresa> empresas = new Banco().getEmpresas();
        Gson gson = new Gson();
        String json = gson.toJson(empresas);

        resp.setContentType("application/json");
        resp.getWriter().print(json);

    }
}
