/*
 * This file is generated by jOOQ.
 */
package cn.bushadie.jooq.generator;


import cn.bushadie.jooq.generator.tables.User;
import cn.bushadie.jooq.generator.tables.Userinfo;
import cn.bushadie.jooq.generator.tables.Userkv;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>jooq</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index USER_PRIMARY = Indexes0.USER_PRIMARY;
    public static final Index USERINFO_PRIMARY = Indexes0.USERINFO_PRIMARY;
    public static final Index USERKV_PRIMARY = Indexes0.USERKV_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index USER_PRIMARY = Internal.createIndex("PRIMARY", User.USER, new OrderField[] { User.USER.ID }, true);
        public static Index USERINFO_PRIMARY = Internal.createIndex("PRIMARY", Userinfo.USERINFO, new OrderField[] { Userinfo.USERINFO.ID }, true);
        public static Index USERKV_PRIMARY = Internal.createIndex("PRIMARY", Userkv.USERKV, new OrderField[] { Userkv.USERKV.ID }, true);
    }
}
