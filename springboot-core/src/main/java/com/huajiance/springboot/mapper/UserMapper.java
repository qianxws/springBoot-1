package com.huajiance.springboot.mapper;

import com.huajiance.springboot.entity.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM dev_user WHERE userid = #{userId}")
    TUser getByUserId(@Param("userId")String userId);

    @Select("select distinct  da.code " +
            "  from dev_auth da join dev_role_auth dra on da.authid = dra.authid " +
            "    join dev_user_role dur on dur.roleid = dra.roleid " +
            "  where dur.userid = #{userId}")
    List<String> getMenusByUserId(@Param("userId") String userId);
}
