package com.leekoko.mq_demo;

import java.io.Serializable;

/**
 * 业务基本信息表-知识产权事务费预算明细表,对应的数据库表-->BUS_AFFAIR_DETAIL
 *
 * @copyright 广州明动软件股份有限公司 Copyright (c) 2020  
 * @since 2020-11-21 
 * @author xiezy
 * @version 1.0
 * 
 */
public class BusAffairDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String code;
	private String budgetSummaryCode;
	private String workType;
	private String workName;
	private Integer nationality;
	private String meteringUnit;

	public BusAffairDetail(String code) {
		this.code = code;
	}

	public BusAffairDetail(){

	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBudgetSummaryCode() {
		return budgetSummaryCode;
	}

	public void setBudgetSummaryCode(String budgetSummaryCode) {
		this.budgetSummaryCode = budgetSummaryCode;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public Integer getNationality() {
		return nationality;
	}

	public void setNationality(Integer nationality) {
		this.nationality = nationality;
	}

	public String getMeteringUnit() {
		return meteringUnit;
	}

	public void setMeteringUnit(String meteringUnit) {
		this.meteringUnit = meteringUnit;
	}
}