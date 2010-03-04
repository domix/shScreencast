package org.springhispano.screencast03;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JdbcEjemplo {
	public static String driverClassName = "org.hsqldb.jdbcDriver";
	public static String url = "jdbc:hsqldb:file:demo";
	public static String username = "sa";
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		if(jdbcTemplate == null) {
			jdbcTemplate = new JdbcTemplate();
			jdbcTemplate.setDataSource(getDataSource());
		}
		return jdbcTemplate;
	}

	public DataSource getDataSource() {
		if (dataSource == null) {
			BasicDataSource implDataSource = new BasicDataSource();
			implDataSource.setDriverClassName(driverClassName);
			implDataSource.setUrl(url);
			implDataSource.setUsername(username);
			implDataSource.setPassword("");
			implDataSource.setInitialSize(5);
			implDataSource.setMaxActive(10);
			dataSource = implDataSource;
		}
		return dataSource;
	}
	
	private void start() {
		//Para prevenir errores al crear la tabla mas abajo :)
		getJdbcTemplate().execute("drop table person IF EXISTS");
		
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE PERSON (");
		sb.append("  ID INTEGER NOT NULL PRIMARY KEY,");
		sb.append("  FIRST_NAME VARCHAR(20),");
		sb.append("  LAST_NAME VARCHAR(20)");
		sb.append(")");
		
		//Creamos la tabla
		getJdbcTemplate().execute(sb.toString());
		//el metodo execute, usa javax.sql.Statement
		
		String insertCodigoDuro = "INSERT INTO PERSON VALUES (1,'DOMINGO','SUAREZ')";
		String insertParametrizado = "INSERT INTO PERSON VALUES (?,?,?)";
		
		//el metodo update nos regresa el numero de registros afectados por el update
		// usa internamente un PreparedStatement
		int affectedRows = getJdbcTemplate().update(insertCodigoDuro);
		
		getJdbcTemplate().update(insertParametrizado, new Object[] {2, "JOSE JUAN", "REYES"});
		
		int numeroPersonas = getJdbcTemplate().queryForInt("select count (*) from person");
		System.out.println("Existen " + numeroPersonas +  " personas en la base de datos.");
		
		
		
		List<Person> personas = getJdbcTemplate().query("select * from Person", new RowMapper<Person>() {
			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person person = new Person();
				person.setId(rs.getInt("ID"));
				person.setNombre(rs.getString("FIRST_NAME"));
				person.setApellidos(rs.getString("LAST_NAME"));
				return person;
			}
		});
		
		for (Person person : personas) {
			System.out.println("Personas en la base de datos");
			System.out.println("\tID:" + person.getId());
			System.out.println("\tNombre:" + person.getNombre());
			System.out.println("\tApellidos:" + person.getApellidos());
		}
		
		//HSQLDB SHUTDOWN
		getJdbcTemplate().execute("SHUTDOWN");
	}

	public static void main(String[] args) {
		new JdbcEjemplo().start();
	}
}
