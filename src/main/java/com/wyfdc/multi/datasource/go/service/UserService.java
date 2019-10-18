package com.wyfdc.multi.datasource.go.service;

import com.wyfdc.multi.datasource.go.dao.UserDao;
import com.wyfdc.multi.datasource.go.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:  
 */
@Service
public class UserService {

  @Autowired
  private UserDao dao;

  public User findUserById_ArchivesDb1(String id){
    return  dao.findUserById_ArchivesDb1(id);
  }

  public User findUserById_PictureDb2(String id){
    return  dao.findUserById_PictureDb2(id);
  }

  public void saveUserById_ArchivesDb1(User user){
    dao.saveUserById_ArchivesDb1(user);
  }

  public void saveUserById_PictureDb2(User user){
      dao.saveUserById_PictureDb2(user);
  }

}
