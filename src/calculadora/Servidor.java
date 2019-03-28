
package calculadora;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Servidor {
    public static void main(String[] args) throws IOException {
  double resultado = 0 ;
  double as,ar;
  String p,x,g;
                    
			//Creando socket servidor	
			ServerSocket serverSocket=new ServerSocket();

			
			InetSocketAddress addr=new InetSocketAddress("localhost",6666);
			serverSocket.bind(addr);

			//Aceptando conexiones
			Socket newSocket= serverSocket.accept();
			InputStream is=newSocket.getInputStream();
			OutputStream os=newSocket.getOutputStream();                        
			
                       
                           byte[] mensaje1=new byte[11];
                           byte[] mensaje2=new byte[11];
                           byte[] mensaje3=new byte[11];
			is.read(mensaje1);
                         is.read(mensaje2);
                         is.read(mensaje3);
                        g= new String(mensaje1);
                          as=Double.parseDouble(g);
			System.out.println("Mensaje recibido: "+g);
                        
                     
                        p= new String(mensaje2);
			System.out.println("Mensaje recibido: "+p);
                       
                        x= new String(mensaje3);
                        ar=Double.parseDouble(x);
			System.out.println("Mensaje recibido: "+x);
                      
                    
                       switch(p){
                           case "Sumar":
                               resultado=as+ar;
                               System.out.println("loco"+resultado);
                               break;
                                case "Restar":
                               resultado=as-ar;
                               break;
                                case "Multiplicar":
                               resultado=as*ar;
                               break;
                                case "Dividir":
                               resultado=as/ar;
                               break;
                                case "Raíz cuadrada":
                               resultado=as;
                                  break;
                                case "":
                               String pepito="Gracias por utilizar la aplicacion";
                                 break;   
                       }
                        String hy=resultado+"";
			os.write(hy.getBytes());
			System.out.println("Cerrando el nuevo socket");

			newSocket.close();
                       
			System.out.println("Cerrando el socket servidor");

			serverSocket.close();

			System.out.println("Terminado");
                     
    }}

