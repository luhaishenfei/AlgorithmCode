package grokkingAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
*/
class NodeElement {
    String nodeName;

    HashMap<NodeElement, Integer> nextNodePathLength;

    public NodeElement() {
    }

    public NodeElement(String nodeName) {
        this.nodeName = nodeName;
        nextNodePathLength = new HashMap<>();
    }

    public NodeElement(String nodeName, HashMap<NodeElement, Integer> nextNodePathLength) {
        this.nodeName = nodeName;
        this.nextNodePathLength = nextNodePathLength;
    }
    /*
 /  NodeElement[] nextNodes;

    public NodeElement(String nodeName, NodeElement[] nextNodes) {
        this.nodeName = nodeName;
        this.nextNodes = nextNodes;
    }

 */
}


public class _6Dijkstra_sAlgorithm {
    public static void main(String[] args) {
        NodeElement aNode = new NodeElement("A");
        NodeElement bNode = new NodeElement("B");
        NodeElement cNode = new NodeElement("C");
        NodeElement dNode = new NodeElement("D");
        NodeElement eNode = new NodeElement("E");
        NodeElement fNode = new NodeElement("F");
       /*
        NodeElement gNode = new NodeElement("G",new HashMap<NodeElement,Integer>(){
            //匿名内部类 不推荐
            {
                put(bNode,9);
                put(cNode,1);
            }

        });
      */
        aNode.nextNodePathLength.put(bNode, 6);
        aNode.nextNodePathLength.put(cNode, 2);
        aNode.nextNodePathLength.put(dNode, 10);

        bNode.nextNodePathLength.put(dNode, 1);

        cNode.nextNodePathLength.put(bNode, 3);
        cNode.nextNodePathLength.put(dNode, 5);

        dNode.nextNodePathLength.put(eNode, 4);
        dNode.nextNodePathLength.put(fNode, 5);

        eNode.nextNodePathLength.put(fNode, 1);

        int shortsPathLength = ShortestPathLength(aNode, fNode);
        String shortsPathStr = ShortestPathStr(aNode,fNode);
        System.out.println(shortsPathStr+":"+shortsPathLength);

        //-----------------------------
        NodeElement musicScoreNode = new NodeElement("musicScore");
        NodeElement vinylRecordNode = new NodeElement("vinylRecord");
        NodeElement posterNode = new NodeElement("poster");
        NodeElement drumNode = new NodeElement("drum");

        musicScoreNode.nextNodePathLength.put(vinylRecordNode, 5);
        musicScoreNode.nextNodePathLength.put(posterNode, 0);


        vinylRecordNode.nextNodePathLength.put(posterNode, -7);

        posterNode.nextNodePathLength.put(drumNode, 35);
        //store program running took time in nano. Ps:more accurate
        long timeCounter = System.nanoTime();
        int shortsPathLengthInGoods = ShortestPathLength(musicScoreNode, drumNode);
        timeCounter =System.nanoTime() - timeCounter;
        String shortsPathStrInGoods = ShortestPathStr(musicScoreNode, drumNode);
        System.out.println(shortsPathStrInGoods+":"+shortsPathLengthInGoods+" takes:"+timeCounter);

        shortsPathLength = DijkstraAlgorithm(aNode,fNode);
        System.out.println(shortsPathLength);

    }
    public static NodeElement getShortestNodeInMap(HashMap<NodeElement,Integer> map){
        NodeElement shortestNode=null;
        int shortestdistant=Integer.MAX_VALUE;
        for (NodeElement node:
             map.keySet()) {
            if (map.get(node)<shortestdistant){
                shortestNode=node;
            }
        }
        return shortestNode;
    }

