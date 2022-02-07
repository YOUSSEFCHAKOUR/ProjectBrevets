package com.ismo.brevets.metier;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.utils.HibernateUtils;
import com.ismo.brevets.dao.DaoEntreprise;
import com.ismo.brevets.dao.IDAO;
import com.ismo.brevets.models.Domaine;
import com.ismo.brevets.models.Entreprise;

public class MetierEntreprise implements IMetier<Entreprise> {

	IDAO<Entreprise> dao=new DaoEntreprise();
	@Override
	public List<Entreprise> getAll() {
		return dao.getAll();
	}

	@Override
	public Entreprise getOne(int id) {
		return dao.getOne(id);
	}

	@Override
	public boolean save(Entreprise obj) {
		return dao.save(obj);
	}

	@Override
	public boolean update(Entreprise obj) {
		return dao.update(obj);
	}

	@Override
	public boolean delete(Entreprise obj) {
		return dao.delete(obj);
	}

}
