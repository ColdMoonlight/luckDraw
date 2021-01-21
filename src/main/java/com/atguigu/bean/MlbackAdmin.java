package com.atguigu.bean;

public class MlbackAdmin {
    private Integer adminId;

    private String adminAccname;

    private String adminPassword;

    private String adminOperatername;

    private Integer adminPower;

    private String adminPowerItemStr;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminAccname() {
        return adminAccname;
    }

    public void setAdminAccname(String adminAccname) {
        this.adminAccname = adminAccname == null ? null : adminAccname.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    public String getAdminOperatername() {
        return adminOperatername;
    }

    public void setAdminOperatername(String adminOperatername) {
        this.adminOperatername = adminOperatername == null ? null : adminOperatername.trim();
    }

    public Integer getAdminPower() {
        return adminPower;
    }

    public void setAdminPower(Integer adminPower) {
        this.adminPower = adminPower;
    }

    public String getAdminPowerItemStr() {
        return adminPowerItemStr;
    }

    public void setAdminPowerItemStr(String adminPowerItemStr) {
        this.adminPowerItemStr = adminPowerItemStr == null ? null : adminPowerItemStr.trim();
    }

	public MlbackAdmin() {
		super();
	}

	public MlbackAdmin(Integer adminId, String adminAccname, String adminPassword, String adminOperatername,
			Integer adminPower, String adminPowerItemStr) {
		super();
		this.adminId = adminId;
		this.adminAccname = adminAccname;
		this.adminPassword = adminPassword;
		this.adminOperatername = adminOperatername;
		this.adminPower = adminPower;
		this.adminPowerItemStr = adminPowerItemStr;
	}

	@Override
	public String toString() {
		return "MlbackAdmin [adminId=" + adminId + ", adminAccname=" + adminAccname + ", adminPassword=" + adminPassword
				+ ", adminOperatername=" + adminOperatername + ", adminPower=" + adminPower + ", adminPowerItemStr="
				+ adminPowerItemStr + "]";
	}
    
    
}