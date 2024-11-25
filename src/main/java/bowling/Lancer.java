package bowling;

public class Lancer {
	private int nbQuille = -1;

	public Lancer(int nbQuille) {
		this.setNbQuille(nbQuille);
	}

	public Lancer() {}

	public int getNbQuille() {
		return nbQuille;
	}

	public void setNbQuille(int nbQuille) {
		if (nbQuille < 0 || nbQuille > 10) {
			throw new IllegalArgumentException("Nombre
