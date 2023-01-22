package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.parameters.P;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PracownicyDAOTest {

	private PracownicyDAO dao;
	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
		datasource.setUsername("BDBTGRC03");
		datasource.setPassword("BDBTGRC03");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		dao = new PracownicyDAO(new JdbcTemplate(datasource));
	}
	@Test
	void testList() {
		List<Pracownicy> listPracownicy = dao.list();
		System.out.println(listPracownicy.get(0));
		assertTrue(listPracownicy.isEmpty());
	}
	@Test
	void testSave() {
		Pracownicy pracownicy = new Pracownicy(3,"Waclaw","Czwarty","12/ 2 /24","M",
				"robotnik",200,"walcaw@o2.pl","123456789","13/3/25",
				"14/4/27",1,2);
		dao.save(pracownicy);
	}
	@Test
	void testGet() {
		int id = 22;
		Pracownicy pracownicy = dao.get(id);
		assertNotNull(pracownicy);
	}

	@Test
	void testUpdate() {
		Pracownicy pracownicy = new Pracownicy();
		pracownicy.setId_pracownika(28);
		pracownicy.setImie("Konrad");
		pracownicy.setNazwisko("Wadziszewska");
		pracownicy.setData_urodzenia("01/1/03");
		pracownicy.setPlec("M");
		pracownicy.setStanowisko("Bramkarz");
		pracownicy.setPlaca(4000);
		pracownicy.setAdres_email("niewiem@gmail.com");
		pracownicy.setTelefon("321321321");
		pracownicy.setData_zatrudnienia("20/3/4");
		pracownicy.setData_zwolnienia("21/3/4");
		pracownicy.setId_domu(1);
		pracownicy.setId_adresu(1);

		dao.update(pracownicy);
	}

	@Test
	void testDelate() {
		int id = 27;
		dao.delete(id);
	}
}
