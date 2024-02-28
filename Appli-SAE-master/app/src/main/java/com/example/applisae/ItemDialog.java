package com.example.applisae;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


public class ItemDialog extends Dialog {

    LinearLayout linearLayout;
    ListView listView;
    Item selectedItem;
    public ItemDialog(Context context, LinearLayout linearLayout, ListView listView, Item selectedItem) {
        super(context);
        this.linearLayout = linearLayout;
        this.listView = listView;
        this.selectedItem = selectedItem;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Utilise le layout défini dans activity_main.xml
        setContentView(R.layout.activity_main);

        // Obtient les références aux éléments du layout

        TextView txtItemDetails = findViewById(R.id.ItemDetail);
        Button btnCloseDialog = findViewById(R.id.btnCloseDialog);
        linearLayout.setVisibility(View.VISIBLE);

        txtItemDetails.setText(selectedItem.toString());

        // Ajoute des actions si nécessaire
        btnCloseDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss(); // Ferme le dialog lorsqu'on clique sur le bouton
                linearLayout.setVisibility(View.INVISIBLE);
                listView.setVisibility(View.VISIBLE);
            }
        });
    }
}