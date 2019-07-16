package com.example.a2019hack.Page.fragment;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.a2019hack.R;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddChildFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddChildFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddChildFragment extends Fragment {

    String [] item = new String[19];
    String name, call, sex, place, age; // 저장한 데이터들
    Boolean sexToggle = false; // true = man, false = woman;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AddChildFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddChildFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddChildFragment newInstance(String param1, String param2) {
        AddChildFragment fragment = new AddChildFragment();
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
        return inflater.inflate(R.layout.fragment_add_child, container, false);
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

        final Spinner ageSpinner = getView().findViewById(R.id.ageSpinner);
        ImageView image = getView().findViewById(R.id.add_child_image);
        Button manBtn = getView().findViewById(R.id.manButton);
        Button womanBtn = getView().findViewById(R.id.womanButton);
        Button confirm = getView().findViewById(R.id.confirmAdd);
        EditText childName = getView().findViewById(R.id.add_child_nameText);
        EditText callNumber = getView().findViewById(R.id.parentPhoneNumber);
        EditText missingPlace = getView().findViewById(R.id.missingLocation);

        String setAge = " 세";

        // 나이 콤보박스 및 선택 시 이벤트
        for(int i=0;i<item.length;i++) {

            item[i] = Integer.toString(i);

            setAge = item[i] + setAge;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext().getApplicationContext(), R.layout.spinner_item, item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        ageSpinner.setAdapter(adapter);

        ageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                age = ageSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // sexToggle is true then man, false then woman
        if(sexToggle) {

            manBtn.setEnabled(true);
            womanBtn.setEnabled(false);
        }
        else {

            womanBtn.setEnabled(true);
            manBtn.setEnabled(false);
        }
        manBtn.setOnClickListener(I -> {

            sexToggle = true;
            sex = "boy";
        });

        womanBtn.setOnClickListener(I -> {

            sexToggle = false;
            sex = "girl";
        });

        image.setOnClickListener(I -> {

            tedPermission();
        });

        confirm.setOnClickListener(I -> {

            name = childName.getText().toString();
            call = callNumber.getText().toString();
            place = missingPlace.getText().toString();

            if(name.equals("") || call.equals("") || ageSpinner.getSelectedItem().equals("")) {

                Toast.makeText(getActivity().getApplicationContext(), "필수 입력란을 채워주세요.", Toast.LENGTH_LONG).show();
            }
            else { // 값이 다 채워졌으면

                Toast.makeText(getActivity().getApplicationContext(), "모든 항목이 입력되었습니다.", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getContext().getApplicationContext(), ChildListviewActivity.class);

                // TODO
            }
        });
    }

    private void tedPermission() {

        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {

            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {

            }
        };

        TedPermission.with(getActivity().getApplicationContext())
                .setPermissionListener(permissionListener)
                .setRationaleMessage(getResources().getString(R.string.permission_2))
                .setDeniedMessage(getResources().getString(R.string.permission_1))
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                .check();
    }

    // 이미지 Uri 가져오기
    private String getImageUri(Uri contentUri) {

        String result;
        Cursor cursor = getActivity().getContentResolver().query(contentUri, null, null, null, null);

        if(cursor == null){

            result = contentUri.getPath();
        }
        else {

            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }

        return result;
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
