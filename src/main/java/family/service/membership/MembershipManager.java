package family.service.membership;

import java.util.ArrayList;

import family.Family;
import family.FamilyMember;
import family.exceptions.IllegalParentException;
import family.exceptions.InvalidGenderException;
import family.exceptions.MemberNotFoundException;
import family.service.Service;

/**
 * The Membership manager class is one stop location for all  membership related tasks of a family.
 * In This class we can find methods that handles and governs adding of a new member to the family
 * The class extends a Service class
 */
public class MembershipManager extends Service {

    public MembershipManager(Family family) {
        super(family);
    }

    /**
    * This method adds new child member to the family 
    * @param existingMemberName This is the name of the family member with whom we are establishing a new relationship
    * @param newMemberName  This is the name of the new family member that is being added to the family.
    * @param newMemberGender  gender of the new member
    * @param relation this determines how the new member is related to the existing member.
    */
    private void addChild(String existingMemberName, String newMemberName, String newMemberGender)
            throws MemberNotFoundException, InvalidGenderException, IllegalParentException {
        family.validateMembership(existingMemberName);
        FamilyMember mother = familyMembers.get(existingMemberName);

        // validte gender of the mother
        mother.validateGender("Female");
        mother.validateMarriage();

        // create new family member
        FamilyMember newMember = new FamilyMember(newMemberName, newMemberGender, mother.getSpouse(), mother);
        mother.addChild(newMember);

        // add new member to family
        family.addNewFamilyMember(newMemberName, newMember);
    }

    /**
    * This method adds a new spouse member to the family 
    * @param existingMemberName This is the name of the family member with whom we are establishing a new relationship
    * @param newMemberName  This is the name of the new family member that is being added to the family.
    * @param newMemberGender  gender of the new member
    * @param relation this determines how the new member is related to the existing member.
    */
    private void addSpouse(String existingMemberName, String newMemberName, String newMemberGender )
            throws InvalidGenderException, MemberNotFoundException {
        family.validateMembership(existingMemberName);
        FamilyMember existingMember = familyMembers.get(existingMemberName);
        existingMember.getGender();

        // check the gender of new spouse
        if(existingMember.getGender().equals(newMemberGender)){
            throw new InvalidGenderException("Spouses cannot be of the same gender");
        }

        // create new spouse
        FamilyMember newMember = new FamilyMember(newMemberName, newMemberGender, null, null);
        newMember.setSpouse(existingMember);
        existingMember.setSpouse(newMember);
        ArrayList<FamilyMember> children = new ArrayList<>();
        existingMember.setChildren(children);
        newMember.setChildren(children);

        // add new spouse to family
        family.addNewFamilyMember(newMemberName, newMember);
    }

    /**
    * This method manages all the tasks related to adding a member to the family
    * @param existingMemberName This is the name of the family member with whom we are establishing a new relationship
    * @param newMemberName  This is the name of the new family member that is being added to the family.
    * @param newMemberGender  gender of the new member
    * @param relation this determines how the new member is related to the existing member.
    */
    public void handleNewFamilyMember(String existingMemberName, String newMemberName, String newMemberGender,String relation) {
        FamilyMember newMember;
       
            switch(relation){

                case "NEW_MEMBER":
                    newMember = new FamilyMember(newMemberName, newMemberGender, null, null);
                    family.addNewFamilyMember(newMemberName, newMember);
                    break;
                case "CHILD":
                    try {
                        addChild(existingMemberName, newMemberName, newMemberGender);
                        System.out.println("CHILD_ADDITION_SUCCEEDED");
                    } catch (MemberNotFoundException e ) {
                        System.out.println("PERSON_NOT_FOUND");
                    } catch (IllegalParentException | InvalidGenderException e){
                        System.out.println("CHILD_ADDITION_FAILED");
                    }
                    break;
                case "SPOUSE":
                    try{
                        addSpouse(existingMemberName, newMemberName, newMemberGender);
                        System.out.println("SPOUSE_ADDITION_SUCCEDED");
                    }catch(InvalidGenderException | MemberNotFoundException e){
                        System.out.println("SPOUSE_ADDITION_FAILED");
                    }
                    break;    
            }

    }
    
}
