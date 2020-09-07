# ToastPersonalizado_Android
En este tema o repositorio, mostrare la manera de usar un toast personalizado, podemos usarlo para apuros asi como facilitarnos la programacion 

![Test Image 4](https://i.ibb.co/xj2tjtw/vlcsnap-00008.png)

## Ejemplo de Activity
Es un ejemplo del activity, donde asignamos 4 botones, un editText, y mostramos cada tipo de toast de manera facil.

```java
package tutorial.toastpersonalizado;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import tutorial.toastpersonalizado.Utilidades.IntentUtil;

public class MainActivity extends AppCompatActivity {
    MyToast myToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creacion de toast personalizado
        myToast=new MyToast(this);
        myToast.setBackgroundColor(Color.parseColor("#000033"),30);
        myToast.setIcon(ContextCompat.getDrawable(this,R.drawable.facebook));
    }
    public void clickToastDefecto(View v)
    {   String text=IntentUtil.getStringEditText(this,R.id.editText);
        MyToast.showToast(this,text);
    }
    public void clickToastInfo(View v) {MyToast.showToastInfo(this,IntentUtil.getStringEditText(this,R.id.editText));}
    public void clickToastLock(View v) {MyToast.showToastLock(this,IntentUtil.getStringEditText(this,R.id.editText));}
    public void clickToastAlert(View v) {MyToast.showToastAlert(this,IntentUtil.getStringEditText(this,R.id.editText));}
    public void clickToastPersonalizado(View v){
        myToast.setText(IntentUtil.getStringEditText(this,R.id.editText));
        myToast.show();
    }
}

```
