package family.service.relationship;

import java.util.ArrayList;

import family.FamilyMember;

public class SisterInLaw extends Relationship {

    @Override
    public ArrayList<String> getPeople(FamilyMember member) {
        ArrayList<FamilyMember> siblings = member.getSiblings();
        ArrayList<FamilyMember> siblingsOfSpouse = null;
        FamilyMember spouse = null;

        // check if member is married
        if(member.isMarried()){
            spouse = member.getSpouse();
            // fetch siblings of spouses
            siblingsOfSpouse = spouse.getSiblings();
        }

        if(siblings == null && siblingsOfSpouse == null)
           return null;

        // call print manager to print
        ArrayList<String> combinedArray = new ArrayList<>();
        if(siblings != null) {
            combinedArray = getAllSpousesOfMembersBasedOnGender(siblings, "Female");
        }
        if(siblingsOfSpouse != null){
            combinedArray.addAll(getAllMembersFromArrayBasedOnNameAndGender(siblingsOfSpouse, spouse.getName(), "Female"));
        }


        return combinedArray;
    }
    
}
