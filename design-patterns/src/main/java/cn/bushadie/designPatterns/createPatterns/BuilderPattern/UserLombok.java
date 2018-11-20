package cn.bushadie.designPatterns.createPatterns.BuilderPattern;

import lombok.Builder;

/**
 * @author jdmy
 * on 2018/11/19.
 **/
@Builder
public class UserLombok {
    private String  name;
    private String password;
    private String nickName;
    private int age;
}
