
package calculadora;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    
    public static void main(String[] args) throws IOException {
  double resultado = 0;
  double as,ar;
  String p,x,g,hy = null;
                    
			//Creando socket servidor	
			ServerSocket serverSocket;
                        serverSocket = new ServerSocket();

			
			InetSocketAddress addr=new InetSocketAddress("localhost",6666);
			serverSocket.bind(addr);
                        
			//Aceptando conexiones
			Socket newSocket= serverSocket.accept();
			InputStream is=newSocket.getInputStream();
			OutputStream os=newSocket.getOutputStream();                        
			
                       
                           byte[] mensaje1=new byte[14];
                           byte[] mensaje2=new byte[14];
                           byte[] mensaje3=new byte[14];
			 is.read(mensaje1);
                         os.write("Recibido".getBytes());
                         is.read(mensaje2);
                         os.write("Recibido2".getBytes());
                         is.read(mensaje3);
                          os.write("Recibido3".getBytes());
                        
                        g= new String(mensaje1);
                          as=Double.parseDouble(g);
			System.out.println("Mensaje recibido: "+g);
                        
                     
                        p= new String(mensaje2);
			System.out.println("Mensaje recibido: "+p);
                       
                        x= new String(mensaje3);
                        ar=Double.parseDouble(x);
			System.out.println("Mensaje recibido: "+x);
                      
                            if(p.contains("Sumar")){
                               resultado=as+ar;
                               hy=resultado+"";
                            }
                            else if(p.contains("Restar")){
                               resultado=as-ar;
                                hy=resultado+"";
                            }
                            else if(p.contains("Multiplicar")){
                               resultado=as*ar;
                                hy=resultado+"";
                            }
                            else if(p.contains("Dividir")){
                                if(ar==0){
                                    System.out.println("Division por cero infinito");
                                    hy="La division entre cero no es una operacion aceptada, ERROR LÓGICO";
                                    if(as==0){
                                        System.out.println("división entre ceros");    
                                        hy="La division entre ceros da un resultado nulo";
                                            }
                                }
                                else{
                               resultado=as/ar;
                                hy=resultado+"";
                                }
                            }
                            else if(p.contains("Raíz")){
                                if(as<0){
                                    System.out.println("El numero es negativo y por lo tanto es imposible su operación");
                                 resultado=as;
                                  hy="El error es en la raíz del numero: "+resultado+"\n disculpe las molestias";
                                }else{
                               resultado=Math.sqrt(as);  
                                hy=resultado+"";
                                }
                            }
                 System.out.println(hy);
			os.write(hy.getBytes());
			System.out.println("Cerrando el nuevo socket");

			newSocket.close();
                       
			System.out.println("Cerrando el socket servidor");

			serverSocket.close();

			System.out.println("Terminado");
                     
    }}

