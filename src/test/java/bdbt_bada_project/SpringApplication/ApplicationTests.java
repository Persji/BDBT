package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.parameters.P;

import java.util.List;

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
//	@Test
//	void testGet() {
//
//	}
//
//	@Test
//	void testUpdate() {
//
//	}
//
//	@Test
//	void testDelate() {
//
//	}
}
