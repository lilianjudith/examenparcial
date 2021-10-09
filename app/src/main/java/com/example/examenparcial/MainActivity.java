package com.example.examenparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener {

        private Button btnSegundaActivity;
        private Button btnEnvioDatos;
        private Button btnIrPaginaWeb;
        private Button btnIrGoogleMaps;
        private Button btnIrMarcadoTelefonico;
        private Button btnLlamar;

        private Intent intent;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            initUI();
            initOnclick();
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnSegundaActivity:
                    intent = new Intent(getApplicationContext(), SegundaActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnEnvioDatos:
                    intent = new Intent(getApplicationContext(), SegundaActivity.class);
                    intent.putExtra("valor1", "Hi");
                    intent.putExtra("valor2", "Hoy examen");
                    intent.putExtra("valor3", 15);
                    startActivity(intent);
                    break;
                case R.id.btnIrPaginaWeb:
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www.Youtube.com"));
                    startActivity(intent);
                    break;
                case R.id.btnIrGoogleMaps:
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:-538538538, -45245244"));
                    startActivity(intent);
                    break;
                case R.id.btnIrMarcadoTelefonico:
                    intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:954567120"));
                    startActivity(intent);
                    break;
                case R.id.btnLlamar:
                    llamar();
                    break;
                case R.id.btnCompartirTexto:
                    intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    //intent.setPackage("com.facebook.katana");
                    //intent.setPackage("com.whatsapp");
                    intent.putExtra(Intent.EXTRA_TEXT, "Hola mundo");
                    startActivity(intent);
                    break;

            }
        }

        public void initUI() {
            btnSegundaActivity = (Button) findViewById(R.id.btnSegundaActivity);
            btnEnvioDatos = (Button) findViewById(R.id.btnEnvioDatos);
            btnIrPaginaWeb = (Button) findViewById(R.id.btnIrPaginaWeb);
            btnIrGoogleMaps = (Button) findViewById(R.id.btnIrGoogleMaps);
            btnIrMarcadoTelefonico = (Button) findViewById(R.id.btnIrMarcadoTelefonico);
            btnLlamar = (Button) findViewById(R.id.btnLlamar);

        }

        public void initOnclick() {
            btnSegundaActivity.setOnClickListener(this);
            btnEnvioDatos.setOnClickListener(this);
            btnIrPaginaWeb.setOnClickListener(this);
            btnIrGoogleMaps.setOnClickListener(this);
            btnIrMarcadoTelefonico.setOnClickListener(this);
            btnLlamar.setOnClickListener(this);
            btnCompartirTexto.setOnClickListener(this);
            btnCompartirImagen.setOnClickListener(this);
        }

        public void llamar() {
            int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 123);
            } else {
                intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:77752810"));
                startActivity(intent);
            }
        }


            }


