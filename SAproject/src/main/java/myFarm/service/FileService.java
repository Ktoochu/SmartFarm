package myFarm.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import myFarm.entity.FileUp;
import myFarm.repository.FileRepository;

@Service
@Transactional
public class FileService {

	@Autowired
	private FileRepository fr;

	private final String PATH = "assets\\FARM-IMAGES\\";

	public List<FileUp> findList(String num) {
		return fr.findByList(num);
	}

	// �̹��� �����ϱ�
	public FileUp insert(MultipartFile file, String root_path, FileUp fileUp) throws IllegalStateException, IOException {

		// ���� �̸�
		String filename = file.getOriginalFilename();

		// ���� ��ȣ ����
		int index = findList(fileUp.getFileId().getBusinessNum()).size();
		fileUp.setGno(index);

		String filePath = PATH + index + "_" + filename;

		System.out.println("================== file start ==================");
		System.out.println("���� ��ȣ" + fileUp.getFileId().getGno() + "\t���� ��� ��ȣ" + fileUp.getFileId().getBusinessNum());
		System.out.println("��ü ���" + root_path + filePath); // ��ü ��� ���
		System.out.println("================== file   END ==================");

		// ���� ����
		file.transferTo(new File(root_path + filePath));
		fileUp.setPhoto_path(filePath);

		return fr.save(fileUp);
	}
}
