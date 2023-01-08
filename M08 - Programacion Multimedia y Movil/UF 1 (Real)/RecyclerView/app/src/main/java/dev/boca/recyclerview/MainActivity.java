package dev.boca.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewUser;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewUser = (RecyclerView) findViewById(R.id.recyclerViewUser);

        recyclerViewUser.setHasFixedSize(true);

        recyclerViewUser.setLayoutManager(new LinearLayoutManager(this));

        adapter = new UserAdapter(getData());
    }

    public List<UserModel> getData(){
        List<UserModel> userModels = new ArrayList<>();
        userModels.add(new UserModel("Gustavo"));
        userModels.add(new UserModel("Daniel"));
        userModels.add(new UserModel("Cecilia"));
        userModels.add(new UserModel("Diego"));
        userModels.add(new UserModel("Carlos"));
        userModels.add(new UserModel("Juan"));

        for(int i = 1; i < 10; i++) {
            userModels.add(new UserModel("Name " + i));
        }

        return userModels;
    }
}