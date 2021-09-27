package entity;

public class Regist {
	String docname;
	String price;
	String paname;
	String date;
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPaname() {
		return paname;
	}
	public void setPaname(String paname) {
		this.paname = paname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Regist(String docname,String paname,String price,String date) {
		this.docname=docname;
		this.paname=paname;
		this.price=price;
		this.date=date;
	}

}
