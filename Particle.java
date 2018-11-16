import com.sun.org.apache.bcel.internal.generic.F2D;
import com.sun.xml.internal.messaging.saaj.soap.ver1_1.Fault1_1Impl;

/**
 * Created with IntelliJ IDEA.
 * User: Sina
 * Date: 11/7/16
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Particle {
    double x,y,PBestX,PBestY,PBestV,Fx,size,InertiaX=0,InertiaY=0,omega=.1,c1=.1,c2=.1;
    Particle(double x,double y){
        Set(x,y);
        PBestX=x;
        PBestY=y;
        PBestV=Fx;
    }
    void Set(double x,double y){
        this.x=x;
        this.y=y;
        calculate();
    }
    void calculate(){
        if(F1()>Math.max(F2(),F3()))
            Fx=F1();
        if(F2()>Math.max(F1(),F3()))
            Fx=F2();
        if(F3()>Math.max(F1(),F2()))
            Fx=F3();
    }
    double fitness(){
        double res=-Fx;
        if(res>PBestV){
            PBestX=x;
            PBestY=y;
            PBestV=res;
        }
        return res;
    }
    void evolve(double XGBest,double YGBest){
        SetInertia(XGBest,YGBest);
        x+=InertiaX;
        y+=InertiaY;
    }
    double F1(){
        return Math.pow(x,4)+Math.pow(y,2);
    }
    double F2(){
        return Math.pow(2-x,2)+Math.pow(2-y,2);
    }
    double F3(){
        return Math.exp(y-x);
    }
    void SetInertia(double XGBest,double YGBest){
        InertiaX=omega*InertiaX+c1*Math.random()*(PBestX-x)+c2*Math.random()*(XGBest-x);
        InertiaY=omega*InertiaY+c1*Math.random()*(PBestY-y)+c2*Math.random()*(YGBest-y);
    }
}
