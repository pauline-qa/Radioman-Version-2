package ru.netology;

public class Radio {

    private int currentStation;
    private int maxStation = 9;
    private int minStation = 0;
    private int currentVolume;
    private int maxVolume = 100;
    private int minVolume = 0;
    private int stationNumber = 10;

    // конструктор с 1 параметром (задать столько станций, сколько хотим)

    public Radio (int variableStationNumber) {
        stationNumber = variableStationNumber;
        maxStation = stationNumber - 1;
    }

    // дефолтный конструктор
    public Radio() {
    }

    // конструкторы для переключения станций
    public Radio (int currentStation, int stationNumber, int currentVolume) {
        this.currentStation = currentStation;
        this.stationNumber = stationNumber;
        this.currentVolume = currentVolume;
        maxStation = stationNumber - 1;
    }

    public Radio (int currentStation, int currentVolume) {
        this.currentStation = currentStation;
        this.currentVolume = currentVolume;
    }
    //

    public int getCurrentStation() {
        return currentStation;
    }

    public int getMinStation() {
        return minStation;
    }

    public int getMaxStation() {
        return maxStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public int getStationNumber () { return stationNumber; }

    public void setNextStation() {
        int newNextStation = 0;
        if (currentStation == maxStation) {
            newNextStation = minStation;
        }
        if (currentStation < maxStation) {
            newNextStation = currentStation + 1;
        }
        this.currentStation = newNextStation;
    }

    public void setPreviousStation() {
        int newPreviousStation = 0;
        if (currentStation == minStation) {
            newPreviousStation = maxStation;
        }
        if (currentStation > minStation) {
            newPreviousStation = currentStation - 1;
        }
        this.currentStation = newPreviousStation;
    }

    public void setStation(int newStation) {
        if (newStation > maxStation || newStation < minStation) {
            return;
        }
        this.currentStation = newStation;
    }

    public void setIncreaseVolume() {
        int getCurrentVolume;
        int newIncreaseVolume = 0;
        if (currentVolume == maxVolume)
            newIncreaseVolume = maxVolume;
        if (currentVolume < maxVolume) {
            newIncreaseVolume = currentVolume + 1;
        }
        this.currentVolume = newIncreaseVolume;
    }

    public void setDecreaseVolume() {
        int getCurrentVolume;
        int newDecreaseVolume = 0;
        if (currentVolume == minVolume) {
            newDecreaseVolume = minVolume;
        }
        if (currentVolume > minVolume) {
            newDecreaseVolume = currentVolume - 1;
        }
        this.currentVolume = newDecreaseVolume;
    }

    public void setVolume(int newVolume) {
        if (newVolume > maxVolume) {
            newVolume = maxVolume;
        }
        if (newVolume < minVolume) {
            newVolume = minVolume;
        }
        this.currentVolume = newVolume;
    }
}