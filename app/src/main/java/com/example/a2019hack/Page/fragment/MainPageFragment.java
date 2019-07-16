package com.example.a2019hack.Page.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.a2019hack.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainPageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainPageFragment extends Fragment {

    private Button changeFindButton;
    private Button changeProtectButton;

//    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//
//    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MainPageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainPageFragment newInstance(String param1, String param2) {
        MainPageFragment fragment = new MainPageFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_page, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    //--------------------------------------------------------

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();

        setting();

        event();
    }

    private void initData() {

        changeFindButton = getView().findViewById(R.id.changeFindButton);
        changeProtectButton = getView().findViewById(R.id.changeProtectButton);
    }

    private void setting() {

        changeFindButton.setVisibility(View.VISIBLE);
        changeFindButton.setEnabled(true);

        changeProtectButton.setVisibility(View.INVISIBLE);
        changeProtectButton.setEnabled(false);
    }

    private void event() {

        clickEvent();
    }

    private void clickEvent() {

        clickChangeFindButton();
        clickChangeProtectButton();
    }

    private void clickChangeFindButton() {

        changeFindButton.setOnClickListener(v -> {

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            changeFindButton.setVisibility(View.INVISIBLE);
            changeFindButton.setEnabled(false);

            changeProtectButton.setVisibility(View.VISIBLE);
            changeProtectButton.setEnabled(true);

            fragmentTransaction.replace(R.id.fragment, new ChildProtectListviewActivity());
            fragmentTransaction.commit();
        });
    }

    private void clickChangeProtectButton() {

        changeProtectButton.setOnClickListener(v -> {

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            changeFindButton.setVisibility(View.VISIBLE);
            changeFindButton.setEnabled(true);

            changeProtectButton.setVisibility(View.INVISIBLE);
            changeProtectButton.setEnabled(false);

            fragmentTransaction.replace(R.id.fragment, new ChildListviewActivity());
            fragmentTransaction.commit();
        });
    }

    //--------------------------------------------------------

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
