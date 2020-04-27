package drug.linkedlist;

/**
 * @author Drug
 * @create 2020-04-15 0:37
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //末尾添加节点
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);

        //按编号顺序添加节点
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        //显示所有
        singleLinkedList.show();

        //定义并更新节点
        HeroNode newHero2 = new HeroNode(4, "小卢", "玉麒麟~~");
        singleLinkedList.update(newHero2);
        System.out.println("更新后的节点信息");
        singleLinkedList.show();

        //删除节点
        singleLinkedList.delete(2);
        singleLinkedList.delete(1);
        singleLinkedList.delete(4);
        singleLinkedList.delete(3);
        System.out.println("显示删除后的节点");
        singleLinkedList.show();
    }
}

class SingleLinkedList{
    private HeroNode headNode;

    public SingleLinkedList() {
        headNode = new HeroNode(0,null,null);
    }

    /**
     * 获取头结点
     * @return
     */
    public HeroNode getHeadNode(){
        return headNode;
    }

    /**
     * 末尾添加节点
     * @param heroNode
     */
    public void add(HeroNode heroNode){
        HeroNode temp = headNode;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next=heroNode;
    }

    /**
     * 按编号添加,如存在则不添加并提示
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = headNode;
        boolean flag = false;//默认false表示添加编号不存在,如存在则返回true
        while(true){
            if(temp.next ==null){
                break;
            }else if(temp.next.no > heroNode.no){
                break;
            }else if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.println("添加的编号"+heroNode.no+"已存在");
        }else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 更新节点
     * @param newHeroNode
     */
    public void update(HeroNode newHeroNode){
        if(headNode.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = headNode.next;
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
        HeroNode temp = headNode;
        boolean flag = false;//是否找到删除节点

        while(true){
            if(temp == null){
                //表明当前节点已是最后一个节点
                break;
            }
            if(temp.next.no == no){
                //表明下一个节点就是需要的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }

        //根据flag删除或返回
        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.println("没有找到需要删除的节点");
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
        HeroNode temp = headNode.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}



class HeroNode{
    int no;  //编号
    String name; //姓名
    String nickName; //昵称
    HeroNode next;  //下一个

    //构造
    public HeroNode(int no, String name, String nickName) {
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
