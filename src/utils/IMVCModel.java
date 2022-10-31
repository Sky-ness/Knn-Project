package utils;

import java.util.Collection;
import java.util.List;

/**
* Decrit un modele de donnee dans le MVC.
*
* Un modele de donnee est un {@link IDataset}, il peut en plus lire ses
* donnees d'un fichier (CSV) ou d'une chaine de caracteres,
* il a une colonne et une ligne par defaut pour afficher un nuage de point
* et il peut avoir des categories
*/
public interface IMVCModel extends IDataset {
/**
* Charge les donnees du modele d'un fichier CSV.
*/
public void loadFromFile(String datafile);
/**
* Charge les donnees du modele d'une String "CSV".
* Cette methode est surtout un utilitaire de test pour eviter d'avoir a
* creer des fichiers CSV pour tous les cas de test.
* Il suffit d'appeller cette methode avec une String contenant les lignes
* d'un "fichier CSV" que l'on veut tester.
*/
public void loadFromString(String data);
/**
* Retourne la colonne a utiliser par defaut pour l'axe des X lors de
* l'affichage du nuage de points.
*/
public IColumn defaultXCol();
/**
* Retourne la colonne a utiliser par defaut pour l'axe des Y lors de
* l'affichage du nuage de points.
*/
public IColumn defaultYCol();
/**
* Ajoute une Categorie (ou classe) de donnees au model.
*/
public void addCategory(ICategory classe);
/**
* Retourne toutes les categories du modele.
*/
public Collection<ICategory> allCategories();
/**
* Nombre de colonnes dans le modele (egale au nombre de colonnes du
* DataSet associe a ce modele)
*/
abstract public int nbColumns();
/**
* Retourne la collection de toutes les colonnes du DataSet dont les
* valeurs peuvent etre normalisees.
* Seules les colonnes normalisables peuvent servir d'axes dans le
* nuage de points.
* La normalisation doit retourner une valeur dans l’intervalle [0;1]
*/
public List<IColumn> getNormalizableColumns();
}