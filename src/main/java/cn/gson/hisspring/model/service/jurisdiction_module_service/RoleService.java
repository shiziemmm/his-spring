package cn.gson.hisspring.model.service.jurisdiction_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.RoleMapper;
import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.RoleMiddleJurisdictionMapper;
import cn.gson.hisspring.model.pojos.FunctionJurisdiction;
import cn.gson.hisspring.model.pojos.Jurisdiction;
import cn.gson.hisspring.model.pojos.Role;
import cn.gson.hisspring.model.pojos.RoleMiddleJurisdiction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    RoleMiddleJurisdictionMapper f;

    public List<Role> selectList() {
        return roleMapper.selectAll();
    }

    public List<FunctionJurisdiction> select() {
        return roleMapper.select();
    }

    public void saceGrant(Integer roleId, List<Integer> funs) {
        System.out.println(roleId+"==="+funs);
//        RoleMiddleJurisdiction role = f.selectById(roleId);
//        List<FunctionJurisdiction> allById =
//                (List<FunctionJurisdiction>) f.selectById((Serializable) funs);
//        List<FunctionJurisdiction> functions = role.getFuns();
//        if(functions == null){
//            functions = new ArrayList<>();
//        }
//        functions.clear();//把原来的全部清空
//        functions.addAll(allById);
    }
}