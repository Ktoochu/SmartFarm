package myFarm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myFarm.entity.Farm;

@Repository
public interface FarmRepository extends JpaRepository<Farm, String> {

	/*
	 * �ܰ��� ��� T ���¿� Optional<T> ���� 2���� ���� �� �ִ�.
	 * ����� 2���̻� ������ javax.persistence.NonUniqueResultException ���ܰ� �߻��ϰ�, ����� 0���� ��� T�� null,
	 * Optional<T>�� Optional.empty() �� �����Ѵ�.
	 * 
	 */
	
	// businessNum���� DB �˻� :: findBy�ʵ��̸�();
	public Farm findBybusinessNum(String num);

}
