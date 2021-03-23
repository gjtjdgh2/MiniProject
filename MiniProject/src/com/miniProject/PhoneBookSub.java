package com.miniProject;

import java.util.*;

public class PhoneBookSub {

	  
	public  void listPhoneBook() {
		PhoneBookDao dao= new PhoneBookDaoOracle();
		List<PhoneBookVo> list= dao.getList();
		
		Iterator<PhoneBookVo> it = list.iterator();
		while(it.hasNext()) {
			PhoneBookVo vo = it.next(); //내용 불러 오기
			System.out.printf("%d , %s , %s , %s%n",vo.getId(),vo.getName(),vo.getHp(),vo.getTel());
		}
			
		}
	
	
	public  void searchPhoneBook(String name) {
		
		PhoneBookDao dao= new PhoneBookDaoOracle();
		List<PhoneBookVo> list= dao.search(name);
		
		Iterator<PhoneBookVo> it = list.iterator();
		
		while(it.hasNext()) {
			PhoneBookVo vo = it.next();
			System.out.printf("%d , %s , %s , %s%n",vo.getId(),vo.getName(),vo.getHp(),vo.getTel());
		}
			
		
	}
	
	
	public  void deletePhoneBook(int id) {
		PhoneBookDao dao= new  PhoneBookDaoOracle();
		
		boolean success = dao.delete(id);
		System.out.println("PhoneBook delete:"+(success? "성공":"실패"));
		
	}
	
	
	public  void insertPhoneBook(String name,String ph, String tel) {
		PhoneBookVo vo= new  PhoneBookVo(name, ph, tel);
		PhoneBookDao dao= new  PhoneBookDaoOracle();
		boolean success = dao.insert(vo);
		
		System.out.println("PhoneBook insert:"+(success? "성공":"실패"));
	}
	
	
	
	
}
