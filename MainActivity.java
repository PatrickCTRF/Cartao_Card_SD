package com.example.patrick.testeusacartaosd;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View view) {

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 123);

        startActivityForResult(new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE), 1234);


        File[] files = this.getExternalFilesDirs(null);

        for(File i : files){
            Log.v("cardSD diretorios", "" + i.getParent());
        }



        //String secStore = System.getenv("SECONDARY_STORAGE");
//        String secStore = "/storage/extSdCarcd";
        String secStore = "/storage/3461-3731";
        //secStore = System.getenv("EXTERNAL_SDCARD_STORAGE");

        Log.v("cardSD string", "" + secStore);
        File f_secs = new File("" + secStore + "/Eixo_X_Tempo.txt");
        File fw_secs = new File("" + secStore + "/EixoTeste.txt");

        Log.v("cardSD caminho arquivo","" + f_secs.getParent());

        try{

            BufferedReader leSD = new BufferedReader(new FileReader(f_secs));
            Log.v("cardSD conteudo leitura", "" + leSD.readLine());
            leSD.close();



            fw_secs.createNewFile(); Toast.makeText(this, " Criou o arquivo", LENGTH_LONG).show();
            FileWriter escritor = new FileWriter(fw_secs, false);//apaga o buffer de dados e o fecha.
            escritor.write("");
            escritor.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

