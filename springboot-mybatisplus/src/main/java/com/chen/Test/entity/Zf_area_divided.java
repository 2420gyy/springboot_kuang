package com.chen.Test.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author ChenChen
 * @since 2022-02-28
 */
@ApiModel(value = "Zf_area_divided对象", description = "")
public class Zf_area_divided implements Serializable {


    @ApiModelProperty(value = "系统字典表administrative_division行政区划字典")
    private String ADMIN_DIVISION_CODE;

    @ApiModelProperty(value = "省級层级编码code")
    private String PROVINCIAL_CODE;

    @ApiModelProperty(value = "市州級层级编码code")
    private String CITY_CODE;

    @ApiModelProperty(value = "区县层级code")
    private String DISTRICT_CODE;

    @ApiModelProperty(value = "乡镇街道层级code")
    private String STREET_CODE;

    @ApiModelProperty(value = "层级代码")
    private String LEVEL_CODE;

    @ApiModelProperty(value = "国家部委级code")
    private String COUNTRY_CODE;

    @ApiModelProperty(value = "省级层级名称")
    private String PROVINCIAL_NAME;

    @ApiModelProperty(value = "市级层级名称")
    private String CITY_NAME;

    @ApiModelProperty(value = "区县层级名称")
    private String DISTRICT_NAME;

    @ApiModelProperty(value = "乡镇街道名称")
    private String STREET_NAME;

    @ApiModelProperty(value = "完整全称")
    private String FULL_NAME;

    @ApiModelProperty(value = "区划名称")
    private String ADMIN_DIVISION_NAME;

    @ApiModelProperty(value = "数据唯一标志id")
    private String ID;

    @ApiModelProperty(value = "删除标志 1 已删除 0未删除")
    private BigDecimal IS_DELETE;

    @ApiModelProperty(value = "分配的分级管理员帐号")
    private String USER_ACCOUNT;

    @ApiModelProperty(value = "是否已审核")
    private BigDecimal IS_EXAMINE;

    @ApiModelProperty(value = "数据创建时间")
    private LocalDateTime CREATE_TIME;

    @ApiModelProperty(value = "数据创建人id")
    private BigDecimal CREATE_USER_ID;

    @ApiModelProperty(value = "审核通过时间")
    private LocalDateTime EXAMINE_TIME;

    @ApiModelProperty(value = "审核人ID")
    private BigDecimal EXAMINE_USER_ID;

    @ApiModelProperty(value = "数据更新时间")
    private LocalDateTime UPDATE_TIME;

    @ApiModelProperty(value = "数据更新人id")
    private BigDecimal UPDATE_USER_ID;

    @ApiModelProperty(value = "数据删除时间")
    private LocalDateTime DELETE_TIME;

    private BigDecimal DELETE_USER_ID;

    @ApiModelProperty(value = "省级简称")
    private String SIMPLE_NAME;

    @ApiModelProperty(value = "区划类别(01-直辖市 02-存在直辖区的省 03-直辖区/直辖市的区 04-特殊区划/港澳台 99-其他)")
    private String LEVEL_TYPE;

    @ApiModelProperty(value = "行政管理机构名称")
    private String ADMIN_ORG_NAME;


    public String getADMIN_DIVISION_CODE() {
        return ADMIN_DIVISION_CODE;
    }

    public void setADMIN_DIVISION_CODE(String ADMIN_DIVISION_CODE) {
        this.ADMIN_DIVISION_CODE = ADMIN_DIVISION_CODE;
    }

    public String getPROVINCIAL_CODE() {
        return PROVINCIAL_CODE;
    }

    public void setPROVINCIAL_CODE(String PROVINCIAL_CODE) {
        this.PROVINCIAL_CODE = PROVINCIAL_CODE;
    }

    public String getCITY_CODE() {
        return CITY_CODE;
    }

    public void setCITY_CODE(String CITY_CODE) {
        this.CITY_CODE = CITY_CODE;
    }

    public String getDISTRICT_CODE() {
        return DISTRICT_CODE;
    }

    public void setDISTRICT_CODE(String DISTRICT_CODE) {
        this.DISTRICT_CODE = DISTRICT_CODE;
    }

    public String getSTREET_CODE() {
        return STREET_CODE;
    }

    public void setSTREET_CODE(String STREET_CODE) {
        this.STREET_CODE = STREET_CODE;
    }

    public String getLEVEL_CODE() {
        return LEVEL_CODE;
    }

    public void setLEVEL_CODE(String LEVEL_CODE) {
        this.LEVEL_CODE = LEVEL_CODE;
    }

    public String getCOUNTRY_CODE() {
        return COUNTRY_CODE;
    }

    public void setCOUNTRY_CODE(String COUNTRY_CODE) {
        this.COUNTRY_CODE = COUNTRY_CODE;
    }

    public String getPROVINCIAL_NAME() {
        return PROVINCIAL_NAME;
    }

    public void setPROVINCIAL_NAME(String PROVINCIAL_NAME) {
        this.PROVINCIAL_NAME = PROVINCIAL_NAME;
    }

    public String getCITY_NAME() {
        return CITY_NAME;
    }

    public void setCITY_NAME(String CITY_NAME) {
        this.CITY_NAME = CITY_NAME;
    }

    public String getDISTRICT_NAME() {
        return DISTRICT_NAME;
    }

    public void setDISTRICT_NAME(String DISTRICT_NAME) {
        this.DISTRICT_NAME = DISTRICT_NAME;
    }

    public String getSTREET_NAME() {
        return STREET_NAME;
    }

    public void setSTREET_NAME(String STREET_NAME) {
        this.STREET_NAME = STREET_NAME;
    }

    public String getFULL_NAME() {
        return FULL_NAME;
    }

