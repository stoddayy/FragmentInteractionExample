package com.apposing.fragmentinteractionexample;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FragOne extends Fragment {

    private FragmentInteractionListener fragListener;

    public FragOne() {
        // Required empty public constructor
    }


    public static FragOne newInstance(String param1, String param2) {
        FragOne fragment = new FragOne();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        fragListener = (FragmentInteractionListener) context;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_frag_one, container, false);


        Button button = (Button) view.findViewById(R.id.button);
        final EditText editText = (EditText) view.findViewById(R.id.edittext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragListener.setFragTwo(editText.getText().toString());
            }
        });

        return view;
    }

}
