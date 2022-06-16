<!--#   -->
# INDEX PRODUCTORUM
<br />
 
![figure description](https://user-images.githubusercontent.com/33204630/173901578-0cc418dd-eb6d-4a4b-96eb-cfa30a012172.png) 
<br />

## DESCRIPCION: Aplicacione para hacer la lista de compra 

### Características

1. Autentificarse
2. Crear, modificar, eliminar leer la lista de compra
3. Crear promociones de la  compra
4. En caso de la lista de compra compartida , valorar y aprobar la compra
5. Animaciones


### Herramientas utilizadas
* SqLite (local)
* Firestore (remoto)



## Extenciones de Grandle
### Vinculación de vista [:link:](https://developer.android.com/topic/libraries/view-binding?hl=es-419)
#### Instrucciones de configuración
1. Vinculación de vista en build.gradle(:app)

```
 viewBinding {
        enabled = true
    }
```
2. Cómo usar la vinculación de vista en actividades
```
  binding = ResultProfileBinding.inflate(getLayoutInflater());
  View view = binding.getRoot();
  setContentView(view);

```


###  Componentes de navegacion [:link:](https://developer.android.google.cn/guide/navigation/navigation-getting-started?hl=es-419)
```
    def nav_version = "2.4.2"

    // Java language implementation
    implementation "androidx.navigation:navigation-fragment:$nav_version"
    implementation "androidx.navigation:navigation-ui:$nav_version"

    // Kotlin
    implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
    implementation "androidx.navigation:navigation-ui-ktx:$nav_version"

    // Feature module Support
    implementation "androidx.navigation:navigation-dynamic-features-fragment:$nav_version"

    // Testing Navigation
    androidTestImplementation "androidx.navigation:navigation-testing:$nav_version"

    //Save args
    implementation "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"

    // Jetpack Compose Integration
    //implementation "androidx.navigation:navigation-compose:$nav_version"

```



> Cómo agregar un NavHostFragment a través de XML
``` 
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <androidx.appcompat.widget.Toolbar
        .../>

    <androidx.fragment.app.FragmentContainerView
        android:id="@+id/nav_host_fragment"
        android:name="androidx.navigation.fragment.NavHostFragment"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"

        app:defaultNavHost="true"
        app:navGraph="@navigation/nav_graph" />

    <com.google.android.material.bottomnavigation.BottomNavigationView
        .../>

</androidx.constraintlayout.widget.ConstraintLayout>
```


### TAREAS A HACER 
- [X] CREAR UI
- [ ] CREAR UML
- [ ] CODIFICAR
- [ ] TESTEAR

<br />
<br />

### Colaboradores

| Miembros del equipo|       GITHUB        |  
| -------------      |:-------------:      | 
| Vazguen            | MrtVazguen          |
| Andrés             | Fahrek              |
<br />
<br />

 

### Extras
([Drive link ](https://docs.google.com/document/d/1r5ElcFDWT98yS-NT08viIMSQooUFfycH5JtQUsLnOFA/edit))
<br />

## Licencia
<a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a><br />Este proyecto tiene una licencia <a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/">Creative Commons Attribution-ShareAlike 4.0 International License</a>.
