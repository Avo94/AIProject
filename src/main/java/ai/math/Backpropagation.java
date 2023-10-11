package ai.math;

import ai.Neuron;

public class Backpropagation {

    public static double calculateError(Neuron[] outputLayer, int[] expectedResult) {
        double error = 0;
//                 (i - a)^2 + ... + (i - a)^2         where: i - ideal output data
//        Error = ----------------------------                a - actual output data
//                              n                             n - count of output neurons (data)
        for (int i = 0; i < outputLayer.length; i++) {
            error = error + Math.pow((expectedResult[i] - outputLayer[i].getOutputData()), 2);
        }
        return error / outputLayer.length;
    }

    public static double sigmoid(Neuron[] outputLayer, int[] expectedResult) {  // use only for output neuron
        double outputData = outputLayer[0].getOutputData();
//      delta = (i - a) * ((1 - a) * a)
        return (expectedResult[0] - outputData) * ((1 - outputData) * outputData);
    }

    public static double hyperbolicTangent(Neuron[] outputLayer, int[] expectedResult) {    // use only for output neuron
        double outputData = outputLayer[0].getOutputData();
//      delta = (i - a) * (1 - a^2)
        return (expectedResult[0] - outputData) * (1 - Math.pow(outputData, 2));
    }
}