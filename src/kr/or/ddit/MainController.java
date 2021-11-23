package kr.or.ddit;

import java.util.Scanner;
import java.util.regex.Pattern;

import kr.or.ddit.flight.FlightController;
import kr.or.ddit.login.LogInDAO;
import kr.or.ddit.mem.MemController;
import kr.or.ddit.mem.MemDAO;
import kr.or.ddit.mem.MemDTO;
import kr.or.ddit.promotion.PromotionController;

public class MainController {
	private Scanner scanner = new Scanner(System.in);
	private static MainController instance = new MainController();
	private static LogInDAO dao = new LogInDAO();

	private MainController() {
	}

	private FlightController flightController = FlightController.getInstance();

	public static MainController getInstance() {
		return instance;
	}

	public int home() {
		System.out.println("스카이스캐너에 오신 것을 환영합니다!");
		System.out.println("");
		System.out.print("1. 로그인 	2.회원가입	");
		return scanner.nextInt();
	}
	
	//로그인
	public int login() throws Exception {
				
           try {
        	  System.out.println("");
              System.out.print("아이디를 입력하세요: ");
              String userId = scanner.next();
              System.out.print("비밀번호를 입력하세요: ");
              String userPass = scanner.next();
              MemDTO vo = dao.selectMemId(userId, userPass);
              vo.getMemId();
              System.out.println("로그인 되었습니다.");
           } catch (NullPointerException e) {
              System.out.println("*아이디나 비밀번호를 확인하세요");
              return 1;
           }
		return 3;
		}

	
	// 회원 등록
	public int join() throws Exception {
		System.out.println("");
        System.out.println("회원 등록하기");
        String memId = null;
        while (true) {
           System.out.print("아이디: ");
           memId = scanner.next();
           if (Pattern.matches("^[a-zA-Z0-9]{2,10}", memId)) {
              break;
           }
           System.out.println("*영문자 혹은 숫자로 시작하는 2-10글자로 입력하세요.");
        }

        String memPass = null;
        while (true) {
           System.out.print("비밀번호: ");
           memPass = scanner.next();
           if (Pattern.matches("^[a-zA-Z0-9]{2,10}", memPass)) {
              break;
           }
           System.out.println("*영문자와 숫자를 조합하여 2-10글자로 입력하세요.");
        }

        String memName = null;
        while (true) {
           System.out.print("이름: ");
           memName = scanner.next();
           if (Pattern.matches("[가-힣]{2,10}+", memName)) {
              break;
           }
           System.out.println("*한글 이름을 두 글자 이상 입력하세요.");
        }

        String memRegno1 = null;
        while (true) {
           System.out.print("주민번호 앞자리: ");
           memRegno1 = scanner.next();
           if (Pattern.matches("[0-9]{6}", memRegno1)) {
              break;
           }
           System.out.println("*주민등록번호 앞 6자리를 입력하세요.");
        }

        String memRegno2 = null;
        while (true) {
           System.out.print("주민번호 뒷자리: ");
           memRegno2 = scanner.next();
           if (Pattern.matches("[1-4]\\d{6}", memRegno2)) {
              break;
           }
           System.out.println("*주민등록번호 뒤 7자리를 입력하세요.");
        }

        String memEmail = null;
        while (true) {
           System.out.print("이메일: ");
           memEmail = scanner.next();
           if (Pattern.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z]+", memEmail)) {
              break;
           }
           System.out.println("*올바른 이메일 형식을 입력하세요.");
        }

        String memHp = null;
        while (true) {
           System.out.print("휴대폰 번호: ");
           memHp = scanner.next();
           if (Pattern.matches("\\d{3}-\\d{3,4}-\\d{4}", memHp)) {
              break;
           }
           System.out.println("*올바른 휴대전화 번호를 입력하세요.");
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
           System.out.println("*(YYYY/MM/DD)형식으로 날짜를 입력하세요.");
        }

        MemDAO dao1 = new MemDAO();
        dao1.insertMem(new MemDTO(memId, memPass, memName, memRegno1, memRegno2, memEmail, memHp, memAdd1,
              memAdd2, memMemorialDay));
		return 3;
	}

	public int mainPage() throws Exception {
		int retMenu = 3;
		flight: while (true) {
			System.out.println("");
			System.out.println("<스카이스캐너 메뉴>");
			System.out.print("1. 항공권조회 	 2. 마이페이지 	 3. 프로모션	0. 프로그램 종료  ");
			
			Scanner scanner = new Scanner(System.in);
			int menu = scanner.nextInt();
			switch (menu) {
			case 1:
				menu = flightController.search(scanner);
				break;
			case 2:
				menu = MemController.myPage(scanner);
				break;
			case 3:
				menu = PromotionController.promotion(scanner);
				break;
			case 0:
				retMenu = 0;
				break flight;
			}
		}
		return retMenu;
	
	}
}
