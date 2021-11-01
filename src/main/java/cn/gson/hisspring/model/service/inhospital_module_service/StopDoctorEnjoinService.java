package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.DoctorEnjoinDetailsMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.DoctorEnjoinMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.StopDoctorEnjoinMapper;
import cn.gson.hisspring.model.pojos.ZyDoctorEnjoin;
import cn.gson.hisspring.model.pojos.ZyDoctorEnjoinDetails;
import cn.gson.hisspring.model.pojos.ZyStopDoctorEnjoin;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 停嘱记录service
 */
@Service
@Transactional
public class StopDoctorEnjoinService {

    @Autowired
    DoctorEnjoinDetailsMapper dedm;//医嘱详情mapper

    @Autowired
    StopDoctorEnjoinMapper sdem;//停用医嘱mapper

    @Autowired
    DoctorEnjoinMapper dem;//医嘱mapper

    /**
     * 停嘱方法
     * 整单停嘱
     */
    public boolean stopDoctorEnjoinOrDoctorEnjoinDetails(ZyStopDoctorEnjoin sde) {
        try {
            if (sde.getStopIs().equals("1")) {//停用详单医嘱
                //===========根据医嘱详单编号赋值停用时间
                ZyDoctorEnjoinDetails zded = new ZyDoctorEnjoinDetails(sde.getDerId(), sde.getSdeDate());
                dedm.updateById(zded);//修改

                //==========新增停用医嘱记录
                sdem.insert(sde);//新增停用医嘱记录

                //=======查询一遍医嘱详表是否已经全部以有停嘱时间
                zded = dedm.selectById(sde.getDerId());
                QueryWrapper<ZyDoctorEnjoinDetails> dedqw = new QueryWrapper<>();
                dedqw.eq("de_id", zded.getDeId())//根据医嘱编号查询医嘱详情
                        .isNull("des_end_date");//查询出没有停嘱日期的
                List<ZyDoctorEnjoinDetails> delist = dedm.selectList(dedqw);//查询


                if (delist.isEmpty()) {//如果查询出来的医嘱详情集合为空就说明全部医嘱详情都有停嘱时间了
                    QueryWrapper<ZyDoctorEnjoinDetails> dedqws = new QueryWrapper<>();
                    dedqws.eq("de_id", zded.getDeId())//根据医嘱编号查询
                            .orderBy(true, false, "des_end_date");//根据医嘱详情里面的停嘱时间倒序
                    List<ZyDoctorEnjoinDetails> deLists = dedm.selectList(dedqws);
                    if (deLists.isEmpty())
                        return false;
                    //==========根据医嘱编号修改停嘱时间
                    System.err.println("医嘱编号" + zded.getDeId() + "最后时间" + deLists.get(0).getDesEndDate());
                    ZyDoctorEnjoin zyDoctorEnjoin = new ZyDoctorEnjoin(zded.getDeId(), deLists.get(0).getDesEndDate());
                    dem.updateById(zyDoctorEnjoin);//修改
                }
            } else {//停用主表医嘱
                //===========根据医嘱编号赋值停用时间
                ZyDoctorEnjoin zde = new ZyDoctorEnjoin(sde.getDerId(), sde.getSdeDate());
                dem.updateById(zde);

                //============修改医嘱详表结束日期字段
                QueryWrapper<ZyDoctorEnjoinDetails> qw = new QueryWrapper();
                qw.eq("de_id", sde.getDerId())//根据医嘱编号查询医嘱详情
                        .isNull("des_end_date");//查询没有设置停嘱日期的
                List<ZyDoctorEnjoinDetails> zyDoctorEnjoinDetailsList = dedm.selectList(qw);//查询出需要修改的医嘱详情
                dedm.updateDoctorEnjoinDetailsFor(sde);//批量修改医嘱详情的停嘱日期

                //===================新增停用记录
                sdem.insertStopDoctorEnjoinFor(zyDoctorEnjoinDetailsList, sde);//批量新增停用记录

            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
