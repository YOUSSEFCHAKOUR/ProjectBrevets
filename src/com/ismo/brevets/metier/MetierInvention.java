package com.ismo.brevets.metier;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.utils.HibernateUtils;
import com.ismo.brevets.dao.DaoInvention;
import com.ismo.brevets.dao.IDAO;
import com.ismo.brevets.models.Inventeur;
import com.ismo.brevets.models.Invention;

public class MetierInvention implements IMetier<Invention> {

	IDAO<Invention> dao=new DaoInvention();
	@Override
	public List<Invention> getAll() {
	return dao.getAll();
	}

	@Override
	public Invention getOne(int id) {
		return dao.getOne(id);
	}

	@Override
	public boolean save(Invention obj) {
		return dao.save(obj);
	}

	@Override
	public boolean update(Invention obj) {
		return dao.update(obj);
	}

	@Override
	public boolean delete(Invention obj) {
		return dao.delete(obj);
	}
	
	

}
