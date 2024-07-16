package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 党务工作者
 *
 * @author 
 * @email
 */
@TableName("gongzuo")
public class GongzuoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GongzuoEntity() {

	}

	public GongzuoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 党务工作者姓名
     */
    @ColumnInfo(comment="党务工作者姓名",type="varchar(200)")
    @TableField(value = "gongzuo_name")

    private String gongzuoName;


    /**
     * 党务工作者手机号
     */
    @ColumnInfo(comment="党务工作者手机号",type="varchar(200)")
    @TableField(value = "gongzuo_phone")

    private String gongzuoPhone;


    /**
     * 党务工作者身份证号
     */
    @ColumnInfo(comment="党务工作者身份证号",type="varchar(200)")
    @TableField(value = "gongzuo_id_number")

    private String gongzuoIdNumber;


    /**
     * 党务工作者头像
     */
    @ColumnInfo(comment="党务工作者头像",type="varchar(200)")
    @TableField(value = "gongzuo_photo")

    private String gongzuoPhoto;


    /**
     * 申请状态
     */
    @ColumnInfo(comment="申请状态",type="int(11)")
    @TableField(value = "shenqing_yuyue_types")

    private Integer shenqingYuyueTypes;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    @ColumnInfo(comment="电子邮箱",type="varchar(200)")
    @TableField(value = "gongzuo_email")

    private String gongzuoEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：党务工作者姓名
	 */
    public String getGongzuoName() {
        return gongzuoName;
    }
    /**
	 * 设置：党务工作者姓名
	 */

    public void setGongzuoName(String gongzuoName) {
        this.gongzuoName = gongzuoName;
    }
    /**
	 * 获取：党务工作者手机号
	 */
    public String getGongzuoPhone() {
        return gongzuoPhone;
    }
    /**
	 * 设置：党务工作者手机号
	 */

    public void setGongzuoPhone(String gongzuoPhone) {
        this.gongzuoPhone = gongzuoPhone;
    }
    /**
	 * 获取：党务工作者身份证号
	 */
    public String getGongzuoIdNumber() {
        return gongzuoIdNumber;
    }
    /**
	 * 设置：党务工作者身份证号
	 */

    public void setGongzuoIdNumber(String gongzuoIdNumber) {
        this.gongzuoIdNumber = gongzuoIdNumber;
    }
    /**
	 * 获取：党务工作者头像
	 */
    public String getGongzuoPhoto() {
        return gongzuoPhoto;
    }
    /**
	 * 设置：党务工作者头像
	 */

    public void setGongzuoPhoto(String gongzuoPhoto) {
        this.gongzuoPhoto = gongzuoPhoto;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getShenqingYuyueTypes() {
        return shenqingYuyueTypes;
    }
    /**
	 * 设置：申请状态
	 */

    public void setShenqingYuyueTypes(Integer shenqingYuyueTypes) {
        this.shenqingYuyueTypes = shenqingYuyueTypes;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getGongzuoEmail() {
        return gongzuoEmail;
    }
    /**
	 * 设置：电子邮箱
	 */

    public void setGongzuoEmail(String gongzuoEmail) {
        this.gongzuoEmail = gongzuoEmail;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Gongzuo{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", gongzuoName=" + gongzuoName +
            ", gongzuoPhone=" + gongzuoPhone +
            ", gongzuoIdNumber=" + gongzuoIdNumber +
            ", gongzuoPhoto=" + gongzuoPhoto +
            ", shenqingYuyueTypes=" + shenqingYuyueTypes +
            ", sexTypes=" + sexTypes +
            ", gongzuoEmail=" + gongzuoEmail +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
