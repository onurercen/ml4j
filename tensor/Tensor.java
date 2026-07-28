package tensor;
public class Tensor {
    // Class implementation goes here
    private double[] data;
    private int[] shape;

    public Tensor(double[] data, int[] shape) {
        this.data = data;
        this.shape = shape;
    }

    public Tensor add(Tensor other){
        // Implementation for adding two tensors
        if (!java.util.Arrays.equals(this.shape, other.shape)) {
            throw new IllegalArgumentException("Shapes of tensors must be the same for addition.");
        }
        // Perform element-wise addition
        double[] resultData = new double[this.data.length];
        for (int i = 0; i < this.data.length; i++) {
            resultData[i] = this.data[i] + other.data[i];
        }
        return new Tensor(resultData, this.shape);
    }

    public Tensor sub(Tensor other){
        // Implementation for subtracting one tensor from another
        if(!java.util.Arrays.equals(this.shape,other.shape)){
            throw new IllegalArgumentException("Shapes of tensors must be the same for subtraction");
        }
        // Perform element-wise subtraction
        double[] resultData = new double[this.data.length];
        for (int i = 0; i < this.data.length; i++) {
            resultData[i] = this.data[i] - other.data[i];
        }
        return new Tensor(resultData, this.shape);
    }
}