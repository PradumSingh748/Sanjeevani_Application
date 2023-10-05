/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevani.gui;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pradu
 */
public class persistenceQuestion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter first input");
        int N=sc.nextInt();
        System.out.println("Enter "+N+"elements");
        int arr[]=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter third input");
        int size=sc.nextInt();
        
        
        ArrayList<Integer>result=new ArrayList<>();
        int a=0;
        while(a<=arr.length-size){
            ArrayList<Integer>list=new ArrayList<>();
        
                for(int i=a;i<a+size;i++){
                    list.add(arr[i]);
                }
                System.out.println("ArrayList is "+list);
                boolean isNegative=false;
                for(int x:list){
                    if(x<0 && isNegative==false){
                        result.add(x);
                        isNegative=true;
                    }
                }
                if(!isNegative) result.add(0);
                a++;
        }
        System.out.println("Output:\n"+result);
    }
}
