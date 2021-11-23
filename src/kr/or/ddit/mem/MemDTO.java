package kr.or.ddit.mem;

public class MemDTO {
   private String memId;
   private String memPass;
   private String memName;
   private String memRegno1;
   private String memRegno2;
   private String memEmail;
   private String memHp;
   private String memAdd1;
   private String memAdd2;
   private String memMemorialDay;
   private String memMileage;

   public MemDTO(String memId) {
      super();
      this.memId = memId;

   }

   public MemDTO(String memId, String memPass, String memName, String memRegno1, String memRegno2, String memEmail,
         String memHp, String memAdd1, String memAdd2, String memMemorialDay) {
      super();
      this.memId = memId;
      this.memPass = memPass;
      this.memName = memName;
      this.memRegno1 = memRegno1;
      this.memRegno2 = memRegno2;
      this.memEmail = memEmail;
      this.memHp = memHp;
      this.memAdd1 = memAdd1;
      this.memAdd2 = memAdd2;
      this.memMemorialDay = memMemorialDay;
   }

   public MemDTO(String memId, String memMileage) {
      super();
      this.memId = memId;
      this.memMileage = memMileage;
   }

   public String getMemId() {
      return memId;
   }

   public void setMemId(String memId) {
      this.memId = memId;
   }

   public String getMemPass() {
      return memPass;
   }

   public void setMemPass(String memPass) {
      this.memPass = memPass;
   }

   public String getMemName() {
      return memName;
   }

   public void setMemName(String memName) {
      this.memName = memName;
   }

   public String getMemRegno1() {
      return memRegno1;
   }

   public void setMemRegno1(String memRegno1) {
      this.memRegno1 = memRegno1;
   }

   public String getMemRegno2() {
      return memRegno2;
   }

   public void setMemRegno2(String memRegno2) {
      this.memRegno2 = memRegno2;
   }

   public String getMemEmail() {
      return memEmail;
   }

   public void setMemEmail(String memEmail) {
      this.memEmail = memEmail;
   }

   public String getMemHp() {
      return memHp;
   }

   public void setMemHp(String memHp) {
      this.memHp = memHp;
   }

   public String getMemAdd1() {
      return memAdd1;
   }

   public void setMemAdd1(String memAdd1) {
      this.memAdd1 = memAdd1;
   }

   public String getMemAdd2() {
      return memAdd2;
   }

   public void setMemAdd2(String memAdd2) {
      this.memAdd2 = memAdd2;
   }

   public String getMemMemorialDay() {
      return memMemorialDay;
   }

   public void setMemMemorialDay(String memMemorialDay) {
      this.memMemorialDay = memMemorialDay;
   }

   public String getMemMileage() {
      return "사용 가능한 마일리지: " + memMileage;
   }

   public void setMemMileage(String memMileage) {
      this.memMileage = memMileage;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("MemDTO [memId=");
      builder.append(memId);
      builder.append(", memPass=");
      builder.append(memPass);
      builder.append(", memName=");
      builder.append(memName);
      builder.append(", memRegno1=");
      builder.append(memRegno1);
      builder.append(", memRegno2=");
      builder.append(memRegno2);
      builder.append(", memEmail=");
      builder.append(memEmail);
      builder.append(", memHp=");
      builder.append(memHp);
      builder.append(", memAdd1=");
      builder.append(memAdd1);
      builder.append(", memAdd2=");
      builder.append(memAdd2);
      builder.append(", memMemorialDay=");
      builder.append(memMemorialDay);
      builder.append(", memMileage=");
      builder.append(memMileage);
      builder.append("]");
      return builder.toString();
   }

}

//public class MemDTO {
//	   private String memId;
//	   private String memPass;
//	   private String memName;
//	   private String memRegno1;
//	   private String memRegno2;
//	   private String memEmail;
//	   private String memHp;
//	   private String memAdd1;
//	   private String memAdd2;
//	   private String memMemorialDay;
//	   
//	   private String memMileage;
//
//	   public MemDTO(String memId) {
//		super();
//		this.memId = memId;
//	}
//	   
//	   public MemDTO(String memId, String memMileage) {
//		super();
//		this.memId = memId;
//		this.memMileage = memMileage;
//	}
//	   
//
//	public String getMemMileage() {
//		return memMileage;
//	}
//
//
//	public void setMemMileage(String memMileage) {
//		this.memMileage = memMileage;
//	}
//
//
//
//	public MemDTO(String memId, String memPass, String memName, String memRegno1, String memRegno2, String memEmail,
//			String memHp, String memAdd1, String memAdd2, String memMemorialDay) {
//		super();
//		this.memId = memId;
//		this.memPass = memPass;
//		this.memName = memName;
//		this.memRegno1 = memRegno1;
//		this.memRegno2 = memRegno2;
//		this.memEmail = memEmail;
//		this.memHp = memHp;
//		this.memAdd1 = memAdd1;
//		this.memAdd2 = memAdd2;
//		this.memMemorialDay = memMemorialDay;
//	}
//
//	public String getMemId() {
//		return memId;
//	}
//
//	public void setMemId(String memId) {
//		this.memId = memId;
//	}
//
//	public String getMemPass() {
//		return memPass;
//	}
//
//	public void setMemPass(String memPass) {
//		this.memPass = memPass;
//	}
//
//	public String getMemName() {
//		return memName;
//	}
//
//	public void setMemName(String memName) {
//		this.memName = memName;
//	}
//
//	public String getMemRegno1() {
//		return memRegno1;
//	}
//
//	public void setMemRegno1(String memRegno1) {
//		this.memRegno1 = memRegno1;
//	}
//
//	public String getMemRegno2() {
//		return memRegno2;
//	}
//
//	public void setMemRegno2(String memRegno2) {
//		this.memRegno2 = memRegno2;
//	}
//
//	public String getMemEmail() {
//		return memEmail;
//	}
//
//	public void setMemEmail(String memEmail) {
//		this.memEmail = memEmail;
//	}
//
//	public String getMemHp() {
//		return memHp;
//	}
//
//	public void setMemHp(String memHp) {
//		this.memHp = memHp;
//	}
//
//	public String getMemAdd1() {
//		return memAdd1;
//	}
//
//	public void setMemAdd1(String memAdd1) {
//		this.memAdd1 = memAdd1;
//	}
//
//	public String getMemAdd2() {
//		return memAdd2;
//	}
//
//	public void setMemAdd2(String memAdd2) {
//		this.memAdd2 = memAdd2;
//	}
//
//	public String getMemMemorialDay() {
//		return memMemorialDay;
//	}
//
//	public void setMemMemorialDay(String memMemorialDay) {
//		this.memMemorialDay = memMemorialDay;
//	}
//
//	@Override
//	public String toString() {
//		return "MemDTO [memId=" + memId + ", memPass=" + memPass + ", memName=" + memName + ", memRegno1=" + memRegno1
//				+ ", memRegno2=" + memRegno2 + ", memEmail=" + memEmail + ", memHp=" + memHp + ", memAdd1=" + memAdd1
//				+ ", memAdd2=" + memAdd2 + ", memMemorialDay=" + memMemorialDay + "]";
//	}
//	   
//	   
//
//	   	
//}