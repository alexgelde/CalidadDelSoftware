package edu.ucam;

public class Ordenador {

	private String modelo;
	private String precio;
	
	public Ordenador(String modelo, String precio) {
		this.modelo =modelo;
		this.precio =precio;
		
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

}
