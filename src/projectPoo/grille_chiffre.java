package projectPoo;
import java.util.*;
public class grille_chiffre {
protected Object[][] gc;
protected ArrayList<Object> lst_8;//liste des 8 chiffres qui seront visibles dans la grille
public grille_chiffre(){
	gc=new Object[5][5];
	lst_8=new ArrayList<Object>();
}

public Object[][] getGc() {
	return gc;
}

public void setGc(Object[][] gc) {
	this.gc = gc;
}

public void initialiser(){
	Random rand=new Random();
	int nb;
	for(int i=0;i<5;i++)
		for(int j=0;j<5;j++){
			do{
		 nb=rand.nextInt(100);
		}while(existe(nb));
			gc[i][j]=nb;
		}
}

public void liste_8(){
	int k=0;
	while(k<8){
		double l=Math.random()*(5-0);
		double c=Math.random()*(5-0);
		int nl=(int)l;
		int nc=(int)c;
		Object nb=gc[nl][nc];
		if(!lst_8.contains(nb)){
			lst_8.add(nb);
			k++;
		}
		
	}
}
public void afficher_g(){
	for(int i=0;i<5;i++){
		for(int j=0;j<5;j++){
			Object tmp='@';
			if(this.gc[i][j]==tmp)
			System.out.print(this.gc[i][j]+"  ");
			else
				System.out.print(this.gc[i][j]+" ");
			
		}
       System.out.println();
	}
	
}
public boolean existe(Object x){
	int i=0;
	boolean trouve=false;
	while(i<5 && !trouve){
		int j=0;
		while(j<5 && !trouve){
			if(gc[i][j]==x)
				trouve=true;
			else j++;
		}
		i++;
	}
	return trouve;
}

public void grille_visible(){
	for(int i=0;i<5;i++)
		for(int j=0;j<5;j++){
			if(!lst_8.contains(gc[i][j]))
            gc[i][j]='@';
			
		}
}

public boolean ligne(int l){ // verifier qu'une ligne est complete
	int col=0;
	boolean trouve=false;
	Object tmp='@';
	while(col<5 && !trouve){
		if(gc[l][col]==tmp) // les valeurs de la ligne doivent etre # au '@'
			trouve=true;
		else
			col++;
	}
	return trouve;
}

public boolean colonne(int c){ // verifer qu'une colonne est complete
	int l=0;
	boolean trouve=false;
	Object tmp='@';
	while(l<5 && !trouve){
		if(gc[l][c]==tmp)
			trouve=true;
		else
			l++;
	}
	return trouve;
}
public boolean diag1(){ // le premiere diagonale est complet
	boolean trouve=false;
	int i=0;
	Object tmp='@';
	while(i<5 && !trouve){
		if(gc[i][i]==tmp)
			trouve=true;
		else
			i++;
	}
	return trouve;
}
public boolean diag2(){ // le deuxieme diagonal est complet
	boolean trouve=false;
	int i=0;
	Object tmp='@';
	while(i<5 && !trouve){
		if(gc[i][gc.length-i-1]==tmp)
			trouve=true;
		else
			i++;
	}
	return trouve;
}


}

