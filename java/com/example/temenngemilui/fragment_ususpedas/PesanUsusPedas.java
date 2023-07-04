package com.example.temenngemilui.fragment_ususpedas;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.temenngemilui.CustomAlertDialog.ErrorMessage;
import com.example.temenngemilui.CustomAlertDialog.SuccessDialogFragment;
import com.example.temenngemilui.R;

import java.util.Calendar;

public class PesanUsusPedas extends Fragment {
    Spinner spin;
    public String[] a;
    public String[] b;
    TimePickerDialog timePicker;
    public EditText harga,waktu,tanggal,jumlah;
    public Button btn_total,btn_order;
    public TextView txttotal,txtnama;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtnama = view.findViewById(R.id.txtnamausus);
        a = view.getResources().getStringArray(R.array.ukuran);
        b = view.getResources().getStringArray(R.array.hargausus);
        harga = view.findViewById(R.id.harga);
        jumlah = view.findViewById(R.id.jumlah);
        txttotal = view.findViewById(R.id.txttotal);
        spin = view.findViewById(R.id.spin);
        spin.setAdapter(new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_dropdown_item,a));
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                harga.setText(b[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        waktu = view.findViewById(R.id.waktu);
        waktu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int jam = c.get(Calendar.HOUR_OF_DAY);
                int menit = c.get(Calendar.MINUTE);
                timePicker = new TimePickerDialog(view.getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int jam, int menit) {
                        waktu.setText(jam + ":" + menit);
                    }
                },jam,menit,false);
                timePicker.show();
            }
        });
        tanggal = view.findViewById(R.id.tanggal);
        tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int thn = c.get(Calendar.YEAR);
                int bln = c.get(Calendar.MONTH);
                int tgl = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int thn, int bln, int tgl) {
                        tanggal.setText(tgl + "-" + (bln+ 1) + "-" + thn);
                    }
                },thn,bln,tgl);
                datePickerDialog.show();
            }
        });
        btn_total = view.findViewById(R.id.btn_total);
        btn_total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ha = harga.getText().toString();
                String jum = jumlah.getText().toString();
                if(jum == null || jum.isEmpty()){
                    ErrorMessage errorMessage = new ErrorMessage(view,"ISI JUMLAH DULU");
                }else {
                    int hg = Integer.parseInt(ha);
                    int jh = Integer.parseInt(jum);
                    int total = hg * jh;
                    txttotal.setText("Rp."+total);
                }
            }
        });
        btn_order = view.findViewById(R.id.order);
        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = txtnama.getText().toString();
                String ukuran = spin.getSelectedItem().toString();
                String har = harga.getText().toString();
                String jmlh = jumlah.getText().toString();
                String total = txttotal.getText().toString();
                String jam = waktu.getText().toString();
                String tngl = tanggal.getText().toString();
                if (total.isEmpty()||jam.isEmpty()||tngl.isEmpty()){
                    ErrorMessage errorMessage = new ErrorMessage(view,"ISI DULU YANG BENER");
                }else{
                    String order = "Nama : "+nama+
                            "\nUkuran : "+ukuran+
                            "\nHarga : "+har+
                            "\nJumlah : "+jmlh+
                            "\nTotal : "+total+
                            "\nJam : "+jam+
                            "\nTanggal : "+tngl;
                    new SuccessDialogFragment(view,order);
                }

            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmen usus pedas
        return inflater.inflate(R.layout.fragment_pesan_usus_pedas, container, false);

    }

}