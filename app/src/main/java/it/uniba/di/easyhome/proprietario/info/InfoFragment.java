package it.uniba.di.easyhome.proprietario.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import it.uniba.di.easyhome.ProprietarioActivity;
import it.uniba.di.easyhome.R;

public class InfoFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        if(getActivity().equals(ProprietarioActivity.class)) {
            FloatingActionButton fab = (getActivity().findViewById(R.id.fab_plus));
            fab.hide();
            fab.setClickable(false);}
        View root = inflater.inflate(R.layout.fragment_info, container, false);


        return root;
    }
}