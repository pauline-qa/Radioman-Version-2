package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void setNextStation() {
        Radio rad = new Radio();
        rad.setStation(3);
        rad.setNextStation();
        int actual = rad.getCurrentStation();
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void setPreviousStation() {
        Radio rad = new Radio();
        rad.setStation(7);
        rad.setPreviousStation();
        int expected = 6;
        int actual = rad.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetStationAboveMax() {
        Radio rad = new Radio();
        int expected = rad.getCurrentStation();
        rad.setStation(rad.getMaxStation() + 100);
        int actual = rad.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetStationBelowMin() {
        Radio rad = new Radio();
        int expected = rad.getCurrentStation();
        rad.setStation(rad.getMinStation() - 15);
        int actual = rad.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void setStationAboveMaxStation() {
        Radio rad = new Radio();
        rad.setStation(9);
        rad.setNextStation();
        int actual = rad.getCurrentStation();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void setStationBelowMinStation() {
        Radio rad = new Radio();
        rad.setStation(0);
        rad.setPreviousStation();
        int actual = rad.getCurrentStation();
        int expected = 9;
        assertEquals(expected, actual);
    }

    @Test
    void setIncreaseVolume() {
        Radio rad = new Radio();
        rad.setVolume(3);
        rad.setIncreaseVolume();
        int actual = rad.getCurrentVolume();
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void setDecreaseVolume() {
        Radio rad = new Radio();
        rad.setVolume(7);
        rad.setDecreaseVolume();
        int expected = 6;
        int actual = rad.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void setVolumeAboveMaxVolume() {
        Radio rad = new Radio();
        rad.setVolume(10);
        rad.setIncreaseVolume();
        int actual = rad.getCurrentVolume();
        int expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    void setVolumeBelowMinVolume() {
        Radio rad = new Radio();
        rad.setVolume(0);
        rad.setDecreaseVolume();
        int actual = rad.getCurrentStation();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetVolumeAboveMax() {
        Radio rad = new Radio();
        int expected = rad.getCurrentVolume();
        rad.setVolume(rad.getMaxVolume() + 100);
        int actual = rad.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSetVolumeBelowMin() {
        Radio rad = new Radio();
        int expected = rad.getCurrentVolume();
        rad.setVolume(rad.getMinVolume() - 100);
        int actual = rad.getCurrentVolume();
        assertEquals(expected, actual);
    }
}