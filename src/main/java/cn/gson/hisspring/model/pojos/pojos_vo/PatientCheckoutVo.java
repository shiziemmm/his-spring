package cn.gson.hisspring.model.pojos.pojos_vo;

import cn.gson.hisspring.model.pojos.TjCodeProject;
import lombok.Data;

import java.util.List;

/**
 * 病人检验集合
 */
@Data
public class PatientCheckoutVo {
    private Long ptNo;//住院号
    private List<TjCodeProject> tjCodeProjectList;//检验集合

}
