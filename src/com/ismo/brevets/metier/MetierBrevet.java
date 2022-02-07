package com.ismo.brevets.metier;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.utils.HibernateUtils;
import com.ismo.brevets.dao.DaoBrevet;
import com.ismo.brevets.dao.IDAO;
import com.ismo.brevets.models.Brevet;





public class MetierBrevet implements IMetier<Brevet> {

	IDAO<Brevet> dao=new DaoBrevet();
	@Override
	public List<Brevet> getAll() {
		
		
		return dao.getAll();
	}

	@Override
	public Brevet getOne(int id) {
		
		return dao.getOne(id);
	}

	@Override
	public boolean save(Brevet obj) {
		return dao.save(obj);
		
	}

	@Override
	public boolean update(Brevet obj) {
	
		return dao.update(obj);
	}

	@Override
	public boolean delete(Brevet obj) {
		
		return dao.delete(obj);
	}

}
