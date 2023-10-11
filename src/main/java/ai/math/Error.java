package ai.math;

import ai.Neuron;

public class Error {

    public static double find(Neuron[] outputLayer, int[] expectedResult) {
        double error = 0;
//                 (i - a)^2 + ... + (i - a)^2         where: i - ideal output data
//        Error = ----------------------------                a - actual output data
//                              n                             n - count of output neurons (data)
        for (int i = 0; i < outputLayer.length; i++) {
            error = error + Math.pow((expectedResult[i] - outputLayer[i].getOutputData()), 2);
        }
        return error / outputLayer.length;
    }
}