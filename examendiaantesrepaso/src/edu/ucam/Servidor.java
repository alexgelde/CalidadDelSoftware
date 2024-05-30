package edu.ucam;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

public class Servidor {

	public Servidor() {
		// TODO Auto-generated constructor stub
	}
	
	private Hashtable<String , Ordenador> ordenadores = new Hashtable<>();
	
	public void ejecutar(){
		
		
		try {
			
			Socket socket;
			ServerSocket serverSocket = new ServerSocket(5001);
			
			while(true) {
				socket = serverSocket.accept();
				
				HiloServidor hs = new HiloServidor(socket, this);
				hs.start();
				//new HiloServidor(socket, this);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public static void main(String[] args) {
		
		Servidor servidor = new Servidor();
		servidor.ejecutar();

	}
	
	public String verOrdenador(String id) {
	
		if(this.ordenadores.get(id)!=null) {
			return "El ordenador "+this.ordenadores.get(id).getModelo()+"cuesta " +this.ordenadores.get(id).getPrecio();
		}else {
			return "El ordenador NO existe ";
		}
		
		
	}
	public void addOrdenador(String id, Ordenador ordenador) {
		this.ordenadores.put(id, ordenador);
	}
	
	public String modificar(String id, String mod) {
		
		this.ordenadores.get(id).setModelo(mod);
		
		return"El ordenador se ha modificado";
	}
	
	public String eliminar(String id) {
		
		if(this.ordenadores.get(id)!=null) {
			
			
			this.ordenadores.remove(id);
			return "El ordenador ha sido eliminado ";
		}else {
			return "El ordenador NO existe ";
		}
		
	}
}
