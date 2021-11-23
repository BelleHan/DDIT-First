package kr.or.ddit;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.passenger.PassengerDAO;
import kr.or.ddit.passenger.PassengerDTO;

public class PassengerTest {
	public static void main(String[] args) throws Exception {
		PassengerDAO dao = new PassengerDAO();
		Scanner scanner = new Scanner(System.in);
		//동승자 등록
//		System.out.println("동승자 정보 입력");
//		System.out.print("이름: ");
//		String paName = scanner.next();
//		System.out.print("주민번호 앞자리: ");
//		String paRegno1 = scanner.next();
//		System.out.print("주민번호 뒷자리: ");
//		String paRegno2 = scanner.next();
//		System.out.print("휴대폰 번호: ");
//		String paHp = scanner.next();
//		System.out.print("이메일: ");
//		String paEmail = scanner.next();
//			
//		dao.insertPassenger(new PassengerDTO(paName, paRegno1, paRegno2, paHp, paEmail));
	
		List<PassengerDTO> list = dao.selectPassengerList();
		for (PassengerDTO vo : list) {
			System.out.print(vo.getPaName() + "\t");
			System.out.print(vo.getPaRegno1() + "\t");
			System.out.print(vo.getPaEmail() + "\t");
			System.out.print(vo.getPaHp() + "\n");
		}
	}
}

