package csvReader;

import java.time.LocalDate;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

public class FormatDonneeBrut {
	@CsvBindByName(column = "Nom")
	private String nom;
	@CsvBindByName(column = "Prénom")
    private String prenom;
	@CsvBindByName(column = "Date de Naissance")
	@CsvDate("yyyy-MM-dd")
    private LocalDate dateNaissance;
	@CsvBindByName(column = "Genre")
    private Genre genre;
	@CsvBindByName(column = "Taille")
    private double taille;
	@CsvBindByName(column = "Score")
    private int score;
	@CsvBindByName(column = "Souscription")
    private OuiNon souscription; // OuiNon est un type énuméré à créer
	
	@Override
	public String toString() {
		return nom + "," + prenom + "," + dateNaissance + ","
				+ genre + "," + taille + "," + score + "," + souscription;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public Genre getGenre() {
		return genre;
	}

	public double getTaille() {
		return taille;
	}

	public int getScore() {
		return score;
	}

	public OuiNon getSouscription() {
		return souscription;
	}

	
	
}
