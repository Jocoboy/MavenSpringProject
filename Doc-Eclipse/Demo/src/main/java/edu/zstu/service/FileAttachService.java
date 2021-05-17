package edu.zstu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.zstu.dao.FileAttachDao;
import edu.zstu.enity.FileAttachEnity;

@Component	
@Transactional
public class FileAttachService extends CrudService<FileAttachEnity, FileAttachDao> {

	@Autowired
	private FileAttachDao fileAttachDao;
	
	@Override
	protected FileAttachDao getDao() {
		// TODO Auto-generated method stub
		return this.fileAttachDao;
	}

	
	public FileAttachEnity findByFileName(String FileName){
		return this.getDao().findByFileName(FileName);
	}
	
//	public void saveFileAttach(FileAttachEnity FileAttach){
//		this.getDao().save(FileAttach);
//	}
}
