//Created by Chaitanya on 22/08/2018.
//Usage without appropriate citations ins prohibited.
package christuniversity.wordhunt;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class UserFragment extends Fragment {
    Globals g=Globals.getInstance();
    EditText name,college,phone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState) {
        View view = inflater.inflate(R.layout.userlayout, container, false);
        ImageButton back=(ImageButton) view.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new MenuFragment());
            }
        });
        name=(EditText)view.findViewById(R.id.playername);
        college=(EditText)view.findViewById(R.id.collegename);
        phone=(EditText)view.findViewById(R.id.phone);

        Button start=(Button)view.findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nametext,collegetext,phonetext;
                nametext=name.getText().toString();
                collegetext=college.getText().toString();
                phonetext=phone.getText().toString();
                if (TextUtils.isEmpty(nametext)) {
                    Toast.makeText(view.getContext(), "Enter your name!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(collegetext)) {
                    Toast.makeText(view.getContext(), "Enter your college!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(phonetext)) {
                    Toast.makeText(view.getContext(), "Enter your phone number!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(phonetext.length()<10){
                    Toast.makeText(view.getContext(), "Enter a valid phone number!", Toast.LENGTH_SHORT).show();
                    return;
                }
                        {
                            g.setData(nametext, collegetext, phonetext);
                            loadFragment(new GameFragment());
                        }
            }
        });
        return view;
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
