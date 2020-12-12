package com.example.lovetest_java.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lovetest_java.R;

import org.w3c.dom.Text;

public class SelectionFragment extends Fragment implements  View.OnClickListener{

    NavController navController;
    private TextView option1, option2, option3, option4;

    public SelectionFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selection, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        ImageView back = view.findViewById(R.id.backIv);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.popBackStack();
            }
        });

        option1 = view.findViewById(R.id.option1);
        option2 = view.findViewById(R.id.option2);
        option3 = view.findViewById(R.id.option3);
        option4 = view.findViewById(R.id.option4);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.equals(option1)) {
            navigateWithIndex(1);
        }else if(v.equals(option2)){
            navigateWithIndex(2);
        }else if(v.equals(option3)){
            navigateWithIndex(3);
        }else if(v.equals(option4)){
            navigateWithIndex(4);
        }

    }

    private void navigateWithIndex(int index) {

        Bundle bundle = new Bundle();
        bundle.putInt("index",index);
        navController.navigate(R.id.action_selectionFragment_to_resultFragment,bundle);
    }
}