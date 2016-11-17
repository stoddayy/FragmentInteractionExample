package com.apposing.fragmentinteractionexample;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FragTwo extends Fragment {

    FragmentInteractionListener fragListener;

    private static final String TEXT_PARAM = "TEXT_PARAM";
    private String textFromFragOne;

    public FragTwo() {
        // Required empty public constructor
    }

    public static FragTwo newInstance(String text) {
        FragTwo fragment = new FragTwo();
        Bundle args = new Bundle();
        args.putString(TEXT_PARAM, text);
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
        if (getArguments() != null) {
            textFromFragOne = getArguments().getString(TEXT_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);


        Button button = (Button) view.findViewById(R.id.button);
        TextView textView = (TextView) view.findViewById(R.id.textview);

        textView.setText(textFromFragOne);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragListener.setFragOne();
            }
        });

        return view;
    }

}
