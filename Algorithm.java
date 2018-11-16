/**
 * Created with IntelliJ IDEA.
 * User: Sina
 * Date: 11/8/16
 * Time: 12:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class Algorithm {
    Particle Particles[]=new Particle[50];
    double XBest,YBest,VBest;
    Algorithm(){
        for(int i=0;i<50;i++)       //initialize
            Particles[i]=new Particle((Math.random()*100)-50,(Math.random()*100)-50);
        XBest=Particles[0].x;
        YBest=Particles[0].y;
        VBest=Particles[0].fitness();
        CalculateBest();
        for(int j=0;j<30;j++){
            for(int i=0;i<50;i++)
                Particles[i].evolve(XBest,YBest);
            CalculateBest();
        }
    }
    void CalculateBest(){
        for (int i=0;i<50;i++)
            if(Particles[i].fitness()>VBest){
                XBest=Particles[i].x;
                YBest=Particles[i].y;
                VBest=Particles[i].fitness();
            }
    }
}
