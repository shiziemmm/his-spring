package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.pojos.RoleMiddleUser;
import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.pojos.User;
import cn.gson.hisspring.model.pojos.User_Staff;
import cn.gson.hisspring.model.service.jurisdiction_module_service.RoleMinddleUserService;
import cn.gson.hisspring.model.service.jurisdiction_module_service.StaffService;
import cn.gson.hisspring.model.service.jurisdiction_module_service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class StaffController {

    @Autowired
    StaffService ss;
    @Autowired
    UserService us;
    @Autowired
    RoleMinddleUserService ro;

    /**
     * 根据科室编号查询
     * @param ksId 科室编号
     * @return
     */
    @RequestMapping("select-staff-all")
    public List<Staff> selectStaffAll(Integer ksId){
        return ss.selectStaffAll(ksId);
    }
    /*
    查询员工所有有信息
     */
    @RequestMapping("selectall-staff")
    public  List<Staff>  selectALl(){
        List<Staff> staff = ss.selectALl();
        return staff;
    }
    //新增员工
    @RequestMapping("add-staff")
    public void dome(String staff, String user){
        Staff staff1 = JSONObject.parseObject(staff, Staff.class);
        User user1 = JSONObject.parseObject(user, User.class);
        System.out.println(staff1);
        System.out.println(user1);
        us.addStaff(user1);
        staff1.setUId(user1.getUId());
        ss.addStaff(staff1);

    }
    @RequestMapping("upa-staff")
    public void upa(String staff, String user){
        Staff staff1 = JSONObject.parseObject(staff, Staff.class);
        User user1 = JSONObject.parseObject(user, User.class);
        staff1.setUId(user1.getUId());
        System.out.println(staff1);
        System.out.println(user1);
        us.upa(user1);
        ss.upa(staff1);

    }
    @RequestMapping("quit-staff")
    public String quit(long id){
       int i= ss.upa(id);
       if(i>0){
           return "ok";
       }else{
           return "false";
       }
    }
}
