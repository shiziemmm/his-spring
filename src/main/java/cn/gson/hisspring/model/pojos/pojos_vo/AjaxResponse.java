package cn.gson.hisspring.model.pojos.pojos_vo;


import cn.gson.hisspring.model.utli.CustomError;
import cn.gson.hisspring.model.utli.CustomErrorType;
import lombok.Data;


@Data
public class AjaxResponse {


    private boolean isSuccess;
    private int code;
    private String message;
    private Object data;

    public AjaxResponse() {

    }

    /**
     * 请求出现异常时的响应数据封装
     *
     * @param e:异常
     * @return AjaxResponse 封闭后的响应对象
     */
    public static AjaxResponse error(CustomError e) {

        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setSuccess(false);
        resultBean.setCode(e.getCode());
        if (e.getCode() == CustomErrorType.USER_INPUT_ERROR.getCode()) {
            resultBean.setMessage("账号密码错误");
            System.err.println("测试1" + resultBean);
        } else if (e.getCode() == CustomErrorType.SYSTEM_ERROR.getCode()) {
            resultBean.setMessage(e.getMessage() + ",系统出现异常，请联系管理员!");
            System.err.println("测试2" + resultBean);
        } else if (e.getCode() == CustomErrorType.PAGE_NOT_FOUND_ERROR.getCode()) {
            resultBean.setMessage("未能找到所请求的资源！");
            System.err.println("测试3" + resultBean);
        } else if (e.getCode() == CustomErrorType.ACCOUNT_ERROR.getCode()) {
            resultBean.setMessage(e.getMessage());
            System.err.println("测试4" + resultBean);
        } else {
            resultBean.setMessage("系统出现未知异常，请联系管理员电话!");
            System.err.println("测试5" + resultBean);
        }
        return resultBean;
    }

    /**
     * 请求正常的响应时进行数据封装
     *
     * @return AjaxResponse 封闭后的响应对象
     */
    public static AjaxResponse success() {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setSuccess(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        return resultBean;
    }

    /**
     * 请求正常的响应时进行数据封装
     *
     * @param data:要封装到响应对象的数据
     * @return AjaxResponse 封闭后的响应对象
     */
    public static AjaxResponse success(Object data) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setSuccess(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        resultBean.setData(data);
        return resultBean;
    }


}