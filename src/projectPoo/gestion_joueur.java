package projectPoo;
import java.util.*;
public class gestion_joueur {
private ArrayList<joueur2> tj;
private int nbj;
public gestion_joueur(){
	tj=new ArrayList<joueur2>();
	nbj=0;
}

public int getNbj() {
	return nbj;
}

public void setNbj(int nbj) {
	this.nbj = nbj;
}
public joueur2 max(){
	int m;
	joueur2 j=new joueur2();
	m=tj.get(0).getScoreP();
	j=tj.get(0);
	for(int i=1;i<tj.size();i++){
		if(tj.get(i).getScoreP()>m){
			tj.get(0).getScoreP();
	         j=tj.get(i);  	
		}
	}
	return j;
}
public void ajouter(joueur2 j){
	if(recherche(j.getNum())==null){
	tj.add(j);
	nbj++;
	}
	else
		System.out.println("ce joueur existe deja");
}
public void supprimer(joueur2 j){
	if(recherche(j.getNum())!=null)
	tj.remove(j);
	else
		System.out.println("suppression impossible ,ce joueur n'existe pas");
}
public joueur2 recherche(int num){
	boolean trouve =false;
	int i=0;
	while(i<tj.size() && !trouve){
		if(tj.get(i).getNum()==num)
			trouve=true;
		else
			i++;
	}
	if(trouve)
		return (tj.get(i));
		else{
			//System.out.println("joueur inexistant !!");
			return null;
		}
			

}
public void modifier(int num){
	if(recherche(num)!=null){
		joueur2 j=recherche(num);
		Scanner sc=new Scanner(System.in);
		System.out.println("Donner le nouveau nom et prenom");
		String np=sc.nextLine();
		j.setNomPren(np);
	}
	else
		System.out.println("joueur inexistant");
}
public void afficher(){
	for(int i=0;i<tj.size();i++)
		tj.get(i).afficher();
}

}
