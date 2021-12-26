package kh.web.dto;

public class FileDTO {
	private int seq;
	private String oriName;
	private String sysName;
	private int parentSeq;
	public FileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileDTO(int seq, String oriName, String sysName, int parentSeq) {
		super();
		this.seq = seq;
		this.oriName = oriName;
		this.sysName = sysName;
		this.parentSeq = parentSeq;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	public String getSysName() {
		return sysName;
	}
	public void setSysName(String sysName) {
		this.sysName = sysName;
	}
	public int getParentSeq() {
		return parentSeq;
	}
	public void setParentSeq(int parentSeq) {
		this.parentSeq = parentSeq;
	}
}

