package demo.poc.bankingdetails.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.poc.bankingdetails.pojo.Login;
import jakarta.persistence.EntityManager;

@Repository
public class LoginService implements LoginImpl{
	@Autowired
	EntityManager entity;
	
	@Override
	public List<Login> getLogins() {
		// TODO Auto-generated method stub
		List<Login> logins=new ArrayList<>();
		logins=entity.createQuery("select l from Login l",Login.class).getResultList();
		return logins;
	}

}
