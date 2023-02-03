package org.olmedo.apiservlet.webapp.buscadordecursos.repositories;

import java.sql.SQLException;
import java.util.List;

public interface Respositorio<T> {
    List<T> listar() throws SQLException;
    List<T> porNombre(String nombre) throws SQLException;
}
