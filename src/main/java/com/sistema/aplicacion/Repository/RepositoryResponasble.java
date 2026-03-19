package com.sistema.aplicacion.Repository;import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sistema.aplicacion.BD.Conexion;
import com.sistema.aplicacion.Model.TablaResponsable;

public class RepositoryResponasble {

    public String insertarResponsable(TablaResponsable responsable) {
        String resultado = "No guardado";
        String sql = "INSERT INTO responsables (nombres_completo, email, cargo) values (?,?,?)";

        try (Connection connection = Conexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, responsable.getNombresCompleto());
            preparedStatement.setString(2, responsable.getEmail());
            preparedStatement.setString(3, responsable.getCargo());

            preparedStatement.executeUpdate();
            resultado = "Guardado";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public List<TablaResponsable> mostrarResponsables() {
        String sql = "SELECT * FROM responsables";
        List<TablaResponsable> misResponsables = new ArrayList<>();

        try (Connection connection = Conexion.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                TablaResponsable responsableActual = new TablaResponsable();
                responsableActual.setIdResponsable(resultSet.getInt("id_responsable"));
                responsableActual.setNombresCompleto(resultSet.getString("nombres_completo"));
                responsableActual.setEmail(resultSet.getString("email"));
                responsableActual.setCargo(resultSet.getString("cargo"));
                misResponsables.add(responsableActual);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return misResponsables;
    }

    public String modificarResponsable(TablaResponsable responsable) {
        String resultado = "No modificado";
        String sql = "UPDATE responsables SET nombres_completo=?, email=?, cargo=? WHERE id_responsable=?";

        try (Connection connection = Conexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, responsable.getNombresCompleto());
            preparedStatement.setString(2, responsable.getEmail());
            preparedStatement.setString(3, responsable.getCargo());
            preparedStatement.setInt(4, responsable.getIdResponsable());

            int filas = preparedStatement.executeUpdate();
            if (filas > 0) resultado = "Modificado";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public String eliminarResponsable(int id) {
        String resultado = "No eliminado";
        String sql = "DELETE FROM responsables WHERE id_responsable = ?";

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