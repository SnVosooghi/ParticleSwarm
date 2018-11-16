public class Main {

    public static void main(String[] args) {
        Algorithm Sample=new Algorithm();
        for (int i=0;i<50;i++)
            System.out.println(Sample.Particles[i].x+"&"+Sample.Particles[i].y+"&"+Sample.Particles[i].fitness());
        System.out.println(Sample.XBest+"&"+Sample.YBest+"&"+Sample.VBest);
    }
}
