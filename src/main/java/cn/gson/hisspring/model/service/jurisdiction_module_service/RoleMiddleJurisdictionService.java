package cn.gson.hisspring.model.service.jurisdiction_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.RoleMiddleJurisdictionMapper;
import cn.gson.hisspring.model.pojos.RoleMiddleJurisdiction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleMiddleJurisdictionService {
    @Autowired
    RoleMiddleJurisdictionMapper roleMiddleJurisdictionMapper;

    /*
    新增中间表
     */
    public int addRoleInfo(long rId, List<Integer> funs){
        List<RoleMiddleJurisdiction> roleMiddleJurisdiction = roleMiddleJurisdictionMapper.seleltAll(rId);
        System.out.println(roleMiddleJurisdiction);
        //根据r_id查中间表是否存在改用户权限，不存在直接新增，存在先删除在新增
        if(roleMiddleJurisdiction.size()>0){
            roleMiddleJurisdictionMapper.delet(rId);
        }
        return roleMiddleJurisdictionMapper.addRoleInfo(rId,funs);
    }
}
