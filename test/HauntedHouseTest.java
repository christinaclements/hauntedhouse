import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HauntedHouseTest {

    static HauntedHouse house;

    @BeforeEach
    void setUp() {
        house = new HauntedHouse();
    }

    @Test
    void isGhostPresentTest() {
        boolean presence = house.isGhostPresent();
        assertTrue(presence);
    }

    @Test
    void scareAwayGhostTest() {
        boolean presence = house.isGhostPresent();
        assertTrue(presence);
        house.scareAwayGhost();
        presence = house.isGhostPresent();
        assertFalse(presence);
    }

    @Test
    void scareAwayGhostTestWhenNoGhost() {
        scareAwayGhostTest();
        house.scareAwayGhost();
        boolean presence = house.isGhostPresent();
        assertFalse(presence);
    }

    @Test
    void refillCandyBowlTestPos() {
        assertEquals(10, house.getCandyCount());
        house.refillCandyBowl(10);
        assertEquals(20, house.getCandyCount());
    }

    @Test
    void refillCandyBowlTestNeg() {
        assertEquals(10, house.getCandyCount());
        house.refillCandyBowl(-10);
        assertEquals(10, house.getCandyCount());
    }

    @Test
    void trickOrTreatTest() {
        house.trickOrTreat(5);
        assertEquals(5, house.getCandyCount());
    }

    @Test
    void trickOrTreatTestTooManyPeople() {
        house.trickOrTreat(15);
        assertEquals(10, house.getCandyCount());
    }


    @Test
    void trickOrTreatTestNegativePeople() {
        house.trickOrTreat(-5);
        assertEquals(10, house.getCandyCount());
    }

    @Test
    void getCandyCountTest() {
        assertEquals(10, house.getCandyCount());
    }

    @Test
    void runningLowTest() {
        house.trickOrTreat(10);
        assertEquals(10, house.getCandyCount());
    }

    @Test
    void runningLowTestNotEmpty() {
        house.trickOrTreat(5);
        house.runningLow();
        assertEquals(5, house.getCandyCount());
    }

    @Test
    void spookySoundTest() {
        assertEquals("Boo!", house.spookySound());
    }

    @Test
    void hauntingTest() {
        house.scareAwayGhost();
        house.haunting();
        assertTrue(house.isGhostPresent());
    }

    @Test
    void hauntingTestWithGhost() {
        house.haunting();
        assertTrue(house.isGhostPresent());
    }
}