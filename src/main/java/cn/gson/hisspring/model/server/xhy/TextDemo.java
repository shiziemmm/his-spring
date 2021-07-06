package cn.gson.hisspring.model.server.xhy;

import cn.gson.hisspring.model.mapper.xhy.zyBedMapper;
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
