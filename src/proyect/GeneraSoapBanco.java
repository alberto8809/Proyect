/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;

import java.io.FileNotFoundException;
import java.util.Formatter;


class GeneraSoapBanco {
     public Formatter escritor;
    public Formatter escritor2;
    public GeneraSoapBanco(){
    try
	     {
	     escritor =new Formatter("m1.xml");
             
         }
         catch(FileNotFoundException e)
         {
         	System.out.println(e.getMessage());
         }
    }
    
    
     public void cabezera(){
        
	  
             escritor.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
	
    }
     
     public void soap(){
        
	  
             escritor.format("\n<soap:Envelope xmlns:soap=\"http:www.nada.com\">");
	
    }
     
    
     
     public void body(){
        
	  
             escritor.format("\n\n\t<soap:Body>");
	
    }
    public void Usuario(){
             escritor.format("\n\t\t<usuario>");
    }
     
     public void IdUsuario(String n){
        
	  
             escritor.format("\n\t\t\t<IdUsuario>"+n+"</IdUsuario>");
	
    }
    
        
     public void Cuenta(String c){
        
	  
             escritor.format("\n\t\t\t<NoCuenta>"+c+"</NoCuenta>");
	
    }
     
     
     
     public void tipoCta(String c){
        
	  
             escritor.format("\n\t\t\t<TipoCuenta>"+c+"</TipoCuenta>");
	
    }
    public void FinUsuario(){
             escritor.format("\n\t\t</usuario>");
    }
     
     
     public void persona(){
        
	  
             escritor.format("\n\t\t<Persona>");
	
    }
    public void nombre(String c){
        
	  
             escritor.format("\n\t\t\t<Nombre>"+c+"</Nombre>");
	
    }
    
    public void ApellidoP(String c){
        
	  
             escritor.format("\n\t\t\t<ApellidoP>"+c+"</ApellidoP>");
	
    } 
     
    public void ApellidoM(String c){
        
	  
             escritor.format("\n\t\t\t<ApellidoM>"+c+"</ApellidoM>");
	
    }  
    public void Finpersona(){
        
	  
             escritor.format("\n\t\t</Persona>");
	
    }
     
     
     
     public void finBody(){
        
	  
             escritor.format("\n\t</soap:Body>\n");
	
    }
    
      public void finSoap(){
        
	  
             escritor.format("\n</soap:Envelope>\n");
	
    }
     
      public void finCabezera(){
      
         
	     escritor.close();
    }
    
   
}
