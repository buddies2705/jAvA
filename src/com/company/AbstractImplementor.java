package com.company;

/**
 * Created by root on 6/5/16.
 */
public class AbstractImplementor extends AbstractExperiment {
        static int p = AbstractExperiment.p;

        AbstractImplementor(int x)
        {
            p =x;
        }
        public void test()
        {
            System.out.println(p);
        }
}