    public static int DijkstraAlgorithm(NodeElement startNode,NodeElement endNode){
            HashMap<NodeElement,Integer> distanceToStartMap= new HashMap<>();
            HashMap<String,String> parentNodeMap = new HashMap<>();
            ArrayList<String> addedNodeList = new ArrayList<>();

            distanceToStartMap.put(startNode,0);

            NodeElement node=null;

            while (!addedNodeList.contains(endNode.nodeName)){

                int shortestdistant=Integer.MAX_VALUE;
                for (NodeElement n:
                        distanceToStartMap.keySet()) {
                    if (!addedNodeList.contains(n.nodeName)&&distanceToStartMap.get(n)<shortestdistant){
                        shortestdistant=distanceToStartMap.get(n);
                        node=n;
                    }
                }
                if (shortestdistant==Integer.MAX_VALUE){
                    distanceToStartMap.put(endNode,-1);
                    break;
                }
                for (NodeElement nextNode:
                   node.nextNodePathLength.keySet()) {
                    //if not contains node
                    if (!distanceToStartMap.containsKey(nextNode)){
                        //distance map put its distance to start
                        distanceToStartMap.put(nextNode,distanceToStartMap.get(node)+node.nextNodePathLength.get(nextNode));
                        //put relationship
                        parentNodeMap.put(nextNode.nodeName,node.nodeName);

                    //if old distance bigger than the new one
                    }else if (distanceToStartMap.get(nextNode)>distanceToStartMap.get(node)+node.nextNodePathLength.get(nextNode)){
                        distanceToStartMap.replace(nextNode,distanceToStartMap.get(node)+node.nextNodePathLength.get(nextNode));
                        parentNodeMap.put(nextNode.nodeName,node.nodeName);


                    }
                }
                addedNodeList.add(node.nodeName);
            }

            return distanceToStartMap.get(endNode);
    }

    public static int ShortestPathLength(NodeElement startNode, NodeElement endNode) {
        String endNodeName = endNode.nodeName;
/*
*
    nodeLenthMap 记录每个节点距离开始的距离

*
* */

        //record each node's path
        HashMap<String, String> nodePassedPath = new HashMap<>();
        nodePassedPath.put(startNode.nodeName, startNode.nodeName);
        String currentPath = null;

        //record each node's distance from the start
        HashMap<String, Integer> nodeLenthMap = new HashMap<>();
        nodeLenthMap.put(startNode.nodeName, 0);

        Queue<NodeElement> searchList = new LinkedList<NodeElement>();
        searchList.add(startNode);
        NodeElement parentNode;

        while (searchList.peek() != null) {
            //node: parent node
            parentNode = searchList.poll();

            for (NodeElement nextNode : parentNode.nextNodePathLength.keySet()) {
                currentPath = nodePassedPath.get(parentNode.nodeName);

                if (nodeLenthMap.containsKey(nextNode.nodeName)) {
                    if (nodeLenthMap.get(nextNode.nodeName) > nodeLenthMap.get(parentNode.nodeName) + parentNode.nextNodePathLength.get(nextNode)) {
                        int subtraction = nodeLenthMap.get(nextNode.nodeName) - (nodeLenthMap.get(parentNode.nodeName) + parentNode.nextNodePathLength.get(nextNode));
                        for (String path :
                                nodePassedPath.keySet()) {
                            if (nodePassedPath.get(path).contains(nextNode.nodeName)) {
                                String[] split = nodePassedPath.get(path).split(nextNode.nodeName);
                                String temStr = nodePassedPath.get(path).replaceFirst(split[0], currentPath);
                                nodePassedPath.replace(path, temStr);
                                nodeLenthMap.replace(path, nodeLenthMap.get(path) - subtraction);
                            }
                        }
                    }
                } else {
                    //if map dont contains node,put node and its distance into map。
                    currentPath = currentPath + nextNode.nodeName;
                    //record distance
                    nodeLenthMap.put(nextNode.nodeName, nodeLenthMap.get(parentNode.nodeName) + parentNode.nextNodePathLength.get(nextNode));
                    //record path
                    nodePassedPath.put(nextNode.nodeName, currentPath);
                }
                searchList.offer(nextNode);
            }
        }

        if (nodeLenthMap.get(endNode.nodeName) != null) {
            return nodeLenthMap.get(endNode.nodeName);
        } else {
            return -1;
        }
    }

