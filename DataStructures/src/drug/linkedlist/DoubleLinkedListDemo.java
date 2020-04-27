package drug.linkedlist;

/**
 * @author Drug
 * @create 2020-04-16 16:31
 */
public class DoubleLinkedListDemo {


    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        //末尾添加节点
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.update(new HeroNode2(2, "公孙胜","入云龙" ));
        doubleLinkedList.delete(3);
        doubleLinkedList.show();

    }



}

//
class DoubleLinkedList{
    private HeroNode2 headNode;

    public DoubleLinkedList() {
        headNode = new HeroNode2(0,null,null);
    }

    /**
     * 获取头结点
     * @return
     */
    public HeroNode2 getHeadNode(){
        return headNode;
    }

    /**
     * 末尾添加节点
     * @param heroNode
     */
    public void add(HeroNode2 heroNode){
        HeroNode2 temp = headNode;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next=heroNode;
        heroNode.pre = temp;
    }

    /**
     * 按编号添加,如存在则不添加并提示
     * @param heroNode
     */
    public void addByOrder(HeroNode2 heroNode){
        HeroNode2 temp = headNode;
        boolean flag = false;//默认false表示添加编号不存在,如存在则返回true
        while(true){
            if(temp.next ==null){
                //已到尾部
                break;
            }else if(temp.next.no == heroNode.no){
                //找到编号相同的英雄
                flag = true;
                break;
            }else if(temp.next.no > heroNode.no){
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.println("添加的编号"+heroNode.no+"已存在");
        }else{
            heroNode.next = temp.next;
            heroNode.pre = temp;
            if(temp.next !=null){
                temp.next.pre = heroNode;
            }
            temp.next = heroNode;
        }
    }

    /**
     * 更新节点
     * @param newHeroNode
     */
    public void update(HeroNode2 newHeroNode){
        if(headNode.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = headNode.next;
        boolean flag = false; //是否找到该节点
        while(true){
            if(temp == null){
                //表示该节点已是链表尾部
                break;
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else{
            System.out.println("没有找到编号为"+newHeroNode.no+"的节点信息");
        }
    }

    /**
     * 删除指定节点
     * @param no
     */
    public void delete(int no){
        if(headNode.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = headNode.next;
        while(temp.no != no){
            if(temp.next == null){
                //当前节点是最后节点了
                System.out.println("链表无所要删除编号节点");
                return;
            }
            temp = temp.next;
        }
        temp.pre.next = temp.next;
        if(temp.next != null){
            temp.next.pre = temp.pre;
        }
    }

    /**
     * 遍历链表
     */
    public void show(){
        if(headNode.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = headNode.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}




//双向链表节点
class HeroNode2{
    int no;  //编号
    String name; //姓名
    String nickName; //昵称
    HeroNode2 next;  //下一个
    HeroNode2 pre;  //上一个

    //构造
    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
