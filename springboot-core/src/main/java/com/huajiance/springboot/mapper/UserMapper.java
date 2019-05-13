package com.huajiance.springboot.mapper;

import com.huajiance.springboot.entity.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface UserMapper {

    TUser getByUserId(@Param("userId")String userId);

    List<String> getMenusByUserId(@Param("userId") String userId);
}
