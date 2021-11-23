package kr.or.ddit.mem;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import kr.or.ddit.MemTest;
import kr.or.ddit.mem.MemDAO;
import kr.or.ddit.mem.MemDTO;


public class MemController {	
	private static MemDAO dao = new MemDAO();
	private static MemController instance = new MemController();
	private MemController() {
	}
	public static MemController getInstance() {
		return instance;
	}
	public static int myPage(Scanner scanner) throws Exception {

			      MemTest main = new MemTest();
			      mainLoop: while (true) {
			         System.out
			               .println("---------------------------------------------------------------------------------------");
			         System.out.println("1.예약조회\t2.마일리지조회 \t3.회원등록\t4.회원수정\t5.회원삭제\t0.종료");
			         System.out
			               .println("---------------------------------------------------------------------------------------");
			         System.out.print("메뉴를 선택하세요: ");
			         int menu = scanner.nextInt();
			         switch (menu) {
			         case 1:
//			            scanner.next();
//			            main.selectMemList();
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
			               if (Pattern.matches("[a-zA-Z]{2,10}[0-9]{1,10}+", memId)) {
			                  break;
			               }
			               System.out.println("아이디 영문자 2글자 이상+숫자 1글자 이상 조합으로 입력 ex)hyeon2");
			            }
			            System.out.print("비밀번호: ");
			            String memPass = scanner.next();

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
			            MemDAO dao2 = new MemDAO();
			            System.out.println("회원 수정하기");
			            System.out.print("수정할 아이디: ");
			            String memId1 = scanner.next();
			            System.out.print("수정할 비밀번호: ");
			            String memPass1 = scanner.next();
			            System.out.print("수정할 이름: ");
			            String memName1 = scanner.next();
			            System.out.print("수정할 주민번호 앞: ");
			            String memRegno11 = scanner.next();
			            System.out.print("수정할 주민번호 뒤: ");
			            String memRegno21 = scanner.next();
			            System.out.print("수정할 이메일: ");
			            String memEmail1 = scanner.next();
			            System.out.print("수정할 전화번호: ");
			            String memHp1 = scanner.next();
			            System.out.print("수정할 도로명: ");
			            String memAdd11 = scanner.next();
			            System.out.print("수정할 상세주소: ");
			            String memAdd21 = scanner.next();
			            System.out.print("기념일(YYYY/MM/DD): ");
			            String memMemorialDay1 = scanner.next();
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
			            System.out.println("프로그램을 종료합니다.");
			            break mainLoop;
			         }
			         System.out.println();
//			         break; --다시 메뉴선택으로
			      }
			      return 3;
			   }
	
	
} 

						
	
	
	

