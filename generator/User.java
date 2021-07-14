package generator;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    /**
     * 用户编号 主键
     */
    private Integer uId;

    /**
     * 用户姓名
     */
    private String uName;

    /**
     * 用户密码
     */
    private String uPswd;

    private static final long serialVersionUID = 1L;
}