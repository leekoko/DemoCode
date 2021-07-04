package com.leekoko.nytzj.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface SysUserDao extends BaseMapper<SysUserDao> {

    String getLastUserNameByUserNamePrefix(@Param("userNamePrefix") String userNamePrefix,@Param("subscript") int subscript);

}
