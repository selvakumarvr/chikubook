package com.jaws;

import java.util.List;

public interface BookClubDao {
	
	public void create(Comments post);
	
	public List<Comments> findAll();
	
	public List<Comments> findRecords(String start);

	}