package jeuGraphic;

public class FenetreJeu {

	public FenetreJeu(int bouton) {
		
		//Lancement du mode normal
		
		if (bouton == 1){
			new FenetreJeuNormal();
			}
		else if(bouton == 2){
			
			//Lancement du mode survie
			
			new FenetreJeuSurvieChoix();
		}
		}

}
