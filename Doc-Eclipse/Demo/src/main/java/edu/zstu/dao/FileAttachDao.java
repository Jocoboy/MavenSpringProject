package edu.zstu.dao;

import edu.zstu.enity.FileAttachEnity;


public interface FileAttachDao extends BaseDao<FileAttachEnity> {
	FileAttachEnity findByFileName(String FileName);
}
