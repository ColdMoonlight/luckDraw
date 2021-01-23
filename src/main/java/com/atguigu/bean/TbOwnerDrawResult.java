package com.atguigu.bean;

public class TbOwnerDrawResult {
    private Integer drawresultId;

    private String drawresultName;

    private Integer drawresultGrade;

    private String drawresultCreatetime;

    private String drawresultMotifytime;

    public Integer getDrawresultId() {
        return drawresultId;
    }

    public void setDrawresultId(Integer drawresultId) {
        this.drawresultId = drawresultId;
    }

    public String getDrawresultName() {
        return drawresultName;
    }

    public void setDrawresultName(String drawresultName) {
        this.drawresultName = drawresultName == null ? null : drawresultName.trim();
    }

    public Integer getDrawresultGrade() {
        return drawresultGrade;
    }

    public void setDrawresultGrade(Integer drawresultGrade) {
        this.drawresultGrade = drawresultGrade;
    }

    public String getDrawresultCreatetime() {
        return drawresultCreatetime;
    }

    public void setDrawresultCreatetime(String drawresultCreatetime) {
        this.drawresultCreatetime = drawresultCreatetime == null ? null : drawresultCreatetime.trim();
    }

    public String getDrawresultMotifytime() {
        return drawresultMotifytime;
    }

    public void setDrawresultMotifytime(String drawresultMotifytime) {
        this.drawresultMotifytime = drawresultMotifytime == null ? null : drawresultMotifytime.trim();
    }

	public TbOwnerDrawResult() {
		super();
	}

	public TbOwnerDrawResult(Integer drawresultId, String drawresultName, Integer drawresultGrade,
			String drawresultCreatetime, String drawresultMotifytime) {
		super();
		this.drawresultId = drawresultId;
		this.drawresultName = drawresultName;
		this.drawresultGrade = drawresultGrade;
		this.drawresultCreatetime = drawresultCreatetime;
		this.drawresultMotifytime = drawresultMotifytime;
	}

	@Override
	public String toString() {
		return "TbOwnerDrawResult [drawresultId=" + drawresultId + ", drawresultName=" + drawresultName
				+ ", drawresultGrade=" + drawresultGrade + ", drawresultCreatetime=" + drawresultCreatetime
				+ ", drawresultMotifytime=" + drawresultMotifytime + "]";
	}
    
}