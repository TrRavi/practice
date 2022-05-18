package com.practice.thread.nonsynchronization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParentAndChild {
	
	public static void main(String[] args) {
	    List<Map<String,String>> listData = new ArrayList<Map<String,String>>();
	    Map<String,String> mapData = new HashMap<String,String>();
	      mapData.put("LE_ID","00111");
	      mapData.put("LE_NAME","Reliance Industry");
	      mapData.put("ParentId","0");
	      listData.add(mapData);

	    Map<String,String> mapData1 = new HashMap<String,String>();
	      mapData1.put("LE_ID","00222");
	      mapData1.put("LE_NAME","JIO Communication");
	      mapData1.put("ParentId","0");
	      listData.add(mapData1);

	      Map<String,String> mapData2 = new HashMap<String,String>();
	      mapData2.put("LE_ID","00283");
	      mapData2.put("LE_NAME","Reliance retail ltd");
	      mapData2.put("ParentId","00111");
	      listData.add(mapData2);

	      Map<String,String> mapData3 = new HashMap<String,String>();
	      mapData3.put("LE_ID","00271");
	      mapData3.put("LE_NAME","JIO commerce");
	      mapData3.put("ParentId","00222");
	      listData.add(mapData3);

	      Map<String,String> mapData4 = new HashMap<String,String>();
	      mapData4.put("LE_ID","00272");
	      mapData4.put("LE_NAME","JIO Business");
	      mapData4.put("ParentId","00222");
	      listData.add(mapData4);


	      Map<String,String> mapData5 = new HashMap<String,String>();
	      mapData5.put("LE_ID","9038");
	      mapData5.put("LE_NAME","Reliance life style");
	      mapData5.put("ParentId","00271");
	      listData.add(mapData5);
	      List<Map<String,String>> hierarchyNameList = new ArrayList<>();

	      //finding root 
	      List<Map<String,String>>rootParentList =  getRoot(listData);
	      System.out.println("No of root = "+rootParentList.size());
	      for(int i=0;i<rootParentList.size();i++){
	          String  level = String.valueOf(i+1);
	          Map<String,String> root = rootParentList.get(i);
	          String rootName = level+"  "+  root.get("LE_NAME");
	          root.put("LE_NAME",rootName);
	          
	          hierarchyNameList.add(root);
	          hierarchyNameList.addAll(getChildren(listData,root.get("LE_ID"), level));
	      }
	      
	      System.out.println(" \n\n Here are level hierarchy \n \n");
	      
	      for(int i= 0;i< hierarchyNameList.size();i++){
	          Map<String,String> data = hierarchyNameList.get(i);
	          System.out.println( data.get("LE_ID")+"  "+data.get("LE_NAME")+ "             "+data.get("ParentId") );

	      }

	  }

	    private static List<Map<String, String>> getRoot(List<Map<String, String>> listData) {
	      List<Map<String, String>> rootParent = new ArrayList<Map<String,String>>();
	      for(int i=0;i<listData.size();i++){
	          Map<String,String> data =  listData.get(i);
	            if(data.get("ParentId").equals("0")){
	                rootParent.add(data);
	            }
	        }
	      return  rootParent;
	    }

	    public static List<Map<String,String>>  getChildren(List<Map<String,String>> listData,String parentId,String level){
	    System.out.println("Finding Children of level => " +level);
	      List<Map<String,String>> children = new ArrayList<Map<String,String>>();
	      int count = 1;
	      for(int i=0; i<listData.size(); i++){
	            Map<String,String> data =  listData.get(i);
	            if(data.get("ParentId").equals(parentId)){
	            	//System.out.println(count);
	            	//System.out.println(level+" parent => "+parentId +" child id =>"+data.get("LE_NAME"));
	                String name = level +"."+count+"  "+ data.get("LE_NAME");
	                data.put("LE_NAME",name);
	                children.add(data);
	                children.addAll(getChildren(listData,data.get("LE_ID"),level +"."+count));
	                count++;
	            }

	        }
	      return children;
	  }

	
	

}
