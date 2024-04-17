/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;

/**
 *
 * @author nn
 */
public class Main {

   
    public static void main(String[] args) {
      Db.consulta("select usuario_id,grupos_idgrupos, usuario_nombre,usuario_password from usuarios;");
       // Db.servicioMysql();
       Db.getDesconexion();
    }
    
}
