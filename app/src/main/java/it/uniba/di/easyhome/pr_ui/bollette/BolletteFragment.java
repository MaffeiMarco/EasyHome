package it.uniba.di.easyhome.pr_ui.bollette;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import it.uniba.di.easyhome.R;

public class BolletteFragment extends Fragment {

    private BolletteViewModel bolletteViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FloatingActionButton fab= (getActivity().findViewById(R.id.fab_plus));
        fab.hide();
        fab.setClickable(false);
        bolletteViewModel =
                ViewModelProviders.of(this).get(BolletteViewModel.class);
        View root = inflater.inflate(R.layout.pr_fragment_bollette, container, false);

        return root;
    }
}