package tensor;

import java.util.Arrays;

public class Shape {

    private final int[] dims;

    public Shape(int... dims) {

        if (dims == null || dims.length == 0) {
            throw new IllegalArgumentException("Shape cannot be empty.");
        }

        for (int dim : dims) {
            if (dim <= 0) {
                throw new IllegalArgumentException("Dimensions must be positive.");
            }
        }

        this.dims = dims.clone();
    }

    public int[] getDims() {
        return dims.clone();
    }

    public int rank() {
        return dims.length;
    }

    public int get(int axis) {
        return dims[axis];
    }

    public int rows() {
        if (rank() != 2)
            throw new IllegalStateException("Tensor is not 2-dimensional.");
        return dims[0];
    }

    public int cols() {
        if (rank() != 2)
            throw new IllegalStateException("Tensor is not 2-dimensional.");
        return dims[1];
    }

    public int size() {
        int size = 1;

        for (int dim : dims)
            size *= dim;

        return size;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Shape))
            return false;

        Shape other = (Shape) obj;

        return Arrays.equals(dims, other.dims);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(dims);
    }

    @Override
    public String toString() {
        return Arrays.toString(dims);
    }

}