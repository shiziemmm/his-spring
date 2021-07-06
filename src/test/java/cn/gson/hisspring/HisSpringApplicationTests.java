package cn.gson.hisspring;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.zyBedMapper;
import cn.gson.hisspring.model.pojos.ZyBed;
import cn.gson.hisspring.model.service.inhospital_module_service.ZyBedService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("cn.gson.hisspring.model.mapper")
class HisSpringApplicationTests {

    @Autowired
    ZyBedService beds;

    @Test
    void contextLoads() {
        List<ZyBed> list = beds.selectPayAllPage();
        for (ZyBed z:list){
            System.out.println(z);
        }

    }

}
