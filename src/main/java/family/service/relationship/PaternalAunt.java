package family.service.relationship;

import java.util.ArrayList;

import family.FamilyMember;

public class PaternalAunt extends Relationship {

    @Override
    public ArrayList<String> getPeople(FamilyMember member) {
        FamilyMember father = member.getFather();
        if(father == null) return null;
        ArrayList<FamilyMember> siblingsOfFather = father.getSiblings();
        return getAllMembersFromArrayBasedOnGender(siblingsOfFather, "Female");
    }
    
}
