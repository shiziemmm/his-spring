package cn.gson.hisspring.model.service.jurisdiction_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.TitleMapper;
import cn.gson.hisspring.model.pojos.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleService {
    @Autowired
    TitleMapper titleMapper;

    public List<Title> selectList() {
        return titleMapper.selectList(null);
    }
}
