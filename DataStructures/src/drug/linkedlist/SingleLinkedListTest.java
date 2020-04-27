package drug.linkedlist;

import java.util.Stack;

/**
 * @author Drug
 * @create 2020-04-15 14:20
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(3, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(5, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(7, "林冲", "豹子头");
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        //显示所有
        singleLinkedList.show();
        System.out.println("查询链表的有效节点数为:"+getLength(singleLinkedList));

        //查找倒数第K个节点
        HeroNode node = getLastIndex(singleLinkedList,2);
        System.out.println("您查找的节点是:"+node);

        //反转单链表
        System.out.println("反转前");
        singleLinkedList.show();
//        System.out.println("反转后");
//        reverse(singleLinkedList);
        //利用栈,不改变链表结构,逆序打印单链表
        System.out.println("逆序打印");
        reversePrint(singleLinkedList);
        //合并两个链表
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        HeroNode hero5 = new HeroNode(2, "毒瘤", "毒瘤");
        HeroNode hero6 = new HeroNode(4, "奶怪", "奶怪");
        HeroNode hero7 = new HeroNode(6, "金咩咩", "金咩咩");
        HeroNode hero8 = new HeroNode(8, "窑子", "窑子");
        singleLinkedList2.add(hero5);
        singleLinkedList2.add(hero6);
        singleLinkedList2.add(hero7);
        singleLinkedList2.add(hero8);
        System.out.println("合并前");
        System.out.println("s1");
        singleLinkedList.show();
        System.out.println("s2");
        singleLinkedList2.show();
        System.out.println("合并后");
        SingleLinkedList list = mergeTwo(singleLinkedList, singleLinkedList2);
        list.show();

    }


    /**
     * 获得链表长度
     * @param s
     * @return
     */
    public static int getLength(SingleLinkedList s){
        if(s.getHeadNode() == null){
            return 0;
        }
        int count = 0;
        HeroNode curr = s.getHeadNode();
        while(curr.next != null){
            count ++;
            curr = curr.next;
        }
        return count;
    }

    /**
     * 获取倒数第index个节点
     * @param s
     * @param index
     * @return
     */
    public static HeroNode getLastIndex(SingleLinkedList s,int index){
        if(s.getHeadNode().next == null){
            System.out.println("链表为空");
            return null;
        }
        //指向第一个节点
        HeroNode curr = s.getHeadNode().next;
        int size = getLength(s);
        if(index>size || index<=0){
            return null;
        }
        for(int i=0;i<size-index;i++){
            curr = curr.next;
        }
        return curr;

    }

    /**
     * 单链表反转
     * @param s
     */
    public static void reverse(SingleLinkedList s){
        if(s.getHeadNode().next == null || s.getHeadNode().next.next == null){
            //当链表为空或者只有1个节点时,不需要反转
            return;
        }
        //指向当前节点,初始值是第一个节点
        HeroNode cur = s.getHeadNode().next;
        //指向当前节点下一个节点
        HeroNode nextNode = null;
        //反转时暂用的链表头
        HeroNode reverseHead = new HeroNode(0,null,null);
        while(cur != null){
            nextNode = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = nextNode;
        }
        //将原链表头指向反转后的链表
        s.getHeadNode().next = reverseHead.next;
    }

    /**
     * 逆序打印单链表(利用栈,不改变链表结构)
     * @param s
     */
    public static void reversePrint(SingleLinkedList s){
        if(s.getHeadNode().next == null) {
            return;
        }
        HeroNode cur = s.getHeadNode().next;
        Stack<HeroNode> stack = new Stack<>();
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while(stack.size()>0 ){
            System.out.println(stack.pop());
        }
    }


    public static SingleLinkedList mergeTwo(SingleLinkedList s1,SingleLinkedList s2){
        if(s1.getHeadNode().next == null){
            return s2;
        }
        if(s2.getHeadNode().next == null){
            return s1;
        }
        SingleLinkedList result = new SingleLinkedList();
        HeroNode tailNode = result.getHeadNode();
        HeroNode node1 = s1.getHeadNode().next;
        HeroNode node2 = s2.getHeadNode().next;
        while(node1!=null && node2!=null){
            if(node1.no <= node2.no){
                //链表尾部节点指向
                tailNode.next=node1;
                //链表尾部节点更新
                tailNode = node1;
                //指向下一个
                node1 = node1.next;
            }else{
                tailNode.next=node2;
                tailNode = node2;
                node2 = node2.next;
            }
        }
        if(node1 != null){
            tailNode.next=node1;
        }else{
            tailNode.next=node2;
        }
        return result;
    }

}




