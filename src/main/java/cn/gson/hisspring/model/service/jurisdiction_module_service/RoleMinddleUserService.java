package cn.gson.hisspring.model.service.jurisdiction_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.RoleMinddleUserMapper;
import cn.gson.hisspring.model.pojos.RoleMiddleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleMinddleUserService {
    @Autowired
    RoleMinddleUserMapper ro;
    public int addRoleMinddle(RoleMiddleUser roleMiddleUser){
        return ro.insert(roleMiddleUser);
    }
    public int upa(long uId,long rId){
        return ro.upa(uId,rId);
    }
    public List<RoleMiddleUser> select(Integer uId){return ro.select(uId);};
}
