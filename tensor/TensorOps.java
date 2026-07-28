package tensor;

public class TensorOps {
    public static void main(String[] args) {
        // Example usage of Tensor class
        double[] data1 = {1.0, 2.0, 3.0, 4.0};
        int[] shape1 = {2, 2};
        Tensor tensor1 = new Tensor(data1, shape1);

        double[] data2 = {5.0, 6.0, 7.0, 8.0};
        int[] shape2 = {2, 2};
        Tensor tensor2 = new Tensor(data2, shape2);

        Tensor resultAdd = tensor1.add(tensor2);
        Tensor resultSub = tensor1.sub(tensor2);
        Tensor resultMul = tensor1.mul(tensor2);

        // Print results
        System.out.println("Addition Result: " + java.util.Arrays.toString(resultAdd.getData()));
        System.out.println("Subtraction Result: " + java.util.Arrays.toString(resultSub.getData()));
        System.out.println("Multiplication Result: " + java.util.Arrays.toString(resultMul.getData()));
    }
}
