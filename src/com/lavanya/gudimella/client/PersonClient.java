package com.lavanya.gudimella.client;

import com.lavanya.gudimella.dao.PersonDao;

public class PersonClient {
	public static void main(String[] args) {
		PersonDao personDao = new PersonDao();
		System.out.println(personDao.getAllPersons());
	}
}
