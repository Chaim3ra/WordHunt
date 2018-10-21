//Created by Chaitanya on 22/08/2018.
//Usage without appropriate citations ins prohibited.
package christuniversity.wordhunt;

public class GlobalScore{
    private static GlobalScore instance;

    // Global variable
    private int score;
    private double time;

    // Restrict the constructor from being instantiated
    private GlobalScore(){}

    public void setData(int s,double t){

        this.score=s;
        this.time=t;
    }
    public int getScore(){

        return this.score;
    }

    public double getTime(){
        return this.time;
    }

    public static synchronized GlobalScore getInstance(){
        if(instance==null){
            instance=new GlobalScore();
        }
        return instance;
    }
}