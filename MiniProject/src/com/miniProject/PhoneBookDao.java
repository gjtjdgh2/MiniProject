package com.miniProject;

import java.util.*;

public interface PhoneBookDao {

	public List<PhoneBookVo> getList();
	public List<PhoneBookVo> search(String keyword);
	public PhoneBookVo get(int id);
	public boolean insert(PhoneBookVo vo);
	public boolean update(PhoneBookVo vo);
	public boolean delete(int id);
	 
}
 