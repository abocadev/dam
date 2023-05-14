package Ejercicio2;

import java.io.Serializable;

public class Pais implements Serializable {
	private String nombre;
	private int habitantes;
	private int pib;
	private String continente;

	public Pais(String nombre, int habitantes, String continente, int pib) {
		this.nombre = nombre;
		this.habitantes = habitantes;
		this.continente = continente;
		this.pib=pib;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getHabitantes() {
		return habitantes;
	}
	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}
	public String getContinente() {
		return continente;
	}
	public void setContinente(String continente) {
		this.continente = continente;
	}
	public int getPIB() {
		return pib;
	}
	public void setPIB(int pib) {
		this.pib = pib;
	}
}