package ebook.grokkingAlgorithms;

import java.util.LinkedList;

public class _4MyHashList {
    public static void main(String[] args) {
        _4MyHashList myHashList = new _4MyHashList();
        myHashList.putMyHashTable("ZhuHaoWen");
        myHashList.putMyHashTable("hotWind");
        myHashList.putMyHashTable("hotWinds");
        System.out.println(myHashList.getMyHashTable("ZhuHaoWen"));
    }

    public _4MyHashList() {

        this.oneLinkedList = new LinkedList<>();
        this.twoLinkedList = new LinkedList<>();
        linkedLists[0]=this.oneLinkedList;
        linkedLists[1]=this.twoLinkedList;
    }
    private  LinkedList<String>[] linkedLists=new LinkedList[2];
    private LinkedList<String> oneLinkedList;
    private LinkedList<String> twoLinkedList;

    public void putMyHashTable(String input){
        if (input.length()%2==1){
            oneLinkedList.add(input);
        }else {
            twoLinkedList.add(input);
        }

    }

    public boolean getMyHashTable(String target){
        boolean isFind=false;
        if (target.length()%2==1){
            for (int i = 0; i < oneLinkedList.size(); i++) {
                if (oneLinkedList.get(i)==target){
                    isFind = true;
                    break;
                }
            }
        }else {
            for (int i = 0; i < twoLinkedList.size(); i++) {
                if (twoLinkedList.get(i)==target){
                    isFind = true;
                    break;
                }
            }
        }
        return isFind;

    }


}
