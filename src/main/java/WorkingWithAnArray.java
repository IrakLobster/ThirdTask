public class WorkingWithAnArray {

    int arraySize;
    int maxElement;
    int minElement;

    public WorkingWithAnArray(int arraySize, int maxElement, int minElement){
        this.arraySize = arraySize;
        this.maxElement = maxElement;
        this.minElement = minElement;
    }

    public static void main(String[] args) {

        WorkingWithAnArray w = new WorkingWithAnArray(10,10,-10);
        w.getTextResult();
    }

    private int[] getArray(){
        int[] array = new int[arraySize];
        for(int i = 0; i < arraySize - 1; i++){
            array[i] = (int)(Math.random() * (maxElement - minElement)) + minElement;
        }

        return array;
    }

    private String getMinMaxElement(int[] array){
        int minPositiveElement = maxElement + 1;
        int minPositiveIndex = 0;
        int maxNegativeElement = minElement - 1;
        int maxNegativeElementIndex = 0;

        for (int i = 0; i < arraySize - 1; i++){
            if(array[i] > maxNegativeElement && array[i] < 0){
                maxNegativeElement = array[i];
                maxNegativeElementIndex = i;
            }
            else if(array[i] < minPositiveElement && array[i] > 0){
                minPositiveElement = array[i];
                minPositiveIndex = i;
            }
        }

        String result = minPositiveElement + " " + minPositiveIndex + " " + maxNegativeElement + " " + maxNegativeElementIndex;

        return result;
    }

    private int[] swapElements(int[] array, int firstIndex, int secondIndex){
        int firstElement = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = firstElement;

        return array;
    }

    public void getTextResult(){
        int[] array = getArray();
        String s = getMinMaxElement(array);
        String[] parseResult = s.split(" ");

        int minPositiveElement = Integer.parseInt(parseResult[0]);
        int minPositiveIndex = Integer.parseInt(parseResult[1]);
        int maxNegativeElement = Integer.parseInt(parseResult[2]);
        int maxNegativeElementIndex = Integer.parseInt(parseResult[3]);
        for(int element : array) System.out.print(element + " ");
        System.out.println("");

        if(minPositiveElement == maxElement + 1 && maxNegativeElement != minElement - 1) System.out.println("Минимальный положительный элемент не найден. Максимальный отрицательный элемент = " + maxNegativeElement);
        else if (minPositiveElement != maxElement + 1 && maxNegativeElement == minElement - 1) System.out.println("Максимальный отрицательный элемент не найден. Минимальный положительный элемент = " + minPositiveElement);
        else if (minPositiveElement == maxElement + 1 && maxNegativeElement == minElement - 1) System.out.println("Массив состоит из нулей!");
        else {
            System.out.println("Максимальный отрицательный элемент = " + maxNegativeElement + '\n' + "Минимальный положительный элемент = " + minPositiveElement);
            System.out.println("Массив до перестановки элементов: ");
            for(int element : array) System.out.print(element + " ");
            System.out.println('\n' + "Массив после перестановки значений: ");
            for(int element : swapElements(array, minPositiveIndex, maxNegativeElementIndex)) System.out.print(element + " ");

        }

    }
}
