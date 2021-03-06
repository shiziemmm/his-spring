package cn.gson.hisspring.model.mapper.jurisdiction_module_mapper;

import cn.gson.hisspring.model.pojos.Staff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffMapper extends BaseMapper<Staff> {
    List<Staff> selectALl();
    List<Staff> selectksId(long ksId);
    List<Staff> selecttId(long tId);
    int upa(long sid);
    List<Staff> selectRole(long uId);

}
