package com.leekoko.nytzj.flow.dao;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 业务与流程关系表,对应的数据库表-->YW_FLOW_RELATION
 * 
 * @copyright 广州明动软件股份有限公司 Copyright (c) 2020  
 * @since 2020-06-22 
 * @author chenhs
 * @version 1.0
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class YwFlowRelation extends Model<YwFlowRelation> {

	private static final long serialVersionUID = 1L;


	/** 业务键 */
	private String ywKey;
	/** 流程ID */
	private String flowId;
	/** 业务类型 */
	private Integer type;
	/** 备注 */
	private String remark;
	

}