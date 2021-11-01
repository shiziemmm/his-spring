package cn.gson.hisspring.model.service.jurisdiction_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.UserMapper;
import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper us;
    @Autowired
    StaffService ss;


    public User login(User user) {
        return us.login(user);
    }

    public User cha(User user) {
        return us.cha(user);
    }

    @Transactional
    public void addStaff(User user, Staff staff) {
        us.insert(user);
        staff.setUId(user.getUId());
        ss.addStaff(staff);
    }

    public int upa(User user) {
        System.err.println(user + "Service++");
        return us.updateById(user);
    }

    public int reset(String upswd, Long uid) {
        return us.reset(upswd, uid);
    }
}
