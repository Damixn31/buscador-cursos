package org.olmedo.apiservlet.webapp.buscadordecursos.service;

import org.olmedo.apiservlet.webapp.buscadordecursos.models.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> listar();
    List<Curso> porNombre(String nombre);
}
