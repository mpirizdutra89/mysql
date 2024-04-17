/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import controlador.Db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nicolas
 */
public class Productos {
    private int id;
    private String nombre;
    private Double precio;

    public Productos(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public Productos(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Productos{" + " nombre=" + nombre + ", precio=" + precio + '}';
    }
    
    
    public ArrayList<Productos> getAll() {
        ArrayList<Productos> lista = new ArrayList<>();
        try {
          
                ResultSet res = Db.consulta("SELECT * FROM productos;");
                if (res != null) {
                    while (res.next()) {
                        id = res.getInt("id");
                        nombre = res.getString("nombre");
                        precio = res.getDouble("precio");
                        lista.add(this);
                    }
                }
            
        } catch (SQLException e) {
            //
        }
         Db.getDesconexion();
        return lista;
    }
    
    public void mostrar(){
         ArrayList<Productos> lista =getAll();
         for (Productos productos : lista) {
             System.out.println(productos);
        }
    }
    
    
}
