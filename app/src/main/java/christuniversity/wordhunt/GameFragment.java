//Created by Chaitanya on 22/08/2018.
//Usage without appropriate citations ins prohibited.
package christuniversity.wordhunt;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static android.content.Context.VIBRATOR_SERVICE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.YELLOW;

public class GameFragment extends Fragment {
    String selectedText,timestamp,day,playername,collegename,phno;
    int score1 = 0;
    private DatabaseReference uDatabase;
    double timetaken;
    private Vibrator myVib;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState) {
        View view = inflater.inflate(R.layout.gamelayout, container, false);
        uDatabase = FirebaseDatabase.getInstance().getReference();
        myVib = (Vibrator)getActivity().getSystemService(VIBRATOR_SERVICE);
        final TextView[ ] words=new TextView[20];
        final String set[]=new String[20];
        final Button submit=(Button)view.findViewById(R.id.submit);
        words[0]=(TextView)view.findViewById(R.id.w1);
        words[1]=(TextView)view.findViewById(R.id.w2);
        words[2]=(TextView)view.findViewById(R.id.w3);
        words[3]=(TextView)view.findViewById(R.id.w4);
        words[4]=(TextView)view.findViewById(R.id.w5);
        words[5]=(TextView)view.findViewById(R.id.w6);
        words[6]=(TextView)view.findViewById(R.id.w7);
        words[7]=(TextView)view.findViewById(R.id.w8);
        words[8]=(TextView)view.findViewById(R.id.w9);
        words[9]=(TextView)view.findViewById(R.id.w10);
        words[10]=(TextView)view.findViewById(R.id.w11);
        words[11]=(TextView)view.findViewById(R.id.w12);
        words[12]=(TextView)view.findViewById(R.id.w13);
        words[13]=(TextView)view.findViewById(R.id.w14);
        words[14]=(TextView)view.findViewById(R.id.w15);
        words[15]=(TextView)view.findViewById(R.id.w16);
        words[16]=(TextView)view.findViewById(R.id.w17);
        words[17]=(TextView)view.findViewById(R.id.w18);
        words[18]=(TextView)view.findViewById(R.id.w19);
        words[19]=(TextView)view.findViewById(R.id.w20);
        final TextView timer=(TextView)view.findViewById(R.id.timer);
        String set0[] = {"Stemplot","Stratification","Boxmodel","Centrifugation",
                        "Chelation", "Antecedent", "Cuvette", "Pyrolisis",
                        "Retort","Kernel", "Bifurcation Theory","Stratum",
                        "Resistant","Ergodic Theory","Apoapsis","Cluster Sample",
                        "Eccentricity","Zenith", "Roche Limit","Outlier"};

        String set1[]={"Confounder","Iwasawa Theory","Sample","Statics","Stem and Leaf Display",
                "Bootstrap","Mach Number","Acoustics","Babinet’s Principle",
                "Undercoverage","Bragg’s Law","Interpolation","Geometric Albedo",
                "Periapsis","Inference","Ampacity","Heteroscedasticity","Buck",
                "Compander","Ideality Factor"};

        String set2[]={"Impedance","Random","Preemphasis","Normal","Beta distribution",
                "Quadrature","Tweak","Skewness","Strobe"," Snubber ","Ramsey Theory ",
                "Range","Coanda Effect ","Gamma distribution","Richardson Number",
                "Transonic Number","Inferential","Strouhal Number","Expectation"," Attenuate"};

        String set3[]={"Hypothesis","Cation","F distribution","Population","Impetus",
                "Moments","Lepton","Meson","Undercoverage","Muon","T distribution","Element","Gay Lussac's Law",
                "Krypton","Legend","Period","Unit","Zymogen","Range","Inferential"};

        String set4[]={"Asterism","Boxmodel","Black Hole","Confounder","Barlow lens","Asteriod",
                "Collimation","Bootstrap","Conjunction","Dobsonian","Ephermeris","Gibbous",
                "Stem and Leaf Display","Inclination","Outlier","Libration","Outlier",
                "Gamma distribution","Magnitude","Antecedent"};

       // String set6[]={"Meridian","Messier","Nebula","Meteor","Parallax","Cluster","Retrograde","Solstice","Faraday","Coloumb","Waxing",
                      //          "Globular Cluster"};

        final String correctwords[]={"Outlier",
                "Outlier",
                "Boxmodel",
                "Antecedent",
                "Cluster Sample",
                "Stemplot",
                "Kernel",
                "Resistant",
                "Stem and Leaf Display",
                "Interpolation",
                "Heteroscedasticity",
                "Confounder",
                "Inference",
                "Undercoverage",
                "Bootstrap",
                "Sample",
                "Random",
                "Normal",
                "Beta distribution",
                "Skewness",
                "Range",
                "Gamma distribution",
                "Inferential",
                "Expectation",
                "Hypothesis",
                "F distribution",
                "Population",
                "Moments",
                "T distribution"};

        final String finallwords[]=new String[20];
        final String finacorrectwords[]=new String[8];
        TextView name=(TextView)view.findViewById(R.id.nameview);
        final TextView score=(TextView)view.findViewById(R.id.score);
        score.setText("0");
        Globals g=Globals.getInstance();
        playername=g.getName();
        collegename=g.getCollege();
        phno=g.getPhone();
        name.setText(playername);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
        day = simpleDateFormat2.format(new Date());

        int setnumber=getRandom();
        if(setnumber==0)
        {
            for(int i=0;i<20;i++)
            {
                set[i]=set0[i];
            }
        }
        if(setnumber==1)
        {
            for(int i=0;i<20;i++)
            {
                set[i]=set1[i];
            }
        }
        if(setnumber==2)
        {
            for(int i=0;i<20;i++)
            {
                set[i]=set2[i];
            }
        }
        if(setnumber==3)
        {
            for(int i=0;i<20;i++)
            {
                set[i]=set3[i];
            }
        }
        if(setnumber==4)
        {
            for(int i=0;i<20;i++)
            {
                set[i]=set4[i];
            }
        }
        Log.d("Set number","set ="+setnumber);
        Collections.shuffle(Arrays.asList(set));

        // String [] finalwords = temp.toArray(new String[20]);
        for(int i=0;i<20;i++)
        {
            words[i].setText(set[i]);
        }


        new CountDownTimer(30000, 10) {

            public void onTick(final long millisUntilFinished) {
                if(millisUntilFinished/1000 <=15){
                    timer.setTextColor(YELLOW);
                }
                if(millisUntilFinished/1000 <=5){
                    timer.setTextColor(RED);
                }
                timer.setText("" + millisUntilFinished / 1000);

                for(int i=0;i<20;i++)
                {
                    final TextView currentText=words[i];
                    currentText.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            selectedText=currentText.getText().toString();
                            if(Arrays.asList(correctwords).contains(selectedText))
                            {
                                currentText.setEnabled(false);
                                score1=score1+10;
                                currentText.setTextColor(GREEN);

                            }
                            else
                            {
                                myVib.vibrate(50);
                                currentText.setEnabled(false);
                                score1=score1-2;
                                currentText.setTextColor(RED);
                            }
                        }
                    });

                }
                score.setText(score1+"");
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        timetaken=30.00-millisUntilFinished/1000;
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy-hh:mm:ss");
                        timestamp = simpleDateFormat.format(new Date());
                        submitScore();
                        cancel();


                    }
                });

            }

            public void onFinish() {
                timetaken=30;
                submitScore();


            }

        }.start();




        return view;
    }
    public static int getRandom() {
        Random rand = new Random();
        return rand.nextInt(5);
    }

    public static class UpdateScore
    {
        private int score;
        private String name,college,phone,timestamp;
        double time;
        public UpdateScore(){

        }
        public UpdateScore(String name, String college, String phone ,double time, int score,String timestamp){
            this.name=name;
            this.college=college;
            this.phone=phone;
            this.time=time;
            this.score=score;
            this.timestamp=timestamp;
        }
        public String getName(){
            return name;
        }
        public String getCollege(){
            return college;
        }
        public String getPhone(){
            return phone;
        }


        public double getTime() {
            return time;
        }

        public int getScore() {
            return score;
        }

        public String getTimestamp(){
            return timestamp;
        }
    }
    public void submitScore(){
        UpdateScore updateScore=new UpdateScore(playername,collegename,phno,timetaken,score1,timestamp);
        uDatabase.child(day).child(""+score1+"("+playername+"_"+phno+")").setValue(updateScore);
        Log.d("data","name"+playername+"college"+collegename+"phone"+phno+"time"+timetaken+"score"+score1);
        GlobalScore gs=GlobalScore.getInstance();
        gs.setData(score1,timetaken);
        loadFragment(new PostGameFragment());

    }
    public void loadFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}