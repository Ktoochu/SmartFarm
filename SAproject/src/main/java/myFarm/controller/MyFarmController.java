package myFarm.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import myFarm.entity.Farm;
import myFarm.entity.FileID;
import myFarm.entity.FileUp;
import myFarm.service.FarmService;
import myFarm.service.FileService;

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

	@Autowired(required = true)
	FarmService farmServ;
	
	@Autowired(required = true)
	FileService fileServ;
	
	/**
	 * name, BusinessNum�� ���� ������ ����Ǿ� �־�� �Ѵ� 
	 * */
	private String name = "Lee";
	private String BusinessNum = "123456";

	private Farm myFarm;
	private List<FileUp> myGallery;

	// ���� ���� ȭ��
	@RequestMapping("/FarmPageMain")
	public String intro(Model model) {

		System.out.println("���� ���� ��Ʈ�ѷ� �����");
		
		// ���� ���� ��������
		myFarm = farmServ.findByfarm(BusinessNum);
		if (myFarm == null) {
			myFarm = farmServ.init(name, BusinessNum);
		}
		model.addAttribute("farm", myFarm);
		
		// ������ ���� ��������
		myGallery = fileServ.findList(BusinessNum);
		if(myGallery == null) System.out.println("�ƹ��͵� ã�� ���ߴ�.");
		else System.out.println(myGallery);
		model.addAttribute("gallerys", myGallery);

		return "myFarm/FarmPageMain";
	}

	@RequestMapping("/FarmPageWrite")
	public String write(Model model) {

		System.out.println("���� �۾��� ��Ʈ�ѷ� �����");

		model.addAttribute("farm", myFarm);

		return "myFarm/FarmPageWrite";
	}

	// �̹����� �ڸ�Ʈ ����
	@PostMapping("/insert")
	public String insert(@RequestParam("filename") MultipartFile file, FileUp fileUp, HttpServletRequest request) throws Exception {

		System.out.println("================== file start ==================");
		System.out.println("���� �̸�: " + file.getName());
		System.out.println("���� ���� �̸�: " + file.getOriginalFilename());
		System.out.println("���� ũ��: " + file.getSize());
		System.out.println("content type: " + file.getContentType());
		System.out.println("�ڸ�Ʈ: " + fileUp.getComment());
		System.out.println("================== file   END ==================");

		String root_path = request.getSession().getServletContext().getRealPath("/");	// ���� ���
		
		FileID id = new FileID();
		id.setBusinessNum(myFarm.getBusinessNum());
		fileUp.setFileId(id);
		
		fileServ.insert(file, root_path, fileUp);
		
		return "redirect:FarmPageMain";
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
