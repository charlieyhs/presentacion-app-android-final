package com.example.presentacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InicioPersonal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_personal);

    }

    public void IntentSkills(View view){
        Intent skills = new Intent(InicioPersonal.this, Habilidades.class);
        startActivity(skills);
    }
    public void abrirWhatsapp(View view){
        Intent whatsapp = new Intent(Intent.ACTION_VIEW);
        String uri = "whatsapp://send?phone=573213350998&text=" +R.string.mensajewhatsapp;
        whatsapp.setData(Uri.parse(uri));
        startActivity(whatsapp);
    }
    public void abriLlamada(View view){
        Uri number = Uri.parse("tel:3213350998");
        Intent llamada = new Intent(Intent.ACTION_DIAL, number);
        startActivity(llamada);;
    }
    public void abrirCorreos(View view){
        Intent appsCorreos = new Intent(Intent.ACTION_SEND);

        appsCorreos.putExtra(Intent.EXTRA_EMAIL, new String[] {"programacioncyhs@gmail.com"});
        appsCorreos.putExtra(Intent.EXTRA_SUBJECT, "Aplicación de Presentación Carlos.");
        appsCorreos.putExtra(Intent.EXTRA_TEXT, "Hola Carlos Yecid Hernández Sánchez, estoy utilizando tu aplicación de presentación y me ha parecido...");

        appsCorreos.setType("message/rfc822");
        startActivity( Intent.createChooser(appsCorreos,"Elige un cliente de correo:"));

    }
    public void abrirGitHub(View view){
        Uri uri = Uri.parse("https://www.github.com/charlieyhs");
        Intent github = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(github);
    }

    public void abrirLinkedin(View view){
        Uri uri = Uri.parse("https://www.linkedin.com/in/carlos-yecid-hern%C3%A1ndez-s%C3%A1nchez-8297391b3");
        Intent linkedin = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(linkedin);
    }

}