/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;

import modelos.Productos;

/**
 *
 * @author nn
 */
public class Main {

   
    public static void main(String[] args) {
        Productos pro=new Productos();
        pro.mostrar();
        if(Db.msjError.size()>0){
            for (String arg : Db.msjError) {
                System.out.println(arg);
            }
        }
        //System.out.println( Db.msjError);
           
     
    }
    
}
