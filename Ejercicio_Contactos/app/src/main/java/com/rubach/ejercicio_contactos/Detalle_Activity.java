package com.rubach.ejercicio_contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Detalle_Activity extends AppCompatActivity {
    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvFecha;
    private TextView tvDescripcion;
    private Contacto contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        this.setTitle("Detalle de  Contacto");
        //Leo los datos a mostrar
        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("Nombre");
        String telefono = parametros.getString("Telefono");
        String email = parametros.getString("Email");
        String fecha = parametros.getString("Fecha");
        String descripcion = parametros.getString("Descripcion");

        //Creo objeto contacto
        contact=new Contacto(nombre,telefono,email,fecha,descripcion);

        //Inicializo y Muestro los campos
        tvNombre = (TextView) findViewById(R.id.lblNombre);
        tvTelefono = (TextView) findViewById(R.id.lblTelefono);
        tvEmail = (TextView) findViewById(R.id.lblEmail);
        tvFecha = (TextView) findViewById(R.id.lblFecha);
        tvDescripcion = (TextView) findViewById(R.id.lblDescripcion);

        tvNombre.setText(nombre);
        tvEmail.setText(email);
        tvTelefono.setText(telefono);
        tvFecha.setText(fecha);
        tvDescripcion.setText(descripcion);

        // Referencia Botón
        Button botonAceptar = (Button) findViewById(R.id.btnEditar);
        assert botonAceptar != null;
        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cargo datos y los envio a la activkty anterior.
                DevuelvoParametros();
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode==KeyEvent.KEYCODE_BACK){
            DevuelvoParametros();
        }
        return super.onKeyDown(keyCode, event);
    }
    //metodo generico para llamar a cargar parametros.
    private void DevuelvoParametros(){
        Intent intent = new Intent(this, MainActivity.class  );
        //vuelvo a crear la actividad principal
        intent.putExtra("Nombre",contact.getNombre());
        intent.putExtra("Telefono",contact.getTelefono());
        intent.putExtra("Email",contact.getEmail());
        intent.putExtra("Fecha",contact.getFechaNacimiento());
        intent.putExtra("Descripcion",contact.getComentario());
        startActivity(intent);
        finish();
    }
}
