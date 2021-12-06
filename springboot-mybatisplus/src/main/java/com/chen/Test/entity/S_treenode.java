package com.chen.Test.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 节点定义表
 * </p>
 *
 * @author ChenChen
 * @since 2021-11-21
 */
@ApiModel(value = "S_treenode对象", description = "节点定义表")
public class S_treenode implements Serializable {


    @ApiModelProperty(value = "主键id")
    private String NODEID;

    @ApiModelProperty(value = "节点名称")
    private String NODENAME;

    @ApiModelProperty(value = "节点编码")
    private String NODECODE;

    @ApiModelProperty(value = "节点简称")
    private String NODESHORT;

    @ApiModelProperty(value = "上级节点ID")
    private String PARENTID;

    @ApiModelProperty(value = "描述")
    private String DESCRIPTION;

    @ApiModelProperty(value = "序号")
    private String PORDER;

    @ApiModelProperty(value = "是否可用")
    private Integer ISUSED;

    @ApiModelProperty(value = "节点层级")
    private String LEVELVALUE;

    @ApiModelProperty(value = "节点类型，关联S_SCHEME_NODETYPE.ID")
    private String NODETYPE;

    @ApiModelProperty(value = "生效时间")
    private LocalDateTime EFFECTIVETIME;

    @ApiModelProperty(value = "人员分组个数（最大63）")
    private Integer MAXGROUPNUM;

    @ApiModelProperty(value = "失效时间")
    private LocalDateTime FAILURETIME;

    @ApiModelProperty(value = "创建者")
    private String CREATEUSER;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime CREATETIME;

    @ApiModelProperty(value = "更新者")
    private String UPDATEUSER;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime UPDATETIME;

    @ApiModelProperty(value = "删除者")
    private String DELETEUSER;

    @ApiModelProperty(value = "删除时间")
    private LocalDateTime DELETETIME;

    @ApiModelProperty(value = "删除状态(0未删除 1已删除 默认为 0)")
    private Integer DELETEFLAG;

    @ApiModelProperty(value = "组织状态 0正常 1撤销 2删除")
    private Integer NODESTART;

    @ApiModelProperty(value = "节点全路径 规则位 父级的TREEPATH+本身的nodecode")
    private String TREEPATH;

    @ApiModelProperty(value = "节点单位数据范围（1：所在单位及下级，2：指定单位）")
    private Integer unitSCOPE;

    @ApiModelProperty(value = "是否为关联人员 默认1， 0否 1是")
    private Integer ISRELEVANCE;

    @ApiModelProperty(value = "是否为管理节点  0否 1是")
    private Integer ISADMINNODE;


    public String getNODEID() {
        return NODEID;
    }

    public void setNODEID(String NODEID) {
        this.NODEID = NODEID;
    }

    public String getNODENAME() {
        return NODENAME;
    }

    public void setNODENAME(String NODENAME) {
        this.NODENAME = NODENAME;
    }

    public String getNODECODE() {
        return NODECODE;
    }

    public void setNODECODE(String NODECODE) {
        this.NODECODE = NODECODE;
    }

    public String getNODESHORT() {
        return NODESHORT;
    }

    public void setNODESHORT(String NODESHORT) {
        this.NODESHORT = NODESHORT;
    }

    public String getPARENTID() {
        return PARENTID;
    }

