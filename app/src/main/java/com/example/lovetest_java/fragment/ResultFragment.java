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

public class ResultFragment extends Fragment {

    NavController navController;
    TextView mainTv, subTv;
    int option;

    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        option = getArguments().getInt("index");


        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        mainTv = view.findViewById(R.id.mainTv);
        subTv = view.findViewById(R.id.tv_sub);

        ImageView home = view.findViewById(R.id.btn_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_resultFragment_to_mainFragment);
            }
        });


        setResult(option);


    }

    private void setResult(int option) {

        switch (option) {
            case 1:
                mainTv.setText("당신은 QUITTER 입니다.");
                subTv.setText("당신은 그 사람을 쉽게 잊을 수 있습니다.");
                break;
            case 2:
                mainTv.setText("당신 자신에게 집중해야 합니다.");
                subTv.setText("당신은 전 애인에게 정말 집착하게 됩니다.");
                break;
            case 3:
                mainTv.setText("당신은 진정해야합니다.");
                subTv.setText("무슨일이 있어도 미친짓을 할 수 있습니다.");
                break;
            case 4:
                mainTv.setText("당신은 꽤 성숙합니다.");
                subTv.setText("당신은 쉽게 이별을 받아 들일 수 있습니다.");
                break;

        }
    }
}