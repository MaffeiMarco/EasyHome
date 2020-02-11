package it.uniba.di.easyhome.proprietario.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import it.uniba.di.easyhome.Home;
import it.uniba.di.easyhome.R;
import it.uniba.di.easyhome.proprietario.bollette.AddBolletteFragment;

public class AddCasaFragment extends Fragment {

     FirebaseAuth mAuth;

    public static AddCasaFragment newInstance() {
        return new AddCasaFragment();
    }
    private DatabaseReference mDatabase;
    String home;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.add_casa_fragment, container, false);
        final FloatingActionButton add_boll_fab= (getActivity().findViewById(R.id.fab2_plus));
        add_boll_fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_person_add));
        final FloatingActionButton add_home_fab= (getActivity().findViewById(R.id.fab3_plus));
        final TextView textIndietro= (TextView) getActivity().findViewById(R.id.agg_boll);
        textIndietro.setText(getResources().getString(R.string.add_inq));
        final Bundle bundle=getArguments();
        final Button btSendt=(Button) root.findViewById(R.id.HomeSend);
        //dichiarazione delle edit
        mDatabase = FirebaseDatabase.getInstance().getReference();
        final EditText casa= root.findViewById(R.id.casa);

        add_home_fab.setImageDrawable(getResources().getDrawable(R.drawable.indietro));
        add_home_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_boll_fab.setImageDrawable(getResources().getDrawable(R.drawable.bill));
                textIndietro.setText(getResources().getString(R.string.bill));
                Fragment newFragment = new HomeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }

        });
        add_boll_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment newFragment = new AddBolletteFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("houses");
        ValueEventListener vel=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                btSendt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        home = casa.getText().toString();

                        writeNewHome(home);

                        Toast.makeText(getActivity(), "Home's Add.",
                                Toast.LENGTH_SHORT).show();
                    }
                });



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        rootRef.addListenerForSingleValueEvent(vel);

        return root;

    }

    private void writeNewHome(String home ) {
        String owner;
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        owner=mAuth.getUid();
        Home casa = new Home(home,owner);
        mDatabase.child("houses").push().setValue(casa);
    }

    }


