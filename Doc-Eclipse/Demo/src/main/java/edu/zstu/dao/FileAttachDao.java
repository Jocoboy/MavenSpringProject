package edu.zstu.dao;

import edu.zstu.entity.FileAttachEntity;


public interface FileAttachDao extends BaseDao<FileAttachEntity> {
	FileAttachEntity findByFileName(String FileName);
}
