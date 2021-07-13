package cn.gson.hisspring;

import cn.gson.hisspring.model.pojos.MzMedicalCard;
import cn.gson.hisspring.model.pojos.MzSick;
import cn.gson.hisspring.model.pojos.ZyWard;
import cn.gson.hisspring.model.service.inhospital_module_service.WardService;
import cn.gson.hisspring.model.service.outpatient_module_service.MzMedicalCardService;
import cn.gson.hisspring.model.service.outpatient_module_service.MzSickService;
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
        ZyWard ward = new ZyWard();
//        ward.setWdId(3);
        ward.setWdName("感染科");
//        ward.setKsId(88898L);

//        wds.insertWard(ward);

        List<ZyWard> list = wds.selectWardAllPage("骨");
        for (ZyWard z:list){
            System.out.println(z);
        }

    }

    @Autowired
    MzMedicalCardService ms;
    @Autowired
    MzSickService mzSick;

    @Test
    void test(){
    }

}
