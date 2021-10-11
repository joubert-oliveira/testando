package br.com.digitalschool.so.repository;

import br.com.digitalschool.so.DatabaseConnection;
import br.com.digitalschool.so.domain.Machine;
import br.com.digitalschool.so.domain.Streamer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StreamerRepository {

    private static List<Streamer> streamers = new ArrayList<>();

    public static List<Streamer> findByUsername(String username) {
        try {
        PreparedStatement preparedStatement = DatabaseConnection
                .getInstance()
                .getConnection()
                .prepareStatement("select * from streamer where username = (?)");

        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Streamer streamer = new Streamer(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        findMachines(resultSet.getInt("id"))
                );
                streamers.add(streamer);
            }

            return streamers;
        } catch (SQLException e) {
            e.printStackTrace();
            return streamers;
        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
    }

    public static List<Machine> findMachines(long id) {
        List<Machine> machines = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = DatabaseConnection
                    .getInstance()
                    .getConnection()
                    .prepareStatement("select * from machine where streamer_id = (?)");

            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                machines.add(new Machine());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return machines;
    }
}
