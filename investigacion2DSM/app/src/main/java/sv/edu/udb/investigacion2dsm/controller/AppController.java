package sv.edu.udb.investigacion2dsm.controller;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import sv.edu.udb.investigacion2dsm.MainActivity;
import sv.edu.udb.investigacion2dsm.model.AppModel;

public class AppController {
    //EL CONTROLADOR SE CONECTA AL MODELO PARA REALIZAR LA PETICION
    String url = "https://udbdsmapi.000webhostapp.com/api/user";
    Context context;
    String respuesta = "";

    public AppController(Context context) {
        this.context = context;
    }

    public String realizarPeticion(){
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try{
                    respuesta = response.toString();
                    Toast.makeText(context, "Petición realizada", Toast.LENGTH_SHORT).show();

                }catch(Exception e){
                    Toast.makeText(context, "Hubo un error al realizar la petición", Toast.LENGTH_SHORT).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Hubo un error al realizar la petición", Toast.LENGTH_SHORT).show();
            }

        });
        AppModel.getInstance(context).addToRequestQueue(request);

        return respuesta;
    }
}
