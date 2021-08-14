package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.DoctorEnjoinDetailsMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.DoctorEnjoinExecuteRecordMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.PatientBaseMapper;
import cn.gson.hisspring.model.pojos.ZyDoctorEnjoinDetails;
import cn.gson.hisspring.model.pojos.ZyDoctorEnjoinExecuteRecord;
import cn.gson.hisspring.model.pojos.ZyPatientBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 执行医嘱service
 */
@Service
@Transactional
public class DoctorEnjoinExecuteRecordService {

    @Autowired
    DoctorEnjoinDetailsMapper dedm;//医嘱详情mapper

    @Autowired
    DoctorEnjoinExecuteRecordMapper deerm;//医嘱执行mapper

    @Autowired
    PatientBaseMapper pbm;//病人mapper

    /**
     * 执行医嘱方法
     */
    public boolean doctorEnjoinExecute(List<ZyDoctorEnjoinDetails> detailsList,Long sId){
            double price = 0;//药品价格

        if(!detailsList.isEmpty()){

            //添加执行医嘱记录
            for (ZyDoctorEnjoinDetails list : detailsList) {
                ZyDoctorEnjoinExecuteRecord record = new ZyDoctorEnjoinExecuteRecord();
                if(list.getDesFrequency() == null || list.getDesFrequency() == 1){
                    record.setDerDrugPrice(list.getDesPrice() * list.getDesCount());//执行一次的价格
                    record.setDesId(list.getDesId());//医嘱详情编号
                    record.setPtNo(list.getPtNo());//病人住院号
                    record.setSId(sId);//护士编号
                    price += list.getDesPrice() * list.getDesCount();//叠加价格
                    deerm.insert(record);//新增

                }else{
                    for (int i = 0;i < list.getDesFrequency();i++){
                        record.setDerDrugPrice(list.getDesPrice() * list.getDesCount());//执行一次的价格
                        record.setDesId(list.getDesId());//医嘱详情编号
                        record.setPtNo(list.getPtNo());//病人住院号
                        record.setSId(sId);//护士编号
                        price += list.getDesPrice() * list.getDesCount();//叠加价格
                        deerm.insert(record);//新增
                    }
                }
            }

            //将医嘱详表里面的执行记录修改为当前时间
            dedm.doctorEnjoinDetailsExecuteFor(detailsList);

            //===============扣费
            pbm.updatePatientBasePrice(price,detailsList.get(0).getPtNo());//修改病人余额


            return true;

        }else{
            return false;
        }
    }

}
