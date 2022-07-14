
# INDEX PRODUCTORUM

![173901578-0cc418dd-eb6d-4a4b-96eb-cfa30a012172](https://user-images.githubusercontent.com/33204630/174042636-463f62c2-3e7c-458b-a546-7942ab92538e.png)
<br />

## DESCRIPCION:
>Aplicacion para hacer la lista de compra. Permite listar de productos que se iran guardando en base de datos locales y remotas.Permite controlar los gastos y agregar promociones.
<br />

### Características

1. Autentificarse
2. Crear, modificar, eliminar leer la lista de compra
4. Compartir la lista con otros usuarios y  valorar  la compra
4. Crear promociones de la  compra
5. Animaciones

### TAREAS A HACER
- [X] CREAR UI
- [X] CREAR UML
- [ ] CODIFICAR
- [ ] TESTEAR

<br />

### Colaboradores

| Miembros del equipo|       GITHUB        |  
| -------------      |:-------------:      | 
| Vazguen            | MrtVazguen          |
| Andrés             | Fahrek              |
<br />
<br />

### Herramientas utilizadas
* Firebase
  - Firestore (Database)
  - Autentification
    <br /><br />

### Diagrama UML

## Extension de Gradle
> Instrucciones de configuración:

### Navigation drawer (menu barra lateral)[:link:](https://material.io/components/navigation-drawer)

### Vinculación de vista [:link:](https://developer.android.com/topic/libraries/view-binding?hl=es-419)
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

### Componentes de navegacion [:link:](https://developer.android.google.cn/guide/navigation/navigation-getting-started?hl=es-419)
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

## UI
 
 ![project_structure](https://user-images.githubusercontent.com/33204630/178748963-24b79c67-39bf-417b-944d-a17e55469a42.png)

## Firestore database Structure
 
![db_structure](https://user-images.githubusercontent.com/33204630/178019529-00fbafcc-d526-48bd-884d-9edb30a0d2bd.png)

## Estructura API Rest



### Extras
([Drive link ](https://docs.google.com/document/d/1r5ElcFDWT98yS-NT08viIMSQooUFfycH5JtQUsLnOFA/edit))
<br />

## Licencia
<a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a><br />Este proyecto tiene una licencia <a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/">Creative Commons Attribution-ShareAlike 4.0 International License</a>.
