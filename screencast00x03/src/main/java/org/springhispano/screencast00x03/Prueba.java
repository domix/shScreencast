package org.springhispano.screencast00x03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

public class Prueba {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dataSource-context.xml");
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		
		
		
		String insertParametrizado = "INSERT INTO PERSON VALUES (?,?,?)";
		try {
			jdbcTemplate.update(insertParametrizado, new Object[] {3, "Jorge", "Rodriguez"});
		} catch (DuplicateKeyException e) {
			System.out.println("Ya existe el id en la base de datos.");
		}
		
		int numeroPersonas = jdbcTemplate.queryForInt("select count (*) from person");
		System.out.println("Existen " + numeroPersonas +  " personas en la base de datos.");
		
		//HSQLDB SHUTDOWN
		jdbcTemplate.execute("SHUTDOWN");
	}
}
