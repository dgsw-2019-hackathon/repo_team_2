package com.example.a2019hack.Page.fragment.picker;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.example.a2019hack.Page.activity.AddChildActivity;
import com.example.a2019hack.R;

public class NumberPickerFragment_weight extends DialogFragment {

    private NumberPicker.OnValueChangeListener valueChangeListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final NumberPicker numberPicker = new NumberPicker(getActivity());

        numberPicker.setMinValue(30);
        numberPicker.setMaxValue(60);
        numberPicker.setWrapSelectorWheel(false);

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("몸무게");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Action for 'OK' Button;
                valueChangeListener.onValueChange(numberPicker, numberPicker.getValue(), numberPicker.getValue());  // 코드분석;
                Toast.makeText(getContext(), numberPicker.getValue() + "kg", Toast.LENGTH_SHORT).show();

                AddChildActivity addChildActivity = (AddChildActivity) getContext();
                assert addChildActivity != null;

                Button weightButton = addChildActivity.findViewById(R.id.weightButton);

                Integer temp = numberPicker.getValue();

                weightButton.setText(temp.toString() + "kg");
                weightButton.setTextColor(Color.BLACK);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Action for 'Cancel' Button;

            }
        });

        builder.setView(numberPicker);

        return builder.create();

    }

    public NumberPicker.OnValueChangeListener getValueChangeListener() {
        return valueChangeListener;

    }

    public void setValueChangeListener(NumberPicker.OnValueChangeListener valueChangeListener) {
        this.valueChangeListener = valueChangeListener;

    }
}