    public void setFULL_NAME(String FULL_NAME) {
        this.FULL_NAME = FULL_NAME;
    }

    public String getADMIN_DIVISION_NAME() {
        return ADMIN_DIVISION_NAME;
    }

    public void setADMIN_DIVISION_NAME(String ADMIN_DIVISION_NAME) {
        this.ADMIN_DIVISION_NAME = ADMIN_DIVISION_NAME;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public BigDecimal getIS_DELETE() {
        return IS_DELETE;
    }

    public void setIS_DELETE(BigDecimal IS_DELETE) {
        this.IS_DELETE = IS_DELETE;
    }

    public String getUSER_ACCOUNT() {
        return USER_ACCOUNT;
    }

    public void setUSER_ACCOUNT(String USER_ACCOUNT) {
        this.USER_ACCOUNT = USER_ACCOUNT;
    }

    public BigDecimal getIS_EXAMINE() {
        return IS_EXAMINE;
    }

    public void setIS_EXAMINE(BigDecimal IS_EXAMINE) {
        this.IS_EXAMINE = IS_EXAMINE;
    }

    public LocalDateTime getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(LocalDateTime CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }

    public BigDecimal getCREATE_USER_ID() {
        return CREATE_USER_ID;
    }

    public void setCREATE_USER_ID(BigDecimal CREATE_USER_ID) {
        this.CREATE_USER_ID = CREATE_USER_ID;
    }

    public LocalDateTime getEXAMINE_TIME() {
        return EXAMINE_TIME;
    }

    public void setEXAMINE_TIME(LocalDateTime EXAMINE_TIME) {
        this.EXAMINE_TIME = EXAMINE_TIME;
    }

    public BigDecimal getEXAMINE_USER_ID() {
        return EXAMINE_USER_ID;
    }

    public void setEXAMINE_USER_ID(BigDecimal EXAMINE_USER_ID) {
        this.EXAMINE_USER_ID = EXAMINE_USER_ID;
    }

    public LocalDateTime getUPDATE_TIME() {
        return UPDATE_TIME;
    }

    public void setUPDATE_TIME(LocalDateTime UPDATE_TIME) {
        this.UPDATE_TIME = UPDATE_TIME;
    }

    public BigDecimal getUPDATE_USER_ID() {
        return UPDATE_USER_ID;
    }

    public void setUPDATE_USER_ID(BigDecimal UPDATE_USER_ID) {
        this.UPDATE_USER_ID = UPDATE_USER_ID;
    }

    public LocalDateTime getDELETE_TIME() {
        return DELETE_TIME;
    }

    public void setDELETE_TIME(LocalDateTime DELETE_TIME) {
        this.DELETE_TIME = DELETE_TIME;
    }

    public BigDecimal getDELETE_USER_ID() {
        return DELETE_USER_ID;
    }

    public void setDELETE_USER_ID(BigDecimal DELETE_USER_ID) {
        this.DELETE_USER_ID = DELETE_USER_ID;
    }

    public String getSIMPLE_NAME() {
        return SIMPLE_NAME;
    }

    public void setSIMPLE_NAME(String SIMPLE_NAME) {
        this.SIMPLE_NAME = SIMPLE_NAME;
    }

    public String getLEVEL_TYPE() {
        return LEVEL_TYPE;
    }

    public void setLEVEL_TYPE(String LEVEL_TYPE) {
        this.LEVEL_TYPE = LEVEL_TYPE;
    }

    public String getADMIN_ORG_NAME() {
        return ADMIN_ORG_NAME;
    }

    public void setADMIN_ORG_NAME(String ADMIN_ORG_NAME) {
        this.ADMIN_ORG_NAME = ADMIN_ORG_NAME;
    }

    @Override
    public String toString() {
        return "Zf_area_divided{" +
        "ADMIN_DIVISION_CODE=" + ADMIN_DIVISION_CODE +
        ", PROVINCIAL_CODE=" + PROVINCIAL_CODE +
        ", CITY_CODE=" + CITY_CODE +
        ", DISTRICT_CODE=" + DISTRICT_CODE +
        ", STREET_CODE=" + STREET_CODE +
        ", LEVEL_CODE=" + LEVEL_CODE +
        ", COUNTRY_CODE=" + COUNTRY_CODE +
        ", PROVINCIAL_NAME=" + PROVINCIAL_NAME +
        ", CITY_NAME=" + CITY_NAME +
        ", DISTRICT_NAME=" + DISTRICT_NAME +
        ", STREET_NAME=" + STREET_NAME +
        ", FULL_NAME=" + FULL_NAME +
        ", ADMIN_DIVISION_NAME=" + ADMIN_DIVISION_NAME +
        ", ID=" + ID +
        ", IS_DELETE=" + IS_DELETE +
        ", USER_ACCOUNT=" + USER_ACCOUNT +
        ", IS_EXAMINE=" + IS_EXAMINE +
        ", CREATE_TIME=" + CREATE_TIME +
        ", CREATE_USER_ID=" + CREATE_USER_ID +
        ", EXAMINE_TIME=" + EXAMINE_TIME +
        ", EXAMINE_USER_ID=" + EXAMINE_USER_ID +
        ", UPDATE_TIME=" + UPDATE_TIME +
        ", UPDATE_USER_ID=" + UPDATE_USER_ID +
        ", DELETE_TIME=" + DELETE_TIME +
        ", DELETE_USER_ID=" + DELETE_USER_ID +
        ", SIMPLE_NAME=" + SIMPLE_NAME +
        ", LEVEL_TYPE=" + LEVEL_TYPE +
        ", ADMIN_ORG_NAME=" + ADMIN_ORG_NAME +
        "}";
    }
}
