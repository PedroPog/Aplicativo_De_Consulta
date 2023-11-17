package com.aula.aplicativodeconsulta.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.aula.aplicativodeconsulta.R;
import com.aula.aplicativodeconsulta.databinding.ActivityMainBinding;
import com.aula.aplicativodeconsulta.databinding.ActivityPrimeiraBinding;
import com.aula.aplicativodeconsulta.recycler.RecyclerViewNomes;

import java.util.ArrayList;

public class PrimeiraActivity extends AppCompatActivity {
    private ActivityPrimeiraBinding binding;

    private NavHostFragment navHostFragment;
    private NavController navController;
    RecyclerViewNomes adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrimeiraBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initNav();

    }

    private void initNav(){
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavigation,navController);
    }
}