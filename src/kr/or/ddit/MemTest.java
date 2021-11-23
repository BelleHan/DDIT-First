package kr.or.ddit;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import kr.or.ddit.mem.MemDAO;
import kr.or.ddit.mem.MemDTO;


public class MemTest {
	private static MemDAO dao = new MemDAO();
	
		   public static void main(String[] args) throws Exception {
		      Scanner scanner = new Scanner(System.in);
		      MemTest main = new MemTest();
		      mainLoop: while (true) {
		         System.out
		               .println("-------------------------------------------------------------------------------------------------");
		         System.out.println("1.예약조회\t2.마일리지조회 \t3.회원등록\t4.회원수정\t5.회원삭제\t0.마이페이지 종료");
		         System.out
		               .println("-------------------------------------------------------------------------------------------------");
		         System.out.print("메뉴를 선택하세요: ");
		         int menu = scanner.nextInt();
		         switch (menu) {
		         case 1:
//		            scanner.next();
//		            main.selectMemList();
		            break;
		         case 2:
		            // 마일리지 조회
		            scanner.nextLine();
		            try {
		               System.out.print("조회할 아이디를 입력하세요: ");
		               String userId = scanner.next();
		               MemDTO vo = dao.selectMileage(userId);
		               System.out.print(vo.getMemMileage() + "\t");
		            } catch (NullPointerException e) {
		               System.out.println("등록되지 않은 아이디입니다.");
		            }
		            break;
		         case 3:
		             // 회원 등록
		             System.out.println("회원 등록하기");

		             String memId = null;
		             while (true) {
		                System.out.print("아이디: ");
		                memId = scanner.next();
		                if (Pattern.matches("^[a-zA-Z0-9]{2,10}", memId)) {
		                   break;
		                }
		                System.out.println("영어나 숫자로 시작하는 2글자 이상 10글자 이하 아이디");
		             }

		             String memPass = null;
		             while (true) {
		                System.out.print("비밀번호: ");
		                memPass = scanner.next();
		                if (Pattern.matches("^[a-zA-Z0-9]{2,10}", memPass)) {
		                   break;
		                }
		                System.out.println("영어와 숫자로 조합하여 2글자 이상 10글자 이하 비밀번호");
		             }

		             String memName = null;
		             while (true) {
		                System.out.print("이름: ");
		                memName = scanner.next();
		                if (Pattern.matches("[가-힣]{2,10}+", memName)) {
		                   break;
		                }
		                System.out.println("한글 이름을 두글자 이상 입력해주세요");
		             }

		             String memRegno1 = null;
		             while (true) {
		                System.out.print("주민번호 앞자리: ");
		                memRegno1 = scanner.next();
		                if (Pattern.matches("[0-9]{6}", memRegno1)) {
		                   break;
		                }
		                System.out.println("주민등록번호 앞 6자리를 입력해주세요");
		             }

		             String memRegno2 = null;
		             while (true) {
		                System.out.print("주민번호 뒷자리: ");
		                memRegno2 = scanner.next();
		                if (Pattern.matches("[1-4]\\d{6}", memRegno2)) {
		                   break;
		                }
		                System.out.println("주민등록번호 뒤 7자리를 입력해주세요");
		             }

		             String memEmail = null;
		             while (true) {
		                System.out.print("이메일: ");
		                memEmail = scanner.next();
		                if (Pattern.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z]+", memEmail)) {
		                   break;
		                }
		                System.out.println("올바른 이메일 형식을 입력하세요");
		             }

		             String memHp = null;
		             while (true) {
		                System.out.print("휴대폰 번호: ");
		                memHp = scanner.next();
		                if (Pattern.matches("\\d{3}-\\d{3,4}-\\d{4}", memHp)) {
		                   break;
		                }
		                System.out.println("올바른 휴대전화 번호를 입력하세요.");
		             }
		             System.out.print("도로명 주소: ");
		             String memAdd1 = scanner.next();
		             System.out.print("상세주소: ");
		             String memAdd2 = scanner.next();

		             String memMemorialDay = null;
		             while (true) {
		                System.out.print("기념일(YYYY/MM/DD): ");
		                memMemorialDay = scanner.next();
		                if (Pattern.matches("[0-9]{4}/[0-1]{1}[0-9]{1}/[0-3]{1}[0-9]{1}", memMemorialDay)) {
		                   break;
		                }
		                System.out.println("(YYYY/MM/DD)형식으로 날짜를 입력하세요");
		             }

		             MemDAO dao1 = new MemDAO();
		             dao1.insertMem(new MemDTO(memId, memPass, memName, memRegno1, memRegno2, memEmail, memHp, memAdd1,
		                   memAdd2, memMemorialDay));
		             break;
		            
		         case 4:
		            // 회원 수정
		        	   // 회원 수정
		             MemDAO dao2 = new MemDAO();
		             System.out.println("회원 수정하기");

		             String memId1 = null;
		             while (true) {
		                System.out.print("수정할 아이디: ");
		                memId1 = scanner.next();
		                if (Pattern.matches("^[a-zA-Z0-9]{2,10}+", memId1)) {
		                   break;
		                }
		                System.out.println("영어와 숫자로 조합하여 2글자 이상 10글자 이하 비밀번호");
		             }

		             String memPass1 = null;
		             while (true) {
		                System.out.print("비밀번호: ");
		                memPass1 = scanner.next();
		                if (Pattern.matches("^[a-zA-Z0-9]{2,10}", memPass1)) {
		                   break;
		                }
		                System.out.println("영어와 숫자로 조합하여 2글자 이상 10글자 이하 비밀번호");
		             }

		             String memName1 = null;
		             while (true) {
		                System.out.print("수정할 이름: ");
		                memName1 = scanner.next();
		                if (Pattern.matches("[가-힣]{2,10}+", memName1)) {
		                   break;
		                }
		                System.out.println("한글 이름을 두글자 이상 입력해주세요");
		             }

		             String memRegno11 = null;
		             while (true) {
		                System.out.print("주민번호 앞자리: ");
		                memRegno11 = scanner.next();
		                if (Pattern.matches("[0-9]{6}", memRegno11)) {
		                   break;
		                }
		                System.out.println("주민등록번호 앞 6자리를 입력해주세요");
		             }

		             String memRegno21 = null;
		             while (true) {
		                System.out.print("주민번호 뒷자리: ");
		                memRegno21 = scanner.next();
		                if (Pattern.matches("[1-4]\\d{6}", memRegno21)) {
		                   break;
		                }
		                System.out.println("주민등록번호 뒤 7자리를 입력해주세요");
		             }

		             String memEmail1 = null;
		             while (true) {
		                System.out.print("이메일: ");
		                memEmail1 = scanner.next();
		                if (Pattern.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z]+", memEmail1)) {
		                   break;
		                }
		                System.out.println("올바른 이메일 형식을 입력하세요");
		             }

		             String memHp1 = null;
		             while (true) {
		                System.out.print("휴대폰 번호(010-2928-5998): ");
		                memHp1 = scanner.next();
		                if (Pattern.matches("\\d{3}-\\d{3,4}-\\d{4}", memHp1)) {
		                   break;
		                }
		                System.out.println("올바른 휴대전화 번호를 입력하세요.ex)010-2928-5998");
		             }

		             System.out.print("수정할 도로명: ");
		             String memAdd11 = scanner.next();
		             System.out.print("수정할 상세주소: ");
		             String memAdd21 = scanner.next();

		             String memMemorialDay1 = null;
		             while (true) {
		                System.out.print("수정할 기념일(YYYY/MM/DD): ");
		                memMemorialDay1 = scanner.next();
		                if (Pattern.matches("[0-9]{4}/[0-1]{1}[0-9]{1}/[0-3]{1}[0-9]{1}", memMemorialDay1)) {
		                   break;
		                }
		                System.out.println("(YYYY/MM/DD)형식으로 날짜를 입력하세요");
		             }

		             dao2.updateMem(new MemDTO(memId1, memPass1, memName1, memRegno11, memRegno21, memEmail1, memHp1,
		                   memAdd11, memAdd21, memMemorialDay1));
		             break;
		         case 5:
		            // 회원 삭제
		            MemDAO dao3 = new MemDAO();
		            System.out.println("삭제하기");
		            System.out.print("삭제할 아이디: ");
		            String id = scanner.next();
		            dao3.deleteMem(id);
		            break;
		         case 0:
		            // 프로그램 종료
		            System.out.println("마이페이지를 종료합니다.");
		            break mainLoop;
		         }
		         System.out.println();
//		         break; --다시 메뉴선택으로
		      }
		      scanner.close();
		   }

		}		

		//회원 등록
