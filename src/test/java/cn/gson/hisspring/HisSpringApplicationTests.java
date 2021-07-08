package cn.gson.hisspring;

import cn.gson.hisspring.model.pojos.ZyWard;
import cn.gson.hisspring.model.service.inhospital_module_service.WardService;
import cn.gson.hisspring.model.service.outpatient_module_service.MzMedicalCardService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("cn.gson.hisspring.model.mapper")
class HisSpringApplicationTests {

    @Autowired
    WardService wds;

    @Test
    void contextLoads() {
        List<ZyWard> list = wds.selectWardAllPage();
        for (ZyWard z:list){
            System.out.println(z);
        }

    }

    @Autowired
    MzMedicalCardService ms;

    @Test
    void test(){
        ms.selectCardCreateTime(1,5);
    }

}
