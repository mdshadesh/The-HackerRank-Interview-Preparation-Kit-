import java.io.*;
public class Solution {
    static int prime(int x)
    {
        int k=1;
        if(x==1)
            k=0;
        else if(x==2)
            k=1;
        else if(x%2==0)
            k=0;
        else
        {
            for(int i=3;i*i<=x;i+=2)
           {
              if(x%i==0)
              {
                  k=0;
                  break;
              }
           }
        }
        return k;
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try
       {
             int p = Integer.parseInt(br.readLine());
            int i,j,k,l;
             for(i=0;i<p;i++)
             {
                 j = Integer.parseInt(br.readLine()); 
                 k = prime(j);
                 if(k==1)
                     System.out.println("Prime");
                 else
                     System.out.println("Not prime");
             }
        }
        catch(IOException e)
            {
            System.out.println(e);
        }
    }
}