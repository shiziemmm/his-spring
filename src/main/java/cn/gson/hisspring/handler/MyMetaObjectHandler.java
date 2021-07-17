package cn.gson.hisspring.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
/**
 * 门诊诊疗卡修改和新增时间 - handler处理器
 */

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",new Date(),metaObject);//门诊诊疗卡-pojos
        this.setFieldValByName("updateTime",new Date(),metaObject);
        this.setFieldValByName("alTime",new Date(),metaObject);//门诊补卡，修改记录-pojos
        this.setFieldValByName("mcrcTime",new Date(),metaObject);//诊疗卡充值记录表
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
