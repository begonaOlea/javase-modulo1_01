package com.ticontrack.registro.servicios;

import com.ticontrack.registro.dominio.Empleado;
import com.ticontrack.registro.persistencia.EmpleadoDAO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.sql.DataSource;

@Named(value = "fichajesService")
@SessionScoped
public class FichajesService implements Serializable {

    @Resource(name = "java:app/jdbc/fichaje")
    private DataSource dataSource;

    private EmpleadoDAO empleadoDao;

    private static Logger log = Logger.getLogger("FichajesService");

    public FichajesService() {
       this.empleadoDao = new EmpleadoDAO();
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Empleado> obtenerListaEmpleados() throws FichajeException {

        List<Empleado> lista = new ArrayList();
        try {
            Connection conn = dataSource.getConnection();
            empleadoDao.setConnection(conn);
            lista = new ArrayList();
            lista = this.empleadoDao.obtenerTodos();
        } catch (SQLException ex) {
            log.severe("error al obtener list empeados ");
            ex.printStackTrace();
            throw new FichajeException("Error de base de datos. No se recupero lista empleados");
        }
        return lista;
    }

}
