package com.example.mascotasapplication.Menu;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.mascotasapplication.R;

import org.jetbrains.annotations.NotNull;


public class Dialogo extends AppCompatDialogFragment {
    private EditText email;
    private EditText contraseña;
    Button ingCorreo;
    private DialogoListener listener;
    private String Email,Contraseña;






    @NotNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.ingresarcorreo, null);
        ingCorreo = (Button) view.findViewById(R.id.IngCorreo);
        builder.setView(view).setTitle("Login")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String Email = email.getText().toString();
                        String Contraseña = contraseña.getText().toString();
                        listener.applyTexts(Email, Contraseña);

                    }
                });


        email = view.findViewById(R.id.email);
        contraseña = view.findViewById(R.id.contraseña);

        return builder.create();
    }




    public void applyTexts(String Email, String Contraseña) {
       this.Email = Email;
        this.Contraseña=Contraseña;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (DialogoListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }

    public interface DialogoListener {
        void applyTexts(String Email, String Contraseña);
    }
}