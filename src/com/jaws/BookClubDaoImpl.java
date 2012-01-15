package com.jaws;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.stereotype.Repository;

@Repository
public class BookClubDaoImpl implements BookClubDao {

	@Override
	public synchronized void create(Comments post) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(post);
		} finally {
			pm.close();
		}
	}

	/**
	 * TODO: investigate appengine bugs here -
	 * http://code.google.com/p/datanucleus-appengine/issues/detail?id=24 -
	 * http:
	 * //groups.google.com/group/google-appengine-java/browse_thread/thread/
	 * 945f6ca66c1c587e
	 */

	public synchronized List<Comments> findRecords(String start) {
		PersistenceManager pm = PMF.get().getPersistenceManager();

		List<Comments> posts;
		try {
			Long startNumber = Long.parseLong(start);
			Long lower_bound = startNumber;
			Long upper_bound = startNumber+10;
			Query query = pm.newQuery(Comments.class);
			query.setOrdering("postDate desc");

			query.setRange(lower_bound, upper_bound);
			posts = (List<Comments>) pm.newQuery(query).execute();
			posts.size();
			return posts;

		} finally {
			pm.close();
		}
	}
	
	
	/**
	 * TODO: investigate appengine bugs here -
	 * http://code.google.com/p/datanucleus-appengine/issues/detail?id=24 -
	 * http:
	 * //groups.google.com/group/google-appengine-java/browse_thread/thread/
	 * 945f6ca66c1c587e
	 */

	public synchronized List<Comments> findAll() {
		PersistenceManager pm = PMF.get().getPersistenceManager();

		List<Comments> posts;
		try {
			Query query = pm.newQuery(Comments.class);
			query.setOrdering("postDate desc");

			
			posts = (List<Comments>) pm.newQuery(query).execute();
			posts.size();
			return posts;

		} finally {
			pm.close();
		}
	}
}