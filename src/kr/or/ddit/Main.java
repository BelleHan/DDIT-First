package kr.or.ddit;

public class Main {
	private MainController mainController = MainController.getInstance();
	
	public static void main(String[] args) throws Exception {
		new Main().init();
	}
	public void init() throws Exception {
		int menu = mainController.home();
		while (true) {
			switch (menu) {
			case 0:
				System.out.println("");
				System.out.println("스카이스캐너를 이용해 주셔서 감사합니다.");
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			case 1:
				menu = mainController.login();
				break;
			case 2:
				menu = mainController.join();
			case 3:
				menu = mainController.mainPage();
				break;
			}
		}
	}
}
