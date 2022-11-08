package ebook.grokkingAlgorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

class FriendDict {
    //自己的名字
    private String name;
    //朋友名列表
    private String[] friends;

    public FriendDict() {
    }

    public FriendDict(String name) {
        this.name = name;
    }

    public FriendDict(String name, String[] friends) {
        this.name = name;
        this.friends = friends;
    }

    public String getName() {
        return name;
    }

    public String[] getFriends() {
        return friends;
    }
}

//BFS
public class _5Breadth_firstSearchBFS {
    public static void main(String[] args) {
      /*  String[] yourFriends={"Your","Bob","Tom","LinDa","XiaoLu","Exe"};
        String[] TomFriends = {"Tom","TomSister","TomF1","TomF2","XiaoLu"};
        String[] LinDa={"LinDa","ZhuHaoWen","Exe"};
        String[] Exe = {"Exe","Tom","Bob","TomF1","Sxs","Target"};

        String target;
        LinkedList<String> searchList = new LinkedList<>();
        HashSet<String> addedNameList = new HashSet<>();

        for (int i = 0; i < yourFriends.length ; i++) {
            if (!addedNameList.contains( yourFriends[i])) {
                 searchList.add(yourFriends[i]);
                 addedNameList.add(yourFriends[i]);
            }
        }
*/
        String[] MyFriends = {"Bob", "Tom", "LinDa", "XiaoLu", "Exe"};
        String[] TomFriends = {"Tom", "TomSister", "TomF1", "TomF2", "XiaoLu"};
        String[] LinDaFriends = {"ZhuHaoWen", "Exe"};
        String[] ExeFriends = {"Exe", "Tom", "Bob", "TomF1", "Sxs", "Target"};

        FriendDict Myself = new FriendDict("Myself", MyFriends);
        FriendDict Tom = new FriendDict("Tom", TomFriends);
        FriendDict LinDa = new FriendDict("LinDa", LinDaFriends);
        FriendDict Exe = new FriendDict("Exe", ExeFriends);

        ArrayList<FriendDict> arr = new ArrayList<>();
        arr.add(Myself);
        arr.add(Tom);
        arr.add(LinDa);
        arr.add(Exe);

        String target = "Sxs";
        boolean isFind = false;

        isFind = BFS(target,Myself,arr);
        System.out.println(isFind);
        System.out.println("-----");

        String[] startPoint = {"A", "B"};
        String[] aPoint = {"D"};
        String[] bPoint = {"C", "E"};
        String[] cPoint = {"D"};
        String[] dPoint = {"END"};
        String[] ePoint = {"D"};

        FriendDict start = new FriendDict("START", startPoint);
        FriendDict a = new FriendDict("A", aPoint);
        FriendDict b = new FriendDict("B", bPoint);
        FriendDict c = new FriendDict("C", cPoint);
        FriendDict d = new FriendDict("D", dPoint);
        FriendDict e = new FriendDict("E", ePoint);

        ArrayList<FriendDict> pointArr = new ArrayList<>();
        pointArr.add(start);
        pointArr.add(a);
        pointArr.add(b);
        pointArr.add(c);
        pointArr.add(d);
        pointArr.add(e);

        String endPoint = "END";
        boolean isFindPath = false;

        isFindPath = BFS(endPoint,start,pointArr);
        System.out.println(isFindPath);



    }

    public static boolean BFS(String target, FriendDict startFD, ArrayList<FriendDict> friendDictsMap) {
        boolean isFind = false;

        LinkedList<String> searchList = new LinkedList<>();
        HashSet<String> addedNameList = new HashSet<>();

        //尝试记录路径


        searchList.add(startFD.getName());
        while (!searchList.isEmpty()) {
            if (searchList.getFirst() == target) {
                isFind = true;
                break;
                //searchList.removeAll(searchList);
            } else {//找不到

                //判断已添加名单是否有这个名字
                if (addedNameList.contains(searchList.getFirst())) {
                //有的话就跳过
                } else {
                    //没有的话 添加名字进已添加名单
                    addedNameList.add(searchList.getFirst());

                    //找不到  遍历 朋友图 将其朋友全部添加到searchList
                    for (FriendDict frdic : friendDictsMap) {
                        if (frdic.getName() == searchList.getFirst()) {
                            for (int i = 0; i < frdic.getFriends().length; i++) {
                                if (addedNameList.contains(frdic.getFriends()[i])) {
                                    //已包含不管他
                                } else {
                                    //不包含 就添加进搜寻list
                                    searchList.add(frdic.getFriends()[i]);
                                }
                            }
                            break;
                        }
                    }


                }
                //删掉第一个
                searchList.removeFirst();


            }

        }


        return isFind;
    }
}
