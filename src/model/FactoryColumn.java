package model;

import java.lang.reflect.Field;

public class FactoryColumn {
	
	public Column createColumn(DataSet dataset, Field field) {
		
		Column column = new Column(field.getName(),dataset);
		Class<?> classField = field.getType();
		String type = classField.getName();
		
		if(type.equals(double.class.toString()) || type.equals(int.class.toString())) {
			column.setNormalizer(new NumberNormalizer(column));
		}
		if(type.equals(boolean.class.toString())) {
			column.setNormalizer(new BooleanNormalizer());
		}
		if(type.equals(PokemonType.class.getName())) {
			column.setNormalizer(new PokemonTypeNormalizer());
		}
		if(type.equals(IrisVariety.class.getName())) {
			column.setNormalizer(new IrisVarietyNormalizer());
		}
		if(type.equals(Sexe.class.getName())) {
			column.setNormalizer(new SexeNormalizer());
		}
		if(type.equals(Embarked.class.getName())) {
			column.setNormalizer(new EmbarkedNormalizer());
		}
		
		return column;
	}
}
