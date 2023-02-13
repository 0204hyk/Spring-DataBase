package dbcp;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCpConnectionPool {
	
	public HikariDataSource getHikariDataSource() {
		HikariConfig config = new HikariConfig();
		
		config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
		config.setUsername("hr");
		config.setPassword("1234");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		
		return new HikariDataSource(config);
	}
	
	public void test() throws SQLException {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
		config.setUsername("hr");
		config.setPassword("1234");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

		// HikariDataSource에서 우리가 사용하던 java.sql.Connection을 꺼낼 수 있다.
		HikariDataSource ds = new HikariDataSource(config);
		
		// 하던대로 getConnection을 하면 java.sql.Connection 인스턴스가 나온다.
		Connection conn = ds.getConnection();
		
		// 닫아주면 연결을 끊어버리는 대신 HikariDataSource로 반환하는 것으로 구현되어 있다.
		conn.close();
	}
	
}
