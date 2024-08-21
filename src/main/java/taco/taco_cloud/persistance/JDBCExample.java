package taco.taco_cloud.persistance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import taco.taco_cloud.components.Ingredient;

import java.sql.*;
import java.util.Optional;

@Slf4j
@Component
public class JDBCExample {
    String dbURL = "jdbc:oracle:thin:main/main@localhost:1521:orcl";

    public JDBCExample() {
        //Class.forName("oracle.jdbc.OracleDriver");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(dbURL);
            statement = connection.prepareStatement("Select * from test_tbl");

            resultSet = statement.executeQuery();
            Ingredient ingredient = null;

            while(resultSet.next()){
                //Display values
                System.out.println("___ ID: " + resultSet.getInt("id"));
                log.info("___ ID: " + resultSet.getInt("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {


                try {
                    resultSet.close();
                } catch (SQLException e) {
                }
            }


            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }


            }

        }


    }

    public Optional<Ingredient> findById(String id) throws ClassNotFoundException {
        //Class.forName("oracle.jdbc.OracleDriver");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;


        try {
            connection = DriverManager.getConnection(dbURL);
            statement = connection.prepareStatement("select id, name, type from Ingredient where id=?");

            statement.setString(1, id);
            resultSet = statement.executeQuery();
            Ingredient ingredient = null;


            if (resultSet.next()) {
                ingredient = new Ingredient(
                        resultSet.getString("id"),
                        resultSet.getString("name"),


                        Ingredient.Type.valueOf(resultSet.getString("type")));
            }
            return Optional.of(ingredient);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {


                try {
                    resultSet.close();
                } catch (SQLException e) {
                }
            }


            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }


            }

        }
        return null;
    }
}