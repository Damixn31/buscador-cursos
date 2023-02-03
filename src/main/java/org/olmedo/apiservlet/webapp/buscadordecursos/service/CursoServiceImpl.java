package org.olmedo.apiservlet.webapp.buscadordecursos.service;

import org.olmedo.apiservlet.webapp.buscadordecursos.models.Curso;
import org.olmedo.apiservlet.webapp.buscadordecursos.repositories.CursoRepositorioImpl;
import org.olmedo.apiservlet.webapp.buscadordecursos.repositories.Respositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CursoServiceImpl implements CursoService{
    private Respositorio<Curso> respository;

    public CursoServiceImpl(Connection connection) {
        this.respository = new CursoRepositorioImpl(connection);
    }

    @Override
    public List<Curso> listar() {

        try {
            return respository.listar();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Curso> porNombre(String nombre) {
        try {
           return respository.porNombre(nombre);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
