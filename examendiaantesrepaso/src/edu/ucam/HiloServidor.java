package edu.ucam;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class HiloServidor extends Thread {

	private Socket socket;
	private Servidor servidor;
	
	
	public HiloServidor(Socket socket, Servidor servidor) {
		this.servidor = servidor;
		this.socket = socket;
	}
	
	public void run() {
		try {
			
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
			BufferedReader br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			
			String lineaLeida= "";
			Ordenador ordenador = null;
			String respuesta = "";
			
			
			while(true) {
				lineaLeida = br.readLine();
				
				String partes[] = lineaLeida.split(" ");
				
				switch (partes[0]) {
				case "ADD":
					
					ordenador = new Ordenador(partes[2], partes[3]);
					 servidor.addOrdenador(partes[1], ordenador);
					 
					respuesta = "ADD OK";
					
					break;
				case "REMOVE":
					
					respuesta = servidor.eliminar(partes[1]);
					break;
					
				case "MOD":
					
					respuesta = this.servidor.modificar(partes[1], partes[2]);
					break;
				case "VER":
					
					respuesta = this.servidor.verOrdenador(partes[1]);
					break;

				default:
					break;
				}
				pw.println(respuesta);
				pw.flush();
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	

}
