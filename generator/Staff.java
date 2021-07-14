package generator;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * staff
 * @author 
 */
@Data
public class Staff implements Serializable {
    /**
     * 员工编号
     */
    private Integer sId;

    /**
     * 员工姓名
     */
    private String sName;

    /**
     * 员工身份证
     */
    private String sSore;

    /**
     * 联系电话
     */
    private String sPhone;

    /**
     * 入职日期
     */
    private Date sDate;

    /**
     * 外连接连接用户表编号
     */
    private Integer uId;

    /**
     * 外连接连接科室表编号
     */
    private Integer ksId;

    /**
     * 连接职称编号
     */
    private Integer tId;

    private static final long serialVersionUID = 1L;
}