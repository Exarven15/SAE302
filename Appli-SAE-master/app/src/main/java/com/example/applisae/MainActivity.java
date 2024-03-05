package com.example.applisae;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.util.Log;
import android.widget.ListView;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Button buttonCaptures;

    // TAG utilisé pour les logs, généralement défini comme le nom de la classe
    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCaptures = findViewById(R.id.Capture);

        // Obtient une instance de l'interface ApiService à partir de GetAPI
        ApiService apiService = GetAPI.getApiService();

        // Effectue la requête API pour obtenir une liste d'items
        Call<List<Item>> call = apiService.getData();
        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.isSuccessful()) {
                    // Traitement des données réussi
                    List<Item> data = response.body();
                    Log.d(TAG, "Data received: " + data.toString());
                    if (data.size() > 4){ //Vérifie si le nombre de données est supérieur à 4
                        Collections.reverse(data);
                        List<Item> limitdata = data.subList(0, Math.min(4, data.size())) ;// Si oui on envoie que les 4 dernières
                        displayDataInListView(limitdata);
                    }
                    else {
                        displayDataInListView(data);
                    }
                } else {
                    // Traitement des erreurs (code d'erreur HTTP non 2xx)
                    Log.e(TAG, "Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                // Gestion des erreurs lors de la requête (connexion perdue, timeout, etc.)
                Log.e(TAG, "Error: " + t.getMessage());
            }
        });


        buttonCaptures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(com.example.applisae.MainActivity.this, MainActivity2.class);

                startActivity(i);
            }
        });


    }

    private void displayDataInListView(List<Item> dataList) {
        // Récupère la référence de la ListView dans le layout
        ListView listView = findViewById(R.id.capturerecente);

        // Crée un adaptateur personnalisé pour lier les données à la ListView
        ArrayAdapter<Item> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);

        // Lie l'adaptateur à la ListView
        listView.setAdapter(adapter);
        // Set item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item
                Item selectedItem = (Item) parent.getItemAtPosition(position);

                // Create and show the dialog with the details of the selected item
                ItemDialog itemDialog = new ItemDialog(MainActivity.this, selectedItem);
                itemDialog.show();
            }
        });
    }



    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }
}

