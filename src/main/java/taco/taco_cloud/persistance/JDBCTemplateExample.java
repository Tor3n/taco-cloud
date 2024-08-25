package taco.taco_cloud.persistance;

import org.springframework.jdbc.core.JdbcTemplate;
import taco.taco_cloud.components.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JDBCTemplateExample {
    private JdbcTemplate jdbcTemplate;

    public Optional<Ingredient> findById(String id){
        List<Ingredient> results = jdbcTemplate.query("select id, name, type from Ingredint where id=?", this::mapRowToIngredint, id);
        return results.size() ==0 ? Optional.empty():Optional.of(results.get(0));
    }

    private Ingredient mapRowToIngredint(ResultSet row, int rowNum) throws SQLException{
        return new Ingredient(row.getString("id"), row.getString("name"), Ingredient.Type.valueOf(row.getString("type")));
    }
}
