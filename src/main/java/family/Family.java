package family;

import java.util.*;
import family.exceptions.MemberNotFoundException;

/**
 * The family class. We can use this class to create new families
 * 
 */
public class Family {

    // store all members of the family in this hashmap. Makes it easy to access using names of the members.
    private HashMap<String, FamilyMember> familyMembers = null;
    private String familyHead = null;

    public Family(String familyHead){

        this.familyHead = familyHead;
        this.familyMembers = new HashMap<>();

    }

    /**
    * This method registers new members to the family.
    * @param name Name of family member
    * @param member FamilyMember object that will become part of the family
    * @return Nothing
    */
    public void addNewFamilyMember(String name, FamilyMember member){
        familyMembers.put(name, member);

    }

    /**
    * This method is used to validate memebership of a person with this family.
    * @param memberName Name of family person to validate
    * @exception MemberNotFoundException thrown if the person is not part of the family
    * @return Nothing
    */
    public void validateMembership(String memberName)throws MemberNotFoundException{

        if(!familyMembers.containsKey(memberName)) {
            throw new MemberNotFoundException("Member not part of the family");
        }
    }

    /**
    * This method is used to check whether a person is part of the family.
    * @param memberName Name of family person to check
    * @return boolean true or false
    */
    public boolean isMember(String memberName){
        return familyMembers.containsKey(memberName);
    }

    /**
    * This method is used to get the head of the family.
    * @param nothing
    * @return familyHead Name of the head of the family.
    */
    public String getFamilyHead(){
        return familyHead;
    }

    /**
    * This method is used to get all the members of the family.
    * @param nothing
    * @return familyMembers all of the members of the family.
    */
    public HashMap<String, FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

}
