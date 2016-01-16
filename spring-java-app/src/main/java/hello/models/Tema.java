package hello;

import java.util.List;
import java.util.ArrayList;

public class Tema{
	private String nume;
	private int id;
	private int nota;

	public Tema(){}
	
	public Tema(int id,String nume,int nota){
		this.nume=nume;
		this.id=id;
		this.nota=nota;
	}
	
	public String getNume(){
		return this.nume;
	}
	
	public float getId(){
		return this.id;
	}
	
	public int getNota(){
		return this.nota;
	}
}