public class DataClean implements IDataClean{
    public DataClean(double[][] inputData) {
        inputData = inputData;
    }

    public void editCellVal(double[][] dataSet, int i, int j, double n) {
        dataSet[i][j] = n;
    } 

    public double[][] deleteRow(double[][] dataSet, int x) {
        double[][] = newData = new double[dataSet.length-1][inputData[0].length];
        for (int i=0; i<dataSet.length; i++) {
            for (int j=0; j<dataSet[0].length; j++) {
                if i != x {
                    i < x ? newData[i][j] = inputdataSetData[i][j] : newData[i][j] = dataSet[i+1][j];
                }
            }
        }
    }

    public void deleteColumn(double[][] dataSet, int x) {
        double[][] = newData = new double[dataSet.length-1][dataSet[0].length];
        for (int i=0; i<dataSet.length; i++) {
            for (int j=0; j<dataSet[0].length; j++) {
                if i != x {
                    j < x ? newData[i][j] = dataSet[i][j] : newData[i][j] = dataSet[i][j+1];
                }
            }
        }
    }

    @Override
    public void toDense(double[][] dataSet) {
        int count=0;
        for int i=0; i<dataSet.length; i++ {
            for int j=0; j<dataSet[0].length; j++ {
                if dataSet[i][j] == 0 {
                    ++count;
                }
            }
        }

        double[] averageOnRows = average(dataSet);

        //define sparse matrix as having at least more than half elements as zero
        if count >= dataSet.length*dataSet[0].length*0.5 {
            for int i=0; i<dataSet.length; i++ {            
                for int j=0; j<dataSet[0].length; j++ {
                    if dataSet[i][j] == 0 {
                        dataSet[i][j] = averageOnRows[i];
                    }
                }
            }
        }

    }

    @Override
    public double[] average(double[][] dataSet) {
        double[] averageOnRows = new double[dataSet.length];
        for int i=0; i<dataSet.length; i++ {
            double sumRow = 0.0;
            for int j=0; j<dataSet[0].length; j++ {
                sumRow = sumRow + dataSet[i][j]; 
            }
            averageOnRows[i] = sumRow/dataSet[0].length;
        }
        
        return averageOnRows;
    } 


    

}