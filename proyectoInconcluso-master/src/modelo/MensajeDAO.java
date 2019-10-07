/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Casa
 */
public class MensajeDAO {
    Conexion con;

    public MensajeDAO() {
        this.con = new Conexion();
    }
    public Mensaje getMensaje(int idMen) {
        Connection accesoBD = con.getConexion();
        Mensaje m = null;

        try {
            String sql = "SELECT * FROM mensaje WHERE id_mensaje='" + idMen + "'";
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
            while (resultados.next()) {
                int id_mensaje = resultados.getInt("id_mensaje");
                String contenido = resultados.getString("contenido");
                int id_usr_emisor = resultados.getInt("id_usr_emisor");
                int id_usr_receptor = resultados.getInt("id_usr_receptor");
                m = new Mensaje(id_mensaje, contenido, id_usr_emisor, id_usr_receptor);
            }

            return m;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Mensaje> getMensajes() {

        ArrayList<Mensaje> Mensajes = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM mensaje;";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                int id_mensaje = resultados.getInt("id_mensaje");
                String contenido = resultados.getString("contenido");
                int id_usr_emisor = resultados.getInt("id_usr_emisor");
                int id_usr_receptor = resultados.getInt("id_usr_receptor");

                mensajes.add(new Mensaje(id_mensaje, id_usr_emisor, id_usr_receptor, contenido));
            }
            return Mensajes;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }

   
    
     public boolean insertarMensaje(Mensaje m) {
        Connection accesoBD = con.getConexion();

        try {
            String sql = "INSERT INTO venta(sucursal,monto,fecha,id_vendedor) VALUES ('" + m.getContenido() + "'," + m.getEmisor() + ",'" + m.getRemitente()  + ")";
            Statement st = accesoBD.createStatement();
            st.executeUpdate(sql); //Execute update es para modificar la BD y meter info

            return true;
        } catch (Exception e) {
            System.out.println("Error al insertar");
            e.printStackTrace();
            return false;
        }
        
      
    
}
}
