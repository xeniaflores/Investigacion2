package sv.edu.udb.investigacion2dsm.model;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

//EL MODELO DE LA APLICACION OCUPA UN SINGLETON PARA MANEJAR
//UNA UNICA INSTANCIA DE LISTA DE PETICIONES
public class AppModel {
    public static AppModel instance;
    public static Context ctx;
    public RequestQueue requestQueue;

    private AppModel(Context context){
        ctx = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized AppModel getInstance(Context context){
        if(instance == null){
            instance = new AppModel(context);
        }

        return instance;
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }

        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }


}
