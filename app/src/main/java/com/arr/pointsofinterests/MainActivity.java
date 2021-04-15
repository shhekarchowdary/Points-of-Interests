package com.arr.pointsofinterests;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner mSpinnerCountry,mSpinnerInterest;
    ImageView mImageView1,mImageView2;

    public static String imgSelected,imgUnSelected;
    ArrayList<PointOfInterest>pois = new ArrayList<>();
    ArrayList<String>countries = new ArrayList<>();
    ArrayList<String>poiNames = new ArrayList<>();

    public static PointOfInterest poiSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView1 = findViewById(R.id.image1);
        mImageView2 = findViewById(R.id.image2);
        mSpinnerCountry = findViewById(R.id.spinner);
        mSpinnerInterest = findViewById(R.id.spinner2);

        fillData();

        for(PointOfInterest poi:pois)
            countries.add(poi.getCountry());

        countries = new ArrayList<>(new LinkedHashSet<>(countries));

        ArrayAdapter countryAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,countries);
        mSpinnerCountry.setAdapter(countryAdapter);

        mSpinnerCountry.setOnItemSelectedListener(this);
        mSpinnerInterest.setOnItemSelectedListener(this);

        mImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),description.class);
                imgSelected = poiSelected.getImageName1();
                imgUnSelected = poiSelected.getImageName2();
                startActivity(i);
            }
        });

        mImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),description.class);
                imgSelected = poiSelected.getImageName2();
                imgUnSelected = poiSelected.getImageName1();
                startActivity(i);
            }
        });

    }

    public void fillData(){
        pois.add(new PointOfInterest("India","Taj Mahal","A white marble tomb built in 1631 - 48 in Agra, seat of the Mughal Empire, by Shah Jehan for his wife, Arjuman Banu Begum, the monument sums up many of the formal themes that have played through Islamic architecture. Its refined elegance is a conspicuous contrast both to the Hindu architecture of pre-Islamic India, with its thick walls, corbelled arches and heavy lintels, and to the Indo-Islamic styles, in which Hindu elements are combined with an eclecticassortment of motifs from Persian and Turkish sources.","tajmahal1","tajmahal2"));
        pois.add(new PointOfInterest("India","Charminar","The Charminar (lit \"four minarets\") constructed in 1591, is a monument and mosque located in Hyderabad, Telangana, India. The landmark has become known globally as a symbol of Hyderabad and is listed among the most recognized structures in India. It has also been officially incorporated as the Emblem of Telangana for the state of Telangana.The Charminar's long history includes the existence of a mosque on its top floor for more than 400 years.","charminar1","charminar2"));
        pois.add(new PointOfInterest("India","Red Fort","The Red Fort is a historic fort in the city of Delhi (in Old Delhi) in India that served as the main residence of the Mughal Emperors. Emperor Shah Jahan commissioned construction of the Red Fort on 12 May 1638, when he decided to shift his capital from Agra to Delhi. Originally red and white, its painting is credited to architect Ustad Ahmad Lahori, who also constructed the Taj Mahal. It was renovated between May 1639 and April 1648 based on an earlier fort.","redfort1","redfort2"));
        pois.add(new PointOfInterest("Canada","CN Tower","On the shores of Lake Ontario in Canada's biggest city is the iconic CN Tower, one of Canada's most famous landmarks. The tower stands an impressive 553 meters high and dominates the skyline.","cntower1","cntower2"));
        pois.add(new PointOfInterest("Canada","Banff National Park","Banff National Park lies in the heart of the majestic Rocky Mountains in the province of Alberta, and showcases some of Canada's most beautiful scenery. Turquoise-colored lakes, snow-capped peaks, and glaciers are all easily accessible in this stunning park.","banffnationalpark1","banffnationalpark2"));
        pois.add(new PointOfInterest("Canada","Niagara Falls","Niagara Falls is Canada's most famous natural attraction, bringing in millions of visitors each year. Located just over an hour's drive from Toronto, along the American border, these massive falls drop approximately 57 meters. You can see the falls at an astoundingly close distance from several key points.","niagarafalls1","niagarafalls2"));
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        switch (adapterView.getId()){
            case R.id.spinner:
                String countrySelected = countries.get(i);
                poiNames.clear();
                for(PointOfInterest poi:pois)
                    if(poi.getCountry().equalsIgnoreCase(countrySelected))
                        poiNames.add(poi.getName());

                ArrayAdapter poiAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,poiNames);
                mSpinnerInterest.setAdapter(poiAdapter);
            break;
            case R.id.spinner2:
                String interestSelected = poiNames.get(i);
                for(PointOfInterest poi:pois)
                    if(poi.getName().equalsIgnoreCase(interestSelected)){
                        poiSelected = poi;
                        break;
                    }
                int res1 = getResources().getIdentifier(poiSelected.getImageName1(),"drawable",getPackageName());
                int res2 = getResources().getIdentifier(poiSelected.getImageName2(),"drawable",getPackageName());
                mImageView1.setImageResource(res1);
                mImageView2.setImageResource(res2);
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + adapterView.getId());
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}