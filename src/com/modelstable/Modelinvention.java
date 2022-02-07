package com.modelstable;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.ismo.brevets.metier.IMetier;
import com.ismo.brevets.metier.MetierInvention;
import com.ismo.brevets.models.Inventeur;
import com.ismo.brevets.models.Invention;

public class Modelinvention extends AbstractTableModel{
	
	List<Invention> Inventions;
	String [] cols= {"NUM_INVENTION","DESCRIPTIF","RESUME"};
	IMetier metier=new MetierInvention();
	public Modelinvention(){
		Inventions=metier.getAll();
	}
	
	public void addInventeur(Invention p) {
		Inventions.add(p);
	}
	public void removeInventeur(int id) {
		Inventions.remove(id);
	}
	
	@Override
	public int getColumnCount() {
		return cols.length;
	}

	@Override
	public int getRowCount() {
		return  Inventions.size();	
	}
	
	@Override
	public String getColumnName(int c) {
		
		return cols[c];
	}

	@Override
	public Object getValueAt(int row, int col) {
		Invention e=Inventions.get(row);
		switch (col) {
		case 0:return e.getNum();
		case 1:return e.getDescriptif();
		case 2:return e.getResume();
	
			
		}
		return null;
	}



}
