package com.example.oreo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener{
    DatabaseReference mRootReference;
    Button mButtonSubirDatosFirebase;
    EditText
            mEditTextDatoCodigoViaje,mEditTextDatoDestino,mEditTextDatoNumeropersonas,mEditTextDatoTipobus,mEditTextDatoDescripcion,mEditTextDatoPrecioviaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonSubirDatosFirebase = findViewById(R.id.btnSubirDatos);
        mButtonSubirDatosFirebase.setOnClickListener(this);
        mEditTextDatoCodigoViaje = findViewById(R.id.etCodviaje);
        mEditTextDatoDestino = findViewById(R.id.etDestino);
        mEditTextDatoNumeropersonas = findViewById(R.id.etNopersonas);
        mEditTextDatoTipobus = findViewById(R.id.etTipobus);
        mEditTextDatoDescripcion = findViewById(R.id.etDescripcionv);
        mEditTextDatoPrecioviaje = findViewById(R.id.etPrecioviaje);
        mRootReference = FirebaseDatabase.getInstance().getReference();
        solicitarDatosFirebase(); }
    private void solicitarDatosFirebase() {
        mRootReference.child("Usuario").addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {
                for(final DataSnapshot snapshot : dataSnapshot.getChildren()){
                    mRootReference.child("Usuario").child(snapshot.getKey()).addValueEventListener(new ValueEventListener() { @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        User user = snapshot.getValue(User.class);
                        String codviaje = user.getCodviaje();
                        String destino = user.getDestino();
                        String nopersonas = user.getNopersonas();
                        String tipobus = user.getTipobus();
                        String descripcionv = user.getDescripcionv();
                        String precioviaje = user.getPrecioviaje();
                        
                        
                        Log.e("Codigo Viaje:",""+codviaje);
                        Log.e("Destino:",""+destino);
                        Log.e("Numero Personas:",""+nopersonas);
                        Log.e("Tipo Bus:",""+tipobus);
                        Log.e("Descripcion Viaje:",""+descripcionv);
                        Log.e("Precio del viaje:",""+precioviaje);
                        Log.e("Datos:",""+snapshot.getValue());
                    }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                        }
                    });
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
    private void cargarDatosFirebase(String nombre, String apellido, int telefono,
                                     String direccion) {
        Map<String, Object> datosUsuario = new HashMap<>();
        datosUsuario.put("nombre", nombre); datosUsuario.put("apellido",
                apellido); datosUsuario.put("telefono", telefono);
        datosUsuario.put("direccion", direccion);
        mRootReference.child("Usuario").push().setValue(datosUsuario);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case
                    R.id.btnSubirDatos:
                String Codviaje = mEditTextDatoCodigoViaje.getText().toString();
                String Destino =
                        mEditTextDatoDestino.getText().toString();
                String Nopersonas =
                        mEditTextDatoNumeropersonas.getText().toString();
                String Tipobus =
                        mEditTextDatoTipobus.getText().toString();
                String Precioviaje =
                        mEditTextDatoPrecioviaje.getText().toString();
                
                String Descripcionv =
                        mEditTextDatoDescripcion.getText().toString();
                cargarDatosFirebase(Codviaje,Destino,Nopersonas,Tipobus,Precioviaje,Descripcionv);
                break;
        }
    }

    private void cargarDatosFirebase(String codviaje, String destino, String nopersonas, String tipobus, String precioviaje, String descripcionv) {
    }
}
