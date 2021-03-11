package family.service.relationship;

import java.util.ArrayList;

import family.FamilyMember;

public class MaternalUncle extends Relationship {

    @Override
    public ArrayList<String> getPeople(FamilyMember member) {
        FamilyMember mother = member.getMother();
        if(mother == null) return null;
        ArrayList<FamilyMember> siblingsOfMother = mother.getSiblings();
        return getAllMembersFromArrayBasedOnGender(siblingsOfMother, "Male");
    }
    
    
}
