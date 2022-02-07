package com.ismo.brevets.metier;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.utils.HibernateUtils;
import com.ismo.brevets.dao.DaoInventeur;
import com.ismo.brevets.dao.IDAO;
import com.ismo.brevets.models.Entreprise;
import com.ismo.brevets.models.Inventeur;

public class MetierInventeur implements IMetier<Inventeur> {

	IDAO<Inventeur> dao=new DaoInventeur();
	@Override
	public List<Inventeur> getAll() {
		return dao.getAll();
	}

	@Override
	public Inventeur getOne(int id) {
		return dao.getOne(id);
	}

	@Override
	public boolean save(Inventeur obj) {
		return dao.save(obj);
	}

	@Override
	public boolean update(Inventeur obj) {
		return dao.update(obj);
	}

	@Override
	public boolean delete(Inventeur obj) {
		return dao.delete(obj);
	}

}
