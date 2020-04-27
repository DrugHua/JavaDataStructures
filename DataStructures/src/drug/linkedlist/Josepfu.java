package drug.linkedlist;

/**
 * @author Drug
 * @create 2020-04-16 18:00
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.countBoy(1, 2, 5);
    }

}

class CircleSingleLinkedList{
    private Boy fist=null;

    public Boy getFist() {
        return fist;
    }

    //创建环形链表
    public void addBoy(int num){
        if(num < 1){
            System.out.println("输入的数据不正确");
        }
        Boy currBoy = null;
        for(int i=1;i<=num;i++){
            if(i==1){
                Boy boy = new Boy(i);
                fist = boy;
                fist.setNext(fist);
                currBoy = boy;
            }else{
                Boy boy = new Boy(i);
                currBoy.setNext(boy);
                boy.setNext(fist);
                currBoy = boy;
            }
        }
    }

    //遍历环形链表
    public void show(){
        if(fist == null){
            System.out.println("链表为空");
            return;
        }
        Boy currBoy = fist;

        while (true){
            System.out.println("当前编号的节点数据是:"+currBoy.getNo());
            if(currBoy.getNext() == fist){
                break;
            }
            currBoy = currBoy.getNext();
        }
    }

    //约瑟夫问题(依次出圈)
    public void countBoy(int startNo,int countNo,int nums){
        if(fist==null || startNo<1 || startNo>nums){
            System.out.println("输入有误");
            return;
        }
        Boy help = fist;
        //将help指向fist后一个
        while(true){
            if(help.getNext()==fist){
                break;
            }
            help = help.getNext();
        }
        for(int i=0;i<startNo-1;i++){
            fist = fist.getNext();
            help = help.getNext();
        }
        while(true){
            if(fist == help){
                break;
            }
            for(int i=0;i<countNo-1;i++){
                fist = fist.getNext();
                help = help.getNext();
            }
            System.out.println("本轮出圈孩子的编号是:"+fist.getNo());
            fist = fist.getNext();
            help.setNext(fist);
        }
        System.out.println("最后留下的孩子是:"+help.getNo());
    }

}

class Boy{
    private int no;
    private Boy next;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy getNext() {
        return next;
    }

    public Boy(int no){
        this.no = no;
    }
}
