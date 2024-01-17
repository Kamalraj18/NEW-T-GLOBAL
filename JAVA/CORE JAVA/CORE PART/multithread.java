//static synchronized block used for static synchronisation
class brackets{
   synchronized public static void show(){
        for(int i=0;i<=20;i++){
            if(i<10){
            System.out.print("[");
        }
        else{
            System.out.print("]");
        }
    }
    System.out.println();

}
    }


public class multithread{
    public static void main(String[] args) throws InterruptedException {
        brackets b = new brackets();
      new Thread(new Runnable() {
        public void run(){
        for(int i=0;i<5;i++){
            try{
            Thread.sleep(500);}
            catch(InterruptedException e){
                System.out.println(e);
            }
            b.show();
        }
    }
      }).start();

       new Thread(new Runnable() {
        public void run(){
        for(int i=0;i<10;i++){
            try{
            Thread.sleep(500);}
            catch(InterruptedException e){
                System.out.println(e);
            }
            b.show();
        }
    }
      }).start();


    }
}
//this is purely anonomous no garbage collected