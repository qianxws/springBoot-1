package com.huajiance.springboot.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class TMenu implements Serializable {

    private String menuid;
    private String name;
    private String code;
    private String pid;
    private String cseq;
    private String url;
    private boolean isopen;
    private boolean enabled;
    private Date createTime;
    private String creator;
    private Date updateTime;
    private String updator;

    public TMenu() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TMenu tMenu = (TMenu) o;
        return Objects.equals(menuid, tMenu.menuid) &&
                Objects.equals(name, tMenu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuid, name);
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCseq() {
        return cseq;
    }

    public void setCseq(String cseq) {
        this.cseq = cseq;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isIsopen() {
        return isopen;
    }

    public void setIsopen(boolean isopen) {
        this.isopen = isopen;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    @Override
    public String toString() {
        return "TMenu{" +
                "menuid='" + menuid + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", pid='" + pid + '\'' +
                ", cseq='" + cseq + '\'' +
                ", url='" + url + '\'' +
                ", isopen=" + isopen +
                ", enabled=" + enabled +
                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                ", updateTime=" + updateTime +
                ", updator='" + updator + '\'' +
                '}';
    }
}
