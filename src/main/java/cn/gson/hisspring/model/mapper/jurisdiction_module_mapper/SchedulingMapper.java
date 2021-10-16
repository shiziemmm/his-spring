package cn.gson.hisspring.model.mapper.jurisdiction_module_mapper;

import cn.gson.hisspring.model.pojos.Scheduling;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface SchedulingMapper extends BaseMapper<Scheduling> {
    int addSch(@Param("rq") Date rq,@Param("sid") Integer sid, @Param("list") List<Integer> list);
    List<Scheduling>selectWeek(@Param("rq")String rq,@Param("ksId") long ksId);

    List<Scheduling>selectAllWeek(@Param("rq")String rq,@Param("ksId") long ksId,@Param("frId") long frId);
    List<Scheduling> selectNowWeek();
    List<Scheduling>selectNow(@Param("rq")String rq,@Param("ksId") long ksId,@Param("sId") long sId);
    List<Scheduling> selectDate();
    List<Scheduling>seletSch(@Param("rq")String rq,@Param("list") List<Integer> dome);

}
