package sv.edu.udb.investigacion2dsm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import sv.edu.udb.investigacion2dsm.controller.AppController;
import sv.edu.udb.investigacion2dsm.model.AppModel;

public class MainActivity extends AppCompatActivity {
    //ARQUITECTURA USADA: CLEAN
    //PARA ESTA APLICACIÓN, SE HA CREADO UN CONTROLADOR Y UN MODELO
    //CON EL FIN DE SEPARAR LAS DIFERENTES NIVELES DE FUNCIONALIDAD DE LA APLICACIÓN

    //
    RequestQueue requestQueue;
    TextView txtResultado;
    AppController controller = new AppController(MainActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResultado = (TextView) findViewById(R.id.txtResultado);
        requestQueue = Volley.newRequestQueue(this);

    }

    public void realizarPeticion(View v){
        txtResultado.setText("");

        String resultado = controller.realizarPeticion();
        txtResultado.setText(resultado);

    }

}