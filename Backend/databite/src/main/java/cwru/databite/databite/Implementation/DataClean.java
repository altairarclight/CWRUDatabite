package cwru.databite.databite.Implementation;

import cwru.databite.databite.Interface.IDataClean;

public class DataClean implements IDataClean {
    public DataClean(double[][] inputData) {
        inputData = inputData;
    }

    public void editCellVal(double[][] dataSet, int i, int j, double n) {
        dataSet[i][j] = n;
    }

    public double[][] deleteRow(double[][] dataSet, int delete_row_index) {
        double[][] newData = new double[dataSet.length - 1][dataSet[0].length];
        for (int i = 0; i < dataSet.length; i++) {
            for (int j = 0; j < dataSet[0].length; j++) {
                if (i < delete_row_index) {
                    newData[i][j] = dataSet[i][j];
                } else if (i > delete_row_index) {
                    newData[i][j] = dataSet[i + 1][j];
                }
            }
        }
        return newData;
    }

    public double[][] deleteColumn(double[][] dataSet, int delete_col_index) {
        double[][] newData = new double[dataSet.length - 1][dataSet[0].length];
        for (int i = 0; i < dataSet.length; i++) {
            for (int j = 0; j < dataSet[0].length; j++) {
                if (j < delete_col_index) {
                    newData[i][j] = dataSet[i][j];
                } else if (j > delete_col_index) {
                    newData[i][j] = dataSet[i][j + 1];
                }
            }
        }
        return newData;
    }

    @Override
    public void toDense(double[][] dataSet) {
        int count = 0;
        for (int i = 0; i < dataSet.length; i++) {
            for (int j = 0; j < dataSet[0].length; j++) {
                if (dataSet[i][j] == 0) {
                    ++count;
                }
            }
        }

        double[] averageOnRows = average(dataSet);

        // define sparse matrix as having at least more than half elements as zero
        if (count >= dataSet.length * dataSet[0].length * 0.5) {
            for (int i = 0; i < dataSet.length; i++) {
                for (int j = 0; j < dataSet[0].length; j++) {
                    if (dataSet[i][j] == 0) {
                        dataSet[i][j] = averageOnRows[i];
                    }
                }
            }
        }

    }

    @Override
    public double[] average(double[][] dataSet) {
        double[] averageOnRows = new double[dataSet.length];
        for (int i = 0; i < dataSet.length; i++) {
            double sumRow = 0.0;
            for (int j = 0; j < dataSet[0].length; j++) {
                sumRow = sumRow + dataSet[i][j];
            }
            averageOnRows[i] = sumRow / dataSet[0].length;
        }

        return averageOnRows;
    }

}
