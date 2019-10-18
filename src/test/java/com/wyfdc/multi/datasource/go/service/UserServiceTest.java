package com.wyfdc.multi.datasource.go.service;


import com.wyfdc.multi.datasource.go.GoApplication;
import com.wyfdc.multi.datasource.go.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author:  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GoApplication.class )//这里是启动类
public class UserServiceTest {

  @Autowired
  private UserService userService;

  @Before
  public void setUp() throws Exception {
    System.out.println("===================================");
  }

  @After
  public void tearDown() throws Exception {
    System.out.println("===================================");
  }


  @Test
  public void saveUserById_UserDb1() {
    for(int i=1;i<100;i++){
      User user = new User();
      user.setId("id_"+i);
      user.setUsername("name_"+i);
      user.setEmail("name_"+i+"@email.com");
      user.setPasswd("password_"+i);
      userService.saveUserById_ArchivesDb1(user);
    }

  }

  @Test
  public void findUserById_UserDb21() {
    for(int i=1;i<100;i++){
      User user = new User();
      user.setId("id_"+i);
      user.setUsername("name_"+i);
      user.setEmail("name_"+i+"@email.com");
      user.setPasswd("password_"+i);
      userService.saveUserById_PictureDb2(user);
    }
  }
}
