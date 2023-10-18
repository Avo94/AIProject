import ai.NeuralNetwork;

public class Main {

    public static void main(String[] args) {
        int[] layers = new int[]{3, 5, 8, 1};      //layer architecture
        int epochs = 200;                      //number of training cycles
        double learningRate = 0.03;             //weight correction factor
        double momentum = 0.01;              //local minimum avoidance factor

        NeuralNetwork ai = new NeuralNetwork(layers, epochs, learningRate, momentum);
        ai.run();
    }
}