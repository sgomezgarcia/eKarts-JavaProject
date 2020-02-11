package com.ekarts.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.ekarts.dao.KartDao;
import com.ekarts.dto.Kart;
import com.ekarts.enums.KartTypes;

@WebServlet("/kart")
public class KartController extends HttpServlet{
    private static final long serialVersionUID = -7558166539389234331L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperam l'acció a realitzar i es crida a la funció corresponent
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "edit":
                    this.editKart(request, response);
                    break;
                default:
                    this.showListKarts(request, response);
            }
        } else {
            this.showListKarts(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Recuperam l'acció a realitzar i es crida a la funció corresponent
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "delete":
                    this.deleteKart(request, response);
                    break;
                case "insert":
                    this.insertKart(request, response);
                    break;
                case "update":
                    this.updateKart(request, response);
                    break;
                default:
                    this.showListKarts(request, response);
            }
        } else {
            this.showListKarts(request, response);
        }
    }

    private void showListKarts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Kart> karts = new KartDao().listar();

        System.out.println("karts = " + karts);

        // Dades a desar a la sessió de la classe
        HttpSession session = request.getSession();
        session.setAttribute("karts", karts);

        // request.getRequestDispatcher("frmClient.jsp").forward(request, response);
        response.sendRedirect("frmKart.jsp");
    }

    private void editKart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // recuperamos el idCliente
        int idKart= Integer.parseInt(request.getParameter("idKart"));
        Kart kart = new KartDao().findById(new Kart(idKart));
        request.setAttribute("kart", kart);
        String jspEditar = "/editKart.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);

    }

    private void insertKart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");

        // recuperamos los valores del formulario agregarCliente
        String nombre = request.getParameter("nombre");
        KartTypes tipo = KartTypes.valueOf(request.getParameter("tipo"));
        double precio = Double.parseDouble(request.getParameter("precio"));

        // Creamos el objeto de cliente (modelo)
        Kart kart = new Kart(nombre, tipo, precio);

        // Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new KartDao().create(kart);
        System.out.println("Registres modificats:" + registrosModificados);

        // Redirigimos hacia accion por default
        this.showListKarts(request, response);
    }

    private void updateKart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");
        System.out.println("Modificar client");

        // Recuperam els valors del formulari editClient
        int idKart = Integer.parseInt(request.getParameter("idKart"));
        String nombre = request.getParameter("nombre");
        System.out.println("Nombre:" + nombre);

        KartTypes tipo = KartTypes.valueOf(request.getParameter("tipo"));
        double precio = Double.parseDouble(request.getParameter("precio"));

        // Creamos el objeto de cliente (modelo)
        Kart kart = new Kart(idKart, nombre, tipo, precio);

        // Modificar el objeto en la base de datos
        int registrosModificados = new KartDao().update(kart);
        System.out.println("Registres modificats:" + registrosModificados);

        // Redirigimos hacia accion por default
        this.showListKarts(request, response);
    }

    private void deleteKart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // recuperamos los valores del formulario editarCliente
        int idKart = Integer.parseInt(request.getParameter("idClient"));

        // Creamos el objeto de cliente (modelo)
        Kart kart = new Kart(idKart);

        // Eliminamos el objeto en la base de datos
        int registrosModificados = new KartDao().delete(kart);
        System.out.println("Registres modificats:" + registrosModificados);

        // Redirigimos hacia accion por default
        this.showListKarts(request, response);
    }


}
