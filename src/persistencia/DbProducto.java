package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelos.Productos;

/**
 *
 * @author Martin
 */
public class DbProducto {

    private static Statement stmt;
    private static String tabla = "productos";
    private static Productos producto;
    static {
        inicializar();
    }

    public static void inicializar() {
        Mysql.tabla(tabla);
    }

    public static ArrayList<Productos> getAll() {
        ResultSet res = null;
        ArrayList<Productos> lista = new ArrayList<>();
        try {
           
            res = Db.consulta(Mysql.select);
            if (res != null) {
                while (res.next()) {

                    producto = new Productos();
                    producto.setId(res.getInt("id"));
                    producto.setNombre(res.getString("nombre"));
                    producto.setPrecio(res.getDouble("precio"));
                    lista.add(producto);

                }
            }

        } catch (SQLException ex) {
            Db.msjError.add("fallo la consulta: " + ex.getMessage());
        }
        Db.getDesconexion();
        return lista;
    }

  
    
    
     public static Productos getById(int id) {
        ResultSet res = null;
        
        try {
           
            res = Db.consulta( Mysql.SelectWhere + " id=" + id);
            if (res != null) {
                while (res.next()) {

                    producto = new Productos();
                    producto.setId(res.getInt("id"));
                    producto.setNombre(res.getString("nombre"));
                    producto.setPrecio(res.getDouble("precio"));
                   

                }
            }

        } catch (SQLException ex) {
            Db.msjError.add("fallo la consulta: " + ex.getMessage());
        }
        Db.getDesconexion();
        return producto;
    }
    

}
