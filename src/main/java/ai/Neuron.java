package ai;

import ai.math.ActivationFunction;

public class Neuron {

    private double outputData;

    private double[] outputSynapsesWeights;

    public Neuron(double inputData, double[] outputSynapsesWeights) {
        this.outputData = ActivationFunction.hyperbolicTangent(inputData);
        this.outputSynapsesWeights = outputSynapsesWeights;
    }

    public double getOutputData() {
        return outputData;
    }

    public void setOutputData(double outputData) {
        this.outputData = outputData;
    }

    public double[] getOutputSynapsesWeights() {
        return outputSynapsesWeights;
    }

    public void setOutputSynapsesWeights(double[] outputSynapsesWeights) {
        this.outputSynapsesWeights = outputSynapsesWeights;
    }
}