package com.modelstable;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.ismo.brevets.dao.DAO;
import com.ismo.brevets.dao.DaoFactory;
import com.ismo.brevets.dao.IDAO;
import com.ismo.brevets.metier.IMetier;
import com.ismo.brevets.metier.MetierEntreprise;
import com.ismo.brevets.models.Entreprise;

public class ModelEntreprise extends AbstractTableModel{
	
	List<Entreprise> entreprises;
	String [] cols= {"NUM_ENTREPRISE","NOM_ENTREPRISE","ACTIVITE","CA","VILLE"};
	
	
	IMetier metier=new MetierEntreprise();
	
	public ModelEntreprise(){
		
		entreprises=metier.getAll();
	}
	
	public void addentreprise(Entreprise p) {
		entreprises.add(p);
	}
	public void removeentreprise(int id) {
		entreprises.remove(id);
	}
	
	@Override
	public int getColumnCount() {
		return cols.length;
	}

	@Override
	public int getRowCount() {
		return entreprises.size();
	}
	@Override
	public String getColumnName(int column) {
		
		return cols[column];
	}

	@Override
	public Object getValueAt(int row, int col) {
		Entreprise e=entreprises.get(row);
		switch (col) {
		case 0:return e.getNum();
		case 1:return e.getNom();
		case 2:return e.getActivite();
		case 3:return e.getCa();
		case 4:return e.getVille();
			
		}
		return null;
	}

}
