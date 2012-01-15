package com.jaws;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookClubService {
    @Autowired
    private BookClubDao bookClubDao;

    public void addPost(Comments post) {
        this.bookClubDao.create(post);
    }

    public List<Comments> findAllPosts() {
        return this.bookClubDao.findAll();
    }
    
    public List<Comments> findPostPage(String start) {
        return this.bookClubDao.findRecords(start);
    }
}