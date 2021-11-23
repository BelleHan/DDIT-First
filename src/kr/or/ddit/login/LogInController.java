//package kr.or.ddit.login;
//
//
//import java.util.Scanner;
//
//
////import bookstore.common.HomeMenu;
////import bookstore.join.CustomerVO;
//import kr.or.ddit.login.LogInDAO;
//import kr.or.ddit.mem.MemDAO;
//import kr.or.ddit.mem.MemDTO;
//
//public class LogInController {
//   private static LogInDAO dao = new LogInDAO();
//   private static LogInController instance = new LogInController();
//   private LogInController() {
//	   
//   }
//
//   public static int logIn(Scanner scanner) throws Exception {
//      Scanner scanner1 = new Scanner(System.in);;
//
//            try {
//               MemDAO dao1 = new MemDAO();
//               System.out.println("회원가입");
//               System.out.print("아이디: ");
//               String memId = scanner1.next();
//               System.out.print("비밀번호: ");
//               String memPass = scanner1.next();
//               System.out.print("이름: ");
//               String memName = scanner1.next();
//               System.out.print("주민번호 앞자리: ");
//               String memRegno1 = scanner1.next();
//               System.out.print("주민번호 뒷자리: ");
//               String memRegno2 = scanner1.next();
//               System.out.print("이메일: ");
//               String memEmail = scanner1.next();
//               System.out.print("휴대폰 번호: ");
//               String memHp = scanner1.next();
//               System.out.print("도로명 주소: ");
//               String memAdd1 = scanner1.next();
//               System.out.print("상세주소: ");
//               String memAdd2 = scanner1.next();
//
//               System.out.print("기념일(YYYY/MM/DD): ");
//               String memMemorialDay = scanner1.next();
//
//               dao1.insertMem(new MemDTO(memId, memPass, memName, memRegno1, memRegno2, memEmail, memHp, memAdd1,
//                     memAdd2, memMemorialDay));
//
//            } catch (Exception e) {
//               System.out.println("잘못된 정보를 입력하였습니다.");
//            }
//  
//         }
////         scanner.close();
//      
//
//   
//
//}