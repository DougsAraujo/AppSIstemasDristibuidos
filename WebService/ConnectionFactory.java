package ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionFactory {

    private static Connection conn;

    private static final String dataBase = "ROOT.COMPRAS";

    private static final String dataBase2 = "ROOT.USUARIO";
    
    private static final String dataBase3 = "ROOT.COMPRA_USUARIO";
    
    public static Connection createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/COMPREFACIL;create=true;user=root;password=root;");
                    return conn;
        } catch (Exception except) {
            except.printStackTrace();
           
        }
        return null;
        
              
       }
    
      public static List<Compra_usuario> getAllCompras_Usuarios() {

        List<Compra_usuario> compras = null;
        Compra_usuario compra = null;

        try {

            PreparedStatement pre = conn.prepareStatement("select * from " + dataBase3);

            ResultSet results = pre.executeQuery();

            compras = new ArrayList<Compra_usuario>();

            while (results.next()) {

                compra = new Compra_usuario(results.getInt("id_usuario"), results.getString("usuario"), results.getString("produto"), 
                results.getString("data_compra"), results.getDouble("preco"), results.getString("endereco"));
                compras.add(compra);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return compras;
    }
    
    
    public static List<Compras> getAllCompras() {

        List<Compras> compras = null;
        Compras compra = null;

        try {

            PreparedStatement pre = conn.prepareStatement("select * from " + dataBase3);

            ResultSet results = pre.executeQuery();

            compras = new ArrayList<Compras>();

            while (results.next()) {

                compra = new Compras(results.getString("produto"), results.getInt("quantidade"), results.getDouble("preco"), results.getString("endereco"));
                compras.add(compra);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return compras;
    }

    public static Compras getCompraBuyId(Integer id) {

        Compras compra = null;

        try {

            PreparedStatement pre = conn.prepareStatement("select ID, produto, quantidade, preco from " + dataBase + " where ID=?");
            pre.setInt(1, id);

            ResultSet results = pre.executeQuery();

            while (results.next()) {

                compra = new Compras(results.getString("produto"), results.getInt("quantidade"), results.getDouble("preco"), results.getString("endereco"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return compra;

    }
    
        public static Usuario getLogin(String login, String senha) {

         Usuario user = null;
        try {
                
            PreparedStatement pre = conn.prepareStatement("select id,usuario, senha, endereco from " +dataBase2 +" where " + "USUARIO='" + login + "'" + "AND SENHA='"+ senha + "'");
            ResultSet results = pre.executeQuery();
            
             while (results.next()) {

               user = new Usuario(results.getInt("id"),results.getString("usuario"),results.getString("senha"),results.getString("endereco"));

             }
      
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;

    }

    public static void main(String[] args) {

    }

}
