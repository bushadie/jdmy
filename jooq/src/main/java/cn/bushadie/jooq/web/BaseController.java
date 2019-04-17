package cn.bushadie.jooq.web;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

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
}
