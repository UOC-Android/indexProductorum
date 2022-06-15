# Index productorum  
<br />
 
![figure description](https://user-images.githubusercontent.com/33204630/173901578-0cc418dd-eb6d-4a4b-96eb-cfa30a012172.png) 
<br />

DESCRIPCION
: Aplicaciones para hacer la lista de compra desde Android 
<br />




### Extenciones de Grandle

>Vinculación de vista en build.gradle(:app)

```
 viewBinding {
        enabled = true
    }
```
>Componente Navigation 

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



### TAREAS A HACER 
- [ ] CREAR UI
- [ ] CREAR UML
- [ ] PROGRAMAR

<br />




| Miembros del equipo|       GITHUB        |  
| -------------      |:-------------:      | 
| Vazguen            | MrtVazguen          |
| Andrés             | Fahrek              |

### Extras
([Drive link ](https://docs.google.com/document/d/1r5ElcFDWT98yS-NT08viIMSQooUFfycH5JtQUsLnOFA/edit))
<br />

## Licencia
<a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a><br />Este proyecto tiene una licencia <a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/">Creative Commons Attribution-ShareAlike 4.0 International License</a>.
