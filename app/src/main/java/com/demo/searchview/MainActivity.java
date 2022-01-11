package com.demo.searchview;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import com.arges.sepan.argmusicplayer.Models.ArgAudio;
import com.arges.sepan.argmusicplayer.PlayerViews.ArgPlayerSmallView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText search_input;
    private ExampleAdapter adapter;
    ImageButton bt_mic;
    LinearLayout search_layout;
    ImageView searched,miced,backed;
    ActionBar actionBar;
    ListView mainLV,marathisong,englishpoems,sounds,marathistory,words,themesin;
    private List<ExampleItem> exampleList;
    private List<ExampleItem> examples;
    MediaPlayer mediaPlayer;

    private static final int SPEECH_REQUEST_CODE = 0;




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
         {
            if (requestCode == SPEECH_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
                ArrayList<String> results = Objects.requireNonNull(data).getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                String spokenText = results.get(0);
                spokenText = spokenText.toLowerCase();
                // Do something with spokenText
                search_input.setText(spokenText);
            }

            super.onActivityResult(requestCode, resultCode, data);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }


    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArgPlayerSmallView argMusicPlayer = (ArgPlayerSmallView) findViewById(R.id.argmusicplayer);

        searched = findViewById(R.id.searched);
        search_input = findViewById(R.id.search_input);
        miced= findViewById(R.id.miced);
        backed = findViewById(R.id.backed);


        RecyclerView recyclerView = (RecyclerView) findViewById( R.id.allitemRV);

        mainLV= findViewById(R.id.mainLV);
        String[] mainlist = {"Badbad Geete","English Poems","Sounds","Marathi Stories","English Words","Themes"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line,mainlist);

        marathisong = findViewById(R.id.marathisong);
        String[] song = {"Pahat Zali","Hatti Dada","Lal Lal Choch"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line,song);
        marathisong.setAdapter(adapter1);

        englishpoems = findViewById(R.id.englishpoems);
        String[] song2 = {"ABCD EFG","God made the blue sky","Hop a little jump a little","I have ten fingers","One Little Finger","Rain on the rooftop","The Dog says bow","If you are happy"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line,song2);
        englishpoems.setAdapter(adapter2);

        sounds = findViewById(R.id.sounds);
        String[] song3 = {"Sounds of City Animals","Sound of Wild Animals","Sounds of Birds","Sounds of Vehicles","Sounds of Water","Other sounds"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line,song3);
        sounds.setAdapter(adapter3);

        marathistory = findViewById(R.id.marathistory);
        String[] song4 = {"Kombdichi chatur pille","Lippo baaget gela","Avayavaanche bhandan","Banee che jevan","Doan bakryaa","Ghosavlyaacha vel","Hema ani prema","Kalkat vinu","Kombde dada","Sashaachi chaturai","Teen rutu","Thirsty crow"};
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line,song4);
        marathistory.setAdapter(adapter4);

        words = findViewById(R.id.words);
        String[] song6 = {"Me and my body parts","City animals & birds","Wild animals","Water","Flowers","Fruits","Professions","Vehicles","Grains","Vegetables","Good Habits"};
        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line,song6);
        words.setAdapter(adapter6);

        themesin = findViewById(R.id.themesin);
        String[] song5 = {"Me and my body parts","City animals & birds","Wild animals","Water","Flowers","Fruits","Professions","Vehicles","Grains","Vegetables","Good Habits"};
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line,song5);
        themesin.setAdapter(adapter5);

        mainLV.setAdapter(adapter);
        search_layout = findViewById(R.id.search_layout);

        mainLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    themesin.setVisibility(View.GONE);
                    sounds.setVisibility(View.GONE);
                    englishpoems.setVisibility(View.GONE);
                    marathisong.setVisibility(View.VISIBLE);
                    words.setVisibility(View.GONE);
                    mainLV.setVisibility(View.GONE);
                    marathistory.setVisibility(View.GONE);

                }
                if(position == 1 ){
                    themesin.setVisibility(View.GONE);
                    sounds.setVisibility(View.GONE);
                    englishpoems.setVisibility(View.VISIBLE);
                    marathisong.setVisibility(View.GONE);
                    words.setVisibility(View.GONE);
                    mainLV.setVisibility(View.GONE);
                    marathistory.setVisibility(View.GONE);
                }
                if(position == 2 ){
                    themesin.setVisibility(View.GONE);
                    sounds.setVisibility(View.VISIBLE);
                    englishpoems.setVisibility(View.GONE);
                    marathisong.setVisibility(View.GONE);
                    words.setVisibility(View.GONE);
                    mainLV.setVisibility(View.GONE);
                    marathistory.setVisibility(View.GONE);
                }
                if(position == 3  ){
                    themesin.setVisibility(View.GONE);
                    sounds.setVisibility(View.GONE);
                    englishpoems.setVisibility(View.GONE);
                    marathisong.setVisibility(View.GONE);
                    words.setVisibility(View.GONE);
                    mainLV.setVisibility(View.GONE);
                    marathistory.setVisibility(View.VISIBLE);
                }
                if(position == 4 ){
                    themesin.setVisibility(View.GONE);
                    sounds.setVisibility(View.GONE);
                    englishpoems.setVisibility(View.GONE);
                    marathisong.setVisibility(View.GONE);
                    words.setVisibility(View.VISIBLE);
                    mainLV.setVisibility(View.GONE);
                    marathistory.setVisibility(View.GONE);
                }
                if(position == 5 ){
                    themesin.setVisibility(View.VISIBLE);
                    sounds.setVisibility(View.GONE);
                    englishpoems.setVisibility(View.GONE);
                    marathisong.setVisibility(View.GONE);
                    words.setVisibility(View.GONE);
                    mainLV.setVisibility(View.GONE);
                    marathistory.setVisibility(View.GONE);
                }



            }
        });



        marathisong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    String url = "https://firebasestorage.googleapis.com/v0/b/fir-mlkit-ca7a6.appspot.com/o/01_Pahat_Zali%5B1%5D.mp3?alt=media&token=379a43b7-e0b9-44ea-aec3-fe421d91682c";
                    ArgAudio audio = ArgAudio.createFromURL("Marathi Song", "Pahat Zhali", url);
                    ArgPlayerSmallView argMusicPlayer = (ArgPlayerSmallView) findViewById(R.id.argmusicplayer);
                    argMusicPlayer.play(audio);
                }

            }
        });




        searched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(search_layout.getVisibility() == View.VISIBLE){
                    recyclerView.setVisibility(View.GONE);
                    search_layout.setVisibility(View.GONE);
   }
                else{
                    search_layout.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.VISIBLE);}
            }

        });

        miced.setOnClickListener(v -> {
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "mr-IN");
//            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            startActivityForResult(intent, SPEECH_REQUEST_CODE);
            recyclerView.setVisibility(View.VISIBLE);
            search_layout.setVisibility(View.VISIBLE);
        });

        backed.setOnClickListener(v -> {
            mainLV.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        });

        fillExampleList();
        setUpRecyclerView();
        initToolbar();
        this.search_input = (EditText) findViewById(R.id.search_input);
        this.search_input.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void afterTextChanged(Editable editable) {
                MainActivity.this.filterQuery(editable.toString());
            }
        });
    }

    private void fillExampleList() {
        this.exampleList = new ArrayList();
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Pahat Zali", "पहाट झाली"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Hatti Dada", "हत्ती दादा"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Lal Lal Choch", "लाल लाल चोच"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Var", "वार"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Chimani Tai Chya Pilla", "चिमणी ताईच्या पिला"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Makade Nighali", "माकडे निघाली"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Yere Yere Pavsa", "येरे येरे पावसा"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Bahuli Sajali", "बाहुली सजली"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Bud Bud Ghagari", "बुड बुड घागरी"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Bharat Bhoochi Mule", "बुड बुड घागरी"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Aaji Ga Aaji","आजी गं आजी"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Daha Bai Chimanya", "दहा बाई चिमण्या"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Hat aaple Kashala", "हात आपले कशाला"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Gadi Kashi Dhavte", "गाडी कशी धावते"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Atak Matak", "अटक मटक"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Tandul Ghya Ho", "तांदूळ घ्या हो"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Telephone", "टेलिफोन"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Gadi Aali", "गाडी आली"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Zatpat Rao", "झटपट राव"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Chala Bagemadhe Firayala", "चला बागे मध्ये"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Nandi Aala", "नंदी आला"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Mora re Mora", "मोरा रे मोरा"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Challo Aamhi Khel", "चाललो आम्ही खेळ खेळायला"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Suryachi Kirane", "सूर्याची किरणे"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Aamhi Teen Makade", "आम्ही तीन माकडे"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Badbad Geet", "बडबड"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Badbad Geet", "बडबड"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Badbad Geet", "बडबड"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Badbad Geet", "बडबड"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Badbad Geet", "बडबड"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Badbad Geet", "बडबड"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Badbad Geet", "बडबड"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Badbad Geet", "बडबड"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Badbad Geet", "बडबड"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Badbad Geet", "बडबड"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Badbad Geet", "बडबड"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Badbad Geet", "बडबड"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Badbad Geet", "बडबड"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Badbad Geet", "बडबड"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Badbad Geet", "बडबड"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Badbad Geet", "बडबड"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Badbad Geet", "बडबड"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Badbad Geet", "बडबड"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Badbad Geet", "बडबड"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Badbad Geet", "बडबड"));
        this.exampleList.add(new ExampleItem( R.drawable.ic_filter_list_black_24dp, "Badbad Geet", "बडबड"));
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById( R.id.allitemRV);
        recyclerView.setHasFixedSize(true);
        LayoutManager layoutManager = new LinearLayoutManager(this);
        this.adapter = new ExampleAdapter(this,this.exampleList,recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(this.adapter);
    }

    private void initToolbar() {
        setSupportActionBar((Toolbar) findViewById( R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "Masti Ki Paathshala");

    }



    /* access modifiers changed from: private */
    public void filterQuery(String text) {
        ArrayList<ExampleItem> filterdNames = new ArrayList<>();
        for (ExampleItem s : this.exampleList) {
            if (s.getText1().toLowerCase().contains(text) || s.getText2().toLowerCase().contains(text)) {
                filterdNames.add(s);
            }
        }
        this.adapter.setFilter(filterdNames);
    }


}
