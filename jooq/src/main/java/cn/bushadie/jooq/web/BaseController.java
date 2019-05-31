package cn.bushadie.jooq.web;

import cn.bushadie.jooq.generator.Tables;
import cn.bushadie.jooq.generator.tables.pojos.User;
import cn.bushadie.jooq.generator.tables.records.UserRecord;
import org.jooq.DSLContext;
import org.jooq.SelectWhereStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * @author jdmy
 * on 2019/3/29.
 **/
@Controller
public class BaseController {
    private final DSLContext dslContext;

    @Autowired
    public BaseController(@Qualifier("dslContext") DSLContext dslContext) {
        this.dslContext=dslContext;
    }

    @GetMapping("/user")
    @ResponseBody
    public String user(UserRecord user){
        System.out.println(user);
        return "user";
    }

    @GetMapping("/data")
    @ResponseBody
    public Object getdata(){
        SelectWhereStep<UserRecord> items=dslContext.selectFrom(Tables.USER);
        ArrayList<User> list=new ArrayList<>();
        for(UserRecord item: items) {
            User user=item.into(User.class);
            list.add(user);
        }
        return list;
    }

}
