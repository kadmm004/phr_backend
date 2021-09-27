package entity;

import java.sql.Date;

public class MedicalRecord {
	private int mrid;
	private String userid;
	private Date mrdate;
	private String hosid;
	private String mrcause;
	private String mrdetail;
	private String mrstate;
	public MedicalRecord(int mrid, String userid, Date mrdate, String hosid, String mrcause, String mrdetail,
			String mrstate) {
		super();
		this.mrid = mrid;
		this.userid = userid;
		this.mrdate = mrdate;
		this.hosid = hosid;
		this.mrcause = mrcause;
		this.mrdetail = mrdetail;
		this.mrstate = mrstate;
	}
	public int getMrid() {
		return mrid;
	}
	public void setMrid(int mrid) {
		this.mrid = mrid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getMrdate() {
		return mrdate;
	}
	public void setMrdate(Date mrdate) {
		this.mrdate = mrdate;
	}
	public String getHosid() {
		return hosid;
	}
	public void setHosid(String hosid) {
		this.hosid = hosid;
	}
	public String getMrcause() {
		return mrcause;
	}
	public void setMrcause(String mrcause) {
		this.mrcause = mrcause;
	}
	public String getMrdetail() {
		return mrdetail;
	}
	public void setMrdetail(String mrdetail) {
		this.mrdetail = mrdetail;
	}
	public String getMrstate() {
		return mrstate;
	}
	public void setMrstate(String mrstate) {
		this.mrstate = mrstate;
	}
	
	

}
