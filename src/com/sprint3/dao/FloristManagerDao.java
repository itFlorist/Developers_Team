package com.sprint3.dao;

import java.util.List;

import com.sprint3.dto.Florist;

public interface FloristManagerDao {

	public void addFlorist(String name, Florist florist) throws FloristManagerDaoException;

	public Florist removeFlorist(String floristName) throws FloristManagerDaoException;

	// boolean checkName(String floristName) throws FloristManagerDaoException;

	public List<Florist> getAllFlorists() throws FloristManagerDaoException;

}
