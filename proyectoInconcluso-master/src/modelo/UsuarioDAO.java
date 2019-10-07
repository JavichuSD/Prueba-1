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
public class UsuarioDAO {
    Conexion con;

    public UsuarioDAO() {
        this.con = new Conexion();
    }


    public Usuario getUsuario(int idUsua) {
        Connection accesoBD = con.getConexion();
        Usuario u = null;

        try {
            String sql = "SELECT * FROM vendedor WHERE id_usuario='" + idUsua + "'";
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
            while (resultados.next()) {
                int id_usuario=resultados.getInt("id_usuario");
                String nombre=resultados.getString("nombre");
               
                u= new Usuario(id_usuario,nombre);
            }
            
           return u; 
        } catch (Exception e) {
   System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
        
    }

    public ArrayList<Usuario> getUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      

   


}
