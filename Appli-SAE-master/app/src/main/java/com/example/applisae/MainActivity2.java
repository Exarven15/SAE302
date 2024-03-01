package com.example.applisae;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity2 extends AppCompatActivity {

    private Button buttonHome;
    private Spinner filterSpinner;
    private ArrayAdapter<Item> adapter;
    private List<Item> originalData;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonHome = findViewById(R.id.home);
        filterSpinner = findViewById(R.id.filter_spinner);

        // Obtient une instance de l'interface ApiService à partir de GetAPI
        ApiService apiService = GetAPI.getApiService();

        // Effectue la requête API pour obtenir une liste d'items
        Call<List<Item>> call = apiService.getData();
        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.isSuccessful()) {
                    // Traitement des données réussi
                    originalData = response.body();
                    Log.d(TAG, "Data received: " + originalData.toString());
                    displayDataInListView(originalData);
                    setupSpinner();
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
    }

    private void setupSpinner() {
        // Créez un ArrayAdapter à partir des options de filtres et liez-le au Spinner
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.filter_op, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterSpinner.setAdapter(spinnerAdapter);

        // Ajoutez un écouteur d'événements pour le Spinner
        filterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Filter the data based on the selected option
                String selectedItem = (String) parent.getItemAtPosition(position);
                List<Item> filteredData = filterData(selectedItem);
                adapter.clear();
                adapter.addAll(filteredData);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    private List<Item> filterData(String filterOption) {
        // Filter the original data based on the selected option
        List<Item> filteredData = new ArrayList<>();
        for (Item item : originalData) {
            // Modify this condition as per your filtering requirement
            if (item.getType().equals(filterOption)) {
                filteredData.add(item);
            }
        }
        return filteredData;
    }

    private void displayDataInListView(List<Item> dataList) {
        ListView listView = findViewById(R.id.capturerecente);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
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