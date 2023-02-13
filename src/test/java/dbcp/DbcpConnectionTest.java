package dbcp;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.zaxxer.hikari.HikariDataSource;

import dbcp.HikariCpConnectionPool;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DbcpConnectionTest {
	
	HikariCpConnectionPool dbcp = new HikariCpConnectionPool();
	
	@Test
	public void getDataSourceTest() {
		HikariDataSource ds = dbcp.getHikariDataSource(); 
		
		assertNotNull(ds);
		log.info(ds);
		
		log.info("Hikari max pool size: " + ds.getMaximumPoolSize());
		log.info("Idle timeout: " + ds.getIdleTimeout()); // 얼마나 놀면 사라지나
		log.info("Minimum idle size: " + ds.getMinimumIdle());
		
		try (
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees");
			ResultSet rs = pstmt.executeQuery();
		) {
			while(rs.next()) {
				log.info("{} {} / {}",
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("job_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
