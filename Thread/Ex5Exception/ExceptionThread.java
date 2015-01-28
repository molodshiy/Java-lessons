public class ExceptionThread extends Thread{
    @Override
    public void run(){
    
        boolean flag = true;
        
        if(flag){
            throw new RuntimeException();
        } else {
            System.out.println("end of ExceptionThread");
        }
    }
}
