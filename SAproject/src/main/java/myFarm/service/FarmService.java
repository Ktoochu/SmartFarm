package myFarm.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import myFarm.entity.Farm;

public class FarmService {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;

	// ������: �ʱ� ����
	public FarmService() {
		emf = Persistence.createEntityManagerFactory("SAproject");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	// ���� ���� ã��
	public void findMyFarm(String name) {

		try {
			tx.begin();
			List<Farm> farm = null;

			String jpql = "SELECT m from Farm m where m.farmName=:name";
			
			/* farm = em.createQuery(jpql, Farm.class).getResultList(); */
			
			TypedQuery<Farm> query = em.createQuery(jpql, Farm.class).setParameter("name", name);
			farm = query.getResultList();

			System.out.println(farm);
			
			// ��� ���
			for (Farm act : farm) {
				System.out.println("-------------------------------------");
				System.out.println(act.getFarmName() + " " + act.getBusinessNum());
				System.out.println("-------------------------------------");
			}
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		emf.close();

	}
}
