/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;

import java.util.ArrayList;

import modelos.Productos;
import persistencia.Db;
import persistencia.DbProducto;
import persistencia.Mysql;

/**
 *
 * @author nn
 */
public class Main {

    public static void main(String[] args) {
       
        System.out.println("Listado de prodcuto");
        mostrar(DbProducto.getAll());
       
        System.out.println("Buscar producto por id");
        Productos producto=DbProducto.getById(1);
        System.out.println(producto);
        
        System.out.println("Hay errores?"); 
        Db.mostrarErrores();
        
    }

    public static void mostrar(ArrayList<Productos> lista) {

        if (lista.size() > 0) {
            for (Productos productos : lista) {
                System.out.println(productos);
            }
        } else {
            System.out.println("No hay productos para motrar.");
        }

    }

}
