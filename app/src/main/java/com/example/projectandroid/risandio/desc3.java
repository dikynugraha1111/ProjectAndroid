package com.example.projectandroid.risandio;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projectandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class desc3 extends Fragment {
    public EditText karet3,kertas3,plastik3;
    public Button kalkulasi1;
    public TextView hasil1;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public desc3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment desc1.
     */
    // TODO: Rename and change types and number of parameters
    public static desc1 newInstance(String param1, String param2) {
        desc1 fragment = new desc1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private void total1(int kertas3,int plastik3,int karet3){
        double hasilvolume=(plastik3*1500)+(kertas3*1000)+(karet3*2000);
        hasil1.setText(String.valueOf(hasilvolume));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_desc1, container, false);
        kertas3 = view.findViewById(R.id.kertas3);
        plastik3 = view.findViewById(R.id.plastik3);
        karet3 = view.findViewById(R.id.karet3);
        kalkulasi1 = view.findViewById(R.id.kalkulasi1);
        hasil1 = view.findViewById(R.id.hasil1);
        kalkulasi1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String plastik= karet3.getText().toString();
                String kaleng = kertas3.getText().toString();
                String kertas = plastik3.getText().toString();
                total1(Integer.parseInt(kaleng),Integer.parseInt(kertas),Integer.parseInt(plastik));
            }
        });
        return view;
    }
}
