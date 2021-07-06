package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_controller.zyBedMapper;
import cn.gson.hisspring.model.pojos.ZyBed;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TextDemo {

    @Autowired
    zyBedMapper mapper;

    public List<ZyBed> selectPayAllPage(){
        Page<ZyBed> page = new Page<>(1,2);
        return mapper.selectAllZyBed(page);
    }
}
