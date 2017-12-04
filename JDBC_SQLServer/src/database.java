import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {

	public static void main(String[] args) {
		
		
		String connectionUrl = "jdbc:sqlserver://;database=PBD;integratedSecurity=true;";
		
		Connection conn = null;
		
		try {
			
			conn = DriverManager.getConnection(connectionUrl);
			
			if( conn != null ){
				System.out.println( "Conexi�n realizada con �xito" );
				
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("  Driver name: " + dm.getDriverName());
                System.out.println("  Driver version: " + dm.getDriverVersion());
                System.out.println("  Product name: " + dm.getDatabaseProductName());
                System.out.println("  Product version: " + dm.getDatabaseProductVersion());
			}
			
		} catch (SQLException e) {
			
			System.err.println( "ERROR: No se ha podido establecer la conexi�n a la base de datos" );
			e.printStackTrace();
			
		} finally {
			
            try {
                if( conn != null && !conn.isClosed() ){
                    conn.close();
    				System.out.println( "Conexi�n finalizada con �xito" );
                }
            } catch (SQLException ex) {
    			System.err.println( "ERROR: No se ha podido cerrar la conexi�n a la base de datos" );
                ex.printStackTrace();
            }
            
        }
		
	}

}