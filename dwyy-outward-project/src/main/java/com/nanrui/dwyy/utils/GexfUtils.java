package com.nanrui.dwyy.utils;

import it.uniroma1.dis.wsngroup.gexf4j.core.*;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.Attribute;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeClass;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeList;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeType;
import it.uniroma1.dis.wsngroup.gexf4j.core.impl.GexfImpl;
import it.uniroma1.dis.wsngroup.gexf4j.core.impl.StaxGraphWriter;
import it.uniroma1.dis.wsngroup.gexf4j.core.impl.data.AttributeListImpl;

import java.io.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class GexfUtils {

    public void GexfFileDispose() throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("part-r-00000"));
        Gexf gexf = new GexfImpl();
        Calendar date = Calendar.getInstance();

        gexf.getMetadata()
                .setLastModified(date.getTime())
                .setCreator("Gephi.org")
                .setDescription("A Web network");
        gexf.setVisualization(true);

        Graph graph = gexf.getGraph();
        graph.setDefaultEdgeType(EdgeType.UNDIRECTED).setMode(Mode.STATIC);

        AttributeList attrList = new AttributeListImpl(AttributeClass.NODE);
        graph.getAttributeLists().add(attrList);

        Attribute attClass = attrList.createAttribute("class", AttributeType.INTEGER, "Class");
        Attribute attPageRank = attrList.createAttribute("pageranks", AttributeType.DOUBLE, "PageRank");

        String line = "";
        int nodeIndex = 1;

        Map<String,Node> map = new HashMap<>();
        Map<String,String> mapName2Pr = new HashMap<>();
        while ((line = bufferedReader.readLine()) != null)
        {
            String[] arr = line.split("\\t");
            String[] arr2 = arr[1].split("#");
            Node node = graph.createNode(String.valueOf(nodeIndex));
            nodeIndex++;
            node.setLabel(arr[0])
                    .getAttributeValues()
                    .addValue(attClass, "1")
                    .addValue(attPageRank, arr2[0]);
            map.put(arr[0],node);


            String[] arr3 = arr2[1].split(";");
            for(String string : arr3)
            {
                String[] Arr4 = string.split(":");
                mapName2Pr.put(arr[0] + "&" + Arr4[0],Arr4[1]);
            }
        }

        int edgeId = 1;
        for(Map.Entry<String,String> entry : mapName2Pr.entrySet())
        {
            String twoPerson = entry.getKey();
            String[] persons = twoPerson.split("&");
            Node node1 = map.get(persons[0]);
            Node node2 = map.get(persons[1]);
            node1.connectTo(String.valueOf(edgeId),node2).setWeight(Float.parseFloat(entry.getValue()));
            edgeId++;
        }

        StaxGraphWriter graphWriter = new StaxGraphWriter();
        File f = new File("static_graph_sample.gexf");
        Writer out;
        try {
            out =  new FileWriter(f, false);
            graphWriter.writeToStream(gexf, out, "UTF-8");
            System.out.println(f.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
