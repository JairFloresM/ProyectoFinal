
package Principal;

import java.sql.SQLException;

public class NewMain {

    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        ConectarBase conectar= new ConectarBase();
        conectar.conectarDB();
    }
    
}
