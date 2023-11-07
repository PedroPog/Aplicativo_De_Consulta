package com.aula.aplicativodeconsulta.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.aula.aplicativodeconsulta.R;
import com.aula.aplicativodeconsulta.databinding.ActivityMainBinding;
import com.aula.aplicativodeconsulta.databinding.ActivityPrimeiraBinding;

public class PrimeiraActivity extends AppCompatActivity {
    private ActivityPrimeiraBinding binding;

    private NavHostFragment navHostFragment;
    private NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrimeiraBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_primeira);

        initNav();

    }


    private void initNav(){
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavigation,navController);
    }
}