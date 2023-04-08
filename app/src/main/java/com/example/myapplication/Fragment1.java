package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment implements View.OnClickListener {

    private Button button1, button2, button3;

    public static Fragment1 newInstance() {
        return new Fragment1();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Find buttons by their ID and set click listeners
        button1 = view.findViewById(R.id.button1);
        button2 = view.findViewById(R.id.button2);
        button3 = view.findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        // Set default button as selected
        button1.setSelected(true);

        // Display fragment content for the default button
        getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment1()).commit();
    }

    @Override
    public void onClick(View view) {
        // Deselect all buttons
        button1.setSelected(false);
        button2.setSelected(false);
        button3.setSelected(false);

        // Select clicked button
        view.setSelected(true);

        // Display fragment content for selected button
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.button1:
                fragment = new Fragment1_1();
                break;
            case R.id.button2:
                fragment = new Fragment1_2();
                break;
            case R.id.button3:
                fragment = new Fragment1_3();
                break;
        }
        getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }
}

