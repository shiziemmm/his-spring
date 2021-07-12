package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.pojos.User;
import cn.gson.hisspring.model.service.jurisdiction_module_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class LoginController {
    @Autowired
    UserService userService;

      /*
      登录
        */
    @PostMapping("login")
    public Object user(User us){
        List<User> cha = userService.cha(us);
        System.out.println(cha);
        if(cha.size()>0){
            return cha;
        }else{
            return 0;
        }

    }
}
