package nn;
import tensor.*;
public class ReLU extends Module {
  @Override
    public Tensor forward(Tensor input) {
        double[] inputData = input.getData();
        double[] outputData = new double[inputData.length];

        for(int i = 0; i < inputData.length; i++) {
            outputData[i] = Math.max(0, inputData[i]);
        }
        return new Tensor(outputData, input.getShape());
    }
}
