package utils;

import java.util.List;

import model.Column;

/**
* Decrit un <i>DatSet</i>, c'est a dire un ensemble de points (ou lignes,
* ou donnees) ayant tous la meme structure (les memes colonnes)
*
* Un DataSet est <i>Iterable</i> pour pouvoir parcourir l'ensemble des
* donnees(ou lignes ou points) .
* Pour cette raison, il n'y a pas de getter pour l'ensemble des points
* d'un DataSet.
*/
public interface IDataset extends Iterable<IPoint> {

/**
* Le nom du DataSet ex: Titanic, Iris, Pokemon, ...
*/
public String getTitle();
/**
* Nombre de lignes (ou donnees ou points) dans le DataSet
*/
public int getNbLines();
/**
* stocke dans le DataSet la collection de donnees passee en parametre
*/
public void setLines(List<IPoint> lines);
/**
* Ajoute une donnee dans le DataSet
*/
void addLine(IPoint element);
/**
* Ajoute une collection de donnees dans le DataSet
*/
void addAllLine(List<IPoint> element);

public List<Column> getListColumns();

public List<IPoint> getListPoints();
}