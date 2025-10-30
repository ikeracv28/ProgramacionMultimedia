package com.example.calculadoraiker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class TextFragment extends Fragment {


    private ImageView imagen;
    private TextView textView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_image, container, false);

        textView = v.findViewById(R.id.fragmenTextView);

        imagen = v.findViewById(R.id.ImageView7);
        return v;
    }


    public void ChangeImageAlpha(int alpha){
        int t_value = alpha * 255 / 100;
        imagen.setImageAlpha(t_value);
    }
    public void ChangeTextProperties(int fontsize, String text)
    {
        if(textView != null){
            textView.setTextSize(fontsize);
            textView.setText(text);
        }

    }

}