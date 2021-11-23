package kr.or.ddit.promotion;


import java.util.List;
import java.util.Scanner;

import kr.or.ddit.promotion.PromotionDAO;
import kr.or.ddit.promotion.PromotionDTO;

public class PromotionController {
	//private PromotionDAO dao = new PromotionDAO();
	private static PromotionController instance = new PromotionController();
	private PromotionController() {
	}
	public static PromotionController getInstance() {
		return instance;
	}
	public static int promotion(Scanner scanner) throws Exception {

		PromotionDAO dao = new PromotionDAO();
		
		System.out.println("");
		System.out.println("스카이스캐너 프로모션");
		System.out.println("");
		System.out.print("1. 프로모션 확인      2. 할인코드 조회");
		int proNum = scanner.nextInt();
		
		if (proNum == 1) {
			//프로모션 조회
			System.out.println("");
			System.out.println("*스카이스캐너 5월 프로모션 정보");
			List<PromotionDTO> list = dao.selectPromotionList();
			for (PromotionDTO vo : list) {
				System.out.print(vo.getPromotionName() + "\t\t");
				System.out.print(vo.getPromotionDetail() + "\n");
			}
		} else if (proNum == 2) {		
			//할인코드 조회
			try {
			System.out.println("");
			System.out.print("할인코드를 입력하세요: ");
		      String proId = scanner.next();
		      PromotionDTO vo = dao.selectPromotionId(proId);
					//System.out.print(vo.getPromotionId()+ "\t\t");
		      		//System.out.print("사용 가능한 할인코드입니다.");
					System.out.println(vo.getPromotionRate() + "% 할인 적용이 가능한 할인코드입니다.");
				

			} catch (NullPointerException e) {
				System.out.println("유효하지 않은 할인코드입니다.");
			}

		}
		return 3;		
	}
}
