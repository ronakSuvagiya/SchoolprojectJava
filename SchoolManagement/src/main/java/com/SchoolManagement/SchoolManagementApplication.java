package com.SchoolManagement;

import java.io.File;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class SchoolManagementApplication {

  public static void main(String[] args) {
    SpringApplication.run(SchoolManagementApplication.class, args);
    new File(System.getProperty("user.dir") + "/image").mkdirs();
    new File(System.getProperty("user.dir") + "/timeTable").mkdirs();
  }

}
