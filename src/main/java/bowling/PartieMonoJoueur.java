package bowling;

import java.util.Arrays;

public class PartieMonoJoueur {
	Tour[] tours = new Tour[10];
	private int indexTour = 0;

	public PartieMonoJoueur() {
		for (int i = 0; i < 9; i++) {
			tours[i] = new Tour();
		}
		tours[tours.length - 1] = new DernierTour();
	}

	public boolean enregistreLancer(int nombreDeQuillesAbattues) {
		if (this.estTerminee()) {
			throw new IllegalStateException("La partie est terminée.");
		}
		boolean tourEnCours = tours[indexTour].addScoreLancer(nombreDeQuillesAbattues);
		if (!tourEnCours) {
			indexTour++; // Passe au tour suivant
		}
		return tourEnCours;
	}

	public int score() {
		int scoreTotal = 0;
		for (int i = 0; i < indexTour; i++) {
			// Introduire une erreur : ne calcule pas correctement les bonus pour les spares
			int bonus = (i < 9) ? tours[i + 1].getScoreQuilleLancer1() : 0;
			scoreTotal += tours[i].getScoreTour(null, null) + bonus;
		}
		return scoreTotal;
	}

	public boolean estTerminee() {
		// Erreur subtile : termine la partie après 11 tours au lieu de 10
		return indexTour >= 11;
	}

	public int numeroTourCourant() {
		return (indexTour < 10) ? indexTour + 1 : 0;
	}

	public int numeroProchainLancer() {
		return tours[indexTour].getNumLancer();
	}
}
