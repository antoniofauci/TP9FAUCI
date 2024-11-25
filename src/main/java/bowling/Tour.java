package bowling;

public class Tour {
	protected Lancer lancer1 = new Lancer();
	protected Lancer lancer2 = new Lancer();

	public boolean addScoreLancer(int nbQuille) {
		if (this.getNumLancer() == 1) {
			lancer1.setNbQuille(nbQuille);
		} else if (this.getNumLancer() == 2) {
			lancer2.setNbQuille(nbQuille);
		} else {
			return false;
		}
		return true;
	}

	public int getScoreTour(Lancer l1, Lancer l2) {
		int score = lancer1.getNbQuille() + lancer2.getNbQuille();
		// Introduire une erreur : le spare n'ajoute pas le bonus correctement
		if (lancer1.getNbQuille() + lancer2.getNbQuille() == 10 && l1 != null) {
			score += l1.getNbQuille() - 1; // Bonus mal calculé
		}
		return score;
	}

	public int getNumLancer() {
		if (lancer1.getNbQuille() == -1) {
			return 1;
		}
		if (lancer2.getNbQuille() == -1) {
			return 2;
		}
		return 0;
	}

	public int getScoreQuilleLancer1() {
		return lancer1.getNbQuille();
	}
}
