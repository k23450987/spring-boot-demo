package com.tom.service.impl;


import com.tom.dao.PersonMapper;
import com.tom.model.Person;
import com.tom.service.PersonService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonMapper dao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Person record) {
        return dao.insert(record);
    }

    // 新增 需要管理员权限
    @Secured("ROLE_ADMIN")
    @Override
    public int insertSelective(Person record) {
        return dao.insertSelective(record);
    }

    @Override
    public Person selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Person record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Person record) {
        return dao.updateByPrimaryKey(record);
    }

    @Override
    public List<Person> selectAll() {
        return dao.selectAll();
    }
}
