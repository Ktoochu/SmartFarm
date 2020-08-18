package myFarm.service;

import java.util.List;

import javax.annotation.Resource;

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
	
	// �� ���� ������ ����� (�� ȸ�������� ���)
	public Farm init(String name, String num) {
		return fr.save(new Farm(name, num));
	}

	// ���� ���� ã��
	public Farm findByfarm(String num) {
		
		Farm farm = fr.findBybusinessNum(num);
		// System.out.println("farm ȣ�� ���::"+farm.getFarmName());
		
		return farm;
	}
	
	// �̹��� �����ϱ�
	public Farm insert(Farm farm) {
		return fr.save(farm);
	}

}
