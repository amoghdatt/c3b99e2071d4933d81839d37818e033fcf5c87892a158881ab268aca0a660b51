package family;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import family.exceptions.MemberNotFoundException;

public class FamilyTest {

    private Family shanFamily;

    @Before
    public void createNewFamily() {
        shanFamily = new Family("Shan");
    }

    @Test
    public void testAddNewFamilyMember() {
        FamilyMember chit = new FamilyMember("Chit", "Male", null, null);
        shanFamily.addNewFamilyMember("Chit", chit);

        assertTrue(shanFamily.isMember("Chit"));
    }

    @Test
    public void testGetFamilyHead() {
        assertEquals(shanFamily.getFamilyHead(), "Shan");
    }

    @Test
    public void testExceptionIsThrownIfMemberNotPartOfFamily() {
        try {
            shanFamily.validateMembership("Anga");
        } catch (MemberNotFoundException e) {
            assertEquals(e.getMessage(), "Member not part of the family");
        }
    }
}
