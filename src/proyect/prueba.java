/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
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
public class prueba {
    
    public static void main(String[] args) throws JDOMException, IOException{
        /*GeneraSoapBanco n=new GeneraSoapBanco();
        String id="2222";
        String noC="1111";
        String Tip="Gold";
        String name="Mario";
        String ap="reyes";
        String am="Dominguez";
        
       n.cabezera();
       n.soap();
       n.body();
       n.Usuario();
       n.IdUsuario(id);
       n.Cuenta(noC);
       n.tipoCta(Tip);
       n.FinUsuario();
       n.persona();
       n.nombre(name);
       n.ApellidoP(ap);
       n.ApellidoM(am);
       n.Finpersona();
       n.finBody();
       n.finSoap();
       n.finCabezera();
       */
           File XmlFile = new File("Banco.xml");
                    SAXBuilder db = new SAXBuilder();
                    Document dc = db.build(XmlFile);
                    XMLOutputter output = new XMLOutputter();
                    //imprime en pantalla el documento
                   //output.output(dc,System.out);

                    //obtiene al padre wsdl
                    
                    
                    
                    
      
                    Element root=dc.getRootElement();
                    Namespace ns=root.getNamespace();
                    Namespace sobre=root.getNamespace("http:www.nada.com");
                    
                    System.out.println(root);
                    
                    Element body=root.getChild("Body", ns);
                        Element us=body.getChild("usuario");
                        Element id=us.getChild("NoCuenta");
                         
                            String tipo=id.getText();
                            System.out.println(tipo);
                        
                    
                    


    }
}
