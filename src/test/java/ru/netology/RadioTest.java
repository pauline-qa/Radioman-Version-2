package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    // тест на то, что можно задать любое количество станций
    @Test
    void setAnyStation() {
        Radio rad = new Radio(80);
        rad.getStationNumber();
        assertEquals(80, rad.getStationNumber());
    }

    // тест на то, что если не задать никакую станцию, то будет по дефолту 10
    @Test
    void notSetAnyStation() {
        Radio rad = new Radio();
        rad.getStationNumber();
        assertEquals(10, rad.getStationNumber());
    }

    // тест на то, что что можно переключиться на следующую станцию, если она уже задана
    @Test
    void setNextStationWithDefinedStation() {
        Radio rad = new Radio(39, 100, 3);
        rad.setNextStation();
        int actual = rad.getCurrentStation();
        int expected = 40;
        assertEquals(expected, actual);
    }

    //тест на то, что можно переключиться на следующую станцию, если она дефолтная
    @Test
    void setNextStationWithDefaultStation() {
        Radio rad = new Radio(7, 6);
        rad.setNextStation();
        int actual = rad.getCurrentStation();
        int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    void setPreviousStationWithDefinedStation() {
        Radio rad = new Radio(39, 100, 3);
        rad.setPreviousStation();
        int actual = rad.getCurrentStation();
        int expected = 38;
        assertEquals(expected, actual);
    }

    @Test
    void setPreviousStationWithDefaultStation() {
        Radio rad = new Radio(7, 6);
        rad.setPreviousStation();
        int actual = rad.getCurrentStation();
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void setNextStationOnEdgeWithDefaultStation() {
        Radio rad = new Radio(9, 5);
        rad.setNextStation();
        int actual = rad.getCurrentStation();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void setNextStationOnEdgeWithDefinedStation() {
        Radio rad = new Radio(199, 200,3);
        rad.setNextStation();
        int actual = rad.getCurrentStation();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void setPreviousStationOnEdgeWithDefaultStation() {
        Radio rad = new Radio();
        rad.setPreviousStation();
        int actual = rad.getCurrentStation();
        int expected = 9;
        assertEquals(expected, actual);
    }

    @Test
    void setPreviousStationOnEdgeWithDefinedStation() {
        Radio rad = new Radio(0, 210, 5);
        rad.setPreviousStation();
        int actual = rad.getCurrentStation();
        int expected = 209;
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetStationAboveMaxWithDefinedStation() {
        Radio rad = new Radio(130,200,5);
        rad.setStation(rad.getMaxStation() + 100);
        int expected = rad.getCurrentStation();
        int actual = rad.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetStationAboveMaxWithDefaultStation() {
        Radio rad = new Radio();
        int SpecifiedStation = 5;
        rad.setStation(SpecifiedStation);
        int SetOutOfLimits = rad.getMaxStation() + 50;
        rad.setStation(SetOutOfLimits);
        int actual = rad.getCurrentStation();
        int expected = SpecifiedStation;
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetStationBelowMinWithDefaultStation() {
        Radio rad = new Radio();
        rad.setStation(rad.getMinStation() - 100);
        int actual = rad.getCurrentStation();
        int expected = rad.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetStationBelowMinWithDefinedStation() {
        Radio rad = new Radio(130,200,5);
        rad.setStation(rad.getMinStation() - 100);
        int actual = rad.getCurrentStation();
        int expected = rad.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void setIncreaseVolume() {
        Radio rad = new Radio(3,5);
        rad.setIncreaseVolume();
        int actual = rad.getCurrentVolume();
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void setDecreaseVolume() {
        Radio rad = new Radio(3,5);
        rad.setDecreaseVolume();
        int actual = rad.getCurrentVolume();
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void setVolumeAboveMaxVolume() {
        Radio rad = new Radio(2,100);
        rad.setIncreaseVolume();
        int actual = rad.getCurrentVolume();
        int expected = 100;
        assertEquals(expected, actual);
    }

    @Test
    void setVolumeBelowMinVolume() {
        Radio rad = new Radio(3,0);
        rad.setDecreaseVolume();
        int actual = rad.getCurrentVolume();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetVolumeAboveMax() {
        Radio rad = new Radio();
        rad.setVolume(rad.getMaxVolume() + 100);
        int expected = rad.getMaxVolume();
        int actual = rad.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetVolumeBelowMin() {
        Radio rad = new Radio();
        rad.setVolume(rad.getMinVolume() - 100);
        int expected = rad.getMinVolume();
        int actual = rad.getCurrentVolume();
        assertEquals(expected, actual);
    }
}