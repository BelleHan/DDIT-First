package kr.or.ddit.flight;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import kr.or.ddit.MemTest;
import kr.or.ddit.PassengerTest;
import kr.or.ddit.PromotionTest;
import kr.or.ddit.mem.MemDAO;
import kr.or.ddit.mem.MemDTO;
import kr.or.ddit.passenger.PassengerDAO;
import kr.or.ddit.passenger.PassengerDTO;
import kr.or.ddit.promotion.PromotionDAO;
import kr.or.ddit.promotion.PromotionDTO;


public class FlightController {
	private FlightDAO dao = new FlightDAO();
	private static FlightController instance = new FlightController();
	private FlightController() {
	}
	public static FlightController getInstance() {
		return instance;
	}
	public int search(Scanner scanner) throws Exception {
//		  System.out.println("스카이스캐너에 오신 것을 환영합니다!");
		  System.out.println("");	
		  System.out.print("출발지를 입력하세요.  ");
		  String depAirport = scanner.next();
		  System.out.print("도착지를 입력하세요.  ");
		  String arrAirport = scanner.next();
		  System.out.print("탑승일자를 입력하세요.(YYYY/MM/DD)  ");
		  String depTime = scanner.next();	
		  System.out.println("");
		  System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		  System.out.println("항공권코드		출발시각		도착시각  	      출발지  도착지 항공사코드 항공사이름   항공권금액");
		  System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		  List<FlightDTO> list2 = dao.selectFlight(new FlightDTO(depAirport, arrAirport, depTime));
		  for (FlightDTO vo : list2) {
			  System.out.print(vo.getFlightId() + "\t");
			  System.out.print(vo.getDepTime() + "\t");
			  System.out.print(vo.getArrTime() + "\t");
			  System.out.print(vo.getDepAirport() + "\t");
			  System.out.print(vo.getArrAirport() + "\t");
			  System.out.print(vo.getAirlineId() + "\t");
			  System.out.print(vo.getAirlineName() + "\t");
			  System.out.print(vo.getPrice() + "\n");
		}
		  System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		  System.out.println("");	
		  int resTime1 = 0;
		  
		  while (true) {
		  System.out.println("예약을 원하는 시간을 선택하십시오.");	
		  System.out.println("");	
		  
		  for (int i = 0; i < list2.size(); i++) {
			  System.out.print((i+1) + ". " + list2.get(i).getDepTime() + "\t");
		  }
		  	resTime1 = scanner.nextInt();
		  	if (resTime1 <= list2.size() && resTime1 > 0) {
		  		break;
		  	}
		  	System.out.println("");
		  	System.out.println("잘못 입력하셨습니다.");
		  }


		  System.out.println("");	
		  System.out.println("원하는 여정을 선택하십시오.");
		  System.out.print("1. 편도		2. 왕복  ");
		  int resCourse = scanner.nextInt();
		  List<FlightDTO> list3 = null;
		  int resTime2 = 0;
		  if (resCourse == 2) {
			  System.out.println("");
			  System.out.print("돌아오는 날짜를 입력하십시오.(YYYY/MM/DD)  ");
			  String comeback = "";
			  comeback = depAirport;
			  depAirport = arrAirport;
			  arrAirport = comeback;
			  String time = scanner.next();
			  depTime = time; 
			  System.out.println("");
			  System.out.println("-------------------------------------------------------------------------------------------------------------------------");
			  System.out.println("항공권코드		출발시각		도착시각  	      출발지  도착지 항공사코드 항공사이름   항공권금액");
			  System.out.println("-------------------------------------------------------------------------------------------------------------------------");
			  //List<FlightDTO> list3 = dao.selectFlight(new FlightDTO(depAirport, arrAirport, depTime));
			list3 = dao.selectFlight(new FlightDTO(depAirport, arrAirport, depTime));
			  for (FlightDTO vo : list3) {
				  System.out.print(vo.getFlightId() + "\t");
				  System.out.print(vo.getDepTime() + "\t");
				  System.out.print(vo.getArrTime() + "\t");
				  System.out.print(vo.getDepAirport() + "\t");
				  System.out.print(vo.getArrAirport() + "\t");
				  System.out.print(vo.getAirlineId() + "\t");
				  System.out.print(vo.getAirlineName() + "\t");
				  System.out.print(vo.getPrice() + "\n");
			}
			  System.out.println("-------------------------------------------------------------------------------------------------------------------------");
			 
			  System.out.println("");	
			  System.out.println("예약을 원하는 시간을 선택하십시오.");
			  System.out.println("");
			  for (int j = 0; j < list3.size(); j++) {
				  System.out.print((j+1) + ". " + list3.get(j).getDepTime() + "\t");
			  }
			  
			  resTime2 = scanner.nextInt();
		  }
			  
			  System.out.println("");
			  System.out.print("탑승인원을 입력하십시오.  ");
			  int person1 = scanner.nextInt();
			  int person2 = 0;
			  int child1 = 0;
			  int child2 = 0;
			  
			  if (person1 > 1) {
				  System.out.println("");
				  System.out.println("동승자 중 유소아(만 12세 미만)가 있습니까?");
				  System.out.print("1.예           2. 아니오  ");
				  person2 = scanner.nextInt();
				  if (person2 == 1) {
					  System.out.println("");
					  System.out.print("유아(24개월 미만) 인원수:");
					  child1 = scanner.nextInt();
					  System.out.print("소아(만 12세 미만) 인원수:");
					  child2 = scanner.nextInt();
				  }
			  }
	  
			  MemDAO mdao = new MemDAO();
			  MemTest mtest = new MemTest();
			  	System.out.println("");
			    System.out.println("아이디를 입력하십시오. ");
				System.out.print("회원아이디: ");
				String memId = scanner.next();
				System.out.println("");
			System.out.println("------------------------------------------------------");
			System.out.println("아이디  이름   생년월일   이메일 	 휴대폰번호");
			System.out.println("------------------------------------------------------");  
				List<MemDTO> list4 = mdao.selectMem(new MemDTO(memId));
				for (MemDTO vo : list4) {
				System.out.print(vo.getMemId() + "\t");
				System.out.print(vo.getMemName() + "\t");
				System.out.print(vo.getMemRegno1() + "\t");
				System.out.print(vo.getMemEmail() + "\t");
				System.out.print(vo.getMemHp() + "\n");
				}
			System.out.println("------------------------------------------------------");  
			
			  System.out.println("");
			  System.out.println("회원정보와 탑승자 정보가 일치합니까?");
			  System.out.print("1. 예          2. 아니오  ");
			  int resNum = scanner.nextInt();
			  
	      PassengerDAO padao = new PassengerDAO();
		  PassengerTest patest = new PassengerTest();
		  
		  if (resNum == 2) {
			  System.out.println("");
			  System.out.println("탑승자 정보 입력");
			  String paName = null;
			  while (true) {
				System.out.print("이름: ");
				paName = scanner.next();
	             if (Pattern.matches("[가-힣]{2,10}+", paName)) {
	                 break;
	              }
	              System.out.println("한글 이름을 두글자 이상 입력해주세요");
			  }
			  String paRegno1 = null;
			  while (true) {				  
				System.out.print("주민번호 앞자리: ");
				paRegno1 = scanner.next();
				if (Pattern.matches("[0-9]{6}", paRegno1)) {
	                break;
	             }
	             System.out.println("주민등록번호 앞 6자리를 입력해주세요");
			  }
			  String paRegno2 = null;
			  while (true) {				  
				System.out.print("주민번호 뒷자리: ");
				paRegno2 = scanner.next();
				if (Pattern.matches("[1-4]\\d{6}", paRegno2)) {
	                break;
	             }
	             System.out.println("주민등록번호 뒤 7자리를 입력해주세요");
			  }
			  String paHp = null;
			  while (true) {				  
				System.out.print("휴대폰 번호: ");
				paHp = scanner.next();
				if (Pattern.matches("\\d{3}-\\d{3,4}-\\d{4}", paHp)) {
	                break;
	             }
	             System.out.println("올바른 휴대전화 번호를 입력하세요.");
			  }
			  String paEmail = null;
			  while (true) {				  
				System.out.print("이메일: ");
				paEmail = scanner.next();
				if (Pattern.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z]+", paEmail)) {
	                break;
	             }
	             System.out.println("올바른 이메일 형식을 입력하세요");
			  }
					
				padao.insertPassenger(new PassengerDTO(paName, paRegno1, paRegno2, paHp, paEmail));
			  }	  
//		  
//		  if (person1 > 1) {
//		  System.out.println("");
//		  System.out.println("동승자 정보 입력");
//			System.out.print("이름: ");
//			String paName = scanner.next();
//			System.out.print("주민번호 앞자리: ");
//			String paRegno1 = scanner.next();
//			System.out.print("주민번호 뒷자리: ");
//			String paRegno2 = scanner.next();
//			System.out.print("휴대폰 번호: ");
//			String paHp = scanner.next();
//			System.out.print("이메일: ");
//			String paEmail = scanner.next();
//				
//			padao.insertPassenger(new PassengerDTO(paName, paRegno1, paRegno2, paHp, paEmail));
//	}
//			
		  if (person1 > 1 && person1-child1-child2 > 1) {
			System.out.println("");
			System.out.println("동승자 정보 입력");
			String paName = null;
			  while (true) {
				System.out.print("이름: ");
				paName = scanner.next();
	             if (Pattern.matches("[가-힣]{2,10}+", paName)) {
	                 break;
	              }
	              System.out.println("한글 이름을 두글자 이상 입력해주세요");
			  }
			  String paRegno1 = null;
			  while (true) {				  
				System.out.print("주민번호 앞자리: ");
				paRegno1 = scanner.next();
				if (Pattern.matches("[0-9]{6}", paRegno1)) {
	                break;
	             }
	             System.out.println("주민등록번호 앞 6자리를 입력해주세요");
			  }
			  String paRegno2 = null;
			  while (true) {				  
				System.out.print("주민번호 뒷자리: ");
				paRegno2 = scanner.next();
				if (Pattern.matches("[1-4]\\d{6}", paRegno2)) {
	                break;
	             }
	             System.out.println("주민등록번호 뒤 7자리를 입력해주세요");
			  }
			  String paHp = null;
			  while (true) {				  
				System.out.print("휴대폰 번호: ");
				paHp = scanner.next();
				if (Pattern.matches("\\d{3}-\\d{3,4}-\\d{4}", paHp)) {
	                break;
	             }
	             System.out.println("올바른 휴대전화 번호를 입력하세요.");
			  }
			  String paEmail = null;
			  while (true) {				  
				System.out.print("이메일: ");
				paEmail = scanner.next();
				if (Pattern.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z]+", paEmail)) {
	                break;
	             }
	             System.out.println("올바른 이메일 형식을 입력하세요");
			  }
					
