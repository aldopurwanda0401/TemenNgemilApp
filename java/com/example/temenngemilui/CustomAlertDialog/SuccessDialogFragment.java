package com.example.temenngemilui.CustomAlertDialog;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.temenngemilui.MainActivity;
import com.example.temenngemilui.R;

public class SuccessDialogFragment extends AppCompatActivity {
    public SuccessDialogFragment(View view, String message){
        AlertDialog.Builder builder =
                new AlertDialog.Builder
                        (view.getContext(), R.style.AlertDialogTheme);
        view = LayoutInflater.from(view.getContext()).inflate(
                R.layout.layout_success_dialog,
                (ConstraintLayout)view.findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);
        ((TextView) view.findViewById(R.id.textTitle))
                .setText("SUCCESS");
        ((TextView) view.findViewById(R.id.textMessage))
                .setText(message);
        ((Button) view.findViewById(R.id.buttonAction))
                .setText("OKE");
        ((ImageView) view.findViewById(R.id.imageIcon))
                .setImageResource(R.drawable.done);
        final AlertDialog alertDialog = builder.create();
        view.findViewById(R.id.buttonAction).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                Intent intent =new Intent(view.getContext(), MainActivity.class);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                startActivity(intent);
            }
        });
        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

}
