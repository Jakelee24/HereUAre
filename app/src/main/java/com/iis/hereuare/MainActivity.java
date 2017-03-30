package com.iis.hereuare;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    // XML node keys
    static final String KEY_NODE = "node"; // parent node
    static final String KEY_ID = "id";
    static final String KEY_LAT = "lat";
    static final String KEY_LON = "lon";
    String xml=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();

        PathParser parser = new PathParser();
        try {
            xml = parser.getXmlFromAssets(getAssets().open("path.xml"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        Document doc = parser.getDomElement(xml); // getting DOM element
        NodeList nl = doc.getElementsByTagName(KEY_NODE);
        for (int i = 0; i < nl.getLength(); i++) {
            // creating new HashMap
            HashMap<String, String> map = new HashMap<String, String>();
            Element e = (Element) nl.item(i);
            // adding each child node to HashMap key => value
            map.put(KEY_ID, parser.getValue(e, KEY_ID));
            map.put(KEY_LAT, parser.getValue(e, KEY_LAT));
            map.put(KEY_LON, parser.getValue(e, KEY_LON));
            // adding HashList to ArrayList
            menuItems.add(map);
            Log.d("aaaaaaaaaaaaaaaaa", "LON:"+ parser.getValue(e, KEY_ID));


        }

    }


}