				padao.insertPassenger(new PassengerDTO(paName, paRegno1, paRegno2, paHp, paEmail));
			  }	  
			
			

		  
		  PromotionDAO pdao = new PromotionDAO();
		  PromotionTest ptest = new PromotionTest();
			  System.out.println("");
			  System.out.println("프로모션을 이용하시겠습니까?");
			  System.out.print("1. 할인코드 입력	 2. 할인코드 없음  ");
			  int resNum2 = scanner.nextInt();
			  String proId = "";
		            if (resNum2 == 1) {
		               try {
		               System.out.println("");
		               System.out.print("할인코드를 입력하세요: ");
		                  proId = scanner.next();
		                  PromotionDTO vo = pdao.selectPromotionId(proId);
		                  vo.getPromotionId();
		                  System.out.println(vo.getPromotionRate() + "% 할인이 적용되었습니다.");
		               } catch (NullPointerException e) {
		                  System.out.println("유효하지 않은 할인코드입니다.");
		               }
		            }

				
				
				MemDTO vo = mdao.selectMileage(memId);
				  System.out.println("");
				  System.out.println("마일리지를 사용하시겠습니까?");
				  System.out.print("(사용가능한 마일리지는 ");
			      System.out.print(vo.getMemMileage());
			      System.out.println("입니다.)");
			      System.out.print("1. 예	     2. 아니요");
			      int resNum3 = scanner.nextInt();
			      int mileage = 0;
			      if (resNum3 == 1) {
			    	  System.out.print("사용할 마일리지 : ");
			    	  mileage = scanner.nextInt();
			      }
			    
			    System.out.println("");
			    System.out.println("결제수단을 선택하십시오.");
			    System.out.print("1. 카카오페이   2. 신용카드  3. 무통장입금  ");
			    int resNum4 = scanner.nextInt();
			    switch (resNum4) {

			    case 1 : while (true) {
			    	System.out.println("");
			    	System.out.println("바코드번호 16자리를 입력하십시오.");
			    		 String pay1 = scanner.next();
			    		 if (Pattern.matches("[0-9]{16}", pay1)) {
			    			 break;
			    		 }
			    }
			    		 break;
			    case 2 : while (true) {
			    	System.out.println("");
			    	System.out.println("카드번호 16자리를 입력하십시오.");
		    		 String pay2 = scanner.next();
		    		 if (Pattern.matches("[0-9]{16}", pay2)) {
		    			 break;
		    		 }
			    }
	    		 		 break;
			    case 3 : System.out.println("");
			    		 System.out.println("입금계좌 : 국민 480402-04-111144");
			             break;
			    }		    
			    
			    System.out.println("");
			    System.out.println("예약이 성공적으로 완료되었습니다!");
			    System.out.println("");	
			    if (resNum == 1) {
			    	System.out.println("<" + list4.get(0).getMemName() + "님의 예약 정보>");
			    } else {
			    	System.out.println("<예약 정보>");
			    }
			    if (resCourse == 1) {
			    	System.out.print(depTime + "에 " + depAirport + "에서 " + arrAirport + "(으)로 출발하는 ");			    	
			    } else {
			    	System.out.print(depTime + "에 " + arrAirport + "에서 " + depAirport + "(으)로 출발하는 ");			    	
			    	
			    }
				    if (resCourse == 1) {
				    	System.out.println("편도 비행입니다.");			    	
				    } else {
				    	System.out.println("왕복 비행입니다.");
				    }
			System.out.println("-------------------------------------------------------------------------------------------------------------------------");	    
		    System.out.println("항공권코드		출발시각		도착시각  	      출발지  도착지 항공사코드 항공사이름   항공권금액");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------");  
			      System.out.print(list2.get(resTime1-1).getFlightId() + "\t");
				  System.out.print(list2.get(resTime1-1).getDepTime() + "\t");
				  System.out.print(list2.get(resTime1-1).getArrTime() + "\t");
				  System.out.print(list2.get(resTime1-1).getDepAirport() + "\t");
				  System.out.print(list2.get(resTime1-1).getArrAirport() + "\t");
				  System.out.print(list2.get(resTime1-1).getAirlineId() + "\t");
				  System.out.print(list2.get(resTime1-1).getAirlineName() + "\t");
				  System.out.print(list2.get(resTime1-1).getPrice() + "\n");
				if (resCourse == 2)  {
			      System.out.print(list3.get(resTime2-1).getFlightId() + "\t");
				  System.out.print(list3.get(resTime2-1).getDepTime() + "\t");
				  System.out.print(list3.get(resTime2-1).getArrTime() + "\t");
				  System.out.print(list3.get(resTime2-1).getDepAirport() + "\t");
				  System.out.print(list3.get(resTime2-1).getArrAirport() + "\t");
				  System.out.print(list3.get(resTime2-1).getAirlineId() + "\t");
				  System.out.print(list3.get(resTime2-1).getAirlineName() + "\t");
				  System.out.print(list3.get(resTime2-1).getPrice() + "\n");
				}
				  
			System.out.println("-------------------------------------------------------------------------------------------------------------------------");  	  
				  System.out.println("탑승인원: 총 " + person1 + "명 (성인: " + (person1-child1-child2) + "명 유아: " + child1 + "명 소아: " + child2 + "명)");
				  System.out.println("");
				  System.out.println("탑승자 정보");
			if (resNum == 1) {
				System.out.println("------------------------------------------------------");
				System.out.println("아이디  이름   생년월일   이메일 	 휴대폰번호");
				System.out.println("------------------------------------------------------"); 
				for (MemDTO vo1 : list4) {
					System.out.print(vo1.getMemId() + "\t");
					System.out.print(vo1.getMemName() + "\t");
					System.out.print(vo1.getMemRegno1() + "\t");
					System.out.print(vo1.getMemEmail() + "\t");
					System.out.print(vo1.getMemHp() + "\n");
					}
			}
			
			if (person1 > 1) {
				List<PassengerDTO> list = padao.selectPassengerList();
				for (PassengerDTO vo1 : list) {
					System.out.print("비회원" + "\t");
					System.out.print(vo1.getPaName() + "\t");
					System.out.print(vo1.getPaRegno1() + "\t");
					System.out.print(vo1.getPaEmail() + "\t");
					System.out.print(vo1.getPaHp() + "\n");
				}
			}
			System.out.println("------------------------------------------------------"); 
			
			int price = 0;
			if (resCourse == 1) {
				price = list2.get(resTime1-1).getPrice();			
			} else {
				price = list2.get(resTime1-1).getPrice() + list3.get(resTime2-1).getPrice();
			}
			if (person1 > 1) {		
				int cprice1 = 0;
				int cprice2 = 0;
				if (person2 == 1) {
					if (child1 > 0) {
						cprice1 = price * child1 * 10 / 100;
					}
					if (child2 > 0) {
						cprice2 = price * child2 * 75 / 100;
					}
				}
				price = price * (person1 - child1 - child2) + cprice1 + cprice2;
			}
			
			if (resNum2 == 1) {				
				PromotionDTO provo = pdao.selectPromotionId(proId);
				price = price*(100-provo.getPromotionRate())/100;  
			}
			
			if (resNum3 == 1) {
				price = price - mileage;
			}
			
			System.out.println("");
			System.out.print("최종결제금액: ");
			System.out.println(price);
			return 3;
	}

}
