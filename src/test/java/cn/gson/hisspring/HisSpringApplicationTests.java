package cn.gson.hisspring;

import cn.gson.hisspring.model.pojos.ZyBed;
import cn.gson.hisspring.model.server.xhy.TextDemo;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@SpringBootTest
@MapperScan("cn.gson.hisspring.model.mapper")
class HisSpringApplicationTests {


    @Autowired
    TextDemo td;

    @Test
    public void shizi(){
        List<ZyBed> list = td.selectPayAllPage();
        for (ZyBed l:list){
            System.out.println(l);
        }
    }

}
