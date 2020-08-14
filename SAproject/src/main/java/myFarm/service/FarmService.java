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

	/*
	 * EntityManagerFactory emf; EntityManager em; EntityTransaction tx;
	 */

	// ������: �ʱ� ����
	public FarmService() {

		/*
		 * emf = Persistence.createEntityManagerFactory("SAproject"); em =
		 * emf.createEntityManager(); tx = em.getTransaction();
		 */

	}

	// ���� ���� ã�� 1
	public Farm findByfarm(String name) {
		System.out.println();
		
		fr.count();
		// MyPage farm = fr.findByfarmName(name);
		return new Farm();
	}

	/*
	 * // ���� ���� ã�� 2 public Farm findMyFarm(String name) {
	 * 
	 * Farm farm = null;
	 * 
	 * try { tx.begin();
	 * 
	 * String jpql = "SELECT m from Farm m where m.farmName=:name";
	 * 
	 * // farm = em.createQuery(jpql, Farm.class).getResultList();
	 * 
	 * TypedQuery<Farm> query = em.createQuery(jpql,
	 * Farm.class).setParameter("name", name); farm = query.getSingleResult();
	 * 
	 * tx.commit(); } catch (Exception e) { e.printStackTrace(); } finally {
	 * em.close(); }
	 * 
	 * return farm; }
	 */

}
