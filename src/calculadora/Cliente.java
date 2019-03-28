
package calculadora;

import java.awt.Component;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Cliente {
    
    public static void main(String[] args) throws IOException, InterruptedException {
                  
			//Creando socket cliente
			Socket clienteSocket=new Socket();
			//Estableciendo conexion			
			InetSocketAddress addr=new InetSocketAddress("localhost",6666);
			clienteSocket.connect(addr);

			InputStream is = clienteSocket.getInputStream();
			OutputStream os= clienteSocket.getOutputStream();
			
                        int r = 0;
                    int p = 0;
        try{
        r=Integer.parseInt(JOptionPane.showInputDialog("Por favor, meta o numero para a seguinte operacion"));
        }catch(NumberFormatException excepcion){
            System.out.println("No es un numero"); 
           
        }
        
      Object seleccion = JOptionPane.showInputDialog(null,"Qué operacion quiere realizar?", "        CUADRO DE OPERACIONES",
   JOptionPane.QUESTION_MESSAGE,
   null,new Object[] { "Sumar", "Restar", "Multiplicar","Dividir","Raíz Cuadrada","NADA" }, 
   "NADA");
        
        
        
      if(seleccion=="Sumar"||seleccion=="Restar"||seleccion=="Multiplicar"||seleccion=="Dividir"){
        p=Integer.parseInt(JOptionPane.showInputDialog("Por favor, meta o numero para a seguinte operacion"));
      }
    
        String numer=r+"";
        String numero=p+"";
       String selecion= (String) seleccion;
            os.write(numer.getBytes());
            os.write(selecion.getBytes());            
            os.write(numero.getBytes());
            byte[] resultado=new byte[25];
            is.read(resultado);
            String g= new String(resultado);
            System.out.println("El resultado es:"+g);
            
        clienteSocket.close();
        //cierro el socket
    }
   
}
