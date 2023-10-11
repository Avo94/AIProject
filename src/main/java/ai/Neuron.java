package ai;

import ai.math.NeuronActivationFunction;

public class Neuron {

    private double outputData;

    private double[] outputSynapsesWeights;

    private double delta;

    private double[] outputSynapsesGradients;

    public Neuron(double inputData, double[] outputSynapsesWeights) {
        this.outputData = NeuronActivationFunction.findHyperbolicTangent(inputData);
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

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public double[] getOutputSynapsesGradients() {
        return outputSynapsesGradients;
    }

    public void setOutputSynapsesGradients(double[] outputSynapsesGradients) {
        this.outputSynapsesGradients = outputSynapsesGradients;
    }
}