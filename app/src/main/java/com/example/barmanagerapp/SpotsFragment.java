package com.example.barmanagerapp;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SpotsFragment extends Fragment {


    private Object SpotsAdapter;

    public SpotsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spots, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Object principalViewModel = ViewModelProviders.of(requireActivity()).get(PrincipalViewModel.class);
        NavController navController = Navigation.findNavController(view);

        RecyclerView SpotsRecyclerView = view.findViewById(R.id.recyclerview_listaSpots);
        SpotsRecyclerView.addItemDecoration(new DividerItemDecoration(SpotsRecyclerView.getContext(), DividerItemDecoration.VERTICAL));

        SpotsAdapter = new SpotsAdapter();
        SpotsRecyclerView.setAdapter((RecyclerView.Adapter) SpotsAdapter);


        principalViewModel.listaSpots.observe(getViewLifecycleOwner(), new Observer<List<Spot>>() {
            @Override
            public void onChanged(List<Spot> Spots) {
                SpotsAdapter.establecerListaSpots(Spots);
            }
        });
    }
}
