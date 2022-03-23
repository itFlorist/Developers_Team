package com.sprint3.service;

import java.util.List;

import com.sprint3.dao.FloristDao;
import com.sprint3.dao.FloristManagerDao;
import com.sprint3.dao.FloristManagerDaoException;
import com.sprint3.dto.Florist;

public class FloristManagerService {

	private FloristManagerDao floristManagerDao;

	public FloristManagerService(FloristManagerDao floristManagerDao) {
		this.floristManagerDao = floristManagerDao;
	}

	public void addFlorist(String name, Florist newFlorist) throws FloristManagerDaoException {
		floristManagerDao.addFlorist(newFlorist.getName(), newFlorist);
	}

	public Florist removeFlorist(String floristName) throws FloristManagerDaoException {
		return floristManagerDao.removeFlorist(floristName);

	}

	public boolean checkName(String floristName) throws FloristManagerDaoException {
		return floristManagerDao.checkName(floristName);

	}

	public List<Florist> getAllFlorists() throws FloristManagerDaoException {
		return floristManagerDao.getAllFlorists();

	}
}
