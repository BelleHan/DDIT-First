package kr.or.ddit.promotion;

public class PromotionDTO {
	   private String promotionId;
	   private String promotionName;
	   private int promotionRate;
	   private String promotionDetail;
	
	   
	public PromotionDTO(String promotionId, int promotionRate) {
			super();
			this.promotionId = promotionId;
			this.promotionRate = promotionRate;

		}
	   
	public PromotionDTO(String promotionName, String promotionDetail, int promotionRate) {
			super();
			this.promotionName = promotionName;
			this.promotionDetail = promotionDetail;
			this.promotionRate = promotionRate;
		}
	
	public PromotionDTO(String promotionId, String promotionName, int promotionRate, String promotionDetail) {
		super();
		this.promotionId = promotionId;
		this.promotionName = promotionName;
		this.promotionRate = promotionRate;
		this.promotionDetail = promotionDetail;
	}
	
	public String getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}
	public String getPromotionName() {
		return promotionName;
	}
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	public int getPromotionRate() {
		return promotionRate;
	}
	public void setPromotionRate(int promotionRate) {
		this.promotionRate = promotionRate;
	}
	public String getPromotionDetail() {
		return promotionDetail;
	}
	public void setPromotionDetail(String promotionDetail) {
		this.promotionDetail = promotionDetail;
	}
	
	@Override
	public String toString() {
		return "PromotionDTO [promotionId=" + promotionId + ", promotionName=" + promotionName + ", promotionRate="
				+ promotionRate + ", promotionDetail=" + promotionDetail + "]";
	}
	   

}
