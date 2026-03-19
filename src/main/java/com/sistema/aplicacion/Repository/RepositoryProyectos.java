package com.sistema.aplicacion.Repository;import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import com.sistema.aplicacion.BD.Conexion;
import com.sistema.aplicacion.Model.TablaProyectos;

public class RepositoryProyectos {

    public String insertarProyecto(TablaProyectos proyecto) {
        String resultado = "No guardado";
        String sql = "INSERT INTO proyectos (nombre, descripcion, fecha_inicio) values (?,?,?)";

        try (Connection connection = Conexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, proyecto.getNombre());
            preparedStatement.setString(2, proyecto.getDescripcion());
            preparedStatement.setDate(3, Date.valueOf(proyecto.getFechaInicio()));

            preparedStatement.executeUpdate();
            resultado = "Guardado";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public List<TablaProyectos> mostrarProyectos() {
        String sql = "SELECT * FROM proyectos";
        List<TablaProyectos> misProyectos = new ArrayList<>();

        try (Connection connection = Conexion.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                TablaProyectos proyectoActual = new TablaProyectos();
                proyectoActual.setIdProyecto(resultSet.getInt("id_proyecto"));
                proyectoActual.setNombre(resultSet.getString("nombre"));
                proyectoActual.setDescripcion(resultSet.getString("descripcion"));
                proyectoActual.setFechaInicio(resultSet.getDate("fecha_inicio").toLocalDate());
                misProyectos.add(proyectoActual);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return misProyectos;
    }

    public String modificarProyecto(TablaProyectos proyecto) {
        String resultado = "No modificado";
        String sql = "UPDATE proyectos SET nombre=?, descripcion=?, fecha_inicio=? WHERE id_proyecto=?";

        try (Connection connection = Conexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, proyecto.getNombre());
            preparedStatement.setString(2, proyecto.getDescripcion());
            preparedStatement.setDate(3, Date.valueOf(proyecto.getFechaInicio()));
            preparedStatement.setInt(4, proyecto.getIdProyecto());

            int filas = preparedStatement.executeUpdate();
            if (filas > 0) resultado = "Modificado";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public String eliminarProyecto(int id) {
        String resultado = "No eliminado";
        String sql = "DELETE FROM proyectos WHERE id_proyecto = ?";

        try (Connection connection = Conexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, id);
            int filas = preparedStatement.executeUpdate();
            if (filas > 0) resultado = "Eliminado";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }
}