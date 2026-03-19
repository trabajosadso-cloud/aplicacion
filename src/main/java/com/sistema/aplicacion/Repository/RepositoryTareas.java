package com.sistema.aplicacion.Repository;import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sistema.aplicacion.BD.Conexion;
import com.sistema.aplicacion.Model.TablaTareas;

public class RepositoryTareas {

    public String insertarTarea(TablaTareas tarea) {
        String resultado = "No guardado";
        String sql = "INSERT INTO tareas (descripcion, estado, id_proyecto, id_responsable) values (?,?,?,?)";

        try (Connection connection = Conexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, tarea.getDescripcion());
            preparedStatement.setString(2, tarea.getEstado());
            preparedStatement.setInt(3, tarea.getIdProyecto());
            // Aplicando tu corrección de String a int para el ID Responsable
            preparedStatement.setInt(4,(tarea.getIdResponsable()));

            preparedStatement.executeUpdate();
            resultado = "Guardado";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public List<TablaTareas> mostrarTareas() {
        String sql = "SELECT * FROM tareas";
        List<TablaTareas> misTareas = new ArrayList<>();

        try (Connection connection = Conexion.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                TablaTareas tareaActual = new TablaTareas();
                tareaActual.setIdTarea(resultSet.getInt("id_tarea"));
                tareaActual.setDescripcion(resultSet.getString("descripcion"));
                tareaActual.setEstado(resultSet.getString("estado"));
                tareaActual.setIdProyecto(resultSet.getInt("id_proyecto"));
                tareaActual.setIdResponsable(resultSet.getInt("id_responsable"));
                misTareas.add(tareaActual);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return misTareas;
    }

    public String modificarTarea(TablaTareas tarea) {
        String resultado = "No modificado";
        String sql = "UPDATE tareas SET descripcion=?, estado=?, id_proyecto=?, id_responsable=? WHERE id_tarea=?";

        try (Connection connection = Conexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, tarea.getDescripcion());
            preparedStatement.setString(2, tarea.getEstado());
            preparedStatement.setInt(3, tarea.getIdProyecto());
            preparedStatement.setInt(4, (tarea.getIdResponsable()));
            preparedStatement.setInt(5, tarea.getIdTarea());

            int filas = preparedStatement.executeUpdate();
            if (filas > 0) resultado = "Modificado";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public String eliminarTarea(int id) {
        String resultado = "No eliminado";
        String sql = "DELETE FROM tareas WHERE id_tarea = ?";

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