package cn.bushadie.designPatterns.StructurePatterns.FacadePattern;

/**
 * @author jdmy
 * on 2018/11/20.
 **/
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}