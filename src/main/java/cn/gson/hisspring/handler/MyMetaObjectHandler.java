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
        this.setFieldValByName("createTime", new Date(), metaObject);//门诊 诊疗卡-pojos创建和修改时间管理
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("alTime", new Date(), metaObject);//门诊 补卡，修改记录-pojos
        this.setFieldValByName("mcrcTime", new Date(), metaObject);//门诊 诊疗卡充值记录表-pojos
        this.setFieldValByName("rtTime", new Date(), metaObject);//门诊 挂号表-pojos
        this.setFieldValByName("cbTime", new Date(), metaObject);//门诊 账单记录表-pojos

        this.setFieldValByName("mrSection", new Date(), metaObject); // 门诊就诊记录表-pojos
        this.setFieldValByName("mrOverTime", new Date(), metaObject); // 门诊就诊记录表-pojos
        this.setFieldValByName("chTime", new Date(), metaObject);// 门诊就病历表-pojos
        this.setFieldValByName("recipeTime", new Date(), metaObject); // 门诊处方表-pojos

        this.setFieldValByName("pmTime", new Date(), metaObject); // 门诊缴费记录表-pojos

        this.setFieldValByName("susTime", new Date(), metaObject);//门诊手术单表-pojos


    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);//门诊 诊疗卡-pojos创建和修改时间管理

        this.setFieldValByName("mrOverTime", new Date(), metaObject); // 门诊就诊记录表-pojos

    }
}
