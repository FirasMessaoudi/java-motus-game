package projectPoo;
import java.util.*;
public class joueur2 {
private String nomPren,motpropse;
private int score;
private int scoreP;
private  int num;
private static int n=0;

public joueur2() {
	nomPren = "";
	motpropse="";
	score = 0;
	scoreP=0;

}
public joueur2(String nomPren,int score,int num){
	this.nomPren=nomPren;
	this.score=score;
}

public void saisieMot(){
	Scanner s=new Scanner(System.in);
	do{
	this.motpropse=s.next();
	if(HasAlphaNumeric(this.motpropse))
		System.out.println(("le mot doit etre alphabetique "));
	}while(HasAlphaNumeric(this.motpropse));
}
public static boolean HasAlphaNumeric(String name){
	 boolean res = false;
	 if(name.matches("^.*[^a-zA-Z ].*$")||(name.matches("^[0-9]*$")))
	 res=true;
		return res;
			
}

public int getScoreP() {
	return scoreP;
}
public void setScoreP(int scoreP) {
	this.scoreP+= scoreP;
}
public String getMotpropse() {
	return motpropse;
}

public String getNomPren() {
	return nomPren;
}

public void setNomPren(String nomPren) {
	this.nomPren = nomPren;
}

public int getScore() {
	return score;
}

public void setScore(int score) {
	this.score = score;
}

public int getNum() {
	return num;
}

public void setNum(int num) {
	this.num = num;
}
public void afficher(){
	System.out.println( "Nom : "+nomPren+"\n Score: "+score+"\n Numero: "+num+"\n score dans tous les parties : "+scoreP);
}
public void incScore(int x){
	score+=x;
}
public void saisie(){
	Scanner sc=new Scanner (System.in);
	do{
		System.out.println("Nom et prenom  du joueur "+(n+1));
	nomPren=sc.nextLine();
	if(HasAlphaNumeric(nomPren))
		System.out.println("Nom incorrecte !!");
	}while(HasAlphaNumeric(nomPren));
	n++;
	num=n;
	System.out.println("Numero : "+num);
	
}


}
