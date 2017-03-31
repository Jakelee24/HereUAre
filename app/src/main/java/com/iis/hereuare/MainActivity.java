package com.iis.hereuare;



import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.w3c.dom.Node;


import java.io.IOException;
import java.io.InputStream;

import java.util.List;




public class MainActivity extends AppCompatActivity {
    InputStream xml = null;
    List<com.iis.hereuare.Node> nodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AssetManager manager = getAssets();
        NodeLoader loader = new NodeLoader();
        try {
            xml = manager.open("path.xml");
            nodes = loader.getNodes(xml);

            Log.d("AAAAAAAA", String.valueOf(nodes.size()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}