package edu.zstu.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zstu.dao.FileAttachDao;
import edu.zstu.enity.FileAttachEnity;

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
}
