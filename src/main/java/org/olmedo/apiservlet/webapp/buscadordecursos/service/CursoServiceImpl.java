package org.olmedo.apiservlet.webapp.buscadordecursos.service;

import org.olmedo.apiservlet.webapp.buscadordecursos.models.Curso;
import org.olmedo.apiservlet.webapp.buscadordecursos.repositories.CursoRepositorioImpl;
import org.olmedo.apiservlet.webapp.buscadordecursos.repositories.Respositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Curso> porId(Long id) {
        try {
            return Optional.ofNullable(respository.porId(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Curso curso) {
        try {
            respository.guardar(curso);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
       try {
           respository.eliminar(id);
       } catch (SQLException e) {
           throw new ServiceJdbcException(e.getMessage(), e.getCause());
       }
    }
}
