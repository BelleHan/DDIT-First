package kr.or.ddit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.promotion.PromotionDAO;
import kr.or.ddit.promotion.PromotionDTO;

public class PromotionTest {
	public static void main(String[] args) throws Exception {
		PromotionDAO dao = new PromotionDAO();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("스카이스캐너 프로모션");
		System.out.println("");
		System.out.print("1. 프로모션 확인      2. 할인코드 조회");
		int proNum = scanner.nextInt();
		
		if (proNum == 1) {
			//프로모션 조회
			System.out.println("");
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
					System.out.print(vo.getPromotionId()+ "\t\t");
					System.out.print(vo.getPromotionRate() + "\n");
				
		      System.out.println("사용 가능한 할인코드입니다.");
		      scanner.close();
			} catch (NullPointerException e) {
				System.out.println("유효하지 않은 할인코드입니다.");
			}
		}
	}
}
