package kr.or.ddit.passenger;

public class PassengerDTO {
	private String paName;
	private String paRegno1;
	private String paRegno2;
	private String paHp;
	private String paEmail;
	
	public PassengerDTO(String paName, String paRegno1, String paEmail, String paHp) {
		super();
		this.paName = paName;
		this.paRegno1 = paRegno1;
		this.paEmail = paEmail;
		this.paHp = paHp;
	}
	
	public PassengerDTO(String paName, String paRegno1, String paRegno2, String paHp, String paEmail) {
		super();
		this.paName = paName;
		this.paRegno1 = paRegno1;
		this.paRegno2 = paRegno2;
		this.paHp = paHp;
		this.paEmail = paEmail;
	}
	
	public String getPaName() {
		return paName;
	}
	public void setPaName(String paName) {
		this.paName = paName;
	}
	public String getPaRegno1() {
		return paRegno1;
	}
	public void setPaRegno1(String paRegno1) {
		this.paRegno1 = paRegno1;
	}
	public String getPaRegno2() {
		return paRegno2;
	}
	public void setPaRegno2(String paRegno2) {
		this.paRegno2 = paRegno2;
	}
	public String getPaHp() {
		return paHp;
	}
	public void setPaHp(String paHp) {
		this.paHp = paHp;
	}
	public String getPaEmail() {
		return paEmail;
	}
	public void setPaEmail(String paEmail) {
		this.paEmail = paEmail;
	}
	
	@Override
	public String toString() {
		return "PassengerDTO [paName=" + paName + ", paRegno1=" + paRegno1 + ", paRegno2=" + paRegno2 + ", paHp=" + paHp
				+ ", paEmail=" + paEmail + "]";
	}
	
	
}