    public static String ShortestPathStr(NodeElement startNode, NodeElement endNode) {
        String endNodeName = endNode.nodeName;
/*
*
    nodeLenthMap 记录每个节点距离开始的距离

*
* */

        //record each node's path
        HashMap<String, String> nodePassedPath = new HashMap<>();
        nodePassedPath.put(startNode.nodeName, startNode.nodeName);
        String currentPath = null;

        //record each node's distance from the start
        HashMap<String, Integer> nodeLenthMap = new HashMap<>();
        nodeLenthMap.put(startNode.nodeName, 0);

        Queue<NodeElement> searchList = new LinkedList<NodeElement>();
        searchList.add(startNode);
        NodeElement parentNode;


        while (searchList.peek() != null) {
            //node: parent node
            parentNode = searchList.poll();

            for (NodeElement nextNode : parentNode.nextNodePathLength.keySet()) {
                currentPath = nodePassedPath.get(parentNode.nodeName);

                if (nodeLenthMap.containsKey(nextNode.nodeName)) {
                    if (nodeLenthMap.get(nextNode.nodeName) > nodeLenthMap.get(parentNode.nodeName) + parentNode.nextNodePathLength.get(nextNode)) {
                        int subtraction = nodeLenthMap.get(nextNode.nodeName) - (nodeLenthMap.get(parentNode.nodeName) + parentNode.nextNodePathLength.get(nextNode));
                        for (String path :
                                nodePassedPath.keySet()) {
                            if (nodePassedPath.get(path).contains(nextNode.nodeName)) {
                                String[] split = nodePassedPath.get(path).split(nextNode.nodeName);
                                String temStr = nodePassedPath.get(path).replaceFirst(split[0], currentPath);
                                nodePassedPath.replace(path, temStr);
                                nodeLenthMap.replace(path, nodeLenthMap.get(path) - subtraction);
                            }
                        }
                    }
                } else {
                    //if map dont contains node,put node and its distance into map。
                    currentPath = currentPath + nextNode.nodeName;
                    //record distance
                    nodeLenthMap.put(nextNode.nodeName, nodeLenthMap.get(parentNode.nodeName) + parentNode.nextNodePathLength.get(nextNode));
                    //record path
                    nodePassedPath.put(nextNode.nodeName, currentPath);
                }
                searchList.offer(nextNode);
            }
        }

        if (nodePassedPath.get(endNode.nodeName) != null) {
            return nodePassedPath.get(endNode.nodeName);
        } else {
            return null;
        }
    }

    public static String ShortestPathByParent(NodeElement startNode, NodeElement endNode) {
        String endNodeName = endNode.nodeName;
        //record each node's path
        HashMap<String, String> nodePassedPath = new HashMap<>();
        nodePassedPath.put(startNode.nodeName, startNode.nodeName);
        String currentPath = null;

        //record each node's parent
        HashMap<String, String> nodeParent = new HashMap<>();
        nodePassedPath.put(startNode.nodeName, startNode.nodeName);

        //record each node's distance from the start
        HashMap<String, Integer> nodeLenthMap = new HashMap<>();
        nodeLenthMap.put(startNode.nodeName, 0);

        Queue<NodeElement> searchList = new LinkedList<NodeElement>();
        searchList.add(startNode);
        NodeElement parentNode;


        while (searchList.peek() != null) {
            //node: parent node
            parentNode = searchList.poll();

            for (NodeElement nextNode : parentNode.nextNodePathLength.keySet()) {
                currentPath = nodePassedPath.get(parentNode.nodeName);

                if (nodeLenthMap.containsKey(nextNode.nodeName)) {
                    if (nodeLenthMap.get(nextNode.nodeName) > nodeLenthMap.get(parentNode.nodeName) + parentNode.nextNodePathLength.get(nextNode)) {
                        int subtraction = nodeLenthMap.get(nextNode.nodeName) - (nodeLenthMap.get(parentNode.nodeName) + parentNode.nextNodePathLength.get(nextNode));
                        for (String path :
                                nodePassedPath.keySet()) {
                            if (nodePassedPath.get(path).contains(nextNode.nodeName)) {
                                String[] split = nodePassedPath.get(path).split(nextNode.nodeName);
                                String temStr = nodePassedPath.get(path).replaceFirst(split[0], currentPath);
                                nodePassedPath.replace(path, temStr);
                                nodeLenthMap.replace(path, nodeLenthMap.get(path) - subtraction);
                            }
                        }
                    }
                } else {
                    //if map dont contains node,put node and its distance into map。
                    currentPath = currentPath + nextNode.nodeName;
                    //record distance
                    nodeLenthMap.put(nextNode.nodeName, nodeLenthMap.get(parentNode.nodeName) + parentNode.nextNodePathLength.get(nextNode));
                    //record path
                    nodePassedPath.put(nextNode.nodeName, currentPath);
                }
                searchList.offer(nextNode);
            }
        }

        if (nodePassedPath.get(endNode.nodeName) != null) {
            return nodePassedPath.get(endNode.nodeName);
        } else {
            return null;
        }
    }

}
