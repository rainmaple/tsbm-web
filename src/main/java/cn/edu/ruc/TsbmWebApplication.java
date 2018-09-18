package cn.edu.ruc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cn.edu.ruc.biz.Core;
import cn.edu.ruc.biz.CoreBiz;
@MapperScan("cn.edu.ruc.mapper")
@SpringBootApplication
public class TsbmWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(TsbmWebApplication.class, args);
	}
}
