package myFarm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import myFarm.entity.Farm;

@Repository
@Transactional
public interface FarmRepository extends JpaRepository<Farm, Long> {

	/*
	 * �ܰ��� ��� T ���¿� Optional<T> ���� 2���� ���� �� �ִ�.
	 * ����� 2���̻� ������ javax.persistence.NonUniqueResultException ���ܰ� �߻��ϰ�, ����� 0���� ��� T�� null,
	 * Optional<T>�� Optional.empty() �� �����Ѵ�.
	 * 
	 */
	
	// farmName���� DB �˻�
	public Farm findByfarmName(String farmName);

}
