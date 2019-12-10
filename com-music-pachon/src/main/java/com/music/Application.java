package com.music;

import java.io.IOException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import com.music.test.ZhihuTask;

@SpringBootApplication
@MapperScan(basePackages = "com.music.dao")
public class Application implements CommandLineRunner  {

	@Autowired
    private ZhihuTask zhihuTask;
	
	public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
    }
	
	@Override
	public void run(String... args) throws Exception {
		// 爬取知乎数据
        zhihuTask.crawl();
	}

}
