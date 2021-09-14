package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

//药品药房库存表

@Data//get  set方法
@TableName(value = "yf_druginventory")
public class YfDruginventory {

  private long yfDrvenId;//药品库存编号
  private long drugId;//药品编号
  private String yfDrvenName;//药品名称
  private long yfDrvenCount;//药品库存  数量
//  @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
  private long supplierId;//连接供应商表 供应商编号
  private String yfSupplierName;//供应商名称
  private String yfDrcaName;//药品类别
  private String drugPrescription;//处方药

  private YkSupplier ykSupplier;//供应商
  private YfDruginformation yfDruginformation;//药品信息
  private YfDrugcategory yfDrugcategory;//药品类别
}
