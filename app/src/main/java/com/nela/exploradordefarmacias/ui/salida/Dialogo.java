package com.nela.exploradordefarmacias.ui.salida;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.nela.exploradordefarmacias.MainActivity;
import com.nela.exploradordefarmacias.ui.farmacias.FarmaciasFragment;

public class Dialogo {
    /// En esta clase me plantie si hacer toda esta logica desde Dialogo estaba bien o si
    /// era mejor hacerla desde el viewmodel(por el intent) pero como el TP5 lo hicimos de
    /// esta forma, lo hice de la misma manera.
    public static void mostrarDialogo(Context context){
        new AlertDialog.Builder(context)
                .setMessage("¿Desea salir del explorador?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ///Agregué esto para que si se elegia la opcion "No" no quedara en una pantalla
                        /// vacia.
                        Intent intent = new Intent(context, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                })
                .show();
    }
}
