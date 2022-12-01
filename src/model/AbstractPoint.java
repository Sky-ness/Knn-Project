package model;

import java.lang.reflect.Field;

/**
 * Decrit un Point (ou donnee, ou ligne) dans un DataSet.
 */
public abstract class  AbstractPoint {
	/**
	 * Retourne la valeur de ce point pour la colonne en parametre.
	 *
	 * Note, on aurait pu utiliser une interface generique (parametree avec
	 * un type), mais cela complique significativement d'autres parties
	 * du code.
	 * @throws Exception 
	 * @throws SecurityException 

	 */
	public Object getValue(Column column) {
		if(column == null)
			return new NullObject();
		Field[] fs = this.getClass().getDeclaredFields();
		String colName = column.getName();
		if(colName == null)
			return new NullObject();
		for(Field f : fs) {
			if(colName.equals(f.getName())){
				try {
					return f.get(this);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return new NullObject();
	}
	/**
	 * Retourne la valeur de ce point normalisee pour la colonne en parametre.
	 *
	 * La normalisation se fait avec le <i>normaliseur</i> de la colonne.
	 * Si la colonne n'est pas normalisable, le comportement n'est pas defini.
	 * @throws Exception 
	 */
	public double getNormalizedValue(Column xcolumn) {
		return xcolumn.getNormalizedValue(this);
	}



}