package fr.dems.pokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class MainActivity extends AppCompatActivity {

    Gson gson = new Gson();
    ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        pokemons = buildPokemonsList();
        Log.i("pokemonInfo",pokemons.get(0).toString());

        ListView pokemonList = (ListView) findViewById(R.id.pokemon_list);

        pokemonList.setAdapter(new PokemonAdapter(getApplicationContext(), pokemons));
        pokemonList.setOnItemClickListener(pokemonListener);

    }
    private ArrayList<Pokemon> buildPokemonsList() {
        Type listType = new TypeToken<ArrayList<Pokemon>>(){}.getType();
        return gson.fromJson(readJSONFile("pokedex.json"), listType);


    }

    private String readJSONFile(String filename) {
        AssetManager am = this.getAssets();
        String result = "";
        try {
            InputStream inputStream = am.open(filename);
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            result = new String(b);
        } catch (Exception e) {
            Log.e("Error readJSONFile", e.getMessage());
        }
        // Log.i("Result",result) ;
        return result;
    }

    private AdapterView.OnItemClickListener pokemonListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent myIntent = new Intent(MainActivity.this, PokemonActivity.class);
            myIntent.putExtra("name", pokemons.get(position).getName().toString());
            myIntent.putExtra("baseAttack", pokemons.get(position).getBase().getAttack());
            myIntent.putExtra("baseDefense", pokemons.get(position).getBase().getDefense());
            myIntent.putExtra("baseHP", pokemons.get(position).getBase().getHP());
            myIntent.putExtra("BaseSpAtt", pokemons.get(position).getBase().getSpAttack());
            myIntent.putExtra("BaseSpeed", pokemons.get(position).getBase().getSpeed());
            myIntent.putExtra("type", pokemons.get(position).getType());
            startActivity(myIntent);
        }
    };

}
