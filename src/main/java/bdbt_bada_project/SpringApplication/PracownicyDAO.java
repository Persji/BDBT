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
public class PracownicyDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public PracownicyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Pracownicy> list(){
        String sql = "SELECT * FROM PRACOWNICY";
        System.out.println(sql);
        List<Pracownicy> listPracownicy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return listPracownicy;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Pracownicy pracownicy) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("pracownicy").usingColumns("imie","nazwisko","data_urodzenia","plec","stanowisko",
                "placa","adres_email","telefon","data_zatrudnienia","data_zwolnienia","id_domu","id_adresu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
        insertActor.execute(param);
    }
    /* Read – odczytywanie danych z bazy */
    public Pracownicy get(int id) {
        String sql = "SELECT * FROM PRACOWNICY WHERE id_pracownika = ?";
        Object[] args = {id};
        Pracownicy pracownicy = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return pracownicy;
    }

    public Pracownicy get1(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM PRACOWNICY WHERE id_pracownika = " + args[0];
        Pracownicy pracownicy = jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return pracownicy;
    }
    /* Update – aktualizacja danych */
    public void update(Pracownicy pracownicy) {
        String sql = "UPDATE PRACOWNICY SET imie=:imie, nazwisko=:nazwisko, data_urodzenia=:data_urodzenia, plec=:plec, stanowisko=:stanowisko," +
                "placa=:placa, adres_email=:adres_email, telefon=:telefon, data_zatrudnienia=:data_zatrudnienia, data_zwolnienia=:data_zwolnienia," +
                "id_domu=:id_domu, id_adresu=:id_adresu WHERE id_pracownika=:id_pracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);

    }
    public void delete(int id) {
        String sql = "DELETE FROM PRACOWNICY WHERE id_pracownika = ?";
        jdbcTemplate.update(sql,id);
    }

}
