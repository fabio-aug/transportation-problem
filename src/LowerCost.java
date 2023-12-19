import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class LowerCost {
    private int numberOfOrigins;
    private int numberOfDestinations;
    private int[] originCapacity;
    private int[] destinationDemand;
    private int[][] costMatrix;
    private int[][] resultMatrix;

    public LowerCost(String fileName) {
        readFile(fileName);
    }

    public void readFile(String fileName) {
        Scanner reader;
        try {
            reader = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
            e.printStackTrace();
            return;
        }

        this.numberOfOrigins = Integer.parseInt(reader.nextLine());
        this.numberOfDestinations = Integer.parseInt(reader.nextLine());

        String data = reader.nextLine();
        String[] numbers = data.split(" ");

        this.originCapacity = new int[this.numberOfOrigins];
        for (int i = 0; i < this.numberOfOrigins; i++) {
            originCapacity[i] = Integer.parseInt(numbers[i]);
        }

        data = reader.nextLine();
        numbers = data.split(" ");

        this.destinationDemand = new int[this.numberOfDestinations];
        for (int i = 0; i < this.numberOfDestinations; i++) {
            destinationDemand[i] = Integer.parseInt(numbers[i]);
        }

        this.costMatrix = new int[this.numberOfOrigins][this.numberOfDestinations];
        this.resultMatrix = new int[this.numberOfOrigins][this.numberOfDestinations];
        for (int i = 0; i < this.numberOfOrigins; i++) {
            data = reader.nextLine();
            numbers = data.split(" ");

            for (int j = 0; j < this.numberOfDestinations; j++) {
                this.costMatrix[i][j] = Integer.parseInt(numbers[j]);
                this.resultMatrix[i][j] = -1;
            }
        }

        reader.close();
    }

    public int[] getMinCost() {
        int[] index = new int[2];

        int value = 0;
        boolean isFirst = true;

        for (int i = 0; i < this.numberOfOrigins; i++) {
            for (int j = 0; j < this.numberOfDestinations; j++) {
                if (this.originCapacity[i] != 0 && this.destinationDemand[j] != 0) {
                    if (isFirst) {
                        value = this.costMatrix[i][j];
                        index[0] = i;
                        index[1] = j;

                        isFirst = false;
                    } else if (this.costMatrix[i][j] < value) {
                        value = this.costMatrix[i][j];
                        index[0] = i;
                        index[1] = j;
                    }
                }
            }
        }

        return index;
    }

    public void solve() {
        for (int i = 0; i < this.numberOfOrigins; i++) {
            for (int j = 0; j < this.numberOfDestinations; j++) {
                int[] index = getMinCost();
                if (originCapacity[index[0]] >= destinationDemand[index[1]]) {
                    this.resultMatrix[i][j] = destinationDemand[index[1]];
                    originCapacity[index[0]] -= destinationDemand[index[1]];
                    destinationDemand[index[1]] = 0;
                } else if (originCapacity[index[0]] < destinationDemand[index[1]]) {
                    this.resultMatrix[i][j] = destinationDemand[index[1]];
                    destinationDemand[index[1]] -= originCapacity[index[0]];
                    originCapacity[index[0]] = 0;
                }

                if (originCapacity[index[0]] == 0 && destinationDemand[index[1]] == 0) {
                    for (int k = 0; k < this.resultMatrix[0].length; k++)
                        if (k != index[1])
                            this.resultMatrix[index[0]][k] = 0;
                } else if (originCapacity[index[0]] == 0 && destinationDemand[index[1]] != 0) {
                    for (int k = 0; k < this.resultMatrix[0].length; k++)
                        if (k != index[1])
                            this.resultMatrix[index[0]][k] = 0;
                } else if (originCapacity[index[0]] != 0 && destinationDemand[index[1]] == 0) {
                    for (int k = 0; k < this.resultMatrix.length; k++)
                        if (k != index[0])
                            this.resultMatrix[k][index[1]] = 0;
                }
            }
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        String print = "";

        for (int i = 0; i < this.costMatrix.length; i++) {
            print += Arrays.toString(this.costMatrix[i]) + "\n";
        }

        print += "\n" + Arrays.toString(this.originCapacity);
        print += "\n" + Arrays.toString(this.destinationDemand) + "\n\n";

        for (int i = 0; i < this.resultMatrix.length; i++) {
            print += Arrays.toString(this.resultMatrix[i]) + "\n";
        }
        return print;
    }

    public static void main(String[] args) {
        LowerCost lowerCost = new LowerCost("input.txt");
        lowerCost.solve();
    }
}
