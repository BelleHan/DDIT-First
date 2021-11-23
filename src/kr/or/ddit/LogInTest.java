package kr.or.ddit;


import java.util.Scanner;


import kr.or.ddit.login.LogInDAO;
import kr.or.ddit.mem.MemDAO;
import kr.or.ddit.mem.MemDTO;


public class LogInTest {
   private static LogInDAO dao = new LogInDAO();

   public static void main(String[] args) throws Exception {
      Scanner scanner = new Scanner(System.in);
      LogInTest main = new LogInTest();
//      mainLoop: while (true) {
//         System.out.println("------------------------------------");
//         System.out.println("1.로그인\t2.회원가입");
//         System.out.println("------------------------------------");
//         System.out.print("메뉴를 선택하세요: ");
         int login = scanner.nextInt();
         switch (login) {
         case 1:
            try {
               System.out.print("아이디를 입력하세요: ");
               String userId = scanner.next();
               System.out.print("비밀번호를 입력하세요: ");
               String userPass = scanner.next();
               MemDTO vo = dao.selectMemId(userId, userPass);
               vo.getMemId();
//               System.out.print(vo.getMemId() + "\t");
               System.out.println("로그인 성공");
            } catch (NullPointerException e) {
               System.out.println("아이디나 비밀번호를 확인하세요");
            }
            break;
         case 2:
            try {
               MemDAO dao1 = new MemDAO();
               System.out.println("회원가입");
               System.out.print("아이디: ");
               String memId = scanner.next();
               System.out.print("비밀번호: ");
               String memPass = scanner.next();
               System.out.print("이름: ");
               String memName = scanner.next();
               System.out.print("주민번호 앞자리: ");
               String memRegno1 = scanner.next();
               System.out.print("주민번호 뒷자리: ");
               String memRegno2 = scanner.next();
               System.out.print("이메일: ");
               String memEmail = scanner.next();
               System.out.print("휴대폰 번호: ");
               String memHp = scanner.next();
               System.out.print("도로명 주소: ");
               String memAdd1 = scanner.next();
               System.out.print("상세주소: ");
               String memAdd2 = scanner.next();

               System.out.print("기념일(YYYY/MM/DD): ");
               String memMemorialDay = scanner.next();

               dao1.insertMem(new MemDTO(memId, memPass, memName, memRegno1, memRegno2, memEmail, memHp, memAdd1,
                     memAdd2, memMemorialDay));

            } catch (Exception e) {
               System.out.println("잘못된 정보를 입력하였습니다.");
            }
            break;
         }
//         scanner.close();
      

   }

}