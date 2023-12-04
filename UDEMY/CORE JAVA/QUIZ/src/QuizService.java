import java.util.*;

public class QuizService {

    Question[] question = new Question[2];
    String[] answer=new String[]{"1","2","4","8"};
    
    //String s;
   
    public QuizService(){
    question[0] = new Question(1, "what is the size of int?", answer, "4");
    question[1] = new Question(1, "what is the size of int?", answer, "4");
}

public void showdetails(){
for(Question q : question){
   // System.out.println(q);
   System.out.println("question no: "+ q.getId());
    System.out.println("question: " + q.getQuestion());
    for(int i=0;i<answer.length;i++){
        System.out.print(answer[i]+ " ");
    }
    //System.out.println();
    Scanner sc = new Scanner(System.in);
    String s=sc.nextLine();
    System.out.println(s.equals(q.getAnswer()));
}
}
}
