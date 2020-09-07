package tutorial.toastpersonalizado.Utilidades;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by pc 9 on 02/09/2020.
 */
public class IntentUtil {

    //ir a una url
    public static void irUrl(Context c, String url)
    {   Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        c.startActivity(intent,null);
    }
    //Mostrar toast
    public static void showToast(Context c,String message)
    {Toast.makeText(c,message,Toast.LENGTH_SHORT).show();}
    //Mostrar toast personalizado
    public static void showToast(Context c,String message,int text_color,int background_color)
    {
        Toast toast = Toast.makeText(c,message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 50, 50);
        toast.getView().setPadding(10, 10, 10, 10);
        toast.getView().setBackgroundColor(background_color);
        TextView text = (TextView) toast.getView().findViewById(android.R.id.message);
        text.setTextColor(text_color);
        text.setTextSize(14);
        toast.show();
    }
    //Mensaje de alerta
    public static void showToastAlert(Context c,String message)
    {   Toast toast = Toast.makeText(c,message,Toast.LENGTH_SHORT);
        //ImageView cc = new ImageView(c);
        //cc.setImageResource(android.R.drawable.ic_dialog_alert);
        //toast.setView(cc);
        Button b=new Button(c);
        b.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(c,android.R.drawable.ic_dialog_alert),null,null,null);
        b.setText(message);
        b.setPadding(15,15,15,15);
        b.setTextColor(Color.BLACK);
        b.setBackground(getShape(Color.parseColor("#bab247"),Color.parseColor("#dad247"),Color.parseColor("#cac247"),50,GradientDrawable.LINEAR_GRADIENT));
        //toast.getView().setBackgroundColor(Color.YELLOW);
        //TextView text = (TextView) toast.getView().findViewById(android.R.drawable.ic_dialog_alert);
        //text.setTextColor(Color.BLACK);
        toast.setView(b);   //asigno el boton al toast
        toast.show();
        /*Drawable resource
        context.getResources().getDrawable();//deprecated
         ContextCompat.getDrawable(context,id)
        Context
        */
    }
    public static void showToastInfo(Context c,String message)
    {
        Toast toast = Toast.makeText(c,message,Toast.LENGTH_SHORT);
        Button b=new Button(c);
        b.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(c,android.R.drawable.ic_dialog_info),null,null,null);
        b.setText(message);
        b.setPadding(15,15,15,15);
        b.setTextColor(Color.BLACK);
        b.setBackground(getShape(Color.parseColor("#5188CF"),Color.parseColor("#69D5F5"),Color.parseColor("#5188CF"),45,GradientDrawable.LINEAR_GRADIENT));
        toast.setView(b);   //asigno el boton al toast
        toast.show();
    }
    public static void showToastLock(Context c,String message)
    {
        Toast toast = Toast.makeText(c,message,Toast.LENGTH_SHORT);
        Button b=new Button(c);
        b.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(c,android.R.drawable.ic_lock_idle_lock),null,null,null);
        b.setText(message);
        b.setPadding(15,15,15,15);
        b.setTextColor(Color.parseColor("#DDDDDD"));
        b.setBackground(getShape(Color.parseColor("#493E3F"),Color.parseColor("#4B2831"),Color.parseColor("#6C444E"),45,GradientDrawable.LINEAR_GRADIENT));
        toast.setView(b);   //asigno el boton al toast
        toast.show();
    }

    //creo drawable shappe figura
    private static Drawable getShape(int startcolor, int centercolor, int endcolor, int radius_pd, int gradienType)
    {
        GradientDrawable gradientDrawable=new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP,new int[]{startcolor,centercolor,endcolor});
        gradientDrawable.setGradientType(gradienType);//GradientDrawable.LINEAR_GRADIENT
        gradientDrawable.setCornerRadii(getRandomFloatArray(radius_pd));
        //gradientDrawable.setGradientCenter(0.0f,0.4f);
        return gradientDrawable;
    }
    //el randomfloat es el radius de esquinas
    private static float[]getRandomFloatArray(int radius){
        Random rnd=new Random();
        float[]buffer=new float[8];
        for(int i=0;i<buffer.length;i++)
        {
            buffer[i]=radius;
        }
        return buffer;
    }
    private static float[]getRandomFloatArray(){
        Random rnd=new Random();
        float[]buffer=new float[8];
        for(int i=0;i<buffer.length;i++)
        {
            buffer[i]=rnd.nextInt(45);
        }
        return buffer;
    }

    public static String getStringEditText(Activity act,int R_id)
    {
        return ((EditText)act.findViewById(R_id)).getText().toString();
    }
    public static boolean isPotrait(Context context)
    {   final int rotation = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getOrientation();
        switch (rotation) {
            case Surface.ROTATION_0:
                return true;
            case Surface.ROTATION_90:
                return false;
            case Surface.ROTATION_180:
                return true;
            default:
                return false;
        }

    }
    //Muestra una vista diferente segun Orientacion del dispositivo
    public static void setContentViewRotation(Activity act,int R_layout_vertical,int R_layout_horizontal)
    {   if(isPotrait(act.getApplicationContext()))act.setContentView(R_layout_vertical);
        else act.setContentView(R_layout_horizontal);
    }
    //Iniciar activity
    public static void startNewAtivity(Activity actitivty,Class <?> newActivityclass)
    {
        try {
            Intent intent = new Intent(actitivty, newActivityclass);
            actitivty.startActivity(intent);
        }catch (Exception exception)
        {   exception.printStackTrace();
            showToastAlert(actitivty.getApplicationContext(),"Ocurrio un error al abrir la actividad.");
        }
            /*Bundle bundle=new Bundle();
        bundle.putString("isoruta",isoread);
        intent.putExtras(bundle);
        context.startActivity(intent);*/
    }

}
