package com.sprint3.service;

import java.util.List;

import com.sprint3.dao.FloristManagerDao;
import com.sprint3.dao.FloristManagerDaoException;
import com.sprint3.dao.FloristManagerDaoFileImpl;
import com.sprint3.dto.Florist;

public class FloristManagerService {

	private FloristManagerDao floristManagerDao;

	public FloristManagerService(FloristManagerDao floristManagerDao) {
		this.floristManagerDao = floristManagerDao;
	}

	public FloristManagerService(String filePath) {
		this.floristManagerDao = new FloristManagerDaoFileImpl(filePath);
	}

	public boolean checkName(String floristName) throws FloristManagerDaoException {
		List<Florist> florists = floristManagerDao.getAllFlorists();

		for (Florist florist : florists) {
			if (floristName.equals(florist.getName())) {
				return true;
			}
		}
		return false;
	}

	public void addFlorist(String floristName, Florist newFlorist) throws FloristManagerDaoException {
		floristManagerDao.addFlorist(floristName, newFlorist);

	}

	public Florist removeFlorist(String floristName) throws FloristManagerDaoException {
		return floristManagerDao.removeFlorist(floristName);
	}

	public List<Florist> getAllFlorists() throws FloristManagerDaoException {
		return floristManagerDao.getAllFlorists();

	}

}
