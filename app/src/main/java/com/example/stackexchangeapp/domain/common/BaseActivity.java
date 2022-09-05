package com.example.stackexchangeapp.domain.common;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stackexchangeapp.domain.di.CompositionRoot;
import com.example.stackexchangeapp.domain.di.ControllerCompositionRoot;
import com.example.stackexchangeapp.domain.di.CustomApp;

public class BaseActivity extends AppCompatActivity {
    ControllerCompositionRoot controllerCompositionRoot;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomApp customApp = (CustomApp) getApplication();
        controllerCompositionRoot = new ControllerCompositionRoot(customApp.getCompositionRoot(), this);
    }

    protected ControllerCompositionRoot getCompositionRoot() {
        return controllerCompositionRoot;
    }
}
