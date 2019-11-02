package by.epam.programming_with_classes.decimal_counter.objects;

public class Counter {

    private int value;
    private int minValue;
    private int maxValue;

    public Counter() {
        this.minValue = 0;
        this.maxValue = 10;
        this.value = 0;
    }

    public Counter(int minValue, int maxValue, int value) {
        this.minValue = minValue < maxValue ? minValue : maxValue;
        this.maxValue = minValue < maxValue ? maxValue : minValue;
        setValue(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value > maxValue) {
            this.value = maxValue;
        } else if (value < minValue){
            this.value = minValue;
        } else {
            this.value = value;
        }
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public void increase(){
        int value = this.getValue() + 1;
        setValue(value);
    }

    public void decrease(){
        int value = getValue() - 1;
        setValue(value);
    }

    public String info(){

        return  (String.format("мин %s, макс %s, текущее значение %s", getMinValue(), getMaxValue(), getValue()));
    }
}
