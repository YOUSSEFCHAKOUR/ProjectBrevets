package com.modelstable;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.ismo.brevets.metier.IMetier;
import com.ismo.brevets.metier.MetierBrevet;
import com.ismo.brevets.models.Brevet;
import com.ismo.brevets.models.Entreprise;

public class ModelBrevet extends AbstractTableModel{

	List<Brevet> brevets;
	String [] cols= {"NUM_BREVET","DESCRIPTION","DATE_DEPOT","DATE_VALIDATION"};
	
	IMetier metier=new MetierBrevet();
	public ModelBrevet(){
		brevets=metier.getAll();
	}
	public void addBrevet(Brevet p) {
		brevets.add(p);
	}
	public void removeBrevet(int id) {
		brevets.remove(id);
	}
	
	@Override
	public int getColumnCount() {
		return cols.length;
	}

	@Override
	public int getRowCount() {
		return brevets.size();
	}
	@Override
	public String getColumnName(int c) {
		
		return cols[c];
	}

	@Override
	public Object getValueAt(int row, int col) {
		Brevet e=brevets.get(row);
		switch (col) {
		case 0:return e.getNum();
		case 1:return e.getDescription();
		case 2:return e.getDateDepot();
		case 3:return e.getDateValidation();
		//case 4:return e.getVille();
			
		}
		return null;
	}



}
