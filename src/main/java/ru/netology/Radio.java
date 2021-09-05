package ru.netology;

public class Radio {

    private int currentStation;
    private int maxStation = 9;
    private int minStation = 0;

    public int getCurrentStation() {
        return currentStation;
    }

    public int getMinStation() {
        return minStation;
    }

    public int getMaxStation() {
        return maxStation;
    }

    public void setNextStation(int currentStation) {
        int newNextStation = 0;
        if (currentStation == maxStation) {
            newNextStation = minStation;
        }
        if (currentStation < maxStation) {
            newNextStation = currentStation + 1;
        }
        this.currentStation = newNextStation;
    }

    public void setPreviousStation(int currentStation) {
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
        if (newStation > maxStation) {
            return;
        }
        if (newStation < minStation) {
            return;
        }
        this.currentStation = newStation;
    }


    private int currentVolume;
    private int maxVolume = 10;
    private int minVolume = 0;

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public void setIncreaseVolume(int currentVolume) {
        int newIncreaseVolume = 0;
        {
            if (currentVolume == maxVolume)
                newIncreaseVolume = maxVolume;
        }
        if (currentVolume < maxVolume) {
            newIncreaseVolume = currentVolume + 1;
        }
        this.currentVolume = newIncreaseVolume;
    }

    public void setDecreaseVolume(int currentVolume) {
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
            return;
        }
        if (newVolume < minVolume) {
            return;
        }
        this.currentVolume = newVolume;
    }
}
