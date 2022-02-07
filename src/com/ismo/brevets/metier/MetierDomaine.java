package com.ismo.brevets.metier;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.utils.HibernateUtils;
import com.ismo.brevets.dao.DaoDomaine;
import com.ismo.brevets.dao.IDAO;
import com.ismo.brevets.models.Brevet;
import com.ismo.brevets.models.Domaine;

public class MetierDomaine implements IMetier<Domaine> {

	IDAO<Domaine> dao=new DaoDomaine();
	@Override
	public List<Domaine> getAll() {
		
		return dao.getAll();
	}

	@Override
	public Domaine getOne(int id) {
		return dao.getOne(id);
	}

	@Override
	public boolean save(Domaine obj) {
		return dao.save(obj);
	}

	@Override
	public boolean update(Domaine obj) {
		return dao.update(obj);
	}

	@Override
	public boolean delete(Domaine obj) {
		return dao.delete(obj);
	}

}
