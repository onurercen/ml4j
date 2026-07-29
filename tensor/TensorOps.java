package tensor;

public final class TensorOps {

    private TensorOps() {
        // Utility class
    }

    public static Tensor identity(int size) {

        double[] data = new double[size * size];

        for (int i = 0; i < size; i++) {
            data[i * size + i] = 1.0;
        }

        return new Tensor(data, new Shape(size, size));
    }

    public static Tensor ones(int rows, int cols) {

        double[] data = new double[rows * cols];

        for (int i = 0; i < data.length; i++) {
            data[i] = 1.0;
        }

        return new Tensor(data, new Shape(rows, cols));
    }

    public static Tensor fill(int rows, int cols, double value) {

        double[] data = new double[rows * cols];

        for (int i = 0; i < data.length; i++) {
            data[i] = value;
        }

        return new Tensor(data, new Shape(rows, cols));
    }

}