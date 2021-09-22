package cn.gson.hisspring.model.mapper.pharmacy_module_mapper;

import cn.gson.hisspring.model.pojos.YkAllot;
import cn.gson.hisspring.model.pojos.YkAllotdetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YKAllotMapper {
    //查询调拨申请
    List<YkAllot> allykallot();
    //查询调拨详表
    List<YkAllotdetail> alldetail();
    //新增调拨
    void adddykallot(YkAllot ykAllot);
    //新增调拨详表
    void  addykallotdetail(YkAllotdetail ykAllotdetail);
}
