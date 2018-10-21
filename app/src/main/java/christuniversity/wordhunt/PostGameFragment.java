//Created by Chaitanya on 22/08/2018.
//Usage without appropriate citations ins prohibited.
package christuniversity.wordhunt;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class PostGameFragment extends Fragment {
    TextView nametext,scoretext,timetext;
    Button back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState) {
        View view = inflater.inflate(R.layout.postgamelayout, container, false);
        back=(Button)view.findViewById(R.id.backmenu);
        scoretext=(TextView)view.findViewById(R.id.scoretext);
        nametext=(TextView)view.findViewById(R.id.nametext);
        timetext=(TextView)view.findViewById(R.id.timetext);
        Globals g1=Globals.getInstance();
        GlobalScore g2=GlobalScore.getInstance();
        String name=g1.getName();
        int score=g2.getScore();
        double time=g2.getTime();
        nametext.setText(name);
        scoretext.setText(""+score);
        timetext.setText(""+time);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new MenuFragment());
            }
        });

        return view;
    }
    public void loadFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
