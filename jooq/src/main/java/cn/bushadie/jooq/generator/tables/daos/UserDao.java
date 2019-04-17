/*
 * This file is generated by jOOQ.
 */
package cn.bushadie.jooq.generator.tables.daos;


import cn.bushadie.jooq.generator.tables.User;
import cn.bushadie.jooq.generator.tables.records.UserRecord;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class UserDao extends DAOImpl<UserRecord, cn.bushadie.jooq.generator.tables.pojos.User, String> {

    /**
     * Create a new UserDao without any configuration
     */
    public UserDao() {
        super(User.USER, cn.bushadie.jooq.generator.tables.pojos.User.class);
    }

    /**
     * Create a new UserDao with an attached configuration
     */
    @Autowired
    public UserDao(Configuration configuration) {
        super(User.USER, cn.bushadie.jooq.generator.tables.pojos.User.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getId(cn.bushadie.jooq.generator.tables.pojos.User object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<cn.bushadie.jooq.generator.tables.pojos.User> fetchById(String... values) {
        return fetch(User.USER.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public cn.bushadie.jooq.generator.tables.pojos.User fetchOneById(String value) {
        return fetchOne(User.USER.ID, value);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<cn.bushadie.jooq.generator.tables.pojos.User> fetchByName(String... values) {
        return fetch(User.USER.NAME, values);
    }

    /**
     * Fetch records that have <code>age IN (values)</code>
     */
    public List<cn.bushadie.jooq.generator.tables.pojos.User> fetchByAge(Integer... values) {
        return fetch(User.USER.AGE, values);
    }

    /**
     * Fetch records that have <code>MODIFIED IN (values)</code>
     */
    public List<cn.bushadie.jooq.generator.tables.pojos.User> fetchByModified(LocalDateTime... values) {
        return fetch(User.USER.MODIFIED, values);
    }

    /**
     * Fetch records that have <code>VERSION IN (values)</code>
     */
    public List<cn.bushadie.jooq.generator.tables.pojos.User> fetchByVersion(Integer... values) {
        return fetch(User.USER.VERSION, values);
    }
}
