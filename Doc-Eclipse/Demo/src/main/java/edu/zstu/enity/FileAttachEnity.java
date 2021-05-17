package edu.zstu.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "file_attach")
public class FileAttachEnity extends BaseEnity{
	private String FileName;
	private String FilePath;
	private String Ext;
	private String FileType;
	private String Note;
	
	@Column(name="FileName")
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	
	@Column(name="FilePath")
	public String getFilePath() {
		return FilePath;
	}
	public void setFilePath(String filePath) {
		FilePath = filePath;
	}
	
	@Column(name="Ext")
	public String getExt() {
		return Ext;
	}
	public void setExt(String ext) {
		Ext = ext;
	}
	
	@Column(name="FileType")
	public String getFileType() {
		return FileType;
	}
	public void setFileType(String fileType) {
		FileType = fileType;
	}
	
	@Column(name="Note")
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	
	
	
}
