package com.atguigu.bean;

public class TbOwnerLuckDraw {
    private Integer luckdrawId;

    private String luckdrawName;

    private String luckdrawAllname;

    private String luckdrawTelephone;

    private Integer luckdrawStatus;

    private Integer luckdrawGrade;

    private Integer luckdrawIfin;

    private String luckdrawCreatetime;

    private String luckdrawMotifytime;

    public Integer getLuckdrawId() {
        return luckdrawId;
    }

    public void setLuckdrawId(Integer luckdrawId) {
        this.luckdrawId = luckdrawId;
    }

    public String getLuckdrawName() {
		return luckdrawName;
	}

	public void setLuckdrawName(String luckdrawName) {
		this.luckdrawName = luckdrawName == null ? null : luckdrawName.trim();
	}

	public String getLuckdrawAllname() {
        return luckdrawAllname;
    }

    public void setLuckdrawAllname(String luckdrawAllname) {
        this.luckdrawAllname = luckdrawAllname == null ? null : luckdrawAllname.trim();
    }

    public String getLuckdrawTelephone() {
        return luckdrawTelephone;
    }

    public void setLuckdrawTelephone(String luckdrawTelephone) {
        this.luckdrawTelephone = luckdrawTelephone == null ? null : luckdrawTelephone.trim();
    }

    public Integer getLuckdrawStatus() {
        return luckdrawStatus;
    }

    public void setLuckdrawStatus(Integer luckdrawStatus) {
        this.luckdrawStatus = luckdrawStatus;
    }

    public Integer getLuckdrawGrade() {
        return luckdrawGrade;
    }

    public void setLuckdrawGrade(Integer luckdrawGrade) {
        this.luckdrawGrade = luckdrawGrade;
    }

    public Integer getLuckdrawIfin() {
        return luckdrawIfin;
    }

    public void setLuckdrawIfin(Integer luckdrawIfin) {
        this.luckdrawIfin = luckdrawIfin;
    }

    public String getLuckdrawCreatetime() {
        return luckdrawCreatetime;
    }

    public void setLuckdrawCreatetime(String luckdrawCreatetime) {
        this.luckdrawCreatetime = luckdrawCreatetime == null ? null : luckdrawCreatetime.trim();
    }

    public String getLuckdrawMotifytime() {
        return luckdrawMotifytime;
    }

    public void setLuckdrawMotifytime(String luckdrawMotifytime) {
        this.luckdrawMotifytime = luckdrawMotifytime == null ? null : luckdrawMotifytime.trim();
    }

	public TbOwnerLuckDraw() {
		super();
	}

	public TbOwnerLuckDraw(Integer luckdrawId, String luckdrawName, String luckdrawAllname, String luckdrawTelephone,
			Integer luckdrawStatus, Integer luckdrawGrade, Integer luckdrawIfin, String luckdrawCreatetime,
			String luckdrawMotifytime) {
		super();
		this.luckdrawId = luckdrawId;
		this.luckdrawName = luckdrawName;
		this.luckdrawAllname = luckdrawAllname;
		this.luckdrawTelephone = luckdrawTelephone;
		this.luckdrawStatus = luckdrawStatus;
		this.luckdrawGrade = luckdrawGrade;
		this.luckdrawIfin = luckdrawIfin;
		this.luckdrawCreatetime = luckdrawCreatetime;
		this.luckdrawMotifytime = luckdrawMotifytime;
	}

	@Override
	public String toString() {
		return "TbOwnerLuckDraw [luckdrawId=" + luckdrawId + ", luckdrawName=" + luckdrawName + ", luckdrawAllname="
				+ luckdrawAllname + ", luckdrawTelephone=" + luckdrawTelephone + ", luckdrawStatus=" + luckdrawStatus
				+ ", luckdrawGrade=" + luckdrawGrade + ", luckdrawIfin=" + luckdrawIfin + ", luckdrawCreatetime="
				+ luckdrawCreatetime + ", luckdrawMotifytime=" + luckdrawMotifytime + "]";
	}

}