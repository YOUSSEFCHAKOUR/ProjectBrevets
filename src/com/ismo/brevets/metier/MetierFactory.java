package com.ismo.brevets.metier;

import com.ismo.brevets.dao.DaoBrevet;
import com.ismo.brevets.dao.DaoDomaine;
import com.ismo.brevets.dao.DaoEntreprise;
import com.ismo.brevets.dao.DaoInventeur;
import com.ismo.brevets.dao.DaoInvention;
import com.ismo.brevets.dao.IDAO;

public class MetierFactory {
	
	
	public static IDAO getDao(METIER type) {

		switch (type) {
		case BREVET: return new DaoBrevet(); 
		case ENTREPRISE: return new DaoEntreprise(); 
		case INVENTION: return new DaoInvention(); 
		case INVENTEUR: return new DaoInventeur();
		case DOMAINE :return new DaoDomaine();
		default: return null;
			
		}	
		
	}

}
