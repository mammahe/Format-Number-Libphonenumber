package com.sairamkrishna.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sairamkrishna.formatnumber.FormatNumber;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
TextView hyphen,national,international,e164,unknown,unknownformat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hyphen =findViewById(R.id.hyphen);
        national =findViewById(R.id.national);
        international =findViewById(R.id.international);
        e164 =findViewById(R.id.e164);
        unknown =findViewById(R.id.unknown);
        unknownformat =findViewById(R.id.unknownformat);
        hyphen.setText("Hyphen: "+FormatNumber.getFormattedNumber("+919652018244","Hyphen",this));
        national.setText("National: "+FormatNumber.getFormattedNumber("+919652018244","National",this));
        international.setText("International: "+FormatNumber.getFormattedNumber("+919652018244","International",this));
        e164.setText("E164: "+FormatNumber.getFormattedNumber("+919652018244","E164",this));
        unknown.setText("unknown format: "+FormatNumber.getFormattedNumber("+919652018244","sairam",this));
        unknownformat.setText("unknown: "+FormatNumber.getFormattedNumber("+91qwe67894","E164",this));
    }
}
