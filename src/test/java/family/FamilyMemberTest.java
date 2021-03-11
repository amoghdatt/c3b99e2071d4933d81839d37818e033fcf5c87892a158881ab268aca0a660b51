package family;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import family.exceptions.IllegalParentException;
import family.exceptions.InvalidGenderException;
import family.exceptions.MemberNotFoundException;
import family.exceptions.SiblingsNotFoundException;

public class FamilyMemberTest {

    private FamilyMember shan;
    private FamilyMember anga;
    private FamilyMember chit;

    @Before
    public void createFamilyMember(){
        shan = new FamilyMember("Shan", "Male", null, null);
        anga = new FamilyMember("Anga", "Female", null, null);
        chit = new FamilyMember("Chit", "Male", shan, anga);
    }

    @Test
    public void testNewFamilyMemberIsCreated() {
        FamilyMember shan = new FamilyMember("Shan", "Male", null, null);
        String name = "Shan";
        String gender = "Male";

        assertEquals(shan.getName(), name);
        assertEquals(shan.getGender(), gender);
    }

    @Test
    public void testFamilyMemberIsMarried() {
        shan.setSpouse(anga);

        assertTrue(shan.isMarried());
    }

    @Test
    public void testExceptionIsThrownForMember() {
        
        try {
            shan.validateMarriage();
        } catch (IllegalParentException e) {
            assertEquals(e.getMessage(), "Member not married");
        }

        try {
            shan.validateFather();
        } catch (MemberNotFoundException e) {
            assertEquals(e.getMessage(), "Father not found for Shan");
        }

        try {
            shan.validateMother();
        } catch (MemberNotFoundException e) {
            assertEquals(e.getMessage(), "Mother not found for Shan");
        }

        try {
            shan.validateGender("Female");
        } catch (InvalidGenderException e) {
            assertEquals(e.getMessage(), "Gender did not match");
        }

    }


    @Test
    public void testChildIsAddedToMarriedCouple(){
        shan.setSpouse(anga);
        ArrayList<FamilyMember> children = new ArrayList<>();
        shan.setChildren(children);
        anga.setChildren(children);
        shan.addChild(new FamilyMember("Chit", "Male", shan, anga));

        assertEquals(shan.getChildren(), children);
        assertEquals(anga.getChildren().get(0).getName(), "Chit");
    }

    @Test
    public void testExceptionIsRaisedIfSiblingsAreNotFound(){
        shan.setSpouse(anga);
        ArrayList<FamilyMember> children = new ArrayList<>();
        shan.setChildren(children);
        anga.setChildren(children);
        shan.addChild(chit);

        try {
            chit.validateSiblings();
        } catch (SiblingsNotFoundException e) {
            assertEquals(e.getMessage(), "Siblings not found for Chit");
        }
        
    }

}
