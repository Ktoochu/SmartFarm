package myFarm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import myFarm.service.FarmService;

/*
 * auction ���� ������ �����Ű�� ���� ��Ʈ�ѷ�
 * @Controller�� ��Ʈ�ѷ���� ���̰�,
 * @RequestMapping("/jsp�̸�")�� �ش��ϴ� jsp�̸����� ��û�� ������ �����Ѵٴ� ���̴�. ���� ������ ���� �Ÿ� ���⼭ �߻�!!
 * �̋�, return "�����̸�/jsp�̸�" ���� ��ȯ����� �Ѵ�.
 * ����� �۵��ϴ��� Ȯ���ϱ� ���� System.out.println ���� �ܼ�â�� ǥ��. �� ������ �����ص� ��.
 * 
 *  */

@Controller
public class MyFarmController {
	// ���� ���� ȭ��
	@RequestMapping("/FarmPageMain")
	public String intro(Model model) {
		System.out.println("���� ���� ��Ʈ�ѷ� �����");
		
		FarmService fs = new FarmService();
		/* fs.findMyFarm("kim"); */
		
		model.addAttribute("farm",  fs.findMyFarm("kim"));
		
		return "myFarm/FarmPageMain";
	}
	
	@RequestMapping("/FarmPageModify")
	public String modify(Model model) {
		System.out.println("���� ���� ��Ʈ�ѷ� �����");
		return "myFarm/FarmPageModify";
	}
	
	@RequestMapping("/FarmPageReview")
	public String review(Model model) {
		System.out.println("���� ���� ��Ʈ�ѷ� �����");
		return "myFarm/FarmPageReview";
	}
}
