
package controlador;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author nn
 */
public class Db {
    
    public static Connection conec = null;
    private static final String host = "jdbc:mysql://localhost/";
    private static final String user = "root";
    private static final String pass = "nicolas89";
    private static  String bd= "pruebas";
    private static final String driver="com.mysql.cj.jdbc.Driver";
      public static ArrayList<String> msjError=new ArrayList<String>();
    
    public static boolean getConeccion() {
        boolean res=false;
        if (servicioMysql()) {

            try {
                Class.forName(driver);
                conec = DriverManager.getConnection(host + bd, user, pass);
                 res=true;
            } catch (NullPointerException | SQLException | ClassNotFoundException ex) {
               res=false;
                msjError.add("fallo de coneccion:" + ex.getMessage());
            }
        }
        return res;

    }

    public static boolean servicioMysql(){
        boolean res;
         String host = "localhost"; // Cambia esto si tu servidor MySQL está en otro host
        int puerto = 3306; // Puerto predeterminado de MySQL

        try {
            // Intenta conectarte al servidor MySQL
            Socket socket = new Socket(host, puerto);
            res=true;
            socket.close();
        } catch (Exception e) {
            res=false;
        }
        return res;
    }
    
    public static boolean getDesconexion(){
        boolean result;
        try {
            conec.close();
           // System.out.println("desconectado");
            conec=null;
            result=true;
        } catch (NullPointerException | SQLException ex) {
             
              msjError.add("fallo la desconexion: "+ex.getMessage());
             result=false;
        }
        return result;
    }
    
    //retorna un ResultSet
    public static ResultSet consulta(String sql) {
        ResultSet res = null;
        if (getConeccion()) {

            Statement stmt;

            try {
                stmt = conec.createStatement();
                res = stmt.executeQuery(sql);
               
              
            } catch (SQLException ex) {
                
                 msjError.add("fallo la consulta: "+ex.getMessage());
            }
            
        }
        return res;
    }
        //devulve 1 el usuario se borro o se actualizo depende de la consulta
    public static int actualizar(String sql) {
        int res = -1;
        if (getConeccion()) {

            Statement stmt;

            try {
                stmt = conec.createStatement();
                res = stmt.executeUpdate(sql);

            } catch (SQLException ex) {
              
                  msjError.add("fallo la actualizacion: "+ex.getMessage());
            }
            getDesconexion();
        }
        return res;
    }
    
    
   /* public static void prueba(ResultSet resultSet ) {
         ArrayList<Object> productos = new ArrayList<>();
         ResultSetMetaData metaData=null;
          int columnCount =0;
        try {
           
                metaData = resultSet.getMetaData();
                columnCount = metaData.getColumnCount();
                System.out.println(columnCount);
                while (resultSet.next()) {
                // Crear un objeto dinámicamente
                Object producto = createObjectDinamico(resultSet, metaData, columnCount);
                productos.add(producto);
            }
        } catch (SQLException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException e) {
            System.out.println(e.toString());
            System.out.println("Erroress");
        }
        
           for (Object producto : productos) {
            System.out.println(producto);
        }
    }
    
    
  public static Object createObjectDinamico(ResultSet resultSet, ResultSetMetaData metaData, int columnCount) throws SQLException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        // Obtener los nombres de las columnas y sus valores
        
        Object[] values = new Object[columnCount];
        for (int i = 1; i <= columnCount; i++) {
            values[i - 1] = resultSet.getObject(i);
        }
        
       
        // Obtener los nombres de las clases de los tipos de datos de las columnas
        Class<?>[] types = new Class<?>[columnCount];
        for (int i = 1; i <= columnCount; i++) {
            String typeName = metaData.getColumnClassName(i);
            types[i - 1] = getType(typeName);
        }
          Class<?> clazz = Class.forName(className);
        // Obtener el constructor de la clase
        Constructor<?> constructor = Object.class.getConstructor(types);
System.out.println("a"+columnCount);
        // Crear una instancia del objeto utilizando el constructor
        return constructor.newInstance(values);
    }

   public static Class<?> getType(String typeName) throws ClassNotFoundException {
        switch (typeName) {
            case "java.lang.Integer":
                return Integer.TYPE;
            case "java.lang.Double":
                return Double.TYPE;
            case "java.lang.String":
                return String.class;
            // Agregar más casos según sea necesario para otros tipos de datos
            default:
                return Class.forName(typeName);
        }
    }*/

}
