package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.RoleMiddleJurisdictionMapper;
import cn.gson.hisspring.model.pojos.FunctionJurisdiction;

import cn.gson.hisspring.model.pojos.Role;
import cn.gson.hisspring.model.service.jurisdiction_module_service.RoleMiddleJurisdictionService;
import cn.gson.hisspring.model.service.jurisdiction_module_service.RoleService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@ResponseBody
public class RoleController {
    @Autowired
    RoleService roleService;

    @Autowired
    RoleMiddleJurisdictionService roleinfo;

    /*
    查询角色
     */
    @RequestMapping("role-list")
    public List<Role> selectList(){
//        List<Role> list=new List;
        List<Role> roles = roleService.chaxun();
       roles.forEach(s->{
           System.out.println(s);
       });
        return roles;
    }
    @RequestMapping("roles-list")
    public List<Role> selectAll(){
        return roleService.selectList();
    }
    /*
    新增角色
     */
    @PostMapping("add-role")
    public int addRole(@RequestBody Role role){
        System.out.println(role);
        int i=roleService.addRoles(role);
        if(i>0){
            return 1;
        }else{
            return 0;
        }
    }
    /*
    查询权限组
     */
    @RequestMapping("func-list")
    public  List<FunctionJurisdiction> select(){
        List<FunctionJurisdiction> select = roleService.select();
        return select;
    }
    /*
    批量新增角色-权限中间表
     */
    @RequestMapping("save-grant")
    public void saceGrant(@RequestParam("grant") String grant){
        JSONObject o = JSONObject.parseObject(grant);
        Integer roleId = Integer.parseInt(o.get("roleId").toString());
        List<Integer> funs = JSONArray.parseArray(o.get("funs").toString(),Integer.TYPE);
        System.out.println(roleId+"==== "+funs);
        roleinfo.addRoleInfo(roleId,funs);
    }
    /*
    查看角色拥有权限
     */
    @RequestMapping("role-funs")
    public List<Integer> allGrantFuns(Integer roleId){
        return roleService.roleFuns(roleId);
    }
    /*
    查询页面权限
     */
    @RequestMapping("home-menus")
    public List<FunctionJurisdiction> homeMenu(Integer userId){
        return roleService.homeMenu(userId);
    }

}
