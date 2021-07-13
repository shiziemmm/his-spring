package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.pojos.FunctionJurisdiction;

import cn.gson.hisspring.model.pojos.Role;
import cn.gson.hisspring.model.service.jurisdiction_module_service.RoleService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    /*
    查询角色
     */
    @RequestMapping("role-list")
    public List<Role> selectList(){
        List<Role> roles = roleService.selectList();
        return roles;
    }
    /*
    查询权限组
     */
    @RequestMapping("func-list")
    public  List<FunctionJurisdiction> select(){
        List<FunctionJurisdiction> select = roleService.select();
        return select;
    }
    @RequestMapping("save-grant")
    public void saceGrant(@RequestParam("grant") String grant){
        JSONObject o = JSONObject.parseObject(grant);
        Integer roleId = Integer.parseInt(o.get("roleId").toString());
        List<Integer> funs = JSONArray.parseArray(o.get("funs").toString(),Integer.TYPE);
        roleService.saceGrant(roleId,funs);
    }
}
