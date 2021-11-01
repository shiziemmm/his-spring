package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.pojos.RoleMiddleUser;
import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.pojos.User;
import cn.gson.hisspring.model.pojos.User_Staff;
import cn.gson.hisspring.model.pojos.pojos_vo.YongGoneVo;
import cn.gson.hisspring.model.service.jurisdiction_module_service.RoleMinddleUserService;
import cn.gson.hisspring.model.service.jurisdiction_module_service.StaffService;
import cn.gson.hisspring.model.service.jurisdiction_module_service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
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
     *
     * @param ksId 科室编号
     * @return
     */
    @RequestMapping("select-staff-all")
    public List<Staff> selectStaffAll(Integer ksId) {
        return ss.selectStaffAll(ksId);
    }

    /*
    查询员工所有有信息
     */
    @RequestMapping("selectall-staff")
    public List<Staff> selectALl() {
        List<Staff> staff = ss.selectALl();
        return staff;
    }

    @RequestMapping("selectall-staffs")
    public int selectALls() {
        List<Staff> staff = ss.selectALl();
        return staff.size();
    }

    //新增员工
    @RequestMapping("add-staff")
    public void dome(YongGoneVo from) {
        System.err.println(from);
        User user = new User();
        user.setUName(from.getUName());
        user.setUPswd(convertMD5(from.getUPswd()));
        Staff s = new Staff();
        s.setSName(from.getSName());
        s.setSSore(from.getSSore());
        s.setSPhone(from.getSPhone());
        s.setSDate(new Date());
        s.setKsId(from.getKsId());
        s.setTId(from.getTId());
        System.err.println(s);
        System.err.println(user);
        System.err.println("新增");
        us.addStaff(user, s);
    }

    @RequestMapping("upa-staff")
    public void upa(YongGoneVo from) {
        System.err.println(from + "修改信息");
        User user = new User();
        user.setUId(from.getUId());
        user.setUName(from.getUName());
        user.setUPswd(convertMD5(from.getUPswd()));
        Staff s = new Staff();
        s.setSId(from.getSId());
        s.setSName(from.getSName());
        s.setSSore(from.getSSore());
        s.setSPhone(from.getSPhone());
        s.setSDate(new Date());
        s.setKsId(from.getKsId());
        s.setTId(from.getTId());
        System.err.println(s);
        System.err.println(user);
        us.upa(user);
        ss.upa(s);

    }

    @RequestMapping("quit-staff")
    public String quit(long id) {
        int i = ss.upa(id);
        if (i > 0) {
            return "ok";
        } else {
            return "false";
        }
    }

    @RequestMapping("reset")
    public int reset(Long uid, String ssore) {
        String upswd = convertMD5(ssore.substring(ssore.length() - 6));
        System.err.println(upswd + "转");
        int reset = us.reset(upswd, uid);
        if (reset > 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @RequestMapping("gitee")
    public List<Staff> gitee(Long uId) {
        return ss.selectRole(uId);
    }

    /**
     * MD5加密
     *
     * @param inStr
     * @return
     */
    public static String convertMD5(String inStr) {
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }
}
