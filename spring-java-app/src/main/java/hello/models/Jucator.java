package hello;

import java.util.List;
import java.util.ArrayList;

public class Jucator{
		private String nume;
		private int id;
		private int varsta;

		public Jucator(){}
		
		public Jucator(int id,String nume,int varsta){
			this.nume=nume;
			this.id=id;
			this.varsta=varsta;
		}
		
		public String getNume(){
			return this.nume;
		}
		
		public int getId(){
			return this.id;
		}
		
		public int getAge(){
			return this.varsta;
		}
		}