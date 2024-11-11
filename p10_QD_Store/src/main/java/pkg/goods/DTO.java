package pkg.goods;

import java.sql.Timestamp;

public class DTO {

	private int number;
	private String oriFName;
	private String upFName;
	private String goodsName;
	private int price;
	private String content;
	private Timestamp regTM;
	private String remoteIP;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getOriFName() {
		return oriFName;
	}
	public void setOriFName(String oriFName) {
		this.oriFName = oriFName;
	}
	public String getUpFName() {
		return upFName;
	}
	public void setUpFName(String upFName) {
		this.upFName = upFName;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getRegTM() {
		return regTM;
	}
	public void setRegTM(Timestamp regTM) {
		this.regTM = regTM;
	}
	public String getRemoteIP() {
		return remoteIP;
	}
	public void setRemoteIP(String remoteIP) {
		this.remoteIP = remoteIP;
	}
	

}
