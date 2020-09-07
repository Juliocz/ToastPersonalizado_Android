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

## Metodos Estaticos
Muestra de los Metodos estaticos.
```java
MyToast.showToast(this,"Este es un toast de prueba");
```
![Test Image 4](https://i.ibb.co/YkPNtpR/3toast.png)
```java
MyToast.showToastAlert(this,"Este es un toast de prueba");
```
![Test Image 4](https://i.ibb.co/K69TWL8/2toast.png)
```java
MyToast.showToastInfo(this,"Este es un toast de prueba");
```
![Test Image 4](https://i.ibb.co/HNtYDVK/4toast.png)
```java
MyToast.showToastLock(this,"Este es un toast de prueba");
```
![Test Image 4](https://i.ibb.co/WG2S6LW/1toast.png)
## Instanciando la clase y personalizando nuestro objeto MyToast
La clase tambien nos permite personalizar, se pueden modificar metodos, pueden aportar, aun falta pero creo que es suficiente ya sino usar el por defecto para personalizara fondo.
```java
//Creacion de toast personalizado
        MyToast myToast=new MyToast(this);
        myToast.setBackgroundColor(Color.parseColor("#000033"),30);
        myToast.setIcon(ContextCompat.getDrawable(this,R.drawable.facebook));
        myToast.setText(IntentUtil.getStringEditText(this,R.id.editText));
        myToast.show();
```
![Test Image 4](https://i.ibb.co/fnMxgTS/6toast.png)
Algunas anotaciones, por defecto el fondo es negro y texto blanco.
el time, se usa el Toast.Short y el mismo, que en realidad es un entero 1 o 0
## Utilidades
Lo pueden llegar a usar para mostrar excepciones, con un exception.getMessage();
Pueden usarlo para personalizar su app y mostrar una caja de mensaje acorde a su app.
![Test Image 4](https://i.ibb.co/cwtRPns/5toast.png)

## Info
[VideoTutorial en youtube: ](https://youtu.be/ZjHp206U8AU)
