package Factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConexionBase {
	
	public DataSource dataSou;
	
	public ConexionBase() {
		ComboPooledDataSource comboPool = new ComboPooledDataSource();
		comboPool.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimezone=true&serverTimezone=UTC");
		comboPool.setUser("root");
		comboPool.setPassword("aguilareal");
		
		this.dataSou = comboPool;
		}
	
 public Connection conectarBase() {
	   try {
	       return this.dataSou.getConnection();
     } catch (SQLException e) {
     System.out.println("hubo un error fatality");
	throw new RuntimeException(e);
     }
 }
}
