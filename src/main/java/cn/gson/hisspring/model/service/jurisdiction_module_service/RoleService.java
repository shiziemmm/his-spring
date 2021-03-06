package cn.gson.hisspring.model.service.jurisdiction_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.RoleMapper;
import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.RoleMiddleJurisdictionMapper;
import cn.gson.hisspring.model.pojos.*;
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
    public List<Role> chaxun() {
        return roleMapper.chaxun();
    }
    public List<FunctionJurisdiction> select() {
        return roleMapper.select();
    }

    public List<Integer> roleFuns(Integer roleId){
       return  roleMapper.roleFuns(roleId);
    }
    public List<FunctionJurisdiction> homeMenu(Integer userId){
        return roleMapper.homeMenu(userId);
    }
    public int addRole(Role role){
        return roleMapper.insert(role);
    };
    public int addRoles(Role role){return roleMapper.insert(role);}
    public List<Role> selectStaff(){return roleMapper.selectStaff();}
    public List<Integer> staffFuns(Integer id){return roleMapper.staffFuns(id);}


}