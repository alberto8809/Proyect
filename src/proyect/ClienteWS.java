/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;

import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import org.jdom2.JDOMException;

/**
 *
 * @author mario
 */
public class ClienteWS {
 
       public static void main(String[] args) throws JDOMException {
        
        
        // TODO code application logic hereSocket cliente = null;
	Socket cliente = null;
        int num,num2;
        String id;
        String funciones[];
        String funciones2[];
	String ipServidor ="172.16.1.154";	 
           
          Scanner entrada= new Scanner(System.in);  
          
          
          
          
	//Conexion
        try {	
 
            cliente = new Socket(ipServidor, 4020);  
         
/***************************************************************************************/
            /*Entradas y Salidas del socket de mensajes*/
            
            InputStream istream = cliente.getInputStream();
            ObjectInput in = new ObjectInputStream(istream);
            
            InputStream istream2 = cliente.getInputStream();
            ObjectInput in2 = new ObjectInputStream(istream2);
            
            OutputStream ostream2 = cliente.getOutputStream();
            ObjectOutput s2 = new ObjectOutputStream(ostream2);
            
/***************************************************************************************/
            /*Menu de opciones
            
            System.out.println("Menu de Servicios Web");
            System.out.println("1.- Banco");
            System.out.println("2.- Farmacia");
            System.out.print("Escoge la opcion: ");
            int op=entrada.nextInt();
            s2.writeObject(op);
            s2.flush();
            
/***************************************************************************************/
                /*Menu dinamico del parseo
                
            if(op==1){
                //lee el tamaño de las operaciones que envio el servidor
                num=(int) in.readObject();

                //lee el arreglo con las operaciones que envio el servidor
                funciones= (String[]) in.readObject();

                 System.out.println("Menu de opciones del servicio Banco\n");

                for(int i=0 ; i<num;i++){
                  System.out.println("\t"+i+ ".-"+funciones[i]);  
                }
                
                System.out.println("\nEscoge la opcion");
                int opcion=entrada.nextInt();
                 s2.writeObject(opcion);
                 s2.flush();
        /*************************************************************************************/
                    /*Opciones del menu
                    if(opcion==0){
                                                                     
                        System.out.print("Ingrese IdUsuario: ");
                        String p=entrada.next();
                        
                        s2.writeObject(p);
                        s2.flush();
                        
                        System.out.println("Datos de usuario");
                        String nombre= (String) in.readObject();
                        System.out.println("Nombre: "+nombre);
                        
                        String ap= (String) in.readObject();
                        System.out.println("Apellido Paterno: "+ap);
                        
                        String apM= (String) in.readObject();
                        System.out.println("Apellido Materno: "+apM);
                        
                    }else if(opcion==1){
                        System.out.println("Ingrese Tipo de Cuenta");
                        String us2=entrada.next();
                        s2.writeObject(us2);
                        s2.flush();
                        String cuenta=(String) in.readObject();
                        System.out.println("ID Cuenta: "+cuenta);
                        
                    }else if(opcion==2){
                        System.out.println("Ingrese Nombre de Usuario");
                        String us4=entrada.next();
                        s2.writeObject(us4);
                        s2.flush();
                        System.out.println("Ingrese primer Apellido de Usuario");
                        String us5=entrada.next();
                        s2.writeObject(us5);
                        s2.flush();
                        
                        String cuenta2=(String) in.readObject();
                        System.out.println("ID Cuenta: "+cuenta2);
                                             
                        
                    }else if(opcion==3){
                        System.out.println("Ingrese Numero de Cuenta");
                        String us4=entrada.next();
                        s2.writeObject(us4);
                        s2.flush();                       
                        System.out.println("Datos del Usuario");                        
                        String nombre7= (String) in.readObject();
                        System.out.println("Nombre: "+nombre7);                        
                        String ap7= (String) in.readObject();
                        System.out.println("Apellido Paterno: "+ap7);                        
                        String apM7= (String) in.readObject();
                        System.out.println("Apellido Materno: "+apM7);
                        
                        
                    }

  
        /**********************************************************************/
                    /*Servicio Farmaacia
            }else if(op==2){
            

                    //lee el tamaño de las operaciones que envio el servidor
                    num2=(int) in2.readObject();
                    //lee el arreglo con las operaciones que envio el servidor
                    funciones2= (String[]) in2.readObject();

                     System.out.println("Menu de opciones del servicio Farmacia\n");

                    for(int i=0 ; i<num2;i++){
                      System.out.println("\t"+i+ ".-"+funciones2[i]);  
                    }
                    
                    System.out.println("\nEscoge la opcion");
                    int opcion2=entrada.nextInt();
                    s2.writeObject(opcion2);
                    s2.flush();
                    if(opcion2==0){
                            System.out.println("Ingrese Precio");
                            String prec=entrada.next();
                            s2.writeObject(prec);

                            System.out.println("Datos del Producto");
                            String nombre9= (String) in.readObject();
                            System.out.println("Nombre: "+nombre9);
                            String compuesto= (String) in.readObject();
                            System.out.println("Compuesto: "+compuesto);
                        
                    }else if(opcion2==1){
                            System.out.println("Ingrese Nombre");
                            String nm=entrada.next();
                            s2.writeObject(nm);
                            System.out.println("Datos del Producto");
                            String nombre10= (String) in.readObject();
                            System.out.println("Compuestos: "+nombre10);
                            
                    }

            }*/

                
                
            
            
            
            cliente.close();
                
                

        }catch (UnknownHostException excepcion) {System.err.println("El servidor no está levantado");
        }catch (Exception e) {System.err.println("Error: " + e );}
 
                       
    }

}

