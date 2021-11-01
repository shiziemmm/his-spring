package generator;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * department
 *
 * @author
 */
@Data
public class Department implements Serializable {
    /**
     * 部门编号
     */
    private Integer deId;

    /**
     * 部门名称
     */
    private String deName;

    /**
     * 创建部门时间
     */
    private Date deDate;

    private static final long serialVersionUID = 1L;
}