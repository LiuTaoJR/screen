package com.heidelberg.screen.common;

import org.springframework.stereotype.Component;

/**
 * Created by TOPFEEL on 2018/11/9.
 */
@Component
public class AjaxResult {

    private Integer success = Integer.valueOf(0);
    private String code = "200";
    private String msg = "";
    private Object data;
    private Page page;
    private String token;

    public AjaxResult() {
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static AjaxResult success() {
        AjaxResult result = new AjaxResult();
        result.setSuccess(Integer.valueOf(1));
        result.setMsg("success");
        return result;
    }

    public static AjaxResult success(String msg) {
        AjaxResult result = new AjaxResult();
        result.setSuccess(Integer.valueOf(1));
        result.setMsg(msg);
        return result;
    }

    public static AjaxResult success(String msg, Object data) {
        AjaxResult result = new AjaxResult();
        result.setSuccess(Integer.valueOf(1));
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    public static AjaxResult success(Object data) {
        AjaxResult result = new AjaxResult();
        result.setSuccess(Integer.valueOf(1));
        result.setData(data);
        result.setMsg("success");
        return result;
    }

    public static AjaxResult failure() {
        AjaxResult result = new AjaxResult();
        result.setSuccess(Integer.valueOf(0));
        result.setMsg("failure");
        return result;
    }

    public static AjaxResult failure(String msg) {
        AjaxResult result = new AjaxResult();
        result.setSuccess(Integer.valueOf(0));
        result.setMsg(msg);
        return result;
    }

    public static AjaxResult failure(String code, String msg) {
        AjaxResult result = new AjaxResult();
        result.setSuccess(Integer.valueOf(0));
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static AjaxResult failure(String msg, Object data) {
        AjaxResult result = new AjaxResult();
        result.setSuccess(Integer.valueOf(0));
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static AjaxResult failure(String code, String msg, Object data) {
        AjaxResult result = new AjaxResult();
        result.setSuccess(Integer.valueOf(0));
        result.setMsg(msg);
        result.setData(data);
        result.setCode(code);
        return result;
    }

    public static AjaxResult getResult(Page page, Object data) throws Exception {
        AjaxResult result = new AjaxResult();
        Page newPage = new Page();
        newPage.setPage(page.getPage());
        newPage.setPageSize(page.getPageSize());
        newPage.setTotal(page.getTotal());
        newPage.setTotalPage(page.getTotalPage());
        result.setPage(newPage);
        result.setData(data);
        result.setSuccess(Integer.valueOf(1));
        return result;
    }

    public Page getPage() {
        return this.page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Integer getSuccess() {
        return this.success;
    }

    public String getMsg() {
        return this.msg;
    }

    public Object getData() {
        return this.data;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
