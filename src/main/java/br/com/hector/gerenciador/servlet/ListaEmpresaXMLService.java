package br.com.hector.gerenciador.servlet;

import br.com.hector.gerenciador.modelo.Banco;
import br.com.hector.gerenciador.modelo.Empresa;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/empresasXML")
public class ListaEmpresaXMLService extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Empresa> empresas = new Banco().getEmpresas();

        XStream xstream = new XStream();
        String xml = xstream.toXML(empresas);

        resp.setContentType("application/xml");
        resp.getWriter().print(xml);

    }
}