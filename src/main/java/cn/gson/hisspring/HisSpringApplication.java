package cn.gson.hisspring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//扫描mapper包
@MapperScan("cn.gson.hisspring.model.mapper")
@SpringBootApplication
public class HisSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(HisSpringApplication.class, args);
    }

}
