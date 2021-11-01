package cn.gson.hisspring.model.service.jurisdiction_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.RoleMiddleJurisdictionMapper;
import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.RoleMinddleUserMapper;
import cn.gson.hisspring.model.pojos.RoleMiddleJurisdiction;
import cn.gson.hisspring.model.pojos.RoleMiddleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleMiddleJurisdictionService {
    @Autowired
    RoleMiddleJurisdictionMapper roleMiddleJurisdictionMapper;
    @Autowired
    RoleMinddleUserMapper roleMinddleUserMapper;

    /*
    新增中间表
     */
    public int addRoleInfo(long rId, List<Integer> funs) {
        List<RoleMiddleJurisdiction> roleMiddleJurisdiction = roleMiddleJurisdictionMapper.seleltAll(rId);
        System.out.println(roleMiddleJurisdiction);
        if (funs.size() == 0) {
            roleMiddleJurisdictionMapper.delet(rId);
            return 0;
        }
        //根据r_id查中间表是否存在改用户权限，不存在直接新增，存在先删除在新增
        if (roleMiddleJurisdiction.size() > 0) {
            roleMiddleJurisdictionMapper.delet(rId);

        }
        return roleMiddleJurisdictionMapper.addRoleInfo(rId, funs);
    }

    public int addStaff(long cs, List<Integer> funs) {
        List<RoleMiddleUser> user = roleMinddleUserMapper.dome(cs);
        System.out.println(user);
        if (funs.size() == 0) {
            roleMiddleJurisdictionMapper.delet(cs);
            return 0;
        }
        //根据r_id查中间表是否存在改用户权限，不存在直接新增，存在先删除在新增
        if (user.size() > 0) {
            roleMinddleUserMapper.delet(cs);
        }
        return roleMinddleUserMapper.addStaff(cs, funs);
    }
}
