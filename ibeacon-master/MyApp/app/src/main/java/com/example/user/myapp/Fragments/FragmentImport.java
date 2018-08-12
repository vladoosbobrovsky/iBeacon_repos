package com.example.user.myapp.Fragments;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.user.myapp.R;

@SuppressWarnings("ALL")
public class FragmentImport extends Fragment {

    private Button mStartButton;
    private ImageButton mImage;
    private Button b_quiz;
    private ImageButton imageButton4;
    private ImageButton imageButton5;
    private ImageButton imageButton6;

    private OnFragmentInteractionListener mListener;

    public FragmentImport() {
    }


    public static FragmentImport newInstance(String param1, String param2) {
        FragmentImport fragment = new FragmentImport();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_import, container, false);

    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
