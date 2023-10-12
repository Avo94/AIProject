import ai.NeuralNetwork;

public class Main {

    public static void main(String[] args) {
        int[] layers = new int[]{3, 5, 8, 1};      //layer architecture
        int epochs = 1000;                      //number of training cycles
        double learningRate = 0.3;             //weight correction factor
        double momentum = 0.1;              //local minimum avoidance factor

        NeuralNetwork ai = new NeuralNetwork(layers, epochs, learningRate, momentum);
        ai.run();
    }
}