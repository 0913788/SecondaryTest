package kwc.secondarytest;

import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Empty extends AppCompatActivity {

    //Pairs bestaan uit twee elementen
    //  First, het eerste element, de score van een land
    //  Second, het tweede element, de naam van een land
    // Maak alle landen op deze manier.
    private Pair<Integer, String> canada = new Pair<>(0, "Canada");
    private Pair<Integer, String> vs = new Pair<>(0, "VS");
    private Pair<Integer, String> alaska = new Pair<>(0, "Alaska");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        //Score verhogen van een land
        alaska = verhoogScore(alaska);
        alaska = verhoogScore(alaska);
        vs = verhoogScore(vs);

        //Vraag het land met de hoogste score op.
        Pair<Integer, String> hoogste = HoogsteLand();
        // Start een nieuw scherm aan de hand van de naam van het land (hoogste.second)
        String hoogsteLandNaam = hoogste.second;

    }

    // Een functie die een Pair (land) als argument neemt en deze terug geeft met de score
    // verhoogd met 1.
    private Pair<Integer, String> verhoogScore(Pair<Integer, String> land){
        return new Pair<>(land.first + 1, land.second);
    }

    // Een functie die alle landen verzameld en het land met de hoogste score terug geeft.
    private Pair<Integer, String> HoogsteLand(){
        // Maak een lijst van landen
        List<Pair<Integer, String>> alleLanden = new ArrayList<>();

        //  Voeg elk land toe aan de lijst.
        alleLanden.add(canada);
        alleLanden.add(alaska);
        alleLanden.add(vs);

        // Zet het hoogste land naar het eerste land in de lijst van landen.
        Pair<Integer, String> hoogste = alleLanden.get(0);

        for(int i=0; i<alleLanden.size(); i++) {
            if (hoogste.first < alleLanden.get(i).first) {
                hoogste = alleLanden.get(i);
            }
        }
        return hoogste;
    }
}

