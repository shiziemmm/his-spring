package cn.gson.hisspring;

import cn.gson.hisspring.model.mapper.xhy.zyBedMapper;
import cn.gson.hisspring.model.pojos.ZyBed;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("cn.gson.hisspring.model.mapper")
class HisSpringApplicationTests {

    @Autowired
    zyBedMapper mapper;

    @Test
    void contextLoads() {
        List<ZyBed> list = mapper.selectList(null);
        for (ZyBed z:list){
            System.out.println(z);
        }

    }

}
