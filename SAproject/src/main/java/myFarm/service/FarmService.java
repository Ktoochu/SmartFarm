package myFarm.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import myFarm.entity.Farm;
import myFarm.repository.FarmRepository;

@Service
@Transactional
public class FarmService {

	@Autowired
	private FarmRepository fr;

	// ���� ���� ã�� 1
	public Farm findByfarm(String name) {
		
		Farm farm = fr.findByfarmName(name);
		// System.out.println("farm ȣ�� ���::"+farm.getFarmName());
		
		return farm;
	}

}
