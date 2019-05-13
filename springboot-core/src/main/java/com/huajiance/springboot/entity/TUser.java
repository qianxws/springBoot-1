package com.huajiance.springboot.entity;

import java.io.Serializable;
import java.util.Date;

public class TUser implements Serializable {
    private String userId;
    private String name;
    private String password;
    private String sex;
    private String phone;
    private String orgId;
    private String email;
    private String creator;
    private boolean enabled;
    private Date createTime;
    private String groupId;
    private Date updateTime;
    private String updator;

    private String xh;
    private String code;
    private String endFlagName;
    private String endFlagCode;
    private String userName;
    private String sexName;
    private String psnSecretLevelName;
    private String psnSecretLevelCode;
    private String mdCode;
    private String fcFlag;
    private String systemUserId;
    /** 用户兵种 */
    private String userArm;
    private String cseq;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEndFlagName() {
        return endFlagName;
    }

    public void setEndFlagName(String endFlagName) {
        this.endFlagName = endFlagName;
    }

    public String getEndFlagCode() {
        return endFlagCode;
    }

    public void setEndFlagCode(String endFlagCode) {
        this.endFlagCode = endFlagCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public String getPsnSecretLevelName() {
        return psnSecretLevelName;
    }

    public void setPsnSecretLevelName(String psnSecretLevelName) {
        this.psnSecretLevelName = psnSecretLevelName;
    }

    public String getPsnSecretLevelCode() {
        return psnSecretLevelCode;
    }

    public void setPsnSecretLevelCode(String psnSecretLevelCode) {
        this.psnSecretLevelCode = psnSecretLevelCode;
    }

    public String getMdCode() {
        return mdCode;
    }

    public void setMdCode(String mdCode) {
        this.mdCode = mdCode;
    }

    public String getFcFlag() {
        return fcFlag;
    }

    public void setFcFlag(String fcFlag) {
        this.fcFlag = fcFlag;
    }

    public String getSystemUserId() {
        return systemUserId;
    }

    public void setSystemUserId(String systemUserId) {
        this.systemUserId = systemUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUserArm() {
        return userArm;
    }

    public void setUserArm(String userArm) {
        this.userArm = userArm;
    }

    public String getCseq() {
        return cseq;
    }

    public void setCseq(String cseq) {
        this.cseq = cseq;
    }
}
