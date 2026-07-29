package examples;

import tensor.*;

public class TensorTest {

    public static void main(String[] args) {

        Tensor a = TensorOps.ones(2, 2);

        Tensor b = TensorOps.identity(2);

        Tensor c = a.matmul(b);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }

}