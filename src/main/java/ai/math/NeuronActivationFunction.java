package ai.math;

public class NeuronActivationFunction {

    private static final double eulerNumber = 2.7182818284590;

    public static double findSigmoid(double inputData) {
//               1
//    f(x) = ----------
//            1 + e^-x
        return 1 / (1 + (1 / (Math.pow(eulerNumber, inputData))));
    }

    public static double findHyperbolicTangent(double inputData) {
//            e^2x - 1
//    f(x) = ----------
//            e^2x + 1
        return (Math.pow(eulerNumber, (2 * inputData)) - 1) / Math.pow(eulerNumber, (2 * inputData) + 1);
    }
}