package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.DoctorEnjoinDetailsMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.DoctorEnjoinMapper;
import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.StaffMapper;
import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.DrugInformationMapper;
import cn.gson.hisspring.model.pojos.YfDruginformation;
import cn.gson.hisspring.model.pojos.ZyDoctorEnjoin;
import cn.gson.hisspring.model.pojos.ZyDoctorEnjoinDetails;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 医嘱service
 */
@Service
@Transactional
public class DoctorEnjoinService {

    @Autowired
    DoctorEnjoinMapper dem;//医嘱mapper

    @Autowired
    DoctorEnjoinDetailsMapper dedm;//医嘱详情表mapper

    @Autowired
    StaffMapper sm;//员工mapper

    @Autowired
    DrugInformationMapper dfm;//药品信息


    /**
     * 添加医嘱以及医嘱详表数据
     */
    public boolean addDoctorEnjoin(ZyDoctorEnjoin zyDoctorEnjoin){
            //===================================新增医嘱主表
            dem.insert(zyDoctorEnjoin);

            System.err.println(zyDoctorEnjoin);

            if(zyDoctorEnjoin.getDeLongorshort() == 2){
                for (ZyDoctorEnjoinDetails zyDoctorEnjoinDetails : zyDoctorEnjoin.getDedList()) {

                    YfDruginformation yfDruginformation = dfm.selectById(zyDoctorEnjoinDetails.getDesDrugId());
                    zyDoctorEnjoinDetails.setDesPrice(yfDruginformation.getDrugPrice());
                }

            }
            //===================================新增医嘱详情表
            dedm.insertDeDetailsFor(zyDoctorEnjoin.getDedList(),zyDoctorEnjoin.getDeId(),zyDoctorEnjoin.getDeExecuteDate());//循环新增
            return true;
    }


    /**
     * 根据住院号查询医嘱信息
     */
    public List<ZyDoctorEnjoin> doctorEnjoinSelectByPtId(SelectExecuteVo selectExecuteVo){
        return dem.doctorEnjoinSelectByPtId(selectExecuteVo);
    }


}
