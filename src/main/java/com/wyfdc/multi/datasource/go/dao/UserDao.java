package com.wyfdc.multi.datasource.go.dao;

import com.alibaba.fastjson.JSON;
import com.wyfdc.multi.datasource.go.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
@Slf4j
public class UserDao {

  @Autowired
  @Qualifier(value = "archivesMongoTemplate")
  private MongoTemplate archivesMongoTemplate;

  @Autowired
  @Qualifier(value = "pictureMongoTemplate")
  private MongoTemplate pictureMongoTemplate;

  public User findUserById_ArchivesDb1(String id) {
    User user = archivesMongoTemplate.findOne(new Query(Criteria.where("id").is(id)), User.class);
    return user;
  }

  public void saveUserById_ArchivesDb1(User user) {
    User u = archivesMongoTemplate.save(user);
    log.info(JSON.toJSONString(u));
  }

  public User findUserById_PictureDb2(String id) {
    User user = pictureMongoTemplate.findOne(new Query(Criteria.where("id").is(id)), User.class);
    return user;
  }

  public void saveUserById_PictureDb2(User user) {
    User u = pictureMongoTemplate.save(user);
    log.info(JSON.toJSONString(u));
  }



}
