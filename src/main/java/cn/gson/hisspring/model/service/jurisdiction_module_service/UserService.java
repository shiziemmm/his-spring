package cn.gson.hisspring.model.service.jurisdiction_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.UserMapper;
import cn.gson.hisspring.model.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper us;


    public List<User> login(User user){
        return us.login(user);
    }
    public List<User> cha(User user){
        return us.cha(user);
    }
}
