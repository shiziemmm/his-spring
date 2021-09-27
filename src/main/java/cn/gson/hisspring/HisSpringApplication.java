package cn.gson.hisspring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//扫描mapper包
@MapperScan("cn.gson.hisspring.model.mapper")
@SpringBootApplication
@EnableTransactionManagement //开启声明式事务
public class HisSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(HisSpringApplication.class, args);
    }

}
