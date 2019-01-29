package projectPoo;
import java.util.*;
public class urne extends grille_chiffre {
protected HashSet<Object> ur; // l'urne qui va contenir les 25 boules anisi que 2 boules noirs
protected Object bn1; //1er boule noire
protected Object bn2; //2eme boule noire
protected Object[][] gc; //grille chiffre
protected boolean noireTiree; //une boule noire est tiree ou non
protected int il,ic; //les indices de la boule tire , ils nous serviront pour verifier qu'une ligne ou colonne est complete
public urne(){
	gc=new Object[5][5];
	ur=new HashSet<Object>();
	bn1=new Object();
	bn2=new Object();

}
public Object boule(){// generartion de boule noire qui sera mise dans l'urne avec les autres boulss
	int x;
	Random rand=new Random();

	do{
		x=rand.nextInt(100);
	}while(existe((Object)x));// la boule doit etre diffrente au nombre de la grille
	return(Object)x;
}
public void initialiser(){
	super.initialiser();
	gc=super.getGc();
	super.liste_8();
	
	do{
		bn1=boule();//1er boule noire
		bn2=boule();//2eme boule noire
	}while(bn1.equals(bn2));// les deux boules doivent etre differents
	
	
	for(int i=0;i<5;i++)
		for(int j=0;j<5;j++){
			case_grille cse=new case_grille();//creation d'une case_grille qui contient:
			cse.setC(j);// l'indice de colonne dans la grille
			cse.setL(i);// l'indice de ligne dans la grille
			cse.setVal(gc[i][j]);//la valeur de la case
			if(!super.lst_8.contains(gc[i][j]))
			ur.add(cse);// on l'ajoute dans l'urne
		}
	case_grille c1=new case_grille();// c1 contient la boule noire 1
	case_grille c2=new case_grille();// c2 contient la boule noire 2
	c1.setC(-1);// on donne aux indices des boules noire -1 car ils n'existent pas dans la grille
	c1.setL(-1);// ça nous facilite de verifier lors du tirage s'il s'agit d'une boule noire ou non
	c1.setVal(bn1);	
	ur.add(c1);//boule noire 1
	c2.setC(-1);
	c2.setL(-1);
	c2.setVal(bn2);	
	ur.add(c2);//boule noire 2
}
public void afficher(){// affichage de l'urne
	Iterator<Object> it=ur.iterator();
	while(it.hasNext()){
		System.out.print(((case_grille)it.next()).getVal()+" ");
	}
	System.out.println();
	
}

public 	void tirage(){ // methode de tirage de la boyule
	Scanner sc=new Scanner(System.in);
	case_grille cs;
	 int x1;
	 Object x;
	 String xx1;
	 do{// le joueur va tirer une boule (entier)
		 do{
		xx1=sc.next();
		 if(!isInteger(xx1))
		System.out.println("La boule doit etre entier !!");
		 }while (!isInteger(xx1));
		 x1=Integer.valueOf(xx1);
		x=(Object)x1;
	    cs=new case_grille();// creation d'une case_grille qui va contenir la valeur de la boule tiree
	    cs.setVal(x);// la valeur de la boule
		cs.setL(ind_ligne(x));// l'indice de la ligne de la boule tiree
		cs.setC(ind_col(x));// l'indice de colonne de la boule tiree
		if(ind_ligne(x)==-2)
		// la boule ne doit pas etre parmis les 8 chiffres visibles
		// la boule doit exister dans l'urne 
			System.out.println("cette boule n'existe pas ");	
	 }while(ind_ligne(x)==-2);
		 System.out.println("la boule tiré est "+ cs.getVal());
		 ur.remove(cs.getVal());
		if(cs.getC()==-1){// on a tiree une boule noire
			noireTiree=true;
		}
		else{
			gc[cs.getL()][cs.getC()]=cs.getVal();//sinon on met la boule tiree dans la grille et elle sera visible
			this.il=cs.getL();//indice de ligne de la boule tiree
			this.ic=cs.getC();//indice de colonne de la boule tire
		}
	
		
	
}
public int getIl() {
	return il;
}
public void setIl(int il) {
	this.il = il;
}
public int getIc() {
	return ic;
}
public void setIc(int ic) {
	this.ic = ic;
}
public int ind_ligne(Object o){// renvoyer l'indice de l'ingne de la boule tiree
	Object[]e=ur.toArray();
	int i=0;
	boolean trouve=false;
	while(i<e.length && !trouve){
		if((((case_grille)e[i]).getVal()).equals(o))
		trouve=true;
		else
			i++;
	}
	if(trouve)
		return ((case_grille)e[i]).getL();
	else
		return -2; // si elle n'existe pas elle retourne -2

}
public int ind_col(Object o){ //l'indice de colonne de la boule tiree
	Object[]e=ur.toArray();
	int i=0;
	boolean trouve=false;
	while(i<e.length && !trouve){
		if((((case_grille)e[i]).getVal()).equals(o))
		trouve=true;
		else
			i++;
	}
	if(trouve)
		return ((case_grille)e[i]).getC();
	else
		return -2;

}
private static boolean isInteger(String s) {
    boolean isValid = true;
    try{ Integer.parseInt(s); }
    catch(NumberFormatException nfe){ isValid = false; }
    return isValid;
}

}
