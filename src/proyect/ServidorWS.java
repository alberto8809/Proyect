/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author mario
 */
public class ServidorWS {
    
    
    public static void main(String args[]) throws JDOMException, ClassNotFoundException {
        ServerSocket mi_servicio2 = null;
        
        
        
        Socket socket_conectado = null;
        try {
            mi_servicio2 = new ServerSocket(2017);
        }
        catch (IOException excepcion) {
            System.out.println(excepcion);
        }
        try {
            socket_conectado = mi_servicio2.accept();
             OutputStream ostream = socket_conectado.getOutputStream();
            ObjectOutput s = new ObjectOutputStream(ostream);
            
            OutputStream ostream2 = socket_conectado.getOutputStream();
            ObjectOutput s2 = new ObjectOutputStream(ostream2);
            
            
            InputStream istream2 = socket_conectado.getInputStream();
            ObjectInput in2 = new ObjectInputStream(istream2);
                
            
             int op=(int)in2.readObject();
             /*********************************************************************/
                        /*Parseo para el menu dinamico*/
             if(op==1){

                    File XmlFile = new File("banco.wsdl");
                    SAXBuilder db = new SAXBuilder();
                    Document dc = db.build(XmlFile);
                    XMLOutputter output = new XMLOutputter();
                    //imprime en pantalla el documento
                   // output.output(dc,System.out);

                    //obtiene al padre wsdl
                    
                    Element root=dc.getRootElement();
                    Namespace ns=root.getNamespace();
                    Namespace soap=root.getNamespace("http://schemas.xmlsoap.org/wsdl/soap/");
                    
                    System.out.println(root);
                    //ubicamos alhijo en portType
                   Element hijo=root.getChild("portType",ns);
                   //System.out.println(hijo);
                   List row=hijo.getChildren("operation", ns);

                    //envia el tamaño de la lista al cliente
                    s.writeObject(row.size());
                    //crea arrgelo del tamaño de la opciones
                    String[] arr=new String[row.size()];


                    for(int i=0;i<row.size();i++){

                         Element infoElenemt=(Element)row.get(i);
                        String h=infoElenemt.getAttributeValue("name");
                        arr[i]=h;                        
                       
                    }
                   //envia el arreglo con todos los tipos de opciones
                   s.writeObject(arr);
                   s.flush();
                   
               /*******************************************************************/    
                        /*Operaciones con el menu*/
               
                 int opcionMenu=(int) in2.readObject();
                 
                 /*********************************************************************/
                                /*Servicio Banco*/
                                
                        if(opcionMenu==0){
                            File XmlFile3 = new File("Banco.xml");
                            SAXBuilder db3 = new SAXBuilder();
                            Document dc3 = db3.build(XmlFile3);
                            
                            Element root3=dc3.getRootElement();
                            Namespace ns2=root.getNamespace();
                    
                    
                            
                            Element hijo3=root3.getChild("usuario",ns2);
                            
                            Element hijoID=hijo3.getChild("IdUsuario",ns2);
                            String valor=hijoID.getText();
                            
                            String num2=(String) in2.readObject();
                            
                                if(valor.equals(num2)){
                                    Element hijoP=root3.getChild("Persona");

                                    Element name=hijoP.getChild("Nombre");
                                    String nombre=name.getText();
                                    s.writeObject(nombre);

                                    Element apellido=hijoP.getChild("ApellidoP");
                                    String ap=apellido.getText();
                                    s.writeObject(ap);

                                    Element apellidoM=hijoP.getChild("ApellidoM");
                                    String apM=apellidoM.getText();
                                    s.writeObject(apM);
                                    s.flush();
                                }
                            
                                                        
                        }else if(opcionMenu==1){
                            
                            File XmlFile4 = new File("Banco.xml");
                            SAXBuilder db4 = new SAXBuilder();
                            Document dc4 = db4.build(XmlFile4);
                            
                            Element root4=dc4.getRootElement();
                            
                            Element hijo4=root4.getChild("usuario");
                            
                            Element typeC=hijo4.getChild("TipoCuenta");
                            String tipo=typeC.getText();
                            
                            String cuenta=(String) in2.readObject();
                            
                            if(cuenta.equals(tipo)){
                                Element IDus=hijo4.getChild("IdUsuario");
                                String Id=IDus.getText();
                                s.writeObject(Id);
                                s.flush();
                            }
                            
                        }else if(opcionMenu==2){
                            File XmlFile5 = new File("Banco.xml");
                            SAXBuilder db5 = new SAXBuilder();
                            Document dc5 = db5.build(XmlFile5);
                            
                            Element root5=dc5.getRootElement();
                            
                            Element P=root5.getChild("Persona");
                            Element name=P.getChild("Nombre");
                            String nombreP=name.getText();
                            Element ap=P.getChild("ApellidoP");
                            String aP=ap.getText();
                                                  
                            
                            String nombre=(String) in2.readObject();
                            String apellido=(String) in2.readObject();
                            
                            if(nombreP.equals(nombre) && aP.equals(apellido)){
                            
                            Element hijo5=root5.getChild("usuario");
                            Element Id=hijo5.getChild("IdUsuario");
                            String idP=Id.getText();
                            s.writeObject(idP);
                            s.flush();
                            
                            }
                            
                        }else if(opcionMenu==3){
                            File XmlFile6 = new File("Banco.xml");
                            SAXBuilder db6 = new SAXBuilder();
                            Document dc6 = db6.build(XmlFile6);                            
                            Element root6=dc6.getRootElement();
                            
                            Element h=root6.getChild("usuario");
                            Element num=h.getChild("NoCuenta");
                            String n=num.getText();
                            
                            String NumC=(String) in2.readObject();
                            
                            
                            if(NumC.equals(n)){
                                Element Person=root6.getChild("Persona");

                                Element name=Person.getChild("Nombre");
                                String nombre=name.getText();
                                s.writeObject(nombre);

                                Element ap=Person.getChild("ApellidoP");
                                String aP=ap.getText();
                                s.writeObject(aP);

                                Element apM=Person.getChild("ApellidoM");
                                String aM=apM.getText();
                                s.writeObject(aM);
                                s.flush();
                            }
                        }                   
                        
            /*********************************************************************/           
                           /*Servicio Farmacia*/
                     
             }else if(op==2){
            /*********************************************************************/                
                        /*Menu dimanico del wsdl*/
            
                    File XmlFile2 = new File("farmacia.wsdl");
                    SAXBuilder db2 = new SAXBuilder();
                    Document dc2 = db2.build(XmlFile2);
                    XMLOutputter output2 = new XMLOutputter();
                    //imprime en pantalla el documento
                   // output.output(dc,System.out);

                    //obtiene al padre wsdl
                    Element root2=dc2.getRootElement();
                    System.out.println(root2);
                    //ubicamos alhijo en portType
                    Element hijo2=root2.getChild("portType");

                    //crea una lista con las operaciones
                    List row2=hijo2.getChildren("operation");

                    //envia el tamaño de la lista al cliente
                    s2.writeObject(row2.size());
                    //crea arrgelo del tamaño de la opciones
                    String[] arr2=new String[row2.size()];


                   for(int i=0;i<row2.size();i++){

                        Element infoElenemt2=(Element)row2.get(i);
                       String h2=infoElenemt2.getAttributeValue("name");
                       arr2[i]=h2;
                      // System.out.println(arr[i]);
                   }
                   //envia el arreglo con todos los tipos de opciones
                   s2.writeObject(arr2);
                   s2.flush();
                   
                   /**************************************************************/
                            /*Opciones del menu*/
                    int opcionMenuF=(int) in2.readObject();
                    
                    if(opcionMenuF==0){
                            File XmlFile7 = new File("Farmacia.xml");
                            SAXBuilder db7 = new SAXBuilder();
                            Document dc7 = db7.build(XmlFile7);                            
                            Element root7=dc7.getRootElement();
                            Element hijo7=root7.getChild("Producto");
                            Element precio=hijo7.getChild("Precio");
                            String precioC=precio.getText();
                            
                            String Precio=(String) in2.readObject();
                            
                            if(Precio.equals(precioC)){
                                
                                Element nombre=hijo7.getChild("Nombre");
                                String n=nombre.getText();
                                s.writeObject(n);
                                
                                Element com=hijo7.getChild("Compuesto");
                                String compuesto=com.getText();
                                s.writeObject(compuesto);
                                
                                s.flush();
                                
                            }
                            
                          
                        
                    }else if(opcionMenuF==1){
                            File XmlFile8 = new File("Farmacia.xml");
                            SAXBuilder db8 = new SAXBuilder();
                            Document dc8 = db8.build(XmlFile8);                            
                            Element root8=dc8.getRootElement();
                            Element hijo8=root8.getChild("Producto");
                            Element prec=hijo8.getChild("Nombre");
                            String p=prec.getText();
                            
                            String Pr=(String) in2.readObject();
                            if(Pr.equals(p)){
                                Element nombre=hijo8.getChild("Compuesto");
                                String n=nombre.getText();
                                s.writeObject(n);
                                s.flush();
                            }
                            
                    }
            
             }
            
            
             
            socket_conectado.close();
        }catch (IOException excepcion) {System.out.println(excepcion);}
    }


}
