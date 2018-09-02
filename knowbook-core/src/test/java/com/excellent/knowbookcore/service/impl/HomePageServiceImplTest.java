package com.excellent.knowbookcore.service.impl;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by 高楚杭 on 2018/8/8.
 */
public class HomePageServiceImplTest {
    @Test
    public void myPageBookList() throws Exception {

        ArrayList<Integer> arrayList=new ArrayList();
        for(int i=0;i<2;i++){
            int d=0;
            do {
                Random rand =new Random();
                d=rand.nextInt(4)+1;
            }
            while (arrayList.contains(d));
            arrayList.add(d);
        }

        for (Integer i:arrayList) {

            System.out.println(i);
        }


    }

}