    public void setPARENTID(String PARENTID) {
        this.PARENTID = PARENTID;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getPORDER() {
        return PORDER;
    }

    public void setPORDER(String PORDER) {
        this.PORDER = PORDER;
    }

    public Integer getISUSED() {
        return ISUSED;
    }

    public void setISUSED(Integer ISUSED) {
        this.ISUSED = ISUSED;
    }

    public String getLEVELVALUE() {
        return LEVELVALUE;
    }

    public void setLEVELVALUE(String LEVELVALUE) {
        this.LEVELVALUE = LEVELVALUE;
    }

    public String getNODETYPE() {
        return NODETYPE;
    }

    public void setNODETYPE(String NODETYPE) {
        this.NODETYPE = NODETYPE;
    }

    public LocalDateTime getEFFECTIVETIME() {
        return EFFECTIVETIME;
    }

    public void setEFFECTIVETIME(LocalDateTime EFFECTIVETIME) {
        this.EFFECTIVETIME = EFFECTIVETIME;
    }

    public Integer getMAXGROUPNUM() {
        return MAXGROUPNUM;
    }

    public void setMAXGROUPNUM(Integer MAXGROUPNUM) {
        this.MAXGROUPNUM = MAXGROUPNUM;
    }

    public LocalDateTime getFAILURETIME() {
        return FAILURETIME;
    }

    public void setFAILURETIME(LocalDateTime FAILURETIME) {
        this.FAILURETIME = FAILURETIME;
    }

    public String getCREATEUSER() {
        return CREATEUSER;
    }

    public void setCREATEUSER(String CREATEUSER) {
        this.CREATEUSER = CREATEUSER;
    }

    public LocalDateTime getCREATETIME() {
        return CREATETIME;
    }

    public void setCREATETIME(LocalDateTime CREATETIME) {
        this.CREATETIME = CREATETIME;
    }

    public String getUPDATEUSER() {
        return UPDATEUSER;
    }

    public void setUPDATEUSER(String UPDATEUSER) {
        this.UPDATEUSER = UPDATEUSER;
    }

    public LocalDateTime getUPDATETIME() {
        return UPDATETIME;
    }

    public void setUPDATETIME(LocalDateTime UPDATETIME) {
        this.UPDATETIME = UPDATETIME;
    }

    public String getDELETEUSER() {
        return DELETEUSER;
    }

    public void setDELETEUSER(String DELETEUSER) {
        this.DELETEUSER = DELETEUSER;
    }

    public LocalDateTime getDELETETIME() {
        return DELETETIME;
    }

    public void setDELETETIME(LocalDateTime DELETETIME) {
        this.DELETETIME = DELETETIME;
    }

    public Integer getDELETEFLAG() {
        return DELETEFLAG;
    }

    public void setDELETEFLAG(Integer DELETEFLAG) {
        this.DELETEFLAG = DELETEFLAG;
    }

    public Integer getNODESTART() {
        return NODESTART;
    }

    public void setNODESTART(Integer NODESTART) {
        this.NODESTART = NODESTART;
    }

    public String getTREEPATH() {
        return TREEPATH;
    }

    public void setTREEPATH(String TREEPATH) {
        this.TREEPATH = TREEPATH;
    }

    public Integer getUnitSCOPE() {
        return unitSCOPE;
    }

    public void setUnitSCOPE(Integer unitSCOPE) {
        this.unitSCOPE = unitSCOPE;
    }

    public Integer getISRELEVANCE() {
        return ISRELEVANCE;
    }

    public void setISRELEVANCE(Integer ISRELEVANCE) {
        this.ISRELEVANCE = ISRELEVANCE;
    }

    public Integer getISADMINNODE() {
        return ISADMINNODE;
    }

    public void setISADMINNODE(Integer ISADMINNODE) {
        this.ISADMINNODE = ISADMINNODE;
    }

    @Override
    public String toString() {
        return "S_treenode{" +
        "NODEID=" + NODEID +
        ", NODENAME=" + NODENAME +
        ", NODECODE=" + NODECODE +
        ", NODESHORT=" + NODESHORT +
        ", PARENTID=" + PARENTID +
        ", DESCRIPTION=" + DESCRIPTION +
        ", PORDER=" + PORDER +
        ", ISUSED=" + ISUSED +
        ", LEVELVALUE=" + LEVELVALUE +
        ", NODETYPE=" + NODETYPE +
        ", EFFECTIVETIME=" + EFFECTIVETIME +
        ", MAXGROUPNUM=" + MAXGROUPNUM +
        ", FAILURETIME=" + FAILURETIME +
        ", CREATEUSER=" + CREATEUSER +
        ", CREATETIME=" + CREATETIME +
        ", UPDATEUSER=" + UPDATEUSER +
        ", UPDATETIME=" + UPDATETIME +
        ", DELETEUSER=" + DELETEUSER +
        ", DELETETIME=" + DELETETIME +
        ", DELETEFLAG=" + DELETEFLAG +
        ", NODESTART=" + NODESTART +
        ", TREEPATH=" + TREEPATH +
        ", unitSCOPE=" + unitSCOPE +
        ", ISRELEVANCE=" + ISRELEVANCE +
        ", ISADMINNODE=" + ISADMINNODE +
        "}";
    }
}