//		System.out.println("등록하기");
//		System.out.print("아이디: ");
//		String memId = scanner.next();
//		System.out.print("비밀번호: ");
//		String memPass = scanner.next();
//		System.out.print("이름: ");
//		String memName = scanner.next();
//		System.out.print("주민번호 앞자리: ");
//		String memRegno1 = scanner.next();
//		System.out.print("주민번호 뒷자리: ");
//		String memRegno2 = scanner.next();
//		System.out.print("이메일: ");
//		String memEmail = scanner.next();
//		System.out.print("휴대폰 번호: ");
//		String memHp = scanner.next();
//		System.out.print("도로명 주소: ");
//		String memAdd1 = scanner.next();
//		System.out.print("상세주소: ");
//		String memAdd2 = scanner.next();
//		System.out.print("기념일: ");
//		String memMemorialDay = scanner.next();
//			
//		dao.insertMem(new MemDTO(memId,memPass, memName, memRegno1, memRegno2, memEmail,
//				 memHp, memAdd1, memAdd2, memMemorialDay));
//		
//        String memHp = null;
//        while (true) {
//           System.out.print("휴대폰 번호: ");
//           memHp = scanner.next();
//           if (Pattern.matches("\\d{3}-\\d{3,4}-\\d{4}", memHp)) {
//              break;
//           }
//           System.out.println("올바른 휴대전화 번호를 입력하세요.");
//        }
//		
//		//회원 조회
//		System.out.print("조회할 아이디를 입력하세요: ");
//		String memId = scanner.nextLine();
//		List<MemDTO> list2 = dao.selectMem(new MemDTO(memId));
//		for (MemDTO vo : list2) {
//		System.out.print(vo.getMemId() + "\t");
//		System.out.print(vo.getMemPass() + "\t");
//		System.out.print(vo.getMemName() + "\t");
//		System.out.print(vo.getMemRegno1() + "\t");
//		System.out.print(vo.getMemRegno2() + "\t");
//		System.out.print(vo.getMemEmail() + "\t");
//		System.out.print(vo.getMemHp() + "\t");
//		System.out.print(vo.getMemAdd1() + "\t");
//		System.out.print(vo.getMemAdd2() + "\t");
//		System.out.print(vo.getMemMemorialDay() + "\n");
//		}
//	
		
		//회원 조회
//		List<MemDTO> list = dao.selectMemList();
//		for (MemDTO vo : list) {
//			System.out.print(vo.getMemId() + "\t");
//			System.out.print(vo.getMemPass() + "\t");
//			System.out.print(vo.getMemName() + "\t");
//			System.out.print(vo.getMemRegno1() + "\t");
//			System.out.print(vo.getMemRegno2() + "\t");
//			System.out.print(vo.getMemEmail() + "\t");
//			System.out.print(vo.getMemHp() + "\t");
//			System.out.print(vo.getMemAdd1() + "\t");
//			System.out.print(vo.getMemAdd2() + "\t");
//			System.out.print(vo.getMemMemorialDay() + "\n");
//		}
//		try {
//		System.out.print("아이디를 입력하세요: ");
//	      String userId = scanner.nextLine();
//	      MemDTO vo = dao.selectMemId(userId);
//	      System.out.print(vo.getMemId() + "\t");
//	      scanner.close();
//		} catch (java.lang.NullPointerException e) {
//			System.out.println("잘못된 아이디를 입력하셨습니다.");
//		}
//	}
//}
