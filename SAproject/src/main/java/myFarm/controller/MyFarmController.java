package myFarm.controller;

import java.io.File;

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

	@Autowired(required = true)
	FarmService fs;

	private Farm myFarm;

	// ���� ���� ȭ��
	@RequestMapping("/FarmPageMain")
	public String intro(Model model) {

		System.out.println("���� ���� ��Ʈ�ѷ� �����");

		myFarm = fs.findByfarm("123456");
		if (myFarm == null) {
			myFarm = fs.init("Lee", "123456");
		}

		model.addAttribute("farm", myFarm);

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
	public String insert(@RequestParam("filename") MultipartFile file, @RequestParam String content, HttpServletRequest request) throws Exception {

		System.out.println("================== file start ==================");
		System.out.println("���� �̸�: " + file.getName());
		System.out.println("���� ���� �̸�: " + file.getOriginalFilename());
		System.out.println("���� ũ��: " + file.getSize());
		System.out.println("content type: " + file.getContentType());
		System.out.println("�ڸ�Ʈ: " + content);
		System.out.println("================== file   END ==================");

		// Save mediaFile on system
		/*
		 * if (!file.getOriginalFilename().isEmpty()) { String path = uploadPath + "/" +
		 * file.getOriginalFilename(); file.transferTo(new File(path, file.getName()));
		 * fs.insert(path, content); }
		 */

		// ���� �̸�
	    String filename = file.getOriginalFilename();
	    
		// ���� ���
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String filePath = "assets\\FARM-IMAGES\\" + filename;
		
		// ��ü ��� ���
		System.out.println(root_path + filePath);
		
		// ���� ����
		file.transferTo(new File(root_path + filePath));
		
		// ���� ����
		myFarm = fs.findByfarm("123456");
		myFarm.setPhoto(filePath);
		myFarm.setComment(content);
		myFarm = fs.insert(myFarm);

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
