package com.iis.hereuare;

import android.app.Application;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Jake on 3/31/17.
 */
public class NodeLoader {
    public List<Node> getNodes(InputStream xml) throws Exception{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        NodeDefaultHandler handler = new NodeDefaultHandler();
        saxParser.parse(xml, handler);
        xml.close();
        return handler.getNodes();

    }
}
