//Created by Chaitanya on 22/08/2018.
//Usage without appropriate citations ins prohibited.
package christuniversity.wordhunt;

public class Globals{
    private static Globals instance;

    // Global variable
    private String name;
    private String college;
    private String phone;

    // Restrict the constructor from being instantiated
    private Globals(){}

    public void setData(String d,String n,String p){

        this.name=d;
        this.college=n;
        this.phone=p;
    }
    public String getName(){

        return this.name;
    }

    public String getCollege() {
        return this.college;
    }

    public String getPhone(){
        return this.phone;
    }
    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }
}