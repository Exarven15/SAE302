package com.example.applisae;
import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;
public interface ApiService {
    @GET("/api/trame") // Remplace avec le chemin de ton API
    Call<List<Item>> getData();
}
