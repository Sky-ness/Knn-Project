package main;

import java.time.LocalDate;

import csvReader.FormatDonneeBrut;
import csvReader.Genre;

public class Personne {
	private String prenomNom; // le prénom et le nom séparés par un espace
	private LocalDate dateNaissance;
	private Genre genre;
	private int taille; // taille en centimètres
	private double scoreNormalise;
	private boolean souscription; // le oui/non devient un boolean

	public Personne(FormatDonneeBrut fdb) {
		prenomNom = fdb.getNom() + " " + fdb.getPrenom();
		dateNaissance = fdb.getDateNaissance();
		genre = fdb.getGenre();
		taille = (int) (fdb.getTaille() * 100);
		scoreNormalise = fdb.getScore();
		souscription = fdb.getSouscription().getV();
	}
	
	public Personne(String pn, LocalDate dateN, Genre genre, double taille, double score, boolean souscription) {
		this.prenomNom = pn;
		this.dateNaissance = dateN;
		this.genre = genre;
		this.taille = (int) (taille*100);
		this.scoreNormalise = score;
		this.souscription = souscription;
	}

	@Override
	public String toString() {
		return prenomNom + "," + dateNaissance + "," + genre
				+ "," + taille + "," + scoreNormalise + "," + souscription;
	}

	public String getPrenomNom() {
		return prenomNom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public Genre getGenre() {
		return genre;
	}

	public int getTaille() {
		return taille;
	}

	public double getScoreNormalise() {
		return scoreNormalise;
	}

	public boolean isSouscription() {
		return souscription;
	}
	
	
	
	
}
