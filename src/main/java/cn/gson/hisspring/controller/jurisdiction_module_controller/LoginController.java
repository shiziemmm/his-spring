package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.pojos.User;
import cn.gson.hisspring.model.pojos.pojos_vo.AjaxResponse;
import cn.gson.hisspring.model.service.jurisdiction_module_service.UserService;
import cn.gson.hisspring.model.utli.*;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@Slf4j
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    JwtTokenUtil jwt;
    demo a = new demo();

    /*
    登录
      */
    @PostMapping("login")
    public Object user(User us) {
        User cha = userService.cha(us);
        System.out.println(cha);
        if (cha != null) {
            return cha;
        } else {
            return 0;
        }
    }

    @RequestMapping("jwt")
    public AjaxResponse login(User user) {
        System.err.println(user);
        System.err.println("加密" + convertMD5("F@BAEL"));
        user.setUPswd(convertMD5(user.getUPswd()));
        User cha = userService.login(user);
        CustomError resultBean = new CustomError();
        if (cha != null) {
            User user1 = userService.cha(user);
            log.info(user1.toString());
            System.err.println(user1);
            if (user1 != null) {
                if (user1.getUName().equals(cha.getUName()) && user1.getUPswd().equals(cha.getUPswd())) {
                    System.err.println(user1.getList().getSZt());
                    if (user1.getList().getSZt() != 0) {
                        //员工离职后返回999
                        resultBean.setCode(999);
                        System.err.println(resultBean.getCode());
                        return AjaxResponse.error(resultBean);
                    } else {
                        System.err.println("调试");
                        //未离职的员工返回token
                        String token = jwt.generateToken(user1.getUName(), user1.getUId() + "");
                        a.setToken(token);
                        a.setUname(user1.getUName());
                        a.setUser(user1);
                        return AjaxResponse.success(token);
                    }
                } else {
                    //账号密码错误返回500
                    resultBean.setCode(500);
                    return AjaxResponse.error(resultBean);
                }
            } else {
                //用户为空返回500
                resultBean.setCode(500);
                return AjaxResponse.error(resultBean);
            }

        } else {
            //接收的   user==null 返回400
            resultBean.setCode(400);
            return AjaxResponse.error(resultBean);
        }
    }

    @RequestMapping("test")
    public Object test(String token, String uName) {
        System.err.println("验证令牌");
        if (token != null) {
            Boolean aBoolean = jwt.validateToken(token, uName);
            System.err.println(aBoolean);
            if (aBoolean) {
                //验证成功返回数据给前端
                return a.getUser();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @RequestMapping("dome")
    public void dome() {
        String s = "";
        if (s == null || "".equals(s)) {
            System.out.println("null");
        } else {
            System.out.println("not null");
        }
    }

    public static String convertMD5(String inStr) {
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }

}
