package com.dev.mrvazguen.indexproductorum.ui.fragment.articulo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.core.content.ContextCompat;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.mrvazguen.indexproductorum.R;
import com.dev.mrvazguen.indexproductorum.data.model.Producto;
import com.dev.mrvazguen.indexproductorum.data.model.Usuari;
import com.dev.mrvazguen.indexproductorum.data.repository.firestore.manager.ArticuloManagerDB;
import com.dev.mrvazguen.indexproductorum.data.repository.iTaskNotification;
import com.dev.mrvazguen.indexproductorum.ui.fragment.articulo.adapter.ListaArticuloAdapter;
import com.dev.mrvazguen.indexproductorum.ui.fragment.articulo.adapter.SharedUserAdapter;
import com.dev.mrvazguen.indexproductorum.utils.GlobarArgs;
import com.dev.mrvazguen.indexproductorum.utils.RetrofitCli;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class ListaArticuloFragment extends Fragment
{
    ArrayList<Producto> articulos;
    ArrayList<Usuari> usuaris;
    NavigationView navigationView;

    private RecyclerView recyclerViewArticles;
    private RecyclerView recyclerViewSharedUser;
    private ListaArticuloAdapter adapterArticles;
    private SharedUserAdapter adapterSharedUser;
    public iTaskNotification<Producto> iTaskNotification;

    @NonNull
    ViewDataBinding binding;
    LinearLayoutManager linearLayoutManagerUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_lista_articulos, container, false);

        ///region dades Article
        ArticuloManagerDB articuloManagerDB = new ArticuloManagerDB("Test/prueba");
        View viewListaArticle = inflater.inflate(R.layout.fragment_lista_articulos, container, false);

        articulos = new ArrayList<>();
        usuaris = new ArrayList<>();
        usuaris.add(new Usuari("test@gmail.com", "Fulanito"));
        usuaris.add(new Usuari("hola@gmail.com", "Menganito"));

        //Cargar los datos de FirestoreArticulo
        iTaskNotification = new iTaskNotification<Producto>()
        {
            @Override
            public void OnSucces(List<Producto> lista) {
                articulos = (ArrayList<Producto>) lista;
                if (articulos.size() == 0)
                    articulos.add(new Producto("EMPTY_FIELD"));
                adapterArticles = new ListaArticuloAdapter(articulos);
                recyclerViewArticles.setAdapter(adapterArticles);
            }

            @Override
            public void OnFail(String msg) {
                Log.d("ArticuloManagerDB", msg);
                articulos.add(new Producto("Empty_DATE"));
                adapterArticles = new ListaArticuloAdapter(articulos);
                recyclerViewArticles.setAdapter(adapterArticles);
            }
        };

        articuloManagerDB.readRealtimeListener(iTaskNotification);
        Log.e("ListaArticulosFragment", "Array lista articulos size: " + articulos.size());

        // Add the following lines to create RecyclerView
        recyclerViewArticles = viewListaArticle.findViewById(R.id.recyclerViewItemArticulos);
        recyclerViewArticles.setHasFixedSize(true);
        recyclerViewArticles.setLayoutManager(new LinearLayoutManager(viewListaArticle.getContext()));
        fetchArticulos();

        //TODO recylerview swipe to  delete item
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT)
        {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getBindingAdapterPosition();
                if (articuloManagerDB.deleteDocument(GlobarArgs.DB_SHOPING + "/" + GlobarArgs.USER_ID + "/" + GlobarArgs.COLLECTION_SHOPING_LIST, articulos.get(position).getNombre()))
                    adapterArticles.deteleItem(viewHolder.getBindingAdapterPosition());
                Log.d("recylerviewArticules", "onSwiped");

            }
        }).attachToRecyclerView(recyclerViewArticles);


        //TODO recylerview UserSHared
        linearLayoutManagerUser = new LinearLayoutManager(viewListaArticle.getContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerViewSharedUser = viewListaArticle.findViewById(R.id.recyclerViewSharedUsers);
        recyclerViewSharedUser.setHasFixedSize(true);
        recyclerViewSharedUser.setLayoutManager(linearLayoutManagerUser);
        adapterSharedUser = new SharedUserAdapter(usuaris);//Set date
        recyclerViewSharedUser.setAdapter(adapterSharedUser);

        //TODO add pager behavior (Recylerview UserSHared item  page indicator)
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerViewSharedUser);


        viewListaArticle.findViewById(R.id.floatingActionButtonAdd).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(
                        R.id.action_listaArticuloFragment_to_agregarArticuloFragment);
            }
        });


        viewListaArticle.findViewById(R.id.btnManageSharedUser).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(
                        R.id.action_listaArticuloFragment_to_sharedUserFragment);
            }
        });
        //endregion

        navigationView = viewListaArticle.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_close:
                        Log.d("NavigationView", "close");
                        getActivity().finish();
                        FirebaseAuth.getInstance().signOut();
                        break;
                    case R.id.nav_shareUser:
                        Navigation.findNavController(viewListaArticle).navigate(
                                R.id.action_listaArticuloFragment_to_sharedUserFragment);
                        break;
                }
                return false;
            }
        });
        return viewListaArticle;
    }

    private void fetchArticulos() {
        RetrofitCli.getRetrofitClient().getProducts().enqueue(new Callback<List<Producto>>()
        {
            @Override
            public void onResponse(@NonNull Call<List<Producto>> call,
                                   @NonNull retrofit2.Response<List<Producto>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    articulos.addAll(response.body());
                    adapterArticles.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Producto>> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    //TODO recylerview ELIMINAR

    //Menu
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        getActivity().getMenuInflater().inflate(R.menu.men_navegation_view, menu);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnu_barra_lateralOpen:
                DrawerLayout drawerLayout = ((DrawerLayout) (getActivity().findViewById(R.id.drawerLayutListaArticles)));
                ActionMenuItemView menuItem = (ActionMenuItemView) getActivity().findViewById(R.id.mnu_barra_lateralOpen);

                if (!drawerLayout.isOpen()) {
                    drawerLayout.openDrawer(Gravity.LEFT);
                    menuItem.setIcon(ContextCompat.getDrawable(getContext(), android.R.drawable.arrow_up_float));
                } else {
                    drawerLayout.close();
                    menuItem.setIcon(ContextCompat.getDrawable(getContext(), android.R.drawable.arrow_down_float));
                }
                return super.onOptionsItemSelected(item);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}