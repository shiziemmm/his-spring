package cn.gson.hisspring;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.BedMapper;
import cn.gson.hisspring.model.pojos.*;
import cn.gson.hisspring.model.pojos.pojos_vo.PatientUpdateBedVo;
import cn.gson.hisspring.model.service.inhospital_module_service.*;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@SpringBootTest
@MapperScan("cn.gson.hisspring.model.mapper")
class HisSpringApplicationTests {

    @Autowired
    PayService ps;

    @Test
    void text9(){
        ZyPay py = new ZyPay();
        py.setPtNo(101L);
        py.setPyPrice(2990d);
        py.setSId(2L);

        ps.addPay(py);
    }

    @Autowired
    DischargeApplyService das;
    @Test
    void text11(){
        das.callPatientApply(101L,"还需要留院观察");
    }


    @Autowired
    InHospitalApplyService ihas;

    @Test
    void text3(){
//        List<ZyInhospitalApply> list = ihas.selectHspApply();
//        list.forEach(i->{
//            System.out.println(i);
//        });
    }

    @Autowired
    PatientBaseService pbs;

    @Test
    void text10(){
        ZyChangeDeptRecord c = new ZyChangeDeptRecord();
        c.setCdrBeforeKs(1L);
        c.setCdrAfterKs(2L);
        c.setCdrCause("太吵了");
        c.setCdrDate(new Timestamp(new Date().getTime()));
        c.setPtNo(101L);
        c.setDoctorId(1L);
        c.setSId(100L);
        c.setBdId(25L);
        pbs.patientChangeDept(c);
    }

    @Test
    void text7(){
        PatientUpdateBedVo vo = new PatientUpdateBedVo();
        vo.setPtNo(101L);
        vo.setBcCurrentBdId(1L);
        vo.setBcLaterBdId(20L);
        vo.setBdPrice(200d);
        pbs.PatientUpdateBed(vo);
    }

    @Test
    void Text6(){
        pbs.PatientUpdateBdIdAndBedUpdateBdIsAndPtNo(3L,101L,200d);
    }

    @Test
    void text5(){
        List<ZyPatientBase> list = pbs.selectPatientNoBed("");
        list.forEach(b->{
            System.out.println(b);
        });
    }


    @Autowired
    WardService wds;

    @Autowired
    BedMapper bm;

    @Autowired
    BedService bs;

    @Test
    void text4(){
        List<ZyBed> list = bs.bedSelectByWdId(1);
        list.forEach(i->{
            System.out.println(i);
        });
    }


    @Test
    void text2(){
        bs.bedUpdateBdIs(1,3);
    }

    @Test
    void text1(){
        ZyBed b = new ZyBed();
        b.setBdId(16);
        b.setBdName("shisihsizii");
        bm.updateById(b);
    }

    @Test
    void contextLoads() {
//        ZyWard ward = new ZyWard();
//        ward.setWdId(3);
//        ward.setWdName("感染科");
//        ward.setKsId(88898L);

//        wds.insertWard(ward);


        List<ZyWard> list = wds.selectWardByKsId("1");
        for (ZyWard z:list){
            System.out.println(z);
        }

    }

}
