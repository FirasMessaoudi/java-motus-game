package projectPoo;
import java.util.*;
import java.io.*;
public class test {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
//FileReader fr=new FileReader("c:\\bd\\six.txt");



Scanner sc=new Scanner(System.in);
char rep,dec;
int num1,num2;
long start,end;
String s1,s2;

gestion_joueur gest=new gestion_joueur();
joueur2 j1=new joueur2();
joueur2 j2=new joueur2();
System.out.println("AJOUT DES JOUEURS \n");//on doit saisir au moins deux joueurs
do{
	do{
joueur2 j=new joueur2();
j.saisie();
gest.ajouter(j);
	}while(gest.getNbj()<2);
System.out.println("Voulez vous ajouter d'autres joueurs (O/N) ?");
rep=sc.next().charAt(0);
}while(rep=='o' || rep=='O');
char r;
do{
System.out.println("CHOIX DES JOUEURS QUI VONT S'AFFRONTER \n");

do{
	do{
	System.out.println("Donner le numero du Joueur 1");
	s1=sc.next();
	System.out.println("Donner le numero du Joueur 2");
	s2=sc.next();
	if(!isInteger(s1) || !isInteger(s2))
		System.out.println("Les numeros des joueurs doivent etre numeriques !!");
	}while(s1.equals(s2) || !isInteger(s1) || !isInteger(s2) );
	num1=Integer.valueOf(s1);
	num2=Integer.valueOf(s2);
	 j1 =gest.recherche(num1);
	 j2 =gest.recherche(num2);
}while(j1==null || j2==null);
int z=0;
do{
	GrilleLettre M =new GrilleLettre();
	M.langue();
	M.Tirermot();
	M.Initialiser();
	
	if(z==0){
		System.out.println("Les joueurs "+j1.getNomPren()+" et "+j2.getNomPren()+" vont s'affronter ");
		
        System.out.println("le Joueur "+j1.getNomPren()+" va commencer :");
	
	}
	z++;
//System.out.println("si vous etes pres appuiyez sur n'importe quelle touche ...");
//dec=sc.next().charAt(0);

int tentative=0;		
ArrayList <Integer>A=new ArrayList<Integer>(); //Arraylist contenant les indices correctes
ArrayList <Integer>B=new ArrayList<Integer>(); //ArrayList contenant les indices erronées
ArrayList <Integer>C=new ArrayList<Integer>(); //ArrayList contenant les indices des malplacés
HashMap<String,Integer> indexes= new HashMap<String,Integer>();//HashMap contenant les lettres et leurs occurence
	String alea=M.Tirermot();//"citron";
	
	System.out.println(alea);
	String prop ="";
	boolean guessed=false,guessedbyj2=false;
		Scanner s = new Scanner(System.in);
		for (int i=0;i<alea.length()*5;i++)
		{
		if(i%alea.length()==0)
			System.out.println();
		M.Set(0," "+alea.toUpperCase().charAt(0)+" ");
		System.out.print(M.get(i));}
	while(((tentative<5)) && !guessed && !guessedbyj2){
	
	do{	
		
	System.out.println("\nTentative n° "+(tentative+1));
	 start=System.currentTimeMillis();
	j1.saisieMot();
	 end=System.currentTimeMillis();
		prop=j1.getMotpropse();//le mot à saisir par le joueur
		if(prop.length()!=M.getTaille())
			System.out.println("Le mot doit etre de taille "+M.getTaille());
	}while(prop.length()!=M.getTaille());
    if(end-start>8000){
    	System.out.println("vous avez depassé 8 seondes "+(end-start)+" millis");
    	tentative++;
    }
    else{
	//prop=j1.getMotpropse();//le mot à saisir par le joueur
	String tempalea = alea.toLowerCase(); 
	String tempprop=prop.toLowerCase();
	if(prop.length()!=M.getTaille())
		System.out.println("Le mot doit etre de taille "+M.getTaille());
	else{ //le mot est de taille 6
	
		//String alea="citron"; //le mot a determiner 
	
	int k1=0,l=k1+1,occ=1;
	while(k1<alea.length()) //Calcule l'occurrence de chaque lettre de mot secret et la met dans un hashmap
		{while(l<alea.length())
		{
		if(alea.charAt(k1)==alea.charAt(l))
			occ++;
		l++;		
		}
		indexes.put(alea.charAt(k1)+"",occ);
		k1++;
		l=0;
		occ=0;
		}
	
	//System.out.println(indexes);
	for (int i=0;i<alea.length();i++) //Chercher les lettres erronées
	if( ( tempalea.indexOf(tempprop.charAt(i)) )<0 )
		{B.add(i); 
		} 
	for(int i=0;i<tempprop.length();i++){
	if(tempprop.charAt(i)==alea.charAt(i)){ //Chaque fois on compare entre les deux lettres des deux mots  
		   //Si'ils ont la meme position on l'ajoute au tableau des positions correctes
		A.add(i); //et a chaque fois on decremente l'occurence de cette lettre dans le tableau des occurences
		
Integer v = indexes.get(tempprop.charAt(i)+"")-1;			
indexes.put(tempprop.charAt(i)+"",v);} }
	
		int aIndex=0;int index=0; Integer v1;
	//Debut potentiel autre C//Chercher les lettres correctes et les lettres malplacées en utilisant deux boucles imbriquées
	while (aIndex < alea.length())
	{//debut while1
	while (index < prop.length())
	  {
	    if (alea.charAt(aIndex) == prop.charAt(index))
	    	 if (aIndex!=index) {
	       v1 = indexes.get(tempprop.charAt(index)+"")-1; //System.out.println(v1);
	      indexes.put(tempprop.charAt(index)+"",v1);
		if((v1.intValue()<0))
			{
			
			if(!C.contains(index))
			B.add(index);}
			else 
			C.add(index);
	    		}		    
	    
		      index++;
	  }
	  index = 0;
	  aIndex++;
	  
	}//fin while1
		
		prop=prop.toUpperCase();
		for(int i=0;i<prop.length();i++)
		{	
			if (A.contains(i)){ //Filling the matrix with the symbols and the letters from each word
				M.add(i," "+prop.charAt(i)+" ");
			}
			
			else if(C.contains(i))
				{M.add(i," +"+prop.charAt(i));
				}
			
			else if(B.contains(i)){
				M.add(i," -"+prop.charAt(i));
				}	
		}//fin for=>prop.length
		
		for (int i=0;i<alea.length();i++)
		System.out.print(M.get(i));
		if(alea.toUpperCase().equals(prop.toUpperCase())) //Tester si les mots sont identiques lettre à lettre
		{	guessed=true;
			System.out.println("\nBRAVO "+j1.getNomPren()+" vous avez devinez le mot correcte apres "+(tentative+1)+" tentative(s)");
			//j1.incScore(50);
			
		//return;
		}
	
		
		//System.out.println(indexes);
	A.clear();
	B.clear();
	C.clear();
	indexes.clear();
	M.clear();
	tentative++; }//fin else cad mot de taille 6
	//}while(prop.length()!=6);
	}//fin tentative
	}

	if(guessed==true){
		j1.incScore(50);
		System.out.println("vous allez passer à l'etape de tirage au sort ");
		partie2 p=new partie2();
		p.tester(j1);
		if(p.isPasser()){
			System.out.println("A vous de Tirer "+j2.getNomPren());
			partie2 p2=new partie2();
			p2.tester(j2);
		}
	}
		else{
			System.out.println("\nLe tour de joueur numero 2: vous avez une seule tentative");
			j2.saisieMot();
			if (j2.getMotpropse().toLowerCase().equals(alea.toLowerCase()))
			{
				System.out.println("Bravo! "+j2.getNomPren()+" vous avez devinez le mot apres une seule tentative");
				guessedbyj2=true;
				j2.incScore(50);
				partie2 p=new partie2();
				p.tester(j2);
				if(p.isPasser()){
					System.out.println("A vous de tirer "+j1.getNomPren());
					partie2 p2=new partie2();
					p2.tester(j1);
				}
			}
			}
	if (guessed==false&&guessedbyj2==false){
		System.out.println("Aucun joueur n' trouvé le mot correcte ");
		System.out.println("Bon sang.Le mot est: "+alea);
	    System.out.println("Vous allez commencer une nouvelle partie...");
	}

    System.out.println("Score des deux joueurs : ");
    System.out.println("Le joueur "+j1.getNomPren()+" a "+j1.getScore()+" Points");
    System.out.println("Le joueur "+j2.getNomPren()+" a "+j2.getScore()+" Points");
    System.out.println("Appuiez sur une touche...");
    r=sc.next().charAt(0);

}while(j1.getScore()<300 && j2.getScore()<300);
j1.setScoreP(j1.getScore());
j2.setScoreP(j2.getScore());
System.out.println("VOULEZ VOUS ASSURER UNE NOUVELLE PARTIE (O/N) ?");
r=sc.next().charAt(0);
}while(r=='o' || r=='O');
System.out.println("STATISTIQUES DES JOUEURS : ");
System.out.println("1-Le joueur qui a le meilleurs score :");
System.out.println("2-Le joueur le plus rapide : ");
int cc;
do{
cc=sc.nextInt();
}while(cc!=1 && cc!=2);
if(cc==1){
	System.out.println("-Le joueur qui a le meilleurs score est: " );
	joueur2 mj=new joueur2();
	mj=gest.max();
	mj.afficher();
}














/*while(tent<5 && !trouve){
		
do{	

System.out.println("Tentative numero "+(tent+1));	
 start=System.currentTimeMillis();
ch1=sc.next();
ch=ch1.toUpperCase();
 end=System.currentTimeMillis();

}while(ch.length()!=mot.length());
if(end-start>8000)
{
	System.out.println("vous avez depassé 8 seondes "+(end-start)+" millis");
	tent++;
	if(tent<5)
	g.getGrille()[tent][0]=mot.charAt(0);
	g.afficher_grille();
}
else{
if(mot.equals(ch)){
	trouve=true;
	for(int j=0;j<mot.length();j++)
		g.getGrille()[tent][j]=mot.charAt(j);
	    g.afficher_grille();
	
}
else{
	for(int i=0;i<ch.length();i++){
		if(mot.indexOf(ch.charAt(i))==-1){
			//System.out.print("-"+ch.charAt(i)+" ");
			g.getGrille()[tent][i]="-"+ch.charAt(i);
		}
		else if(ch.indexOf(ch.charAt(i))==mot.indexOf(ch.charAt(i))){
				//System.out.print(ch.charAt(i)+" ");
				g.getGrille()[tent][i]=ch.charAt(i);
			}
			else{
				//System.out.print("+"+ch.charAt(i)+" ");
				g.getGrille()[tent][i]="+"+ch.charAt(i);
			}
		
		
	}
	
	
	tent++;
	if(tent<5)
	g.getGrille()[tent][0]=mot.charAt(0);
	g.afficher_grille();
	
}
	
}	
	
	
	
}*/
/*if(!trouve){
	System.out.println("le joueur "+j2.getNomPren()+" a une seule tentative :");
	do{
	System.out.println("votre tentative :");
	ch1=sc.next();
	ch=ch1.toUpperCase();
	}while(ch.length()!=mot.length());
	if(ch.equals(mot)){
		System.out.println("Bravo "+j2.getNomPren()+" vous etes un genie vous avez deviné le mot en une seul tentative maintenant vous allez passer à l'tape du tirage au sort ");
		trouve=true;
		j2.incScore(50);
		
		partie2 p=new partie2();
		p.tester(j2);
		if(p.isPasser()){
			System.out.println("A vous de tirer "+j1.getNomPren());
			partie2 p2=new partie2();
			p2.tester(j1);
		}
		//le traitement pour le tirage au sort des boules pour j2
	}
	else{
		System.out.println("vous avez perdu votre seul et unique chance ");
	    //aucun joueur n'a reussi à trouver le mot correcte
	    System.out.println("le mot que vous chercher est :"+mot);
	    System.out.println("vous allez commener une nouvelle partie ! si vous etes pres appuiyez sur n'importe quelle touche ...");
	   
	    dec=sc.next().charAt(0);
	}
	 
}
else{
	System.out.println("Bravo "+j1.getNomPren()+" vous avez deviné le mot aprés "+(tent+1)+" tentatives maintenant vous allez passer à l'tape du tirage au sort");
	j1.incScore(50);
	//le traitement pour le tirage au sort des boules pour j2

	partie2 p=new partie2();
	p.tester(j1);
	if(p.isPasser()){
		System.out.println("A vous de Tirer "+j2.getNomPren());
		partie2 p2=new partie2();
		p2.tester(j2);
	}

}
j1.afficher();
j2.afficher();
}while(j1.getScore()<300 && j2.getScore()<300);*/





	}

	 private static boolean isInteger(String s) {
	       boolean isValid = true;
	       try{ Integer.parseInt(s); }
	       catch(NumberFormatException nfe){ isValid = false; }
	       return isValid;
	   }


}
