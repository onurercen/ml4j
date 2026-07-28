package tensor;

import java.util.Arrays;

public class Tensor {

    private final double[] data;
    private final Shape shape;

    public Tensor(double[] data, Shape shape) {

        if (data == null || shape == null) {
            throw new IllegalArgumentException("Data and shape cannot be null.");
        }

        if (shape.size() != data.length) {
            throw new IllegalArgumentException(
                    "Data length (" + data.length + ") does not match shape size (" + shape.size() + ").");
        }

        this.data = data;
        this.shape = shape;
    }

    public double[] getData() {
        return data;
    }

    public Shape getShape() {
        return shape;
    }

    /* ===========================
       Element-wise Operations
       =========================== */

    public Tensor add(Tensor other) {

        checkSameShape(other);

        double[] result = new double[data.length];

        for (int i = 0; i < data.length; i++)
            result[i] = data[i] + other.data[i];

        return new Tensor(result, shape);
    }

    public Tensor sub(Tensor other) {

        checkSameShape(other);

        double[] result = new double[data.length];

        for (int i = 0; i < data.length; i++)
            result[i] = data[i] - other.data[i];

        return new Tensor(result, shape);
    }

    public Tensor mul(Tensor other) {

        checkSameShape(other);

        double[] result = new double[data.length];

        for (int i = 0; i < data.length; i++)
            result[i] = data[i] * other.data[i];

        return new Tensor(result, shape);
    }

    /* ===========================
       Matrix Operations
       =========================== */

    public Tensor matmul(Tensor other) {

        if (shape.rank() != 2 || other.shape.rank() != 2) {
            throw new IllegalArgumentException("Both tensors must be 2D.");
        }

        int m = shape.get(0);
        int n = shape.get(1);
        int p = other.shape.get(1);

        if (n != other.shape.get(0)) {
            throw new IllegalArgumentException("Inner dimensions must match.");
        }

        double[] result = new double[m * p];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < p; j++) {

                double sum = 0;

                for (int k = 0; k < n; k++) {

                    sum += data[i * n + k]
                            * other.data[k * p + j];

                }

                result[i * p + j] = sum;
            }
        }

        return new Tensor(result, new Shape(m, p));
    }

    public Tensor transpose() {

        if (shape.rank() != 2)
            throw new IllegalArgumentException("Tensor must be 2D.");

        int rows = shape.get(0);
        int cols = shape.get(1);

        double[] result = new double[data.length];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                result[j * rows + i] = data[i * cols + j];

            }

        }

        return new Tensor(result, new Shape(cols, rows));
    }

    public Tensor reshape(int... dims) {

        Shape newShape = new Shape(dims);

        if (newShape.size() != data.length) {
            throw new IllegalArgumentException(
                    "New shape must contain the same number of elements.");
        }

        return new Tensor(data, newShape);
    }

    /* ===========================
       Factory Methods
       =========================== */

    public static Tensor zeros(int rows, int cols) {

        return new Tensor(
                new double[rows * cols],
                new Shape(rows, cols));
    }

    public static Tensor random(int rows, int cols) {

        double[] values = new double[rows * cols];

        for (int i = 0; i < values.length; i++)
            values[i] = Math.random();

        return new Tensor(values, new Shape(rows, cols));
    }

    /* ===========================
       Helper Methods
       =========================== */

    private void checkSameShape(Tensor other) {

        if (!shape.equals(other.shape)) {

            throw new IllegalArgumentException(
                    "Tensor shapes must be identical. Expected "
                            + shape + " but got " + other.shape);

        }

    }

    @Override
    public String toString() {

        return "Tensor(shape=" + shape +
                ", data=" + Arrays.toString(data) + ")";

    }

}