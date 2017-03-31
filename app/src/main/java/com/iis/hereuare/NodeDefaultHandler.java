package com.iis.hereuare;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.iis.hereuare.Node;
/**
 * Created by Jake on 3/31/17.
 */
public class NodeDefaultHandler extends DefaultHandler {
    private List<Node> nodes;
    private Node node ;    //记录当前person
    private String perTag;    //记录前一个标签的名称

    /**
     * 重写父类的开始文档方法。用于初始化
     */
    @Override
    public void startDocument() throws SAXException {
        nodes = new ArrayList<Node>();
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        if("node".equals(localName)){
            Integer id = new Integer(attributes.getValue(0));    //取id
            node = new Node();
            node.setId(id);
            Float lat = new Float(attributes.getValue(3));
            node.setLat(lat);
            Float lon = new Float(attributes.getValue(4));
            node.setLon(lon);
        }
        perTag = localName;
    }
    /**参数：
     * ch        整个XML字符串
     * start     节点值在整个XML字符串中的索引位置
     * length    节点值的长度
     */
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if("node".equals(localName)){
            nodes.add(node);
            node = null;
        }
        perTag = null;
    }
    public List<Node> getNodes() {
        return nodes;
    }

}
