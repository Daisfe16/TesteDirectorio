/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testedirectorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Isaias
 */
public class Directorio {
   private Cliente cliente;
   private String telefono;
   private TreeMap<String,Cliente> directorio=new TreeMap<>();

    public TreeMap<String, Cliente> getDirectorio() {
        return directorio;
    }

    public void setDirectorio(TreeMap<String, Cliente> directorio) {
        this.directorio = directorio;
    }
    
   public boolean agregarCliente(String tel,Cliente cliente){
      return directorio.put(tel, cliente)==null;
   }
   public Cliente buscarCliente(String telefono){
    if(directorio.containsKey(telefono)){
        return directorio.get(telefono);
    }else{
         
        return null;       
   }
   }
   public ArrayList<String>buscarTelefono(String apellido){
   ArrayList<String>numerosdevueltos= new ArrayList();
   Set<String> claves=directorio.keySet();
        for(String clave: claves){
           Cliente cliente=directorio.get(clave);
        if(cliente.getApellido().equals(apellido)){
           numerosdevueltos.add(clave);
           }
        }
    return numerosdevueltos;
   }
   public ArrayList<Cliente> BuscarClientes(String ciudad){
       ArrayList<Cliente> listaClientes=new ArrayList<>();
       Set<String> claves = directorio.keySet();
        for(String clave:claves){
           Cliente c=directorio.get(clave);
            if(c.getCiudad().equals(ciudad)){
                listaClientes.add(c);               
            }                    
       }
       return listaClientes;
   }
   public TreeMap<String,Cliente> borrarCliente(long dni){
     
        TreeMap<String,Cliente> clienteBorrado=new TreeMap<>();
        
        Set<String> claves=directorio.keySet();
        
        for(String clave:claves){
        
            Cliente c=directorio.get(clave);
            if(c.getDni()==(dni)){
                 
               clienteBorrado.put(clave,c);
                directorio.remove(clave);
                return clienteBorrado;
            }
        
        }
        return clienteBorrado;
    }
}

