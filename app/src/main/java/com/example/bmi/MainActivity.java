package com.example.bmi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends Activity {


    EditText editTen, editChieucao, editCannang, editBMI, editChandoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTen = (EditText) findViewById(R.id.edtTen);
        editChieucao = (EditText) findViewById(R.id.edtChieuCao);
        editCannang = (EditText) findViewById(R.id.edtCanNang);
        editBMI = (EditText) findViewById(R.id.edtBMI);
        editChandoan = (EditText) findViewById(R.id.edtChuanDoan);

        editChandoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                double H = Double.parseDouble(String.valueOf(editChieucao.getText())) / 100;
                double W = Double.parseDouble(String.valueOf(editCannang.getText()));
                double BMI = W / Math.pow(H, 2);
                String chandoan = "";
                if (BMI < 18) {
                    chandoan = "Bạn gầy";
                } else if (BMI < 24.9) {
                    chandoan = "Bạn bình thường";
                } else if (BMI < 29.9) {
                    chandoan = "Bạn béo phì độ 1";
                } else if (BMI < 34.9) {
                    chandoan = "Bạn béo phì độ 2";
                } else {
                    chandoan = "Bạn béo phì độ 3";
                }
                DecimalFormat dcf = new DecimalFormat("#.0");
                editBMI.setText(dcf.format(BMI));
                editChandoan.setText(chandoan);
            }
        });
    }
}