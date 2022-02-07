package com.modelstable;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.ismo.brevets.metier.IMetier;
import com.ismo.brevets.metier.MetierDomaine;
import com.ismo.brevets.models.Brevet;
import com.ismo.brevets.models.Domaine;

public class ModelDomaine extends AbstractTableModel{
	
	
	List<Domaine> domaines;
	String [] cols= {"NUM_BREVET","DESCRIPTION","DATE_DEPOT","DATE_VALIDATION"};
	IMetier metier=new MetierDomaine();
	public ModelDomaine(){
		domaines=metier.getAll();
	}
	
	public void addDomaine(Domaine p) {
		domaines.add(p);
	}
	public void removeDomaine(int id) {
		domaines.remove(id);
	}
	
	@Override
	public int getColumnCount() {
		return cols.length;
	}

	@Override
	public int getRowCount() {
		return  domaines.size();
	}
	@Override
	public String getColumnName(int c) {
		// TODO Auto-generated method stub
		return cols[c];
	}
	@Override
	public Object getValueAt(int row, int col) {
		Domaine e=domaines.get(row);
		switch (col) {
		case 0:return e.getNum();
		case 1:return e.getNom();
	//	case 2:return e.getDateDepot();
	//	case 3:return e.getDateValidation();
		//case 4:return e.getVille();
			
		}
		return null;
	}



}
