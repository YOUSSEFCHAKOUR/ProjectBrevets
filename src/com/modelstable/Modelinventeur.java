package com.modelstable;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.ismo.brevets.metier.IMetier;
import com.ismo.brevets.metier.MetierInventeur;
import com.ismo.brevets.models.Domaine;
import com.ismo.brevets.models.Inventeur;

public class Modelinventeur extends AbstractTableModel{
	
	List<Inventeur> Inventeurs;
	String [] cols= {"NUM_INVENTEUR","NOM","PRENOM","ADRESSE","DATE_NAISS"};
	IMetier metier=new MetierInventeur();
	public Modelinventeur(){
		Inventeurs=metier.getAll();
	}
	
	public void addInventeur(Inventeur p) {
		Inventeurs.add(p);
	}
	public void removeInventeur(int id) {
		Inventeurs.remove(id);
	}
	
	@Override
	public int getColumnCount() {
		return cols.length;
	}

	@Override
	public int getRowCount() {
		return  Inventeurs.size();
	}
	
	@Override
	public String getColumnName(int c) {
		// TODO Auto-generated method stub
		return cols[c];
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		Inventeur e=Inventeurs.get(row);
		switch (col) {
		case 0:return e.getNum();
		case 1:return e.getNom();
		case 2:return e.getPrenom();
		case 3:return e.getAdresse();
		case 4:return e.getDate_nais();
			
		}
		return null;
	}



}

