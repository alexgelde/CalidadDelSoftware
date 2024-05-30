package edu.ucam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public void ejecutar() {
		
		
		try {
		
			
			Socket socket = new Socket("localhost", 5001);
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
				pw.println("ADD 01 RYZEN 500"); pw.flush();
				System.out.println(bf.readLine());
				
				pw.println("VER 01 ");pw.flush();
				System.out.println(bf.readLine());
				
				pw.println("MOD 01 RYZEN2");pw.flush();
				System.out.println(bf.readLine());
			
				pw.println("VER 01 ");pw.flush();
				System.out.println(bf.readLine());
				
				pw.println("REMOVE 01 ");pw.flush();
				System.out.println(bf.readLine());
				
				pw.println("VER 01 ");pw.flush();
				System.out.println(bf.readLine());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	public static void main(String[] args) {
	
		(new Cliente()).ejecutar();

	}

}
