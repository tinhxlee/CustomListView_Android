import java.util.Random;
  
public class RandomNumberClass {
  
    public static void main(String[] args) {
          
         Random generateRand = new Random();
           
         System.out.println("Generate random numbers:");
         for(int i=0; i<3; i++){
              System.out.printf("%d ",generateRand.nextInt());
              System.out.println(" "+generateRand.nextDouble());
         } 
  
         //set ranges
         Random generateRange = new Random();
           
         System.out.println("\nGenerate random int [1,10] and double [0.0,360.0):");
         // by default, nextInt(int bound) returns pseudorandom int value between 0 (inclusive) and specified bound value (exclusive)
         for(int i=0; i<5; i++) {
             int num = generateRange.nextInt(10)+1;
             double angle = generateRange.nextDouble()*360.0;
             System.out.println(" num = "+num+" and angle = "+angle);
         }
           
         Random generateGaus = new Random();
         System.out.println("\nGaussian random =  "+generateGaus.nextGaussian()+"\n"); 
           
         Random seed1 = new Random(5);
         for(int i=0; i<3; i++) {
            System.out.println("seed1 = "+seed1.nextInt()); 
         }
         System.out.println("--------------------");
         Random seed2 = new Random(5);
         for(int i=0; i<3; i++) {
            System.out.println("seed2 = "+seed2.nextInt()); 
         }
    }
}
