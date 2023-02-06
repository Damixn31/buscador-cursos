package org.olmedo.apiservlet.webapp.buscadordecursos.repositories;

import org.olmedo.apiservlet.webapp.buscadordecursos.models.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoRepositorioImpl implements Respositorio<Curso>{
    //Atributo
    private Connection conn;

    //Constructor
    public CursoRepositorioImpl(Connection conn) {
        this.conn = conn;
    }

    // Metodos
    @Override
    public List<Curso> listar() throws SQLException {
        List<Curso> cursos = new ArrayList<>();
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM cursos as c")) {
            while (rs.next()) {
                Curso p = getCurso(rs);
                cursos.add(p);
            }
        }
        return cursos;
    }
    @Override
    public List<Curso> porNombre(String nombre) throws SQLException {
        List<Curso> cursos = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cursos as c WHERE c.nombre like ?")) {
            stmt.setString(1, "%" + nombre + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    cursos.add(getCurso(rs));
                }
            }
        }
        return cursos;
    }

    @Override
    public Curso porId(Long id) throws SQLException {
        Curso curso = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cursos as c WHERE c.id = ?")){
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    curso = getCurso(rs);
                }
            }
        }
        return curso;
    }

    @Override
    public void guardar(Curso curso) throws SQLException {
        String sql;
        if(curso.getId() != null && curso.getId() > 0) {
            sql = "update cursos set nombre=?, instructor=?, duracion=?, descripcion=? where id=?";
        } else {
            sql = "insert into cursos (nombre, instructor, duracion, descripcion) values (?,?,?,?)";
        }
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, curso.getNombre());
            stmt.setString(2, curso.getInstructor());
            stmt.setDouble(3, curso.getDuracion());
            stmt.setString(4, curso.getDescripcion());

            if(curso.getId() != null && curso.getId() > 0) {
                stmt.setLong(5, curso.getId());
            }
            stmt.executeUpdate();
        }

    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = "delete from cursos where id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }

    }

    private Curso getCurso(ResultSet rs) throws SQLException{
        Curso c = new Curso();
        c.setId(rs.getLong("id"));
        c.setNombre(rs.getString("nombre"));
        c.setDescripcion(rs.getString("descripcion"));
        c.setInstructor(rs.getString("instructor"));
        c.setDuracion(rs.getDouble("duracion"));
        return c;
    }
}
