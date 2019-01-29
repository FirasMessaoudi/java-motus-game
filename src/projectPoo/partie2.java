package projectPoo;
import java.util.*;
public class partie2 {
	private boolean passer; // elle sera true si on tire une boule noire pour passer la main
	public partie2(){
		super();
		passer=false;
	}
	
	public boolean isPasser() {
		return passer;
	}

	public void setPasser(boolean passer) {
		this.passer = passer;
	}

	public void tester(joueur2 j){
		char touche;
		Scanner sc=new Scanner(System.in);
		urne ur=new urne();
		ur.initialiser();
		//ur.afficher_g();//temporaire
		System.out.println("\n"+j.getNomPren()+" voila votre grille, bonne chance..");
		//ur.liste_8();// les 8 chiffres qui seront visibles dans la grille
		ur.grille_visible();//seul les 8 chiffres seront visibles dans la grille
		ur.afficher_g();//affichage de la grille(seulement 8 chiffres visibles)
		int tire=0;//nombre de boules tirees
		boolean bn=false; //si on a tire une boule noire
		boolean complet=false;//si une ligne,colonne ou diagonal est complet
		while(tire<2 && !bn && !complet){
			System.out.println(("\nUrne :"));
			ur.afficher();//affichage de l'urne
			System.out.println("Tirage numero "+(tire+1)+" Tirez une boule ");
			ur.tirage();// le tirage d'une boule
			if(ur.noireTiree){// si la boule noire est tiree
				bn=true;
				passer=true; // le joueur doit passer la main
			}
			else if(!ur.colonne(ur.getIc())){//une colonne complet
				complet=true;	
				System.out.println("---------------------------------");
				ur.afficher_g();//affichage de la grille apres chaque tirage		
			}
			else if(!ur.diag1()){//diagonal complet
				complet=true;
				System.out.println("---------------------------------");
				ur.afficher_g();//affichage de la grille apres chaque tirage
			}
			else if(!ur.diag2()){//diagonal complet
				complet=true;
				System.out.println("---------------------------------");
				ur.afficher_g();//affichage de la grille apres chaque tirage
			}
			else if(!ur.ligne(ur.getIl())){//ligne complet
				complet=true;
				System.out.println("---------------------------------");
				ur.afficher_g();//affichage de la grille apres chaque tirage
			}
			else{
				tire++;
				System.out.println("---------------------------------");
				ur.afficher_g();//affichage de la grille apres chaque tirage
			}
			
		}
		if(complet){//une ligne ,colonne ou diagonal complet
			System.out.println("bravo vous avez un motus ");
            j.incScore(100);//score+=100 points
        
		}
		else if(bn){// si il a tire une boule noire
			System.out.println("vous avez tirez une boule noire vous allez passer la main");
			System.out.println("Appuiez sur une touche pour passer la main ...");
			touche=sc.next().charAt(0);
		}
		else{// il depassé 2 tentatives sans realiser un motus
			System.out.println("vous avez depasser 2 tentatives");
			
		}
		
		
		
	}
	
}
