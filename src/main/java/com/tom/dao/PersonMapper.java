package com.tom.dao;


import com.tom.model.Person;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

    List<Person> selectAll();
}
