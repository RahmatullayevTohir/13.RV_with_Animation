package com.example.a13rv_with_animation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.a13rv_with_animation.adapter.CustomAdapter;
import com.example.a13rv_with_animation.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        List<User> users = UserList();
        refrehaAdapter(users);
    }

    private List<User> UserList() {
        List<User> user = new ArrayList<>();
        for (int i=1; i<31; i++){
            user.add(new User(i+" A",i+" B"));
        }
        return  user;
    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));

        LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_animation_fall);
        recyclerView.setLayoutAnimation(animationController);
    }

    public void refrehaAdapter(List<User> users){
        CustomAdapter adapter = new CustomAdapter(context,users);
        recyclerView.setAdapter(adapter);
    }
}