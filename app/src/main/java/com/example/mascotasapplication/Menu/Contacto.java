package com.example.mascotasapplication.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mascotasapplication.JavaMail.GMailSender;
import com.example.mascotasapplication.R;

import java.security.Provider;


public class Contacto extends AppCompatActivity implements Dialogo.DialogoListener{
    EditText destinatario;
    EditText asunto;
    EditText mensaje;
    Button enviar;

    Button button;
    String Email;
    String Contraseña;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionbar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setTitle("Contacto");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        destinatario     = (EditText) findViewById(R.id.Correo);
        asunto           = (EditText) findViewById(R.id.Asunto);
        mensaje          = (EditText) findViewById(R.id.Mensaje);
        enviar           = (Button) findViewById(R.id.Enviar);
        button           = (Button) findViewById(R.id.IngCorreo);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                String destino = destinatario.getText().toString();
                String asun = asunto.getText().toString();
                String mensa = mensaje.getText().toString();
                sendEmail(destino, asun, mensa);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }
    public void openDialog() {
        Dialogo exampleDialog = new Dialogo();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    private void sendEmail(final String destino, final String asun, final String mensa) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    GMailSender envio = new GMailSender(Email, Contraseña);
                    envio.sendMail(asun, "<b>" + mensa + "</b>",Email, destino);
                    makeAlert();

                } catch (Exception e) {
                    Log.e("Enviado Mensaje...", e.getMessage(), e);
                }
            }

        }).start();
    }

    private void makeAlert() {
        this.runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(getBaseContext(), "Mensaje Enviado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void applyTexts(String Email, String Contraseña) {
        
    }


    public class JSSEProvider extends Provider {

        protected JSSEProvider(String name, double version, String info) {
            super(name, version, info);
        }
    }
}
