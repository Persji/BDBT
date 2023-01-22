package bdbt_bada_project.SpringApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
@Repository
public class DomyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public DomyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Domy> list() {
        String sql = "SELECT * FROM DOMY_SENIORA";
        List<Domy> listDomy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Domy.class));
        return listDomy;
    }

    public void save(Domy domy) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("domy_seniora").usingColumns("nazwa", "data_zalozenia", "wlasciciel", "id_adresu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(domy);
        insertActor.execute(param);
    }
    /* Read – odczytywanie danych z bazy */
    public Domy get(int id) {
        String sql = "SELECT * FROM DOMY_SENIORA WHERE id_domu = ?";
        Object[] args = {id};
        Domy domy = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Domy.class));
        return domy;
    }

    public Domy get1(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM DOMY_SENIORA WHERE id_domu = " + args[0];
        Domy domy = jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Domy.class));
        return domy;
    }
    /* Update – aktualizacja danych */
    public void update(Domy domy) {
        String sql = "UPDATE DOMY_SENIORA SET nazwa=:nazwa, data_zalozenia=:data_zalozenia, wlasciciel=:wlasciciel, id_adresu=:id_adresu WHERE id_domu=:id_domu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(domy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);

    }
    public void delete(int id) {
        String sql = "DELETE FROM DOMY_SENIORA WHERE id_domu = ?";
        jdbcTemplate.update(sql,id);
    }


}
