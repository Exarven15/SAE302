package com.example.applisae;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {


    private Button buttonHome;
    private Button buttonFavoris;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonHome = findViewById(R.id.home);
        buttonFavoris = findViewById(R.id.Favoris);

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
                    // Fais quelque chose avec les données récupérées
                    Log.d(TAG, "Data received: " + data.toString());
                    displayDataInListView(data);
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


        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(com.example.applisae.MainActivity2.this, MainActivity.class);

                startActivity(i);
            }
        });
        buttonFavoris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(com.example.applisae.MainActivity2.this, MainActivity3.class);

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item
                Item selectedItem = (Item) parent.getItemAtPosition(position);

                // Create and show the dialog with the details of the selected item
                ItemDialog itemDialog = new ItemDialog(MainActivity2.this, selectedItem);
                itemDialog.show();
            }
        });
    }
}