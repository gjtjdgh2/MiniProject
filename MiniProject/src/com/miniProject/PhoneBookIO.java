package com.miniProject;

import java.util.*;

public class PhoneBookIO {

public static void ioProject() {
	Scanner scan = new Scanner(System.in);
	while(true){
		System.out.println("---------------------------------");
		System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
		System.out.println("---------------------------------");
		System.out.print(">메뉴번호: ");
		 
		int num = scan.nextInt();
		switch(num) {
		 
		case 1:System.out.println("<1.리스트>");
		PhoneBookSub list = new PhoneBookSub();
		list.listPhoneBook();
		break;
		
		case 2:System.out.println("<2.등록>");
		System.out.print(">이름 : ");
		String name2 =scan.next();
		System.out.print(">휴대전화 : ");
		String ph2 =scan.next();
		System.out.print(">집전화 : ");
		String tel2 =scan.next();
		PhoneBookSub sub2 = new PhoneBookSub();
		sub2.insertPhoneBook(name2, ph2, tel2);
		
		System.out.println("[등록 되었습니다]");
		break;
		
		case 3:System.out.println("<삭제>");
		System.out.print(">번호 : ");
		int id = scan.nextInt();
		PhoneBookSub delete = new PhoneBookSub();
		delete.deletePhoneBook(id);
			System.out.println("[삭제 되었습니다]");
		break;	
		
		case 4:System.out.println("<4.검색>");
		System.out.print(">이름 :");
		String name = scan.next();
		PhoneBookSub ps= new PhoneBookSub();
		ps.searchPhoneBook(name);
		break;	
		
		
		case 5:
			System.out.println("********************");
			System.out.println("*      감사합니다     *");
			System.out.println("********************");
		break;
		
		default: System.out.println("[다시 입력해주세여]");
			
		}
		if(num == 5){ 
			break;
		}
	}
	
}
}

