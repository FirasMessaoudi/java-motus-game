package projectPoo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class GrilleLettre {
	private ArrayList <String>Grillemot=new ArrayList<String>();
	private final int taille=6;
	private int lang;
	public void Initialiser() throws IOException{
		for(int i=0;i<Tirermot().length()*5;i++)
			Grillemot.add(" "+"*"+" ");
	
	}
	
	
   
	public int getTaille() {
		return taille;
	}


	public void afficher() throws IOException{
		for (int i=0;i<Tirermot().length();i++)
		{
			System.out.println(Grillemot.get(i));
		}
	}
	
	public String Tirermot()throws IOException{ //Avoir un mot aleatoire a partir du fichier
		int cptmots = 0;
	    String motpropose = "";
	    File listemots = null;
	   try
	    {
	      if(lang==1)
	    	  listemots = new File("C:/bd/fr.txt");
	      else if(lang==2)
	    	  listemots = new File("C:/bd/ang.txt");
	      Scanner f1 = new Scanner(listemots);
	      Scanner f2 = new Scanner(listemots);
	      //compter le nombre de mots dans le fichier
	      String mot = "";
	      while (f1.hasNext())
	      {
	        mot = f1.next();
	        cptmots++;
	      }
	      
	  //avoir un mot au hasard du fichier
	      int cpt = 0;
	      int numalea = (int)(Math.random() * cptmots);
	      while (cpt < numalea)
	      {
	        f2.next();
	        cpt++;
	      }
	      motpropose = f2.next();
	      f1.close();
	      f2.close();
	    }
	   
	   
	   //catch error if read in failed
	    catch (IOException erreur)
	    {
	      System.out.println("Erreur au dela de lecture de fichier!!");
	    }
	   
	   return motpropose;
	}
	public void Set(int index,String ch){
		Grillemot.set(index,ch);
	}
	
	public void langue(){
		System.out.println("\nCHOIX DE LANGUE DU JEU :\n");
		System.out.println("1-Français");
		System.out.println("2-Anglais");
		Scanner sc=new Scanner(System.in);
		this.lang=sc.nextInt();
	}
	

		
		
	

	public void add(int index, String str) {
		Grillemot.add(index, str);
		// TODO Auto-generated method stub
		
	}

	public String get(int i) {
		// TODO Auto-generated method stub
		return Grillemot.get(i);
	}

	public void clear() {
		Grillemot.clear();
		// TODO Auto-generated method stub
		
	}
	
	
		
		
	
}
