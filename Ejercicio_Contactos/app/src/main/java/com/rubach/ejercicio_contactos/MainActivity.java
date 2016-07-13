package com.rubach.ejercicio_contactos;

import android.app.DatePickerDialog;
import android.app.Dialog;
//import android.app.DialogFragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.DialogFragment;

import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private String sFechaNacimiento;
    private EditText txtEmail;
    private EditText txtTelefono;
    private EditText txtDescripcion;
    private TextView lblFechaNacimiento;
    private DatePicker datePicker;
    private int year, month, day;
    private Contacto contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Nuevo Contacto");

        //inicializo componentes
        lblFechaNacimiento=(TextView) findViewById(R.id.lblFechaNacimiento);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtEmail= (EditText) findViewById(R.id.txtEmail);
        txtTelefono= (EditText) findViewById(R.id.txtTelefono);
        txtDescripcion= (EditText) findViewById(R.id.txtDescripcion);

        //cargo parametros para editar
        String nombre="";
        String telefono="";
        String email="";
        String fecha="";
        String descripcion="";

        if(getIntent().hasExtra("Nombre")) {
            Bundle parametros = getIntent().getExtras();
            nombre = parametros.getString("Nombre");
            telefono = parametros.getString("Telefono");
            email = parametros.getString("Email");
            fecha = parametros.getString("Fecha");
            descripcion = parametros.getString("Descripcion");
        }
        //inicializo y muestro datos.
        sFechaNacimiento=fecha;
        lblFechaNacimiento.setText(fecha);
        txtNombre.setText(nombre);
        txtEmail.setText(email);
        txtTelefono.setText(telefono);
        txtDescripcion.setText(descripcion);

        //Cargo evento de boton siguiente
        Button btnSiguiente = (Button)findViewById(R.id.btnSiguiente);
        assert btnSiguiente != null;
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 CargoDatos();
            }
        });
    }
    //Metodo para llamar y enviar datos a la otra activity
    public void CargoDatos(){
        contact=new Contacto(txtNombre.getText().toString(),txtTelefono.getText().toString(),txtEmail.getText().toString(),lblFechaNacimiento.getText().toString(),txtDescripcion.getText().toString());
        Intent intent=new Intent(MainActivity.this,Detalle_Activity.class);
        intent.putExtra("Nombre",contact.getNombre());
        intent.putExtra("Telefono",contact.getTelefono());
        intent.putExtra("Email",contact.getEmail());
        intent.putExtra("Fecha",contact.getFechaNacimiento());
        intent.putExtra("Descripcion",contact.getComentario());
        //llamo a la otra actividad
        startActivity(intent);
        //mato esta actividad, no se puede volver con el boton hacia atras.
        finish();
    }

    //Boton que abre la seleccion de fecha, dtpicker.
    public void setFecha(View v){
        //abre el dtpicker para seleccionar una fecha
        DatePickerDialog.OnDateSetListener dpd = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
                //datos seleccionados por el usuario
                int s=monthOfYear+1;
                sFechaNacimiento = dayOfMonth+"/"+s+"/"+year;
                lblFechaNacimiento.setText(sFechaNacimiento);
            }
        };

        //Carga la fecha por default a mostrar
        DatePickerDialog d = new DatePickerDialog(this, dpd, 1980 ,1, 1);
        d.show();
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode==KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}
