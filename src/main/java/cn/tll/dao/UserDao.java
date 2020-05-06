package cn.tll.dao;

import cn.tll.entity.User;

import java.util.List;

/**
 * @author tll
 * @date 2020/05/06
 * 持久层
 */
public interface UserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

}
