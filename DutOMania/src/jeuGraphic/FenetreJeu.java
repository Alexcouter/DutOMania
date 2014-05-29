package jeuGraphic;

public class FenetreJeu {

	public FenetreJeu(int bouton) {
		if (bouton == 1){
			new FenetreJeuNormal();
			}
		else if(bouton == 2){
			new FenetreJeuSurvieChoix();
		}
		}

